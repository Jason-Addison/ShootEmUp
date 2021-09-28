package gfx;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ShopItem 
{

	public String title;
	public String desc1;
	public String desc2;
	public String desc3;
	public BufferedImage image;
	public Rectangle pos;
	public int scaleX;
	public int scaleY;
	public int cost;
	public Rectangle img;
	public ShopItem(String title, String desc1, String desc2, String desc3, BufferedImage image, Rectangle pos, Rectangle img, int cost)
	{
		this.title = title;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.image = image;
		this.pos = pos;
		this.cost = cost;
		this.img = img;
	}
	
}
