package com.gafw.game.Graphics;

public class Sprite {
	public final int SIZE;
	private int width, height;
	private int x, y;
	public int[] pixels;
	protected SpriteSheet sheet;

	// tiles
	// public static Sprite voidSprite = new Sprite(16,4,0, spriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 1, 4, SpriteSheet.tiles);

	public static Sprite grass_1 = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite grass_2 = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite grass_flower_1 = new Sprite(16, 0, 11, SpriteSheet.tiles);
	public static Sprite grass_flower_2 = new Sprite(16, 0, 12, SpriteSheet.tiles);

	public static Sprite woodTile_1 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite woodTile_2 = new Sprite(16, 2, 2, SpriteSheet.tiles);
	public static Sprite woodTile_3 = new Sprite(16, 2, 1, SpriteSheet.tiles);

	public static Sprite stone_1 = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite stone_2 = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite stone_3 = new Sprite(16, 1, 2, SpriteSheet.tiles);

	public static Sprite sand_1 = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite sand_2 = new Sprite(16, 3, 1, SpriteSheet.tiles);
	public static Sprite sand_3 = new Sprite(16, 3, 2, SpriteSheet.tiles);

	public static Sprite wall_1 = new Sprite(16, 1, 5, SpriteSheet.tiles);

	// tiles WITH WATER
	public static Sprite water = new Sprite(16, 0, 10, SpriteSheet.tiles);
	public static Sprite lilypad = new Sprite(16, 0, 13, SpriteSheet.tiles);
	public static Sprite fountain = new Sprite(16, 0, 0, SpriteSheet.s_tiles);

	public static Sprite water_side_1 = new Sprite(16, 0, 9, SpriteSheet.tiles);
	public static Sprite water_side_2 = new Sprite(16, 0, 8, SpriteSheet.tiles);
	public static Sprite water_side_3 = new Sprite(16, 0, 7, SpriteSheet.tiles);
	public static Sprite water_side_4 = new Sprite(16, 0, 6, SpriteSheet.tiles);

	public static Sprite water_corner_1 = new Sprite(16, 0, 5, SpriteSheet.tiles);
	public static Sprite water_corner_2 = new Sprite(16, 0, 4, SpriteSheet.tiles);
	public static Sprite water_corner_3 = new Sprite(16, 0, 3, SpriteSheet.tiles);
	public static Sprite water_corner_4 = new Sprite(16, 0, 2, SpriteSheet.tiles);

	// player(wizard) sprites
	public static Sprite player_wizard_Cprojectile = new Sprite(16, 8, 2, SpriteSheet.playerSprites);
	public static Sprite player_wizard_projectile = new Sprite(16, 8, 0, SpriteSheet.playerSprites);
	public static Sprite player_wizard_projectile2 = new Sprite(16, 8, 1, SpriteSheet.playerSprites);

	// particles
	public static Sprite particle_normal = new Sprite(3, 0xcacaca);
	public static Sprite particle_wizardProjectile = new Sprite(3, 0xff7200/*0x0072ff - båa    0xff7200 -röd/oranga*/);
	public static Sprite particle_water = new Sprite(3, 0x55c4c6);

	// special stuff

	
	
	protected Sprite(int width,int height,SpriteSheet sheet){
		this.width = width;
		this.height = height;
		if(width == height)SIZE = width;else SIZE = -1;
		this.sheet = sheet;
	}
	public Sprite(int[] pixels, int width,int height){
		if(width == height)SIZE = width;else SIZE = -1;
		this.width = width;
		this.height = height;
		//pixels = new int[width*height];
		this.pixels = pixels;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();

	}

	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);

	}

	public Sprite(int size, int color) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	public void setColor(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];
			}
		}
	}

}
