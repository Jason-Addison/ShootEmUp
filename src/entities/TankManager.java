package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import engine.Camera;
import gfx.Sources;

public class TankManager 
{

	public static ArrayList<Tank> tanks = new ArrayList<Tank>();
	private Camera cam = new Camera();
	double x = 0;
	double y = 0;
	public void tick()
	{
		if(tanks.size() < -1)
		{
			x = randomX();
			y = randomY();
			tanks.add(new Tank(new Rectangle2D.Double(x, y, 150, 120), new Rectangle2D.Double(x + 35, y + 70, 60, 5), false, 45, randomSpeed(), 2, 0, 0, 0));
		}
		for(int e = 0; e < tanks.size(); e++)
		{
			tanks.get(e).pos.x -= Helicopter.hVelo;	
			
			if(tanks.get(e).pos.x < Helicopter.hX - cam.getCamera())
			{
				tanks.get(e).right = false;
			}
			else
			{
				tanks.get(e).right = true;
			}
			
			if(tanks.get(e).right)
			{
				tanks.get(e).pos.x += tanks.get(e).speed;
				tanks.get(e).barrel.x += tanks.get(e).speed;
			}
			else if(!tanks.get(e).right)
			{
				tanks.get(e).pos.x -= tanks.get(e).speed;
				tanks.get(e).barrel.x -= tanks.get(e).speed;
			}
			
		}
		
	}
	
	public void render(Graphics2D g)
	{
		for(int e = 0; e < tanks.size(); e++)
		{
			tanks.get(e).radian ++;
			g.setColor(Color.BLACK);
			AffineTransform transform = new AffineTransform();
			transform.rotate(Math.toRadians(tanks.get(e).radian), tanks.get(e).pos.getX() + tanks.get(e).pos.width / 2, tanks.get(e).pos.getY() + tanks.get(e).pos.height / 3);
			AffineTransform old = g.getTransform();
			g.transform(transform);
			//g.fill(tanks.get(e).barrel);
			g.setTransform(old);
			
			g.setColor(Color.BLACK);
			//g.fillRect((int) tanks.get(e).barrel.x - (int) cam.getCamera(), (int) tanks.get(e).barrel.y, (int) tanks.get(e).barrel.width, (int) tanks.get(e).barrel.height);
			g.drawImage(Sources.tank[0], (int) tanks.get(e).pos.x, (int) tanks.get(e).pos.y, (int) tanks.get(e).pos.width, (int) tanks.get(e).pos.height, null);
		}
	}
	
	public double randomX()
	{
		Random r = new Random();
		int x = r.nextInt(1800 - 0) - 0;
		return x;
	}
	
	public double randomY()
	{
		Random r = new Random();
		int y = r.nextInt(730 - 560) - (-560);
		return y;
	}
	
	public int randomSpeed()
	{
		Random r = new Random();
		int speed = r.nextInt(5 - 2) - 2;
		return speed;
	}
	
}
