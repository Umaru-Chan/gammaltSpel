package com.gafw.game;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.gafw.entity.mob.Player;


public class MouseInput implements MouseListener, MouseMotionListener{

	static Rectangle mouse = new Rectangle(0,0,1,1);
//	public static boolean startButton,optionsButton,aboutButton,exitButton,backToMenuButton,changeFpsButton,showStatsButton;
	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	
	@SuppressWarnings("unused")
	private Player player;//yayaya

	public MouseInput(Player player) {
		this.player = player;
	}
	
	public void tick(){
		
	//mouse = new Rectangle(mouseX,mouseY,1,1);
	
	}
	
	public static int getX(){
		return mouseX;
	}
	public static int getY(){
		return mouseY;
	}
	public static int getButton(){
		return mouseB;
	}
	
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();		
		
	}
	public void mouseMoved(MouseEvent e) {	
		mouseX = e.getX();
		mouseY = e.getY();		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		
		mouseB = e.getButton();
		
	}

	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}

}
