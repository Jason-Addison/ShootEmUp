package level;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import engine.Camera;
import entities.Helicopter;
import gfx.Sources;

public class LevelCity
{
	Rectangle rect = new Rectangle (700, 700, 50, 100);
	private Camera cam = new Camera();
	int angle = 0;
	public void tick()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(40, 150, 40, 255));
		g.fillRect(0, 0, 1800, 1000);
		g.setColor(new Color(0.4f, 0.4f, 1f, 1f));
		g.fillRect(0, 0, 1800, 100);
		g.setColor(new Color(0.5f, 0.5f, 1f, 1f));
		g.fillRect(0, 100, 1800, 100);
		g.setColor(new Color(0.6f, 0.6f, 1f, 1f));
		g.fillRect(0, 200, 1800, 100);
		g.setColor(new Color(0.7f, 0.7f, 1f, 1f));
		g.fillRect(0, 300, 1800, 100);
		
		for(int e = 0; e < 60; e++)
		{
			if( e % 3 == 0)
			{
				g.drawImage(Sources.city1, (e  * 200) - (int) cam.getCamera() - 500, 160, 200, 400, null);
			}
			else if (e % 3 == 1)
			{
				g.drawImage(Sources.city2, (e  * 200) - (int) cam.getCamera() - 500, 160, 200, 400, null); 
			} 
			else
			{
				g.drawImage(Sources.city3, (e  * 200) - (int) cam.getCamera() - 500, 160, 200, 400, null);
			}
		}
		for(int e = 0; e < 90; e++)
		{
			if( e % 3 == 0)
			{
				g.drawImage(Sources.city1, (e  * 150) - (int) cam.getCamera() - 100, 360, 150, 300, null);
			}
			else if (e % 3 == 1)
			{
				g.drawImage(Sources.city2, (e  * 150) - (int) cam.getCamera() - 100, 360, 150, 300, null);
			} 
			else
			{
				g.drawImage(Sources.city3, (e  * 150) - (int) cam.getCamera() - 100, 360, 150, 300, null);
			}
		}
		for(int e = 0; e < 30; e++)
		{		
			g.drawImage(Sources.road, (e  * 500) - (int) cam.getCamera() - 100, 740, 500, 100, null);
			g.drawImage(Sources.road, (e  * 500) - (int) cam.getCamera() - 100, 660, 500, 100, null);
		}
		if(Helicopter.hX < 650)
		{
			angle--;
		}
		/*rect.x -= Helicopter.hVelo;
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(angle), rect.getX() + rect.width / 2, rect.getY() + rect.height);
		AffineTransform old = g.getTransform();
		g.transform(transform);
		g.fill(rect);
		g.setTransform(old);*/
	}
}
