package entities;

import java.awt.geom.Rectangle2D;

public class Smoke 
{

	Rectangle2D.Double pos;
	float trans;
	float r;
	float g;
	float b;
	int type; // 0 = heli, 1 = c130
	
	public Smoke(Rectangle2D.Double pos, float trans, float r, float g, float b, int type)
	{
		this.pos = pos;
		this.trans = trans;
		this.r = r;
		this.g = g;
		this.b = b;
		this.type = type;
	}
	
}
