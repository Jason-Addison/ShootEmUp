package entities;

import java.awt.Rectangle;

public class RocketSmoke 
{

	Rectangle pos;
	float trans;
	float r;
	float g;
	float b;
	int tick;
	
	public RocketSmoke(Rectangle pos, float trans, float r, float g, float b, int tick)
	{
		this.pos = pos;
		this.trans = trans;
		this.r = r;
		this.g = g;
		this.b = b;
		this.tick = tick;
	}
	
}
