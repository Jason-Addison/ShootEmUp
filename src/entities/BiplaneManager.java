package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import enemyproj.BiplaneBullet;
import engine.Camera;
import engine.Key;
import engine.Upgrades;
import gfx.Overlay;
import gfx.Sources;

public class BiplaneManager 
{

	public static ArrayList<Biplane> biplanes = new ArrayList<Biplane>();
	public static ArrayList<BiplaneBullet> bBullets = new ArrayList<BiplaneBullet>();
	private Camera cam = new Camera();
	public void tick()
	{
		if(biplanes.size() < EntityCount.biplaneCount)
		{
			biplanes.add(new Biplane(0, 5, new Rectangle2D.Double(getRandomX(), getRandomY(), 140, 60), 50, 7, 0, 1, 0));
		}
		for(int x = 0; x < bBullets.size(); x++)
		{

			bBullets.get(x).pos.x -= Helicopter.hVelo;
			bBullets.get(x).pos.x += bBullets.get(x).velocity;
		}
		for(int i = 0; i < biplanes.size(); i++)
		{
			biplanes.get(i).frame++;
			if(biplanes.get(i).frame >= biplanes.get(i).frameLim)
			{
				biplanes.get(i).frame = 0;
				biplanes.get(i).currentFrame++;
				if(biplanes.get(i).currentFrame >= 3)
				{
					biplanes.get(i).currentFrame = 0;
				}
			}
			for(int x = 0; x < EntityManager.bullets.size(); x++)
			{
				if(EntityManager.bullets.get(x).pos.intersects(biplanes.get(i).pos))
				{
					biplanes.get(i).health -= EntityManager.bullets.get(x).damage;
				}
			}
			for(int x = 0; x < EntityManager.bulletsL.size(); x++)
			{
				if(EntityManager.bulletsL.get(x).pos.intersects(biplanes.get(i).pos))
				{
					biplanes.get(i).health -= EntityManager.bullets.get(x).damage;
				}
			}
			for(int x = 0; x < RocketManager.hydra.size(); x++)
			{
				if(RocketManager.hydra.get(x).pos.intersects(biplanes.get(i).pos))
				{
					biplanes.get(i).health -= RocketManager.hydra.get(x).damage;
					EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle(RocketManager.hydra.get(x).pos.x + 20, RocketManager.hydra.get(x).pos.y - 25, 50, 50), 3));
					RocketManager.hydra.remove(x);
				}
			}
			if(biplanes.get(i).pos.x > cam.getCamera() - Helicopter.hX + 2500)
			{
				biplanes.remove(i);
				EntityCount.biplaneCount--;
			}
			if(biplanes.get(i).health <= 0)
			{
				EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle((int) biplanes.get(i).pos.x + 60, (int) biplanes.get(i).pos.y - 25, 100, 100), 3));
				biplanes.remove(i);
				EntityCount.biplaneCount--;
				Overlay.score += 2;
			}
			if(Helicopter.hY >= biplanes.get(i).pos.y - 70)
			{
				if(Helicopter.hY <= biplanes.get(i).pos.y + 30)
				{
					if(Helicopter.hX - cam.getCamera() >= biplanes.get(i).pos.x + 50)
					{
						biplanes.get(i).tick++;
						
						if(biplanes.get(i).tick >= biplanes.get(i).tickMax)
						{
							biplanes.get(i).tick = 0;
							bBullets.add(new BiplaneBullet(40, 0, 5, new Rectangle2D.Double(biplanes.get(i).pos.x + 130, biplanes.get(i).pos.y + 30, 5, 5)));
						}
					}
				}
				
			}
			
			biplanes.get(i).pos.x += biplanes.get(i).speed;
			biplanes.get(i).pos.x -= Helicopter.hVelo;
		}	
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < biplanes.size(); i++)
		{
			g.drawImage(Sources.biplane[biplanes.get(i).currentFrame], (int) biplanes.get(i).pos.x, (int) biplanes.get(i).pos.y, 140, 60, null);
			
			if(Key.showHealth)
			{
				g.setColor(Color.RED);
				g.fillRect((int) biplanes.get(i).pos.x + 50, (int) biplanes.get(i).pos.y - 20, biplanes.get(i).health * 1, 5);
			}

		}
		
		for(int i = 0; i < bBullets.size(); i++)
		{
			g.setColor(Color.BLACK);
			g.fillRect((int)bBullets.get(i).pos.x, (int) bBullets.get(i).pos.y, (int) bBullets.get(i).pos.width, (int) bBullets.get(i).pos.height);
			if(bBullets.get(i).pos.x > cam.getCamera() - Helicopter.hX + 2500)
			{
				bBullets.remove(i);
			}
			if(bBullets.get(i).pos.intersects(Helicopter.heliBound))
			{
				Upgrades.health-= 0.1;
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
		int ranY = r.nextInt(900 - 0) - 0;
		return ranY;
	}
	
}
