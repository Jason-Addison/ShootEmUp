package states;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class LuckItem 
{

	Rectangle2D.Double pos;
	Rectangle2D.Double bounds;
	//Rectangle2D.Double ;
	BufferedImage image;
	BufferedImage rank;
	int rankInt;
	String name;
	Color color;
	public LuckItem(Rectangle2D.Double pos, Rectangle2D.Double bounds, BufferedImage image, BufferedImage rank, int rankInt, String name, Color color)
	{
		this.pos = pos;
		this.image = image;
		this.rank = rank;
		this.rankInt = rankInt;
		this.name = name;
		this.color = color;
		this.bounds = bounds;
	}
	
}
