package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import engine.Camera;
import engine.Key;
import engine.Upgrades;
import gfx.Overlay;
import gfx.Sources;

public class EnemySpawn 
{
	public static ArrayList<Balloon> balloons = new ArrayList<Balloon>();
	private Camera cam = new Camera();
	boolean up, right;
	int score = 0;
	public static ArrayList<Explosion> explosions = new ArrayList<Explosion>();
	int expFrame = 0;
	int eFrame = 0;
	public void tick()
	{
		if(balloons.size() < EntityCount.balloonCount)
		{
			balloons.add(new Balloon(new Rectangle(getRandomX() - 00, getRandomY(), 50, 85), 10));
		}
	}
	
	public void render(Graphics2D g)
	{
		for(int i = 0; i < balloons.size(); i++)
		{
			balloons.get(i).pos.x += 0 - Helicopter.hVelo;
			if(Helicopter.hY > balloons.get(i).pos.y)
			{
				balloons.get(i).pos.y+= 1;
			}
			if(Helicopter.hY < balloons.get(i).pos.y)
			{
				balloons.get(i).pos.y-= 1;
			}
			if(Helicopter.hX - cam.getCamera()> balloons.get(i).pos.x)
			{
				balloons.get(i).pos.x += 1;
			}
			if(Helicopter.hX- cam.getCamera() < balloons.get(i).pos.x)
			{
				balloons.get(i).pos.x -= 1;
			}
			if(balloons.get(i).pos.intersects(Helicopter.heliBound))
			{
				if(Upgrades.health > 0)
				{
					Upgrades.health-= 0.1;
					Overlay.redBar += 0.001;
					Overlay.greenBar -= 0.001;
				}
			}
			//balloons.get(i).pos.x -= Helicopter.hVelo;
		
			g.drawImage(Sources.balloonbomb, balloons.get(i).pos.x,  balloons.get(i).pos.y, balloons.get(i).pos.width, balloons.get(i).pos.height, null);
			if(balloons.get(i).pos.x > cam.getCamera() - Helicopter.hX + 2500)
			{
				balloons.remove(i);
				EntityCount.balloonCount--;
			}
			for(int x = 0; x < EntityManager.bullets.size(); x++)
			{
				if(EntityManager.bullets.get(x).pos.intersects(balloons.get(i).pos))
				{
					balloons.get(i).health -= EntityManager.bullets.get(x).damage;
					//explosions.add(new Explosion(0, 0, new Rectangle(EntityManager.bullets.get(x).pos.x - 25, EntityManager.bullets.get(x).pos.y - 25, 50, 50)));
					EntityManager.bullets.remove(x);
					break;
				}
			}
			
			for(int x = 0; x < EntityManager.bulletsL.size(); x++)
			{
				if(EntityManager.bulletsL.get(x).pos.intersects(balloons.get(i).pos))
				{
					balloons.get(i).health -= EntityManager.bulletsL.get(x).damage;
					//explosions.add(new Explosion(0, 0, new Rectangle(EntityManager.bulletsL.get(x).pos.x - 25, EntityManager.bulletsL.get(x).pos.y - 25, 50, 50)));
					EntityManager.bulletsL.remove(x);
					break;
				}
			}
			
			for(int x = 0; x < RocketManager.hydra.size(); x++)
			{
				if(RocketManager.hydra.get(x).pos.intersects(balloons.get(i).pos))
				{
					balloons.get(i).health -= RocketManager.hydra.get(x).damage;
					explosions.add(new Explosion(0, 0, new Rectangle(RocketManager.hydra.get(x).pos.x - 25, RocketManager.hydra.get(x).pos.y - 25, 50, 50), 3));
					RocketManager.hydra.remove(x);
					break;
				}
			}
			if(balloons.get(i).health <= 0)
			{
				balloons.remove(i);
				EntityCount.balloonCount--;
				Overlay.score++;
			}
			if(Key.showHealth)
			{
				g.setColor(Color.RED);
				g.fillRect(balloons.get(i).pos.x, balloons.get(i).pos.y - 20, balloons.get(i).health * 5, 5);
			}
		}

		for(int e = 0; e < explosions.size(); e++)
		{
			g.drawImage(Sources.explosion[explosions.get(e).exFrame], explosions.get(e).pos.x, explosions.get(e).pos.y, explosions.get(e).pos.width, explosions.get(e).pos.height, null);
			
				
		}
		
		for(int e = 0; e < explosions.size(); e++)
		{
			explosions.get(e).pos.x += 0 - Helicopter.hVelo;
			explosions.get(e).frame++;
			if(explosions.get(e).frame >= explosions.get(e).maxFrame)
			{
				explosions.get(e).frame = 0;
				if(explosions.get(e).exFrame < 3)
				{
					explosions.get(e).exFrame++;
				}
				if(explosions.get(e).exFrame == 3)
				{
					explosions.remove(e);
					//break;
				}
				
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
