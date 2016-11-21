package com.gafw.game.Graphics;

public class AnimatedSprite extends Sprite {

	private int frame = 0;
	private Sprite sprite;
	private int rate = 10;
	private int length = -1;
	private int time = 0;
	
	
	public AnimatedSprite(int width, int height, SpriteSheet sheet, int animationLenght) {
		super(width, height, sheet);
		length = animationLenght;
		sprite = sheet.getSprites()[0];
		if(length > sheet.getSprites().length) System.err.println("Error! length of animation is too long.");
	}
	public AnimatedSprite(int width, int height, SpriteSheet sheet, int animationLenght,int rate) {
		super(width, height, sheet);
		length = animationLenght;
		this.rate = rate;
		sprite = sheet.getSprites()[0];
		if(length > sheet.getSprites().length) System.err.println("Error! length of animation is too long.");
	}
	public void update(){
		time ++;
		if(time % rate == 0){
			if(frame >= length)frame = 0;
			else frame++;
			sprite = sheet.getSprites()[frame];			
		}
		//System.out.println(sprite + ",frame :" +frame);
	}
	public Sprite getSprite(){	
		return sprite;
	}
	public void setFrameRate(int frameRate){
		rate = frameRate;
	}
	public void setFrame(int frame){
		if(frame > sheet.getSprites().length-1){
			System.err.println("index out of bounds in setFrame, index : "+frame);
			return;
		}
		sprite = sheet.getSprites()[frame];
	}
}
