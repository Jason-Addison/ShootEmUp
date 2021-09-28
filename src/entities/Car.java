package entities;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Car 
{

	Rectangle2D.Double pos;
	BufferedImage texture;
	double speed;
	int health;
	boolean right;
	boolean stop;
	
	public Car(Rectangle2D.Double pos, BufferedImage texture, double speed, int health, boolean right, boolean stop)
	{
		this.stop = stop;
		this.right = right;
		this.pos = pos;
		this.texture = texture;
		this.speed = speed;
		this.health = health;
	}
}
