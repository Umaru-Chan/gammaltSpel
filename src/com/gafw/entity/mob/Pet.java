package com.gafw.entity.mob;

import com.gafw.game.Graphics.AnimatedSprite;
import com.gafw.game.Graphics.Screen;
import com.gafw.game.Graphics.SpriteSheet;

public class Pet extends Mob {

	public AnimatedSprite up = new AnimatedSprite(32,32,SpriteSheet.dummy_up,2);
	public AnimatedSprite down = new AnimatedSprite(32,32,SpriteSheet.dummy_down,2);
	public AnimatedSprite left = new AnimatedSprite(32,32,SpriteSheet.dummy_left,2);
	public AnimatedSprite right = new AnimatedSprite(32,32,SpriteSheet.dummy_right,2);
	
	public AnimatedSprite currentSprite = null;

	
	int xa = 0, ya = 0;
	int time = 0;
	
	public Pet(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		currentSprite = down;
	}

	public void update() {
		time++;

		if (time % (random.nextInt(50) + 30) == 0) {
			xa = random.nextInt(3) - 1;// kan vara -1, 0, 1
			ya = random.nextInt(3) - 1;
			if (random.nextInt(5) == 0)// så att han inte går runt förjävligt
			{
				xa = ya = 0;
			}
			if (time > 60000) // förhindra att time > Integer.MAX_VALUE
				time = 0;
		}

		
		if (walking)
			currentSprite.update();
		else
			currentSprite.setFrame(0);

		if (ya < 0) {
			currentSprite = up;
			dir = Direction.UP;
		} else if (ya > 0) {
			currentSprite = down;
			dir = Direction.DOWN;
		}
		if (xa < 0) {
			currentSprite = left;
			dir = Direction.LEFT;
		} else if (xa > 0) {
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
		screen.renderMob(x-16, y-16, this);
	}

}
