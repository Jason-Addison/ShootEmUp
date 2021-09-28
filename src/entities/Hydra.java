package entities;

import java.awt.Rectangle;

public class Hydra
{

	int damage;
	int velocity;
	Rectangle pos;
	
	public Hydra(int velocity, int damage, Rectangle pos)
	{
		this.velocity = velocity;
		this.pos = pos;
		this.damage = damage;
	}
	
}
