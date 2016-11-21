package com.gafw.entity.mob;

import com.gafw.entity.projectile.Projectile;
import com.gafw.entity.projectile.WizardProjectile;
import com.gafw.game.Game;
import com.gafw.game.Keyinput;
import com.gafw.game.MouseInput;
import com.gafw.game.Graphics.AnimatedSprite;
import com.gafw.game.Graphics.Screen;
import com.gafw.game.Graphics.Sprite;
import com.gafw.game.Graphics.SpriteSheet;

public class Player extends Mob {

	private Keyinput input;
	private Sprite sprite;
	private boolean walking = false;

	private AnimatedSprite down = new AnimatedSprite(32, 32, SpriteSheet.player_down, 2, 7);
	private AnimatedSprite right = new AnimatedSprite(32, 32, SpriteSheet.player_right, 2, 7);
	private AnimatedSprite left = new AnimatedSprite(32, 32, SpriteSheet.player_left, 2, 7);
	private AnimatedSprite up = new AnimatedSprite(32, 32, SpriteSheet.player_up, 2, 7);

	private AnimatedSprite currentSprite = null;

	private int fireRate = 0;

	public Player(int x, int y, Keyinput input) {
		this.x = x;
		this.y = y;
		this.input = input;
		//start spriten
		currentSprite = down;
		//...
		fireRate = WizardProjectile.FIRE_RATE;
	}

	public void update() {
		//update sprite
		if (walking)
			currentSprite.update();
		else
			currentSprite.setFrame(0);
		
		//update firerate
		if (fireRate > 0)
			fireRate--;

		//check input
		int xa = 0, ya = 0;
		if (input.up) {
			currentSprite = up;
			ya--;
		}
		if (input.down) {
			currentSprite = down;
			ya++;
		}
		if (input.left) {
			if (!input.down && !input.up)
				currentSprite = left;
			xa--;
		}
		if (input.right) {
			if (!input.down && !input.up)
				currentSprite = right;
			xa++;
		}

		//move
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		//update shooting
		clear();
		updateShooting();
	}

	private void clear() {
		for (int i = 0; i < level.projectiles.size(); i++) {
			Projectile temporaryProjectile = level.projectiles.get(i);
			if (temporaryProjectile.isRemoved()) {
				level.projectiles.remove(i);
			}
		}
	}

	private void updateShooting() {

		if (MouseInput.getButton() == 1 && fireRate <= 0) {
			double dx = MouseInput.getX() - Game.getWindowWidth() / 2;
			double dy = MouseInput.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}

	}

	public void render(Screen screen) {
		sprite = currentSprite.getSprite();
		screen.renderMob(x - 16, y - 16, sprite, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
