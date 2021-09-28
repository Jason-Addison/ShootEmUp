package entities;

import java.awt.Rectangle;

public class Explosion
{

	public int frame;
	public int exFrame;
	public Rectangle pos;
	public int maxFrame;
	public Explosion(int frame, int exFrame, Rectangle pos, int maxFrame)
	{
		this.maxFrame = maxFrame;
		this.frame = frame;
		this.pos = pos;
		this.exFrame = exFrame;
	}
}
