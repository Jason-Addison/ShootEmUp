package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import engine.Camera;
import engine.Key;
import engine.Upgrades;
import gfx.Sources;

public class C130Manager
{

	public static ArrayList<C130> c130 = new ArrayList<C130>();
	private Camera cam = new Camera();
	public void tick()
	{
		if(c130.size() < EntityCount.C130Count)
		{
			c130.add(new C130(0, 5, new Rectangle2D.Double(getRandomX(), getRandomY(), 480, 160), 500, 5 + (int)Upgrades.speedOverride, 0, 3, 0, true));
		}
		for(int i = 0; i < c130.size(); i++)
		{
			c130.get(i).frame++;
			
			if(c130.get(i).frame >= c130.get(i).frameLim)
			{
				c130.get(i).frame = 0;
				c130.get(i).currentFrame++;
			}
			if(c130.get(i).currentFrame >= 4)
			{
				c130.get(i).currentFrame = 0;
			}
			for(int x = 0; x < RocketManager.hydra.size(); x++)
			{
				if(RocketManager.hydra.get(x).pos.intersects(c130.get(i).pos))
				{
					c130.get(i).health -= RocketManager.hydra.get(x).damage;
					EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle(RocketManager.hydra.get(x).pos.x + 100, RocketManager.hydra.get(x).pos.y - 25, 50, 50), 3));
					RocketManager.hydra.remove(x);
				}
			}
			if(c130.get(i).health <= 0 && !(c130.get(i).pos.y >= 620))
			{
				c130.get(i).pos.y += 2;
				c130.get(i).frameLim = 7;
			}
			if(c130.get(i).pos.y >= 620 && c130.get(i).alive)
			{
				EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle((int) c130.get(i).pos.x + 250,(int) c130.get(i).pos.y - 25, 150, 150), 5));
				EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle((int) c130.get(i).pos.x + 200, (int) c130.get(i).pos.y + 50, 100, 100), 7));
				EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle((int) c130.get(i).pos.x + 300, (int) c130.get(i).pos.y, 200, 200), 4));				
				c130.get(i).alive = false;
			}
			if(c130.get(i).health <= 200)
			{
				HelicopterFX.smoke.add(new Smoke(new Rectangle2D.Double((int)c130.get(i).pos.x + 280 + randomSmokeX(), (int) c130.get(i).pos.y + 70 + randomSmokeY(), 20, 20), 0.7f, 1f, 0.5f, 0f, 1));
			
			}
			if(!c130.get(i).alive)
			{
				c130.get(i).health = 0;
				HelicopterFX.smoke.add(new Smoke(new Rectangle2D.Double((int)c130.get(i).pos.x + 120 + randomSmokeX(), (int) c130.get(i).pos.y + 120 + randomSmokeY(), 20, 20), 0.7f, 1f, 0.5f, 0f, 1));
				HelicopterFX.smoke.add(new Smoke(new Rectangle2D.Double((int)c130.get(i).pos.x + 400 + randomSmokeX(), (int) c130.get(i).pos.y + 50 + randomSmokeY(), 20, 20), 0.7f, 1f, 0.5f, 0f, 1));
				HelicopterFX.smoke.add(new Smoke(new Rectangle2D.Double((int)c130.get(i).pos.x + 300 + randomSmokeX(), (int) c130.get(i).pos.y + 50 + randomSmokeY(), 20, 20), 0.7f, 1f, 0.5f, 0f, 1));
			}
			c130.get(i).pos.x -= Helicopter.hVelo;
			if(!(c130.get(i).pos.y >= 620))
			{
				c130.get(i).pos.x += c130.get(i).speed;
			}
		}
		
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < c130.size(); i++)
		{
			
			if(c130.get(i).pos.y >= 680)
			{
				g.drawImage(Sources.c130crash, (int) c130.get(i).pos.x, (int) c130.get(i).pos.y, (int) c130.get(i).pos.width, (int) c130.get(i).pos.height, null);
			}
			else
			{
				g.drawImage(Sources.c130[c130.get(i).currentFrame], (int) c130.get(i).pos.x, (int) c130.get(i).pos.y, (int) c130.get(i).pos.width, (int) c130.get(i).pos.height, null);
			}
			if(Key.showHealth)
			{
				g.setColor(Color.RED);
				g.fillRect((int) c130.get(i).pos.x + 200, (int) c130.get(i).pos.y + 50, c130.get(i).health / 10, 5);
			}
		}
	}
	public int getRandomX()
	{
		Random r = new Random();
		int ranX = r.nextInt(1100 - 0) - 0;
		return ranX;
	}
	public int getRandomY()
	{
		Random r = new Random();
		int ranY = r.nextInt(500 - 0) - 0;
		return ranY;
	}
	public int randomSmokeX()
	{
		Random r = new Random();
		int ranY = r.nextInt(20 - 0) - 0;
		return ranY;
	}
	public int randomSmokeY()
	{
		Random r = new Random();
		int ranY = r.nextInt(20 - 0) - 0;
		return ranY;
	}
}
