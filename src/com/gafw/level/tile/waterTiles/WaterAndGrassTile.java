package com.gafw.level.tile.waterTiles;

import com.gafw.game.Graphics.Screen;
import com.gafw.game.Graphics.Sprite;
import com.gafw.level.tile.Tile;

public class WaterAndGrassTile extends Tile{

	public WaterAndGrassTile(Sprite sprite) {
		super(sprite);
	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
	public boolean solid(){
		return false;
	}
	public boolean liquid(){
		return true;
	}


}
