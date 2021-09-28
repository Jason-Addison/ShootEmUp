package states;

import java.awt.Color;
import java.awt.Graphics;

import engine.Key;
import gfx.Fonts;
import gfx.Level;
import gfx.Sources;

public class Menu 
{
	private Level lvl = new Level();
	private Fonts font = new Fonts();
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(0.2f, 0.2f, 1f, 1f));
		g.fillRect(0, 0, 1800, 200);
		g.setColor(new Color(0.3f, 0.3f, 1f, 1f));
		g.fillRect(0, 200, 1800, 200);
		g.setColor(new Color(0.4f, 0.4f, 1f, 1f));
		g.fillRect(0, 400, 1800, 200);
		g.setColor(new Color(0.5f, 0.5f, 1f, 1f));
		g.fillRect(0, 600, 1800, 200);
		g.setColor(new Color(0.6f, 0.6f, 1f, 1f));
		g.fillRect(0, 800, 1800, 200);
		
		lvl.generate();
		lvl.render(g);
		
		g.setFont(font.bigFont);
		
		if(Key.menuSelect == 1)
		{
			g.setColor(Color.BLACK);
			g.drawString("Play", 750, 300);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.drawString("Play", 750, 300);
		}
		if(Key.menuSelect == 2)
		{
			g.setColor(Color.BLACK);
			g.drawString("Editor", 680, 450);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.drawString("Editor", 680, 450);
		}
		if(Key.menuSelect == 3)
		{
			g.setColor(Color.BLACK);
			g.drawString("Options", 640, 600);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.drawString("Options", 640, 600);
		}
		if(Key.menuSelect == 4)
		{
			g.setColor(Color.BLACK);
			g.drawString("Quit", 750, 750);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.drawString("Quit", 750, 750);
		}
		
	}
	
}
