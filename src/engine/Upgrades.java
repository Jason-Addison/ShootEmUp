package engine;

import gfx.Overlay;

public class Upgrades
{

	int bulletVel = 50;
	int hydraVel = 20;
	public static double health = 100;
	public static int hydraDmg = 10;
	public static int bulletDmg = 1;
	public static boolean dualGuns = true;
	public static boolean hydraRockets = true;
	public static int currentHydra = 10;
	public static boolean cheatMode = true;
	public static int helicopter = 2; //Chinook = 2
	public static double speedOverride = 0;
	
	public void tick()
	{
		if(cheatMode)
		{
			currentHydra = 999;
		}
		if(Key.healthUp)
		{
			if(health < 100)
			{
				health++;
				Overlay.redBar -= 0.01;
				Overlay.greenBar += 0.01;
			}
		}
		if(Key.healthDown)
		{
			if(health > 0)
			{
				health--;
				Overlay.redBar += 0.01;
				Overlay.greenBar -= 0.01;
			}
		}
	}
	
	public int getBullVel()
	{
		return bulletVel;
	}
	
	public double getHealth()
	{
		return health;
	}
	public int getHydraVel()
	{
		return hydraVel;
	}
	public int getBulletDmg()
	{
		return bulletDmg;
	}
	public int getHydraDmg()
	{
		return hydraDmg;
	}
}
