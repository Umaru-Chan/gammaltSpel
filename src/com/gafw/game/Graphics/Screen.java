package com.gafw.game.Graphics;

import com.gafw.entity.mob.Mob;
import com.gafw.entity.mob.Pet;
import com.gafw.entity.projectile.Projectile;
import com.gafw.level.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int mapSize = 64;
	public final int mapSizeMask = mapSize - 1;
	public int xOffset, yOffset;

	// public int[] tiles = new int[mapSize * mapSize];

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderSheet(int xp, int yp, SpriteSheet sheet, boolean fixed) {
		if (fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}

		for (int y = 0; y < sheet.HEIGHT; y++) {
			int ya = y + yp;
			for (int x = 0; x < sheet.WIDTH; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height)
					continue;
				pixels[xa + ya * width] = sheet.pixels[x + y * sheet.WIDTH];
			}
		}

	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}

		for (int y = 0; y < sprite.getHeight(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getWidth(); x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height)
					continue;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.getWidth()];
			}
		}

	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderProjectile(int xp, int yp, Projectile p) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < p.getSprite().SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < p.getSprite().SIZE; x++) {
				int xa = x + xp;
				if (xa < -p.getSprite().SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = p.getSprite().pixels[x + y * p.getSprite().SIZE];
				if (col != 0xff7f007f && col != 0xffff00ff) {
					pixels[xa + ya * width] = col;
				}
			}
		}
	}

	/*
	 * @param FLIP if (flip == 3) flipa båda x & y if (flip == 2) flipa bara x
	 * if (flip == 1) flipa bara y
	 */
	public void renderMob(int xp, int yp, Sprite sprite, int flip) {

		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;

			int ys = y;
			if (flip == 2 || flip == 3) {
				ys = sprite.SIZE - 1 - y;
			}

			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;

				int xs = x;
				if (flip == 1 || flip == 3) {
					xs = sprite.SIZE - 1 - x;
				}

				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int color = sprite.pixels[xs + ys * sprite.SIZE];
				if (color != 0xff7f007f && color != 0xffff00ff) {
					pixels[xa + ya * width] = color;
				}
			}
		}
	}

	public void renderMob(int xp, int yp, Mob mob) {

		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < mob.getSprite().SIZE; y++) {
			int ya = y + yp;

			for (int x = 0; x < mob.getSprite().SIZE; x++) {
				int xa = x + xp;

				if (xa < -mob.getSprite().SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)xa = 0;

				int color = mob.getSprite().pixels[x + y * mob.getSprite().SIZE];
				// ------------------------Pets ska ha andra färger-----------------------------------------------------------------
				if (mob instanceof Pet) {
					if (color == 0xff2B4736 || color == 0xff45695C || color == 0xff85B091 || color == 0xff668770)
						color = 0xff7983C6;

					else if (color == 0xff5CA69E || color == 0xff4F828A || color == 0xff33636B || color == 0xff213B45)
						color = 0xff5E58CE;

					else if (color == 0xff1C241F)
						color = 0xff293C9E;
				}
				// ------------------------------------------------------------------------------------------------------------------
				if (color != 0xff7f007f && color != 0xffff00ff) {
					pixels[xa + ya * width] = color;
				}
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
