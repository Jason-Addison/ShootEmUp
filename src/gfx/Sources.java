package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sources
{

	public static BufferedImage[] helicopter;
	public static BufferedImage[] helicopterL;
	public static BufferedImage[] explosion;
	public static BufferedImage[] chinookR;
	public static BufferedImage[] biplane;
	public static BufferedImage[] c130;
	public static BufferedImage[] tank;
	public static BufferedImage c130crash;
	public static BufferedImage balloonbomb;
	public static BufferedImage cash;
	public static BufferedImage shop;
	public static BufferedImage minigun;
	public static BufferedImage minigunD;
	public static BufferedImage dualguns;
	public static BufferedImage buy;
	public static BufferedImage expensive;
	public static BufferedImage mountain;
	public static BufferedImage hydraR;
	public static BufferedImage hydraRocketR;
	public static BufferedImage hydraIcon;
	public static BufferedImage heart;
	
	public static BufferedImage common;
	public static BufferedImage uncommon;
	public static BufferedImage rare;
	public static BufferedImage legendary;
	
	public static BufferedImage road;
	public static BufferedImage city1;
	public static BufferedImage city2;
	public static BufferedImage city3;
	
	public static BufferedImage car1;
	public static BufferedImage car1L;
	public static BufferedImage car2;
	public static BufferedImage car2R;
	public static BufferedImage car3;
	public static BufferedImage car3R;
	public static BufferedImage crash;
	
	public void loadImages()
	{
		helicopter = new BufferedImage[3];
		helicopterL = new BufferedImage[3];
		chinookR= new BufferedImage[3];
		explosion = new BufferedImage[3];
		biplane = new BufferedImage[3];
		c130 = new BufferedImage[4];
		tank = new BufferedImage[3];
		
		try 
		{
			helicopter[0] = ImageIO.read(new File("heli1.png"));
			helicopter[1] = ImageIO.read(new File("heli2.png"));
			helicopter[2] = ImageIO.read(new File("heli3.png"));
			
			chinookR[0] = ImageIO.read(new File("chinook1.png"));
			chinookR[1] = ImageIO.read(new File("chinook2.png"));
			chinookR[2] = ImageIO.read(new File("chinook3.png"));
			
			explosion[0] = ImageIO.read(new File("explosion1.png"));
			explosion[1] = ImageIO.read(new File("explosion2.png"));
			explosion[2] = ImageIO.read(new File("explosion3.png"));
			
			biplane[0] = ImageIO.read(new File("biplane1.png"));
			biplane[1] = ImageIO.read(new File("biplane2.png"));
			biplane[2] = ImageIO.read(new File("biplane3.png"));
			
			c130[0] = ImageIO.read(new File("c1301.png"));
			c130[1] = ImageIO.read(new File("c1302.png"));
			c130[2] = ImageIO.read(new File("c1303.png"));
			c130[3] = ImageIO.read(new File("c1302.png"));
			c130crash = ImageIO.read(new File("c130crash.png"));
			
			tank[0] = ImageIO.read(new File("tank1.png"));
			tank[1] = ImageIO.read(new File("tank1.png"));
			tank[2] = ImageIO.read(new File("tank1.png"));
			
			helicopterL[0] = ImageIO.read(new File("heli1L.png"));
			helicopterL[1] = ImageIO.read(new File("heli2L.png"));
			helicopterL[2] = ImageIO.read(new File("heli3L.png"));
			balloonbomb = ImageIO.read(new File("balloonbomb.png"));
			cash = ImageIO.read(new File("cash.png"));
			shop = ImageIO.read(new File("shop.png"));
			minigun = ImageIO.read(new File("minigun.png"));
			minigunD = ImageIO.read(new File("minigunD.png"));
			dualguns = ImageIO.read(new File("dualguns.png"));
			buy = ImageIO.read(new File("buy.png"));
			expensive = ImageIO.read(new File("expensive.png"));
			mountain = ImageIO.read(new File("mountain.png"));
			hydraR = ImageIO.read(new File("hydraR.png"));
			hydraRocketR = ImageIO.read(new File("hydrarocket.png"));
			hydraIcon = ImageIO.read(new File("hydraicon.png"));
			common = ImageIO.read(new File("common.png"));
			uncommon = ImageIO.read(new File("uncommon.png"));
			rare = ImageIO.read(new File("rare.png"));
			legendary = ImageIO.read(new File("legendary.png"));
			road = ImageIO.read(new File("road.png"));
			city1 = ImageIO.read(new File("city1.png"));
			city2 = ImageIO.read(new File("city2.png"));
			city3 = ImageIO.read(new File("Buildings/city3.png"));
			
			car1 = ImageIO.read(new File("Vehicles/car1.png"));
			car1L = ImageIO.read(new File("Vehicles/car1L.png"));
			car2 = ImageIO.read(new File("Vehicles/car2.png"));
			car2R = ImageIO.read(new File("Vehicles/car2R.png"));
			car3 = ImageIO.read(new File("Vehicles/car3.png"));
			car3R = ImageIO.read(new File("Vehicles/car3R.png"));
			crash = ImageIO.read(new File("Vehicles/broken.png"));
			heart = ImageIO.read(new File("Vehicles/fullheart.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
}
