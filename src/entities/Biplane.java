package entities;

import java.awt.geom.Rectangle2D;

public class Biplane
{

	Rectangle2D.Double pos;
	int health = 0;
	int frame;
	int frameLim;
	int currentFrame;
	int speed;
	int tick;
	int tickMax;
	
	public Biplane(int tick, int tickMax, Rectangle2D.Double pos, int health, int speed, int frame, int frameLim, int currentFrame)
	{
		this.pos = pos;
		this.speed = speed;
		this.health = health;
		this.frame = frame;
		this.frameLim = frameLim;
		this.currentFrame = currentFrame;
		this.tick = tick;
		this.tickMax = tickMax;
	}
	
}
