package entities;

import java.awt.geom.Rectangle2D;

public class Tank
{

	public Rectangle2D.Double pos;
	public Rectangle2D.Double barrel;
	int radian;
	int speed;
	int health;
	int frame;
	int maxFrame;
	int currentFrame;
	boolean right;
	
	public Tank(Rectangle2D.Double pos, Rectangle2D.Double barrel, boolean right, int radian, int speed, int health, int frame, int maxFrame, int currentFrame)
	{
		this.pos = pos;
		this.barrel = barrel;
		this.right = right;
		this.radian = radian;
		this.speed = speed;
		this.health = health;
		this.frame = frame;
		this.maxFrame = maxFrame;
		this.currentFrame = currentFrame;
	}
}
