package com.gafw.entity.Spawners;

import com.gafw.entity.particle.Particle;
import com.gafw.game.Graphics.Sprite;
import com.gafw.level.Level;

public class ParticleSpawner extends Spawner {

	
	public ParticleSpawner(int x, int y, int life, int ammount, Level level,Sprite sprite) {
		super(x, y, Type.PARTICLE, ammount, level);
		//this.life = life;

		for (int i = 0; i < ammount; i++) {
			level.add(new Particle(x, y, life,sprite));
		}
	}

}
