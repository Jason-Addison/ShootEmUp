package staticentities;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Cloud 
{

	Color color;
	Rectangle2D.Double pos;
	boolean right;
	double speed;
	
	public Cloud(Rectangle2D.Double pos, Color color, boolean right, double speed)
	{
		this.color = color;
		this.pos = pos;
		this.right = right;
		this.speed = speed;
	}
	
}
