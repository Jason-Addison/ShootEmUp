package entities;

import java.awt.geom.Rectangle2D;

public class C130 
{
	Rectangle2D.Double pos;
	int health = 0;
	int frame;
	int frameLim;
	int currentFrame;
	int speed;
	int tick;
	int tickMax;
	boolean alive;
	
	public C130(int tick, int tickMax, Rectangle2D.Double pos, int health, int speed, int frame, int frameLim, int currentFrame, boolean alive)
	{
		this.pos = pos;
		this.speed = speed;
		this.health = health;
		this.frame = frame;
		this.frameLim = frameLim;
		this.currentFrame = currentFrame;
		this.tick = tick;
		this.tickMax = tickMax;
		this.alive = alive;
	}
}
