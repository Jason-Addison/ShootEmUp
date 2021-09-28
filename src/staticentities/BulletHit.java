package staticentities;

import java.awt.Rectangle;

public class BulletHit
{

	Rectangle pos;
	int tick;
	int maxTick;
	
	public BulletHit(Rectangle pos, int tick, int maxTick)
	{
		this.pos = pos;
		this.tick = tick;
		this.maxTick = maxTick;
	}
}
