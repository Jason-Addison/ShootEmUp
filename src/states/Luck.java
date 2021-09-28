package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import gfx.Fonts;
import gfx.Overlay;
import gfx.Sources;

public class Luck implements ActionListener
{

	ArrayList<LuckItem> items = new ArrayList<LuckItem>();
	double x = 0;
	int options = 16;
	double spinVel = 0;
	boolean spin = false;
	Rectangle2D.Double pointer = new Rectangle2D.Double(900, 320, 20, 200);
	String currentItem;
	Color currentColor;
	boolean launch = true;
	Rectangle spinB = new Rectangle(800, 700, 200, 100);
	int spinCount = 0;
	int common, uncommon, rare, legendary;
	int randomVel = 50;
	boolean spinLock = false;
	public void tick(Graphics g)
	{
		if(launch)
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(null);
			JButton e = new JButton("DSA");
			e.setOpaque(false);
			e.setBounds(spinB);
			e.addActionListener(this);
			buttonPanel.add(e);
			buttonPanel.setOpaque(false);
			Game.frame.add(buttonPanel);
			launch = false;
		}
		
	
		for(int i = 0; i < items.size(); i++)
		{
			if(items.get(i).pos.x < -300)
			{
				items.remove(i);
			}
			
		}
		render((Graphics2D) g);
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(0.3f, 0.3f, 0.3f, 1f));
		g.fillRect(0, 0, 1800, 1000);
		
		g.setColor(new Color(0.7f, 0.7f, 0.7f, 1f));
		g.fillRect(0, 350, 1800, 300);
		for(int i = 0; i < items.size(); i++)
		{
			//items.get(i).pos.x -= 20;
			g.drawImage(items.get(i).image, (int) items.get(i).pos.x, (int)  items.get(i).pos.y, (int) items.get(i).pos.width, (int) items.get(i).pos.height, null);
			g.drawImage(items.get(i).rank, (int) items.get(i).pos.x, (int) items.get(i).pos.y - 60, 250, 250, null);
			items.get(i).pos.x -= spinVel;
		}
		if(spinVel <= -randomVel && spin)
		{
			spinVel++;
		}
		if(spinVel >= -randomVel)
		{
			spin = false;
		}
		g.setFont(Fonts.shopFontMedium);
		g.setColor(Color.WHITE);
		g.drawString("You won : ", 615, 200);
		if(!spin)
		{
			for(int i = 0; i < items.size(); i++)
			{
				if(pointer.intersects(items.get(i).pos))
				{
					currentItem = items.get(i).name;
					currentColor = items.get(i).color;
				}
			}
		}
		if(currentItem == null)
		{
			currentItem = "???";
		}
		g.setColor(currentColor);
		g.drawString(currentItem + "", 960, 200);
		//g.drawString(common + " " + uncommon + " " + rare + " " + legendary, 300, 200);
		if(spinVel > 0 && !spin)
		{
			spinVel -= 0.1;
			
		}
		if(spinVel <= 0)
		{
			spinLock = false;
		}
		if(spinLock)
		{
			g.setColor(new Color(0.5f, 0.5f, 0.5f, 1f));
		}
		else
		{
			g.setColor(Color.WHITE);
		}
		g.fill(spinB);
		g.setColor(Color.BLACK);
		g.drawString("Spin!", spinB.x + 30, spinB.y + 70);
		g.drawImage(Sources.cash, 20, -5, 200, 200, null);
		g.setColor(Color.WHITE);
		g.drawString("-50", spinB.x, spinB.y + 250);
		g.drawImage(Sources.cash, spinB.x + 110, spinB.y + 185, 90, 90, null);
		g.setFont(Fonts.bigFont);
		g.drawString("x" + Overlay.score, 230, 158);
		g.setColor(Color.WHITE);
		g.fillRect((int) pointer.x,(int) pointer.y,(int) pointer.width,(int) pointer.height);
		System.out.println(randomVel);
	}
	
	public int getRandom()
	{
		Random r = new Random();
		int ran = r.nextInt(options - 0) - 0;
		return ran;
	}
	public int getRandomVelo()
	{
		Random r = new Random();
		randomVel = r.nextInt(100 - 80) - 80;
		return randomVel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(!spinLock)
		{
			Overlay.score -= 50;
			items.clear();
			spinVel = 0;
			x = 1800;
			randomVel = getRandomVelo();
			spin = true;
			for(int i = 0; i < 200; i++)
			{
				if(getRandom() == 0 || getRandom() == 1 || getRandom() == 2 || getRandom() == 3 || getRandom() == 4 || getRandom() == 5 || getRandom() == 6 || getRandom() == 14)
				{
					items.add(new LuckItem(new Rectangle2D.Double(x, 430, 220, 145), new Rectangle2D.Double(x, 430, 250, 250), Sources.dualguns, Sources.common, 5, "Common", new Color(0f, 1f, 0f, 1f)));
					x += 250;
					common++;
				}
				if(getRandom() == 7 || getRandom() == 8 || getRandom() == 9 || getRandom() == 10)
				{
					items.add(new LuckItem(new Rectangle2D.Double(x, 430, 220, 145), new Rectangle2D.Double(x, 430, 250, 250), Sources.hydraR, Sources.uncommon, 10, "Uncommon", new Color(0.6f, 0f, 0.9f, 1f)));
					x += 250;
					uncommon++;
				}
				if(getRandom() == 11 || getRandom() == 12 || getRandom() == 13)
				{
					items.add(new LuckItem(new Rectangle2D.Double(x, 430, 220, 145),new Rectangle2D.Double(x, 430, 250, 250), Sources.dualguns, Sources.rare, 5, "Rare", new Color(0f, 0f, 1f, 1f)));
					x += 250;
					rare++;
				}
				if(getRandom() == 15)
				{
					items.add(new LuckItem(new Rectangle2D.Double(x, 430, 220, 145),new Rectangle2D.Double(x, 430, 250, 250), Sources.hydraR, Sources.legendary, 10, "Legendary", new Color(1f, 1f, 0f, 1f)));
					x += 250;
					legendary++;
				}
					
			}
			spinLock = true;
		}
	}
	
}
