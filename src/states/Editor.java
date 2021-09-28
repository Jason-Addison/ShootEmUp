package states;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Level;

public class Editor 
{
	private Level lvl = new Level();
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(50, 50, 50, 255));
		g.fillRect(0, 0, 1800, 1000);
		g.setColor(new Color(200, 200, 200, 255));
		g.fillRect(50, 200, 1500, 700);
		
		display(g);
	}
	
	public void display(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect( 75, 225, 1450, 650);
	}
	
}
