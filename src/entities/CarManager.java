package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import engine.Camera;
import engine.Key;
import gfx.Sources;

public class CarManager 
{

	public static ArrayList<Car> cars = new ArrayList<Car>();
	public static ArrayList<Car> carsL = new ArrayList<Car>();
	public static ArrayList<Car> crash = new ArrayList<Car>();
	private Camera cam = new Camera();
	static int tick = 0;
	int tickMax = 60;
	int stopDis = 300;
	private Comparator<Car> compare = new Comparator<Car>()
	{
	@Override
		public int compare(Car a, Car b)
		{
			if(a.pos.y < b.pos.y)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	};	
	public void tick()
	{
		tick++;
		
		if(tick >= tickMax)
		{
			System.out.println(tick);
			tick = 0;
			cars.add(new Car(new Rectangle2D.Double(-randomX(), randomY(), 80, 50), randomCar(), -randomSpeed(), 20, true, false));
			
			carsL.add(new Car(new Rectangle2D.Double(randomX() + 1800, randomYL(), 80, 50), randomCarL(), -randomSpeed(), 20, false, false));
		}
		
		for(int i = 0; i < cars.size(); i++)
		{			
			for(int x = 0; x < RocketManager.hydra.size(); x++)
			{
				if(cars.get(i).pos.intersects(RocketManager.hydra.get(x).pos))
				{
					cars.get(i).health -= RocketManager.hydra.get(x).damage;
					EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle(RocketManager.hydra.get(x).pos.x, RocketManager.hydra.get(x).pos.y - 25, 50, 50), 3));
					RocketManager.hydra.remove(x);
				}
			}
			if(Key.stop)
			{
				cars.get(i).stop = true;
			}
			for(int x = 0; x < EnemySpawn.explosions.size(); x++)
			{
				if(cars.get(i).pos.x >= EnemySpawn.explosions.get(x).pos.x - 500)
				{
					if(cars.get(i).pos.x <= EnemySpawn.explosions.get(x).pos.x + 500)
					{
						cars.get(i).stop = true;
					}
				}
			}
			if(!cars.get(i).stop)
			{
				cars.get(i).pos.x += cars.get(i).speed;
			}
			cars.get(i).pos.x -= Helicopter.hVelo;
			if(cars.get(i).health <= 0)
			{
				crash.add(new Car(new Rectangle2D.Double(cars.get(i).pos.x, cars.get(i).pos.y, 80, 50), Sources.crash, 0, 20, true, false));
				cars.remove(i);
			}
			else if(cars.get(i).pos.x > Helicopter.hX - cam.getCamera() + 3500)
			{
				cars.remove(i);
			}
		}
		for(int i = 0; i < carsL.size(); i++)
		{
			for(int x = 0; x < RocketManager.hydra.size(); x++)
			{
				if(carsL.get(i).pos.intersects(RocketManager.hydra.get(x).pos))
				{
					carsL.get(i).health -= RocketManager.hydra.get(x).damage;
					EnemySpawn.explosions.add(new Explosion(0, 0, new Rectangle(RocketManager.hydra.get(x).pos.x, RocketManager.hydra.get(x).pos.y - 25, 50, 50), 3));
					RocketManager.hydra.remove(x);
				}
			}
			if(Key.stop)
			{
				carsL.get(i).stop = true;
			}
			if(!carsL.get(i).stop)
			{
				carsL.get(i).pos.x -= carsL.get(i).speed;
			}
			for(int x = 0; x < EnemySpawn.explosions.size(); x++)
			{
				if(carsL.get(i).pos.x >= EnemySpawn.explosions.get(x).pos.x - 500)
				{
					if(carsL.get(i).pos.x <= EnemySpawn.explosions.get(x).pos.x + 500)
					{
						carsL.get(i).stop = true;
					}
				}
			}
			carsL.get(i).pos.x -= Helicopter.hVelo;
			if(carsL.get(i).health <= 0)
			{
				crash.add(new Car(new Rectangle2D.Double(carsL.get(i).pos.x, carsL.get(i).pos.y, 80, 50), Sources.crash, 0, 20, true, false));
				carsL.remove(i);
			}
			else if(carsL.get(i).pos.x < Helicopter.hX - cam.getCamera() - 500)
			{
				carsL.remove(i);
			}
		
		}
		
		for(int x = 0; x < crash.size(); x++)
		{
			crash.get(x).pos.x -= Helicopter.hVelo;
			HelicopterFX.smoke.add(new Smoke(new Rectangle2D.Double((int)crash.get(x).pos.x + 40 + (int) (randomOffset() - 5), (int) crash.get(x).pos.y + 30 +(int) (randomOffset() - 5), 10, 10), 0.7f, 1f, 0.5f, 0f, 1));
		}
		
		cars.sort(compare);
		carsL.sort(compare);
	}
	double e = 0;
	Rectangle d = new Rectangle(500, 500, 100, 50);
	public void render(Graphics2D g)
	{
		for(int i = 0; i < carsL.size(); i++)
		{
			g.drawImage(carsL.get(i).texture, (int) carsL.get(i).pos.x, (int) carsL.get(i).pos.y, (int) carsL.get(i).pos.width, (int) carsL.get(i).pos.height, null);
			//g.setColor(Color.RED);
			//g.fillRect((int) carsL.get(i).pos.x, (int) carsL.get(i).pos.y, carsL.get(i).health, 10);
		}
		for(int i = 0; i < cars.size(); i++)
		{
			g.drawImage(cars.get(i).texture, (int) cars.get(i).pos.x, (int) cars.get(i).pos.y, (int) cars.get(i).pos.width, (int) cars.get(i).pos.height, null);
		}
		
		for(int i = 0; i < crash.size(); i++)
		{
			g.drawImage(crash.get(i).texture, (int) crash.get(i).pos.x, (int) crash.get(i).pos.y, (int) crash.get(i).pos.width, (int) crash.get(i).pos.height, null);
		}
		g.setColor(Color.BLACK);
		g.drawString(tick + "", 100, 100);
		d.x -= Helicopter.hVelo;
		g.setColor(Color.BLACK);
		if(d.intersects(Helicopter.heliBound))
		{
			g.setColor(Color.RED);
		}
		e++;
		AffineTransform transform = new AffineTransform();
		
		transform.rotate(Math.toRadians(e), d.x + d.width / 2, d.y + d.height / 2);
		AffineTransform old = g.getTransform();
		g.transform(transform);
		g.fill(d);
		g.setTransform(old);
	}
	
	public double randomOffset()
	{
		Random r = new Random();
		int off = r.nextInt(10 - 0) - 0;
		return off;
	}
	
	public double randomX()
	{
		Random r = new Random();
		int x = r.nextInt(800 - 0) - 0;
		return x;
	}
	
	public double randomY()
	{
		Random r = new Random();
		int y = r.nextInt(790 - 730) + 730;
		return y;
	}
	public double randomYL()
	{
		Random r = new Random();
		int y = r.nextInt(700 - 630) + 630;
		return y;
	}
	
	public int randomSpeed()
	{
		Random r = new Random();
		int speed = r.nextInt(7 - 5) - 5;
		return speed;
	}
	
	public BufferedImage randomCar()
	{
		Random r = new Random();
		int image = r.nextInt(3 - 0) - 0;
		if(image == 0)
		{
			return Sources.car1;
		}
		else if (image == 1)
		{
			return Sources.car2R;
		}
		else
		{
			return Sources.car3R;
		}
	}
	public BufferedImage randomCarL()
	{
		Random r = new Random();
		int image = r.nextInt(3 - 0) - 0;
		if(image == 0)
		{
			return Sources.car1L;
		}
		else if(image == 1)
		{
			return Sources.car2;
		}
		else
		{
			return Sources.car3;
		}
	}
	
	public boolean right()
	{
		Random r = new Random();
		int right = r.nextInt(2 - 0) - 0;
		if(right == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
			
	}
}
