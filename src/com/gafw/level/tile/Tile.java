package com.gafw.level.tile;

import com.gafw.game.Graphics.Screen;
import com.gafw.game.Graphics.Sprite;
import com.gafw.level.tile.waterTiles.WaterAndGrassTile;
import com.gafw.level.tile.waterTiles.WaterTile;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile GrassTile_1 = new GrassTile(Sprite.grass_1);
	public static Tile GrassTile_2 = new GrassTile(Sprite.grass_2);
	public static Tile GrassTile_flower_1 = new GrassTile(Sprite.grass_flower_1);
	public static Tile GrassTile_flower_2 = new GrassTile(Sprite.grass_flower_2);
	public static final int c_grassTile_1 = 0xff00ff00;
	public static final int c_grassTile_2 = 0xff0c7e19;
	public static final int c_grassTile_flower_1 = 0xff313f33;
	public static final int c_grassTile_flower_2 = 0xff6c7c6e;
	
	public static Tile VoidTile = new VoidTile(Sprite.voidSprite);
	public static final int c_voidTile = 0xffffffff;
	
	public static Tile WoodTile_1 = new WoodTile(Sprite.woodTile_1);
	public static Tile WoodTile_2 = new WoodTile(Sprite.woodTile_2);
	public static final int c_woodTile_1 = 0xffe8ba71;
	public static final int c_woodTile_2 = 0xffca8820;
	
	public static Tile SandTile_1 = new SandTile(Sprite.sand_1);
	public static Tile SandTile_2 = new SandTile(Sprite.sand_2);
	public static Tile SandTile_3 = new SandTile(Sprite.sand_3);
	public static final int c_sandTile_2 = 0xffd9b378;
	public static final int c_sandTile_1 = 0xffffff00;
	public static final int c_samdTile_3 = 0xfff3c884;
	
	/**TODO wallTile*/
	public static Tile WallTile_1 = new WallTile(Sprite.wall_1);
	public static final int c_wallTile_1 = 0xff9f9f9f;
	
	public static Tile StoneTile_1 = new StoneTile(Sprite.stone_1);
	public static Tile StoneTile_2 = new StoneTile(Sprite.stone_2);
	public static Tile StoneTile_3 = new StoneTile(Sprite.stone_3);
	public static final int c_stoneTile_1 = 0xff535553;
	public static final int c_stoneTile_2 = 0xff686a68;
	public static final int c_stoneTile_3 = 0xff000000;
	
	// water --------------------------------------------------------
	public static Tile WaterTile = new WaterTile(Sprite.water);
	public static final int c_waterTile = 0xff0000ff;
	public static Tile lilyPadTile = new WaterTile(Sprite.lilypad);
	public static final int c_lilyPadTile = 0xffcccccc;
	public static Tile Fountain = new WaterTile(Sprite.fountain);
	public static final int c_fountain = 0xff285051;
	
	/*botten_höger*/public static Tile WaterCornerTile_1 = new WaterTile(Sprite.water_corner_1);
	/*botten_vänster*/public static Tile WaterCornerTile_2 = new WaterTile(Sprite.water_corner_2);
	/*toppen_höger*/public static Tile WaterCornerTile_3 = new WaterTile(Sprite.water_corner_3);
	/*toppen_vänster*/public static Tile WaterCornerTile_4 = new WaterTile(Sprite.water_corner_4);
	public static final int c_waterCornerTile_1 = 0xffdaffae;
	public static final int c_waterCornerTile_2 = 0xff8aff00;
	public static final int c_waterCornerTile_3 = 0xff2e5500;
	public static final int c_waterCornerTile_4 = 0xff768662;
	
	/*botten*/public static Tile WaterEdgeTile_1 = new WaterAndGrassTile(Sprite.water_side_1);
	/*toppen*/public static Tile WaterEdgeTile_2 = new WaterAndGrassTile(Sprite.water_side_2);
	/*vänster*/public static Tile WaterEdgeTile_3 = new WaterAndGrassTile(Sprite.water_side_4);
	/*höger*/public static Tile WaterEdgeTile_4 = new WaterAndGrassTile(Sprite.water_side_3);
	public static final int c_WaterEdgeTile_1 = 0xff006a70;
	public static final int c_WaterEdgeTile_2 = 0xff445758;
	public static final int c_WaterEdgeTile_3 = 0xff0099a1;
	public static final int c_WaterEdgeTile_4 = 0xff00eaff;
	//------------------------------------------------------------------
	
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
		
	}

	public void render(int x, int y, Screen screen){
	}
	public boolean solid(){
		return false;
	}
	public boolean liquid(){
		return false;
	}
	
}
