package com.gafw.level;

import java.util.ArrayList;
import java.util.List;

import com.gafw.entity.Entity;
import com.gafw.entity.particle.Particle;
import com.gafw.entity.projectile.Projectile;
import com.gafw.game.Graphics.Screen;
import com.gafw.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tileInt;
	protected int[] tiles;
	protected TileCoordinate spawn;

	private List<Entity> entities = new ArrayList<Entity>();
	public List<Projectile> projectiles = new ArrayList<Projectile>();
	public static List<Particle> particles = new ArrayList<Particle>();
	
	public static Level nexusLevel = new SpawnLevel("/levels/spawn.png", TileCoordinate.nexusLevelSpawn);

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tileInt = new int[width * height];
		generateLevel();
	}

	public Level(String path, TileCoordinate spawn) {
		this.spawn = spawn;
		loadLevel(path);
		generateLevel();

	}

	public TileCoordinate getSpawn() {
		return spawn;
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}
	//double timer = System.currentTimeMillis();
	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
	
	
		remove();
	}

	private void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) {
				entities.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved()) {
				projectiles.remove(i);
			}
		}
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved()) {
				particles.remove(i);
			}
		}
		
		
	}

	@SuppressWarnings("unused")
	private void time() {

	}

	public boolean tileCollision(int x, int y, int size, int xOffs, int yOffs) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {

			int xt = (x - c % 2 * size + xOffs) >> 4;
			int yt = (y - c / 2 * size + yOffs) >> 4;

			if (getTile(xt, yt).solid())
				return true;
		}
		return solid;

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;// >> 4 = / 16
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
		
	}

	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else if (e instanceof Projectile) {
			e.init(this);
			projectiles.add((Projectile) e);
		}else {
			entities.add(e);
		}
	}
	
	public static int x,y;
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.VoidTile;
		/*
		 * om tilen inte är med på kartan, ge tillbaks
		 * en f*****g voidtile
		*/
		switch (tiles[x + y * width]) {
		case(Tile.c_grassTile_1):return Tile.GrassTile_1;
		case(Tile.c_grassTile_2):return Tile.GrassTile_2;
		case(Tile.c_grassTile_flower_1):return Tile.GrassTile_flower_1;
		case(Tile.c_grassTile_flower_2):return Tile.GrassTile_flower_2;
		case(Tile.c_sandTile_1):return Tile.SandTile_1;
		case(Tile.c_stoneTile_3):return Tile.StoneTile_3;
		case(Tile.c_woodTile_1):return Tile.WoodTile_1;
		case(Tile.c_woodTile_2):return Tile.WoodTile_2;
		case(Tile.c_wallTile_1):return Tile.WallTile_1;
		case(Tile.c_waterTile):return Tile.WaterTile;
		case(Tile.c_waterCornerTile_1):return Tile.WaterCornerTile_1;
		case(Tile.c_waterCornerTile_2):return Tile.WaterCornerTile_2;
		case(Tile.c_waterCornerTile_3):return Tile.WaterCornerTile_3;
		case(Tile.c_waterCornerTile_4):return Tile.WaterCornerTile_4;
		case(Tile.c_WaterEdgeTile_1):return Tile.WaterEdgeTile_1;
		case(Tile.c_WaterEdgeTile_2):return Tile.WaterEdgeTile_2;
		case(Tile.c_WaterEdgeTile_3):return Tile.WaterEdgeTile_3;
		case(Tile.c_WaterEdgeTile_4):return Tile.WaterEdgeTile_4;
		case(Tile.c_lilyPadTile):return Tile.lilyPadTile;
		
		case(Tile.c_fountain):

			return Tile.Fountain;
		
		default:return Tile.VoidTile;
		}
	}
}
