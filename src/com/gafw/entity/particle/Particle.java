package com.gafw.entity.particle;

import com.gafw.entity.Entity;
import com.gafw.game.Graphics.Screen;
import com.gafw.game.Graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;
	protected int life;
	protected double xa, ya, za;
	protected double xx, yy, zz;
	private int time = 0;

	/*
	 * xx & yy f�r att man beh�ver x&y i double innan man renderar dom f�r mer
	 * precition
	 */

	public Particle(int x, int y, int life, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(25) - 15);
		this.sprite = sprite;

		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat() + 1.5;
	}

	public void update() {
		time++;
		if (time >= 10000)time = 0;/* om time blir �ver 2^31 �r man fucked ... t�nk sj�lv noob */
		if (time > life)
			remove();

		za -= 0.1;
		if (zz < 0) {
			zz = 0;
			za *= -0.8;
			xa *= 0.6;
			ya *= 0.6;
		}

		move(xx + xa, (yy + ya) + (zz + za));

	}

	private void move(double x, double y) {

		if(collision(x,y)){
			this.xa *= -0.5;
			this.ya *= 0.5;
			this.za *= -0.5;
		}
		
		this.xx += xa;
		this.yy += ya;
		this.zz += za;

	}
	public boolean collision(double x, double y) {
		boolean solid = false;
	
		for (int c = 0; c < 4; c++) {
			
			
			double xt = (x - c % 2 * 16) / 16;
			double yt = (y - c / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0)ix = (int) Math.floor(xt);
			if(c / 2 == 0)iy = (int) Math.floor(yt);
			if (level.getTile(ix, iy).solid())
				return true;
		}
		
		return solid;

	}

	public void render(Screen screen) {
		screen.renderSprite((int) xx, (int) yy - (int) zz - 3, sprite, true);
	}

}
