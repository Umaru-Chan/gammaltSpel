package com.gafw.entity.Spawners;

import com.gafw.entity.Entity;
import com.gafw.game.Graphics.Screen;
import com.gafw.level.Level;

public class Spawner extends Entity {

	//private List<Entity> entities = new ArrayList<Entity>();
	
	public enum Type {
		PARTICLE,
		MOB
	}
	
	//private Type type;
	
	public Spawner(int x, int y, Type type, int ammount,Level level) {
		this.x = x;
		this.y = y;
		//this.type = type;
		this.level = level;
		
		
	}
	public void update(){}
	public void render(Screen screen){}

}
