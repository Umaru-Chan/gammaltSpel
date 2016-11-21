package com.gafw.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gafw.entity.mob.Dummy;
import com.gafw.entity.mob.Pet;


public class SpawnLevel extends Level {

	public SpawnLevel(String path, TileCoordinate spawn) {
		super(path, spawn);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class
					.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			System.out.println("missing or corrupt level file. (sadface)");
			e.printStackTrace();
		}
		/*for(int i = 0; i < 3; i++)
			add(new Pet(50, 85));
		//add(new Pet(50*16, 85*16+6));
		for(int i = 0; i < 3; i++)
			add(new Dummy(new TileCoordinate(50, 85)));*/
		add(new Pet(50,85));
	}

	protected void generateLevel() {
		
	}
}
