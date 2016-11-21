package com.gafw.entity.projectile;

import java.util.Random;

import com.gafw.entity.Entity;
import com.gafw.game.Graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrigin , yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx , ny;
	protected double speed, range, damage, distance;
	protected final Random random = new Random();
	
	public Projectile(int x, int y, double dir){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	protected void move(){
		
	}
	public Sprite getSprite(){
		return sprite;
	}
}
