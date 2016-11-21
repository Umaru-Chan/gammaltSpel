package com.gafw.entity.mob;

import com.gafw.game.Graphics.AnimatedSprite;
import com.gafw.game.Graphics.Screen;
import com.gafw.game.Graphics.SpriteSheet;
import com.gafw.level.TileCoordinate;

public class Dummy extends Mob {
	
	public AnimatedSprite up = new AnimatedSprite(32,32,SpriteSheet.dummy_up,2);
	public AnimatedSprite down = new AnimatedSprite(32,32,SpriteSheet.dummy_down,2);
	public AnimatedSprite left = new AnimatedSprite(32,32,SpriteSheet.dummy_left,2);
	public AnimatedSprite right = new AnimatedSprite(32,32,SpriteSheet.dummy_right,2);
	
	public AnimatedSprite currentSprite = null;

	private int time = 0;
	private int xa = 0, ya = 0;
	
	public Dummy(TileCoordinate c){
		this.x = c.getX();
		this.y = c.getY();
		currentSprite = down;
	}
	
	public Dummy(int x, int y) {
		this.x = x;
		this.y = y;
		currentSprite = down;
	}

	public void update() {
		time ++;
		
		if(time % (random.nextInt(50) + 30) == 0)
		{
			xa = random.nextInt(3) - 1;// kan vara -1, 0, 1
			ya = random.nextInt(3) - 1;
			if(random.nextInt(5) == 0)//så att han inte går runt förjävligt mycket
			{
				xa = ya = 0;
			}
			if(time > 60000) // förhindra att time > Integer.MAX_VALUE
				time = 0;
		}
		
		
		if(walking)currentSprite.update();
		else currentSprite.setFrame(0);
		
		if (ya < 0) {
			currentSprite = up;
			dir = Direction.UP;
		}
		else if (ya > 0) {
			currentSprite = down;
			dir = Direction.DOWN;
		}
		if (xa < 0) {
			currentSprite = left;
			dir = Direction.LEFT;				
		}
		else if (xa > 0) {
			currentSprite = right;
			dir = Direction.UP;
		}
		
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
		
	}

	public void render(Screen screen) {
		sprite = currentSprite.getSprite();
		screen.renderMob(x-16, y-16, sprite, 0);
	}

}
