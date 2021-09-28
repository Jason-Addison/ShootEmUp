package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import engine.Camera;
import engine.Upgrades;

public class HelicopterFX 
{

	int smokeInt = 0;
	int smokeMax = 0;
	public static ArrayList<Smoke> smoke = new ArrayList<Smoke>();
	private Camera cam = new Camera();
	float smokeDespawn = 0.003f;
	int smokeDensity = 4;

	int lowSmoke = 0;
	int lowSmokeMax = 0;
	public void tick()
	{
		smokeInt++;
		if(smokeInt >= smokeMax)
		{
			smokeInt = 0;
			
			for(int i = 0; i < smokeDensity; i++)
			{
				smoke.add(new Smoke(new Rectangle2D.Double((int)Helicopter.hX - (int) cam.getCamera() + 35 + getRandomX(), (int) Helicopter.hY + 30 + getRandomY(), 10, 10), 0.7f, 1f, 0.5f, 0f, 0));
			}
		}
	}
	
	public void lowTick()
	{
		lowSmoke++;
		if(lowSmoke >= lowSmokeMax)
		{
			smokeInt = 0;
			
			for(int i = 0; i < 5; i++)
			{
				smoke.add(new Smoke(new Rectangle2D.Double((int)Helicopter.hX - (int) cam.getCamera() + 35 + getRandomX(), (int) Helicopter.hY + 30 + getRandomY(), 10, 10), 0.6f, 0.0001f, 0f, 0f, 0));
			}
			
		}
	}
	
	public void render(Graphics2D g)
	{
		for(int i = 0; i < smoke.size(); i++)
		{
			if(Upgrades.health <= 25 && smoke.get(i).type == 0)
			{
				if(smoke.get(i).trans >= 0.01)
				{
					smoke.get(i).trans -= smokeDespawn;
				}
				if(smoke.get(i).r > 0.0001)
				{
					smoke.get(i).r -= 0.005;
				}
				if(smoke.get(i).g > 0.0001)
				{
					smoke.get(i).g -= 0.005;
				}
				if(smoke.get(i).b > 0.0001)
				{
					smoke.get(i).b -= 0.005;
				}
			}
			
			else if(Upgrades.health <= 75 && smoke.get(i).type == 0)
			{
				if(smoke.get(i).trans >= 0.01)
				{
					smoke.get(i).trans -= 0.005;
				}
				if(smoke.get(i).r < 0.9f && smoke.get(i).r >= 0f)
				{
					smoke.get(i).r += 0.01;
				}
				if(smoke.get(i).g < 0.9f && smoke.get(i).g >= 0f)
				{
					smoke.get(i).g += 0.01;
				}
				if(smoke.get(i).b < 0.9f && smoke.get(i).b >= 0f)
				{
					smoke.get(i).b += 0.01;
				}
			}
			
			if(smoke.get(i).type == 1)
			{
				if(smoke.get(i).trans >= 0.01)
				{
					smoke.get(i).trans -= smokeDespawn;
				}
				if(smoke.get(i).r > 0.0001)
				{
					smoke.get(i).r -= 0.005;
				}
				if(smoke.get(i).g > 0.0001)
				{
					smoke.get(i).g -= 0.005;
				}
				if(smoke.get(i).b > 0.0001)
				{
					smoke.get(i).b -= 0.005;
				}
			}
						
			if(smoke.get(i).trans <= 0.01)
			{
				smoke.remove(i);
			}
			g.setColor(new Color(smoke.get(i).r, smoke.get(i).g, smoke.get(i).b, smoke.get(i).trans));
			//g.fill(smoke.get(0).pos);
			smoke.get(i).pos.x -= Helicopter.hVelo;
			smoke.get(i).pos.x -= getRanXOff();
			smoke.get(i).pos.y -= getRanYOff();
			g.fillRect((int) smoke.get(i).pos.x, (int)smoke.get(i).pos.y, (int)smoke.get(i).pos.width, (int)smoke.get(i).pos.height);
		}
	}
	
	public int getRanXOff()
	{
		Random r = new Random();
		int ranX = r.nextInt(2 - 0) - 0;
		return ranX;
	}

	public int getRanYOff()
	{
		Random r = new Random();
		int ranY = r.nextInt(2 - 0) - 0;
		return ranY;
	}
	
	public int getRandomX()
	{
		Random r = new Random();
		int ranX = r.nextInt(20 - 0) - 0;
		return ranX;
	}
	public int getRandomY()
	{
		Random r = new Random();
		int ranY = r.nextInt(20 - 0) - 0;
		return ranY;
	}
	
}
