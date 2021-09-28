package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import engine.Camera;
import engine.Key;
import engine.Upgrades;
import gfx.Sources;

public class Helicopter 
{

	private Camera camera = new Camera();
	public static double hX = 300;
	public static double hY = 200;
	int timer = 0;
	int frame = 0;
	public static double hVelo = 0;
	static double vVelo = 0;
	double heliPowerV = 1;
	double heliPowerLim = 10;
	double heliStable = 0.5;
	
	//Horizontal
	
	double heliPowerH = 1;
	double heliPowerHLim = 10;
	double heliStableH = 0.5;
	boolean leftScrollLock = false;
	
	Rectangle2D.Double vertBounds = new Rectangle2D.Double(0, 840, 10000, 100);
	
	static double xOff = 0;
	int yOff = 0;
	public static Rectangle heliBound = new Rectangle((int) hX, (int) hY, 100, 100);
	public void tick()
	{
		animate();
		move();
		camera.camera();
		
	}
	int noScroll = 300;
	public void move()
	{
		if(hX <= 500)
		{
			leftScrollLock = true;
		}
		if(hX >= 501)
		{
			leftScrollLock = false;
		}
		if(Key.up)
		{
			if(-vVelo < heliPowerLim)
			{
				vVelo -= heliPowerV;
			}
		}
		if(!Key.up)
		{
			if(vVelo <= 0.1)
			{
				vVelo += heliStable;
			}
		}
		if(Key.down)
		{
			if(vVelo < heliPowerLim)
			{
				vVelo += heliPowerV;
			}
			if(heliBound.intersects(vertBounds))
			{
				vVelo = 0;
			}
			
		}
		if(!Key.down)
		{
			if(vVelo >= 0.1)
			{
				vVelo -= heliStable;
			}
			if(heliBound.intersects(vertBounds) && !Key.up)
			{
				vVelo = 0;
			}
		}
		if(Key.left)
		{
			if(-hVelo < heliPowerHLim)
			{
				hVelo -= heliPowerH;
			}
			if(hX < noScroll)
			{
				hVelo = 0;
			}
		}
		if(!Key.left)
		{
			if(hVelo <= 0.1)
			{
				hVelo += heliStableH;
			}
			if(hX < noScroll && !Key.right)
			{
				hVelo = 0;
			}
		}
		if(Key.right)
		{
			if(hVelo < heliPowerHLim && hX > noScroll)
			{
				hVelo += heliPowerH;
			}
		}
		if(!Key.right && hX > noScroll)
		{
			if(hVelo >= 0.1)
			{
				hVelo -= heliStableH;
			}
		}

		if(heliBound.intersects(vertBounds))
		{
			//vVelo = 0;
			EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle((int) hX - (int) camera.getCamera(), (int) hY, 50, 50), 3));
		}
		hX += hVelo;
		hY += vVelo;
		//heliPowerH = Upgrades.speedOverride; 
		heliBound = new Rectangle((int) hX - (int)camera.getCamera(), (int) hY + 25, 100, 70);
		
	}
	
	public void animate()
	{
		timer++;
		if(timer >= 2)
		{
			timer = 0;
			frame++;
			if(frame >= 3)
			{
				frame = 0;
			}
		}
	}
	boolean death = false;
	boolean spin = false;
	int curFrame = 0;
	int maxFrame = 10;
	float e = 100;
	public void render(Graphics g)
	{
		e+= 0.01f;
		//g.setColor(Color.BLACK);
		//g.fillRect(heliBound.x, heliBound.y, heliBound.width, heliBound.height);
		if(Key.leftLock)
		{
			g.drawImage(Sources.helicopterL[frame], (int) hX - (int) camera.getCamera(), (int) hY, 100, 100, null);
			if(Upgrades.dualGuns)
			{
				g.drawImage(Sources.minigunD, (int) hX - (int) camera.getCamera() + 10, (int) hY + 50, 40, 20, null);
			}
			if(Upgrades.hydraRockets)
			{
				g.drawImage(Sources.minigunD, (int) hX - (int) camera.getCamera() + 10, (int) hY + 50, 40, 20, null);
			}
		}
		else
		{
			g.drawImage(Sources.helicopter[frame], (int) hX - (int) camera.getCamera(), (int) hY, (int) 59, (int) 59, null);
			g.drawImage(Sources.heart, 30, 30, 30, 30, null);
			//g.drawImage(Sources.minigun, (int) hX - (int) camera.getCamera() + 50, (int) hY + 50, 40, 20, null);
			if(Upgrades.hydraRockets)
			{
				//g.drawImage(Sources.hydraR, (int) hX - (int) camera.getCamera() + 50, (int) hY + 60, 40, 20, null);
			}
		}
		if(death)
		{
			if(Helicopter.hY <= 750)
			{
				Helicopter.hY+= 5;
				Helicopter.hVelo = 3;
				curFrame++;
				if(curFrame >= maxFrame)
				{
					curFrame = 0;
					if(spin)
					{
						spin = false;
					}
					else
					{
						spin = true;
					}
				}
			}
		}
		if(spin && death)
		{
			Key.leftLock = true;
		}
		if(!spin && death)
		{
			Key.leftLock = false;
		}
		
	
		
	}
	
	public double getXOff()
	{
		return xOff;
	}
	
	public double getY()
	{
		return hY;
	}
	
	public double getHVelo() {
		return hVelo;
	}
}
