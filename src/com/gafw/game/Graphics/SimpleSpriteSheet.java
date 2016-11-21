package com.gafw.game.Graphics;

import java.awt.image.BufferedImage;



import javax.imageio.ImageIO;

public class SimpleSpriteSheet {
	
	BufferedImage sheet;
	private int width,height;
	private String path;
	
	public static SimpleSpriteSheet menuBG = new SimpleSpriteSheet("/textures/menuBG.png",1,1);
	public static SimpleSpriteSheet optionsBG = new SimpleSpriteSheet("/textures/optionsBG.png",1,1);
	public static SimpleSpriteSheet aboutBG = new SimpleSpriteSheet("/textures/aboutBG.png",1,1);
	public static SimpleSpriteSheet window_icon = new SimpleSpriteSheet("/textures/window_icon.png",1,1);
 	
	public SimpleSpriteSheet(String path,int width,int height) {
		
		this.path = path;
		this.width = width;
		this.height = height;
		load();
		
	}
	public void load(){
		try{
			System.out.print("(SimpleSpriteSheet)loading : "+path+" ... ");
			sheet = ImageIO.read(getClass().getResource(path));
			System.out.println(" :)");
		}catch(Exception e){
			System.err.println(" failed");
			e.printStackTrace();
		}
	}
	public BufferedImage getSheet(){
		return sheet;
	}
	public BufferedImage getImage(int x, int y){
		try{
			return sheet.getSubimage((x*width)-width, (y*height)-height, width, height);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
