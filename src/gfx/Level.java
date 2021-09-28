package gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import engine.Camera;
import entities.Helicopter;
import entities.HelicopterFX;
import states.State;

public class Level 
{
	int tileScale = 50;
	int tileCount = 50;
	int pastY = 1000;
	int yRan = 100;
	static int tileInt = 10;
	int tileLevel = 1800;
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	private Camera cam = new Camera();
	private Helicopter heli = new Helicopter();
	int currentLvl = 1;
	
	public void generate()
	{
		while(tiles.size() < 200)
		{
			tiles.add(new Tile(getYRan() + tileLevel));
			tiles.add(new Tile(getYRan() + tileLevel));
			tiles.add(new Tile(getYRan() + tileLevel));
			tiles.add(new Tile(getYRan() + tileLevel));
			tiles.add(new Tile(getYRan() + tileLevel));
			tiles.add(new Tile(getYRan() + tileLevel));
			tiles.add(new Tile(getYRan() + tileLevel));
			tiles.add(new Tile(getYRan() + tileLevel));
			
		}
		System.out.println(tiles.size());
	}
	
	public void tick()
	{
		if(tiles.size() * 2 < Helicopter.hX / 2)
		{
			//tiles.add(new Tile(getYRan() + tileLevel));
		}
		
	}
	
	float prevAlphaSun = 0.8f;
	int alpha = 255;
	
	public void render(Graphics g)
	{

		System.out.println(HelicopterFX.smoke.size());
		
		if(State.currentState == 0)
		{
			g.setColor(new Color(0.4f, 0.4f, 1f, 1f));
			g.fillRect(0, 0, 1800, 200);
			g.setColor(new Color(0.5f, 0.5f, 1f, 1f));
			g.fillRect(0, 200, 1800, 200);
			g.setColor(new Color(0.6f, 0.6f, 1f, 1f));
			g.fillRect(0, 400, 1800, 200);
			g.setColor(new Color(0.7f, 0.7f, 1f, 1f));
			g.fillRect(0, 600, 1800, 200);
			g.setColor(new Color(0.6f, 0.6f, 1f, 1f));
			g.fillRect(0, 800, 1800, 200);
		}
		for(int i = 0; i < 10; i++)
		{
			g.drawImage(Sources.mountain, i * 500 - (int) cam.getCamera() / 20, 440, 500, 250, null);
		}
		for(int i = 1; i < 30; i++)
		{
			g.setColor(new Color(255, 255, 0, alpha / i));
			{
				g.fillOval(100 - i, 50 - i, 100 + (i * 2), 100 +(i * 2));
			}
		}
		
		for(int y = 0; y < tiles.size(); y++)
		{
			g.setColor(Color.GREEN);
			g.fillRect((int) (y * (int) (tileScale / 4.5) - ((int) cam.getCamera() / 4.5)), tiles.get(y).y - 150, tileScale / 4, tileScale /  4 * 20);
			g.setColor(new Color(0.4f,0.4f,0.4f,1f));
			g.fillRect((int) (y * (int)(tileScale / 4.5) - ((int) cam.getCamera() / 4.5)), tiles.get(y).y - 140, tileScale / 4, tileScale / 4 * 20);
		}
		for(int y = 0; y < tiles.size(); y++)
		{
			g.setColor(Color.GREEN);
			g.fillRect(y * tileScale / 2 - ((int) cam.getCamera() / 2), tiles.get(y).y - 100, tileScale / 2, tileScale /  2 * 20);
			g.setColor(new Color(0.5f,0.5f,0.5f,1f));
			g.fillRect(y * tileScale / 2 - ((int) cam.getCamera() / 2), tiles.get(y).y - 90, tileScale / 2, tileScale / 2 * 20);
		}
		for(int y = 0; y < tiles.size(); y++)
		{
			g.setColor(Color.GREEN);
			g.fillRect(y * tileScale - (int) cam.getCamera(), tiles.get(y).y, tileScale, tileScale * 20);
			g.setColor(new Color(0.6f,0.6f,0.6f,1f));
			g.fillRect(y * tileScale - (int) cam.getCamera(), tiles.get(y).y + 20, tileScale, tileScale * 20);
		}
		
	}
	public int getYRan()
	{
		Random ran = new Random();
		yRan = ran.nextInt((pastY + tileInt) - (pastY - tileInt)) - (pastY - tileInt);
		
		int y = yRan;
		return y;
	}
	
	public void reset()
	{
		tiles.clear();
	}
	
	public int getCurrentLvl()
	{
		return currentLvl;
	}
}
