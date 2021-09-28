package enemyproj;

import java.awt.geom.Rectangle2D;

public class BiplaneBullet
{

	public int velocity;
	public Rectangle2D.Double pos;
	public int tick;
	public int tickMax;
	
	public BiplaneBullet(int velocity, int tick, int tickMax, Rectangle2D.Double pos)
	{
		this.velocity = velocity;
		this.pos = pos;
	}
	
}
