package states;

import java.awt.Graphics;
import java.awt.Graphics2D;

import engine.Game;
import engine.Key;
import engine.Upgrades;
import entities.C130Manager;
import entities.CarManager;
import entities.EntityManager;
import entities.Helicopter;
import entities.HelicopterFX;
import entities.RocketManager;
import entities.TankManager;
import gfx.Level;
import gfx.Overlay;
import level.LevelCity;
import staticentities.CloudManager;

public class State
{

	public static int currentState = 1;
	private Level lvl = new Level();
	private Helicopter heli = new Helicopter();
	private Overlay ol = new Overlay();
	private Menu menu = new Menu();
	private Shop shop = new Shop();
	private RocketManager rm = new RocketManager();
	private Luck luck = new Luck();
	private C130Manager c130 = new C130Manager();
	private CloudManager cloud = new CloudManager();
	private Pause pause = new Pause();
	private EntityManager em = new EntityManager();
	private HelicopterFX fx = new HelicopterFX();
	private Editor editor = new Editor();
	private LevelCity city = new LevelCity();
	private TankManager tm = new TankManager();
	private CarManager car = new CarManager();
	//1 = menu, 2 = shop
	public void ManageStates(Graphics g)
	{
		if(currentState == 1)
		{
			Menu(g);
		}
		if(currentState == 0)
		{
			Game(g);
		}
		if(currentState == 2)
		{
			Shop(g);
		}
		if(currentState == 3)
		{
			Luck(g);
		}
		if(currentState == 4)
		{
			Editor(g);
		}
		
		
	}
	
	public void Editor(Graphics g)
	{
		editor.tick();
		editor.render(g);	
	}
	
	public void Menu(Graphics g)
	{
		menu.tick();
		menu.render(g);
	}
	
	public void Luck(Graphics g)
	{
		luck.tick(g); // remove g later m8
	}
	
	public void Game(Graphics g)
	{
		if(!Key.pause)
		{
			rm.tick();
			//lvl.generate();
			ol.tick();
			//lvl.tick();
			heli.tick();
			cloud.tick();
			c130.tick();
			em.tick();
			tm.tick();
			city.tick();
			car.tick();
			Game.frame.add(Overlay.buttonPanel);
			if(Upgrades.health <= 25)
			{
				fx.tick();
			}
			else if(Upgrades.health <= 75)
			{
				fx.lowTick();
			}
		}
		cloud.render(g);
		city.render((Graphics2D) g);
		tm.render((Graphics2D) g);
		//lvl.render(g);
		c130.render(g);
		heli.render(g);
		car.render((Graphics2D) g);
		em.render(g);
		fx.render((Graphics2D) g);
		rm.render(g);
		ol.render((Graphics2D) g);
		if(Key.pause)
		{
			pause.tick();
			pause.render(g);
		}
	}
	
	public void Shop(Graphics g)
	{
		shop.tick();
		shop.render(g);
	}
		
}
