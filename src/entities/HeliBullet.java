package entities;

import java.awt.Rectangle;

public class HeliBullet 
{

	int damage;
	int velocity = 0;
	Rectangle pos;
	
	public HeliBullet(int damage, int velocity, Rectangle pos)
	{
		this.velocity = velocity;
		this.pos = pos;
		this.damage = damage;
	}
}
