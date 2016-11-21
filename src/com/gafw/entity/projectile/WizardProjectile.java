package com.gafw.entity.projectile;

import com.gafw.entity.Spawners.ParticleSpawner;
import com.gafw.game.Graphics.Screen;
import com.gafw.game.Graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 10;/* higher = slower */
	public boolean crit = false;
	
	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);

		range = random.nextInt(80) + 100;
		damage = 20;
		speed = 3;
		
		if(random.nextInt(20) < 4){
			sprite = Sprite.player_wizard_Cprojectile;
			crit = true;
		}
		else if(random.nextBoolean()){
			sprite = Sprite.player_wizard_projectile;			
		}else{
			sprite = Sprite.player_wizard_projectile2;
		}
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);

	}

	public void update() {
		if (level.tileCollision((int) (x + nx), (int) (y + ny), 8, 4, 4)) {
			
			if(!crit)
			new ParticleSpawner((int) x, (int) y, 35, random.nextInt(3) + 3, level, Sprite.particle_wizardProjectile);
			else
			new ParticleSpawner((int) x, (int) y, 25, random.nextInt(20)+30, level, Sprite.particle_wizardProjectile);
			
			remove();
		}
		move();
	}

	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) {
			remove();
		}
	}

	public double distance() {
		double distance = 0;
		distance = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x)) + Math.abs((yOrigin - y) * (yOrigin - y)));
		/** pythagoras sats... måste man förklara? */
		return distance;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 8, (int) y - 3, this);
	}

}
