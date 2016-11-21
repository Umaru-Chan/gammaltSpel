package com.gafw.entity.mob;


import com.gafw.entity.Entity;
import com.gafw.entity.projectile.Projectile;
import com.gafw.entity.projectile.WizardProjectile;
import com.gafw.game.Graphics.Screen;

public abstract class Mob extends Entity{
	
	protected boolean moving = false;
	protected boolean walking = false;
	
	
	protected enum Direction {
		UP,DOWN,LEFT,RIGHT;
	}
	protected Direction dir;
	
	public void move(int xa, int ya){
		
		if(xa != 0 && ya != 0){
			move(xa,0);
			move(0,ya);
			return;
		}
		
		if (xa > 0) dir = Direction.RIGHT;
		if (xa < 0) dir = Direction.LEFT;
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;
		
		if(!collision(xa,ya)){
			x += xa;
			y += ya;
		} else {

		}
	}
	
	public abstract void update();
	public abstract void render(Screen screen);
	
	protected void shoot(int x, int y, double dir){
		//dir *= (180 / Math.PI);  <- konverterar radianer til grader xaxaxa 
		Projectile p = new WizardProjectile(x,y,dir);
		level.add(p);
		
	}
	
	private boolean collision(int xa, int ya){
		boolean solid = false;
		for(int i = 0; i < 4; i++){
			int xt = ((x+xa) - i % 2 * 24 + 11) >> 4;
			int yt = ((y+ya) + i / 2 * 12 +3) >> 4;
			if(level.getTile(xt,yt).solid())solid = true;
			if(level.getTile(xt,yt).liquid())solid = true;
		}
		return solid;
	
	}

}
