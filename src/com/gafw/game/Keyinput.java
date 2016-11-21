package com.gafw.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyinput implements KeyListener {
	private boolean[] keys = new boolean[200];
	public boolean up, down, left, right;

	public Keyinput() {

	}

	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key < keys.length){			
			keys[key] = true;
		}
		
		switch(key){
		case(KeyEvent.VK_ESCAPE):System.exit(1);
		default:return;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < keys.length){
			keys[e.getKeyCode()] = false;			
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}
