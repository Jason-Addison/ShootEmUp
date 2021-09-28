package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import engine.Camera;
import engine.Key;
import engine.Upgrades;
import gfx.Sources;

public class RocketManager
{

	int hydraTick = 0;
	int hydraTickMax = 10;
	private Upgrades up = new Upgrades();
	private Camera cam = new Camera();
	public static ArrayList<Hydra> hydra = new ArrayList<Hydra>();
	public static ArrayList<RocketSmoke> hydraSmoke = new ArrayList<RocketSmoke>();
	int rsDespawn = 30;
	int hydraDespawn = 1500;
	
	public void tick()
	{
		if(Key.hydra)
		{
		
			hydraTick++;
			if(hydraTick >= hydraTickMax)
			{
				hydraTick = 0;
				shootHydra();
				
			}
			//addSmoke();
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < hydra.size(); i++)
		{
			hydra.get(i).pos.x -= Helicopter.hVelo;
			hydra.get(i).pos.x += hydra.get(i).velocity;
			hydraSmoke.add(new RocketSmoke(new Rectangle(hydra.get(i).pos.x, hydra.get(i).pos.y + 5, 2, 2), 1f, 1f, 0.5f, 0f, 0));
			hydraSmoke.add(new RocketSmoke(new Rectangle(hydra.get(i).pos.x - 5, hydra.get(i).pos.y + 5, 2, 2), 1f, 1f, 0.5f, 0.2f, 0));
			hydraSmoke.add(new RocketSmoke(new Rectangle(hydra.get(i).pos.x - 10, hydra.get(i).pos.y + 5, 2, 2), 1f, 1f, 0.5f, 0.2f, 0));
			g.drawImage(Sources.hydraRocketR, hydra.get(i).pos.x, hydra.get(i).pos.y, hydra.get(i).pos.width, hydra.get(i).pos.height, null);
			
			if(hydra.get(i).pos.x > Helicopter.hX - cam.getCamera() + hydraDespawn)
			{
				hydra.remove(i);
			}
			
		}
		for(int x = 0; x < hydraSmoke.size(); x++)
		{
			g.setColor(new Color(hydraSmoke.get(x).r, hydraSmoke.get(x).g, hydraSmoke.get(x).b, hydraSmoke.get(x).trans));
			g.fillRect(hydraSmoke.get(x).pos.x, hydraSmoke.get(x).pos.y, hydraSmoke.get(x).pos.width, hydraSmoke.get(x).pos.height);
			hydraSmoke.get(x).tick++;
			if(hydraSmoke.get(x).tick >= rsDespawn)
			{
				hydraSmoke.remove(x);
			}
			if(hydraSmoke.get(x).trans > 0.3)
			{
				hydraSmoke.get(x).trans -= 0.3;
			}
			if(hydraSmoke.get(x).r >= 0.3)
			{
				hydraSmoke.get(x).trans -= 0.3;
			}
			if(hydraSmoke.get(x).trans <= 0.3)
			{
				hydraSmoke.remove(x);
			}
			
		}
		
	}
	
	public void shootHydra()
	{
		Upgrades.currentHydra--;
		hydra.add(new Hydra(up.getHydraVel(), up.getHydraDmg(), new Rectangle((int) Helicopter.hX - (int) cam.getCamera() + 30, (int) Helicopter.hY + 65, 20, 10)));
	}
	
	public void addSmoke()
	{
		
	}
	
}
