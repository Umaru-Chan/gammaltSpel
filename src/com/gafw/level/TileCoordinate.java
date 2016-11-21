package com.gafw.level;

public class TileCoordinate {

	public static TileCoordinate nexusLevelSpawn = new TileCoordinate(56/*spawnLevelspawn x ? */,80/*spawnLevelspawn y ? */);
	
	private int x, y;

	public TileCoordinate(int x, int y) {
		this.x = x * 16;
		this.y = y * 16;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int[] getXY() {
		int[] xy = new int[2];
		xy[0] = x;
		xy[1] = y;
		return xy;
	}
	
	
}
