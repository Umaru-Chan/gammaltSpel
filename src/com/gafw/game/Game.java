package com.gafw.game;

/**
 * @author Alexander Norozkhani
 */

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import com.gafw.entity.mob.Player;
import com.gafw.game.Graphics.Screen;
import com.gafw.level.Level;

/** TODO ta bort lite skit */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 450;/* klaga inte */
	/** TODO kanske ändra storleken */
	public static final int HEIGHT = WIDTH / 16 * 9;/* klaga inte */
	public static final int SCALE = 3;/* klaga inte */

	public Dimension dim = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static int savedTicks, savedFps, r, g, b;
	Font font = new Font("Ariel", Font.BOLD, 20);
	public static boolean showStats = false;
	private static final String startingTitle = new String("gaAafw alpha.v0.5 | ...  | fps: 0 ups: 0");
	private static final String title = new String("gaAafw alpha.v0.5 | ...");

	Random random = new Random();

	private boolean running = false;
	private Thread gamethread;
	private Screen screen;
	private Keyinput key;
	private MouseInput mouse;
	private Player player;

	static Level level;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		setPreferredSize(dim);
		screen = new Screen(WIDTH, HEIGHT);
		level = Level.nexusLevel;
		key = new Keyinput();
		player = new Player(level.getSpawn().getX(), level.getSpawn().getY(), key);
		player.init(level);
		mouse = new MouseInput(player);

		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		new Window(dim, startingTitle, this);
	}

	public synchronized void start() {
		try {
			gamethread = new Thread(this, "gameThread");
			gamethread.start();
			running = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void stop() {
		running = false;
		try {
			gamethread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		int frames = 0, ticks = 0;
		final double ns = 1000000000.0D / 60.0D;
		double timer = System.currentTimeMillis();
		double delta = 0.0D;
		this.requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				if (ticks <= 60) { 
					update();
					ticks++;
				}
				delta--;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("fps: " + frames + " ticks: " + ticks);
				savedTicks = ticks;
				savedFps = frames;
				render();

				Window.f.setTitle(title + "  | fps: " + savedFps + " UPS: " + savedTicks);

				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {

		key.update();
		mouse.tick();
		player.update();
		level.update();
		// TODO gameStates

	}

	public void render() {
		BufferStrategy awesomeBufferStrategy_1337_420 = this.getBufferStrategy();
		if (awesomeBufferStrategy_1337_420 == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics2D g2d = (Graphics2D) awesomeBufferStrategy_1337_420.getDrawGraphics();
		screen.clear();

		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;

		
		level.render(xScroll, yScroll, screen);
		player.render(screen);		
		
		
		for (int i = 0; i < pixels.length; i++) {pixels[i] = screen.pixels[i];}
		g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g2d.dispose();
		awesomeBufferStrategy_1337_420.show();

	}

	public static int getWindowWidth() {
		return WIDTH * SCALE;
	}

	public static int getWindowHeight() {
		return HEIGHT * SCALE;
	}

	public static void main(String[] args) {
		new Game();
	}
}
