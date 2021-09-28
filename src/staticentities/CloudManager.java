package staticentities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import engine.Camera;
import entities.Helicopter;

public class CloudManager
{

	public static ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	private Camera cam = new Camera();
	public void tick()
	{
		if(clouds.size() <= 10)
		{
			clouds.add(new Cloud(new Rectangle2D.Double(-randomX(), randomY(), randomWidth(), randomHeight()), new Color(0.8f, 0.8f, 0.8f, 0.5f), false, 0.3));
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < clouds.size(); i++)
		{
			if(clouds.get(i).right)
			{
				clouds.get(i).pos.x += clouds.get(i).speed;
			}
			else
			{
				clouds.get(i).pos.x -= clouds.get(i).speed * 5;
			}
			clouds.get(i).pos.x -= 0.44444444444;
			clouds.get(i).pos.x -= Helicopter.hVelo / 4.5;
			g.setColor(clouds.get(i).color);
			g.fillRect((int) clouds.get(i).pos.x,(int) clouds.get(i).pos.y,(int) clouds.get(i).pos.width,(int) clouds.get(i).pos.height);
			
			if(clouds.get(i).pos.x < -500)
			{
				clouds.remove(i);
			}
		}
	}
	
	public double randomY()
	{
		Random r = new Random();
		int ranY = r.nextInt(500 - 0) - 0;
		return ranY;
	}
	public double randomX()
	{
		Random r = new Random();
		int ranX = r.nextInt((2000 + (int) Helicopter.hX) - (int) Helicopter.hX) + (1500 + (int) Helicopter.hX);
		return ranX;
	}
	public double randomWidth()
	{
		Random r = new Random();
		int ranX = r.nextInt(600 - 100) - 100;
		return ranX;
	}
	public double randomHeight()
	{
		Random r = new Random();
		int ranY = r.nextInt(300 - 50) - 50;
		return ranY;
	}
}
