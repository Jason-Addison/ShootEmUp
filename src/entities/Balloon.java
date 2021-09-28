package entities;

import java.awt.Rectangle;

public class Balloon 
{

	Rectangle pos;
	int health = 0;
	
	public Balloon(Rectangle pos, int health)
	{
		this.pos = pos;
		
		this.health = health;
	}
	
}
