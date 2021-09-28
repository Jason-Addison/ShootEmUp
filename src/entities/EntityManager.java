package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import engine.Camera;
import engine.Key;
import engine.Upgrades;

public class EntityManager
{
	public static ArrayList<HeliBullet> bullets = new ArrayList<HeliBullet>();
	public static ArrayList<HeliBullet> bulletsL = new ArrayList<HeliBullet>();
	private BiplaneManager bm = new BiplaneManager();
	private Upgrades upg = new Upgrades();
	private Camera cam = new Camera();
	int bulletDespawn = 1500;
	private EnemySpawn es = new EnemySpawn();
	int bulletTimer = 0;
	int bulletTimerMax = 5;
	public void tick()
	{
		if(Key.shoot)
		{
			bulletTimer++;
		}
		if(Upgrades.dualGuns)
		{
			bulletTimerMax = 2;
		}
		if(bulletTimer >= bulletTimerMax)
		{
			
			if(Key.leftLock)
			{
				bulletTimer = 0;
				shootBulletL();
			}
			else
			{
				bulletTimer = 0;
				shootBulletR();
			}
		}
		for(int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).pos.x += bullets.get(i).velocity;
			
			bullets.get(i).pos.x -= Helicopter.hVelo;
			if(bullets.get(i).pos.x > Helicopter.hX - cam.getCamera() + bulletDespawn)
			{
				bullets.remove(i);
			}
		}
		//c130.tick();
		bm.tick();
		es.tick();
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < bullets.size(); i++)
		{
			g.setColor(Color.BLACK);
			g.fillRect(bullets.get(i).pos.x, bullets.get(i).pos.y, bullets.get(i).pos.width, bullets.get(i).pos.height);
		}
		for(int i = 0; i < bulletsL.size(); i++)
		{
			bulletsL.get(i).pos.x -= bulletsL.get(i).velocity;
			
			bulletsL.get(i).pos.x -= Helicopter.hVelo;
			g.setColor(Color.BLACK);
			g.fillRect(bulletsL.get(i).pos.x, bulletsL.get(i).pos.y, bulletsL.get(i).pos.width, bulletsL.get(i).pos.height);
			if(bulletsL.get(i).pos.x < Helicopter.hX - cam.getCamera() + -bulletDespawn)
			{
				bulletsL.remove(i);
			}
		}
		//c130.render(g);
		bm.render(g);
		es.render((Graphics2D) g);	
	}
	
	public void shootBulletR()
	{
		bullets.add(new HeliBullet(upg.getBulletDmg(), upg.getBullVel(), (new Rectangle((int) Helicopter.hX - (int) cam.getCamera(), (int) Helicopter.hY + 65, 2, 2))));	
	}	
	public void shootBulletL()
	{
		bulletsL.add(new HeliBullet(upg.getBulletDmg(), upg.getBullVel(), (new Rectangle((int) Helicopter.hX - (int) cam.getCamera(), (int) Helicopter.hY + 60, 2, 2 ))));	
	}	
}