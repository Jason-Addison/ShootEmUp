package gfx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import engine.Upgrades;
import entities.EntityCount;

public class Overlay 
{

	public static int score = 0;
	Area shopOut = new Area(new Rectangle(1600, 0, 150, 150));
	private Upgrades up = new Upgrades();
	private Level lvl = new Level();
	
	int warning = 10;
	int warningMax = 40;
	boolean warningSign = false;
	public static float redBar = 0;
	public static float greenBar = 1;
	Point warningPoint = new Point(820, 5);
	Rectangle balloonInc = new Rectangle(1670, 180, 100, 100);
	Rectangle biplaneInc = new Rectangle(1670, 300, 100, 100);
	Rectangle C130Inc = new Rectangle(1670, 420, 100, 100);
	Rectangle speedOv = new Rectangle(1540, 180, 100, 100);
	Rectangle speedDecR = new Rectangle(1540, 300, 100, 100);
	Rectangle speedIncR = new Rectangle(1540, 420, 100, 100);
	public static JPanel buttonPanel = new JPanel();
	static boolean launch = true;
	boolean overrideSpeed = false;
	double speedOver = 0;
	double speedInt = 1;
	public void tick()
	{
		if(launch)
		{
		
			buttonPanel.setLayout(null);
			JButton addBalloon = new JButton();
			JButton addBiplane = new JButton();
			JButton addC130 = new JButton();
			
			JButton speedOverride = new JButton();
			JButton speedInc = new JButton();
			JButton speedDec = new JButton();
			
			speedOverride.setOpaque(false);
			speedOverride.setBounds(speedOv);
			speedOverride.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e) 
			    {
			    	if(overrideSpeed)
			    	{
			    		overrideSpeed = false;
			    	}
			    	else
			    	{
			    		overrideSpeed = true;
			    	}
					Game.frame.requestFocusInWindow();
				}
			}
			);
			speedInc.setOpaque(false);
			speedInc.setBounds(speedIncR);
			speedInc.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e) 
			    {
			    	Upgrades.speedOverride -= speedInt;
					Game.frame.requestFocusInWindow();
				}
			}
			);
			speedDec.setOpaque(false);
			speedDec.setBounds(speedDecR);
			speedDec.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e) 
			    {
			    	Upgrades.speedOverride += speedInt;
					Game.frame.requestFocusInWindow();
				}
			}
			);
			
			addBalloon.setOpaque(false);
			addBalloon.setBounds(balloonInc);
			addBalloon.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e) 
			    {
					EntityCount.balloonCount++;
					Game.frame.requestFocusInWindow();
				}
			}
			);
			addBiplane.setOpaque(false);
			addBiplane.setBounds(biplaneInc);
			addBiplane.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e) 
			    {
					EntityCount.biplaneCount++;
					Game.frame.requestFocusInWindow();
				}
			}
			);
			addC130.setOpaque(false);
			addC130.setBounds(C130Inc);
			addC130.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e) 
			    {
					EntityCount.C130Count++;
					Game.frame.requestFocusInWindow();
				}
			}
			);
			buttonPanel.add(addC130);
			buttonPanel.add(addBiplane);
			buttonPanel.add(addBalloon);
			buttonPanel.add(speedOverride);
			buttonPanel.add(speedDec);
			buttonPanel.add(speedInc);
			buttonPanel.setOpaque(false);
			Game.frame.add(buttonPanel);
			launch = false;
		}
		
		up.tick();
		Game.frame.requestFocusInWindow();
	}
	
	public void render(Graphics2D g)
	{
		//redBar = (float) Upgrades.health / 100;
		//greenBar = (float) Upgrades.health / 10;
		g.setColor(new Color(0.2f, 0.2f, 0.2f, 1f));
		g.fillRect(1280, 0, 510, 170);
		g.setColor(new Color(0.4f, 0.4f, 0.4f, 1f));
		g.fillRect(1300, 0, 500, 150);
		g.setColor(Color.WHITE);
		g.setFont(Fonts.font);
		render2D((Graphics2D) g);
		g.drawString("x" + score, 1430, 130);
		g.setFont(Fonts.smallFont);
		g.drawString(lvl.getCurrentLvl() + " Grasslands", 1300, 50);
		g.drawImage(Sources.cash, 1320, 50, 100, 100, null);
		g.drawImage(Sources.shop, 1615, 20, 110, 110, null);
		g.setColor(new Color(1f, 0f, 0f, 0.3f));
		g.fillRect(790, 120, 450, 50);
		g.setColor(new Color(redBar, greenBar, 0f, 1f));
		g.fillRect(790, 120, (int) (up.getHealth() * 4.5), 50);
		
		if(Upgrades.health < 25)
		{
			warning++;
			if(warning >= warningMax)
			{
				warning = 0;
				if(warningSign)
				{
					warningSign = false;
				}
				else if(!warningSign)
				{
					warningSign = true;
				}
			}
		}
		else if(Upgrades.health > 25)
		{
			warning = 0;
			warningSign = false;
		}
		g.setColor(new Color(50, 50, 50, 150));
		g.fillRect(0, 850, 1800, 120);
		g.drawImage(Sources.hydraIcon, 50, 855, 100, 100, null);
		g.setFont(Fonts.font);
		g.setColor(Color.WHITE);
		g.drawString("x" + Upgrades.currentHydra, 120, 950);
		if(warningSign)
		{

			g.setColor(Color.RED);
			g.fillRect(warningPoint.x, warningPoint.y, 20, 80);
			g.fillRect(warningPoint.x, warningPoint.y + 95, 20, 20);
			g.fillRect(warningPoint.x + 350, warningPoint.y, 20, 80);
			g.fillRect(warningPoint.x + 350, warningPoint.y + 95, 20, 20);
			g.setColor(Color.RED);
			g.setFont(Fonts.font);
			g.drawString("Warning", 870, 100);
		}
		if(Upgrades.cheatMode)
		{
			g.setColor(new Color(0.3f, 0.3f, 0.3f, 0.5f));
			g.fill(balloonInc);
			g.drawImage(Sources.balloonbomb, balloonInc.x + 20, balloonInc.y, balloonInc.width - 45, balloonInc.height, null);
			g.fill(biplaneInc);
			g.drawImage(Sources.biplane[0], biplaneInc.x, biplaneInc.y + 22, 96, 44, null);
			g.fill(C130Inc);
			g.drawImage(Sources.c130[0], C130Inc.x, C130Inc.y + 30, 96, 35, null);
			g.setColor(Color.WHITE);
			g.setFont(Fonts.tinyFont);
			g.drawString("Balloon", balloonInc.x + 3, balloonInc.y + 100);
			g.drawString("Biplane", biplaneInc.x + 8, biplaneInc.y + 100);
			g.drawString("C130", C130Inc.x + 25, C130Inc.y + 100);
			g.setColor(new Color(0.3f, 0.3f, 0.3f, 0.5f));
			g.fill(speedIncR);
			g.fill(speedDecR);
		
			if(overrideSpeed)
			{
				g.setColor(new Color(0.3f, 0.3f, 0.3f, 0.5f));
				g.fill(speedOv);
				g.setColor(Color.GREEN);
				g.fillRect(speedOv.x + 10, speedOv.y + 10, 80, 80);
			
			}
			else
			{
				g.setColor(new Color(0.3f, 0.3f, 0.3f, 0.5f));
				g.fill(speedOv);
				g.setColor(Color.RED);
				g.fillRect(speedOv.x + 10, speedOv.y + 10, 80, 80);
			}
		
			g.setColor(Color.WHITE);
			g.setFont(Fonts.special);
			g.drawString("+", speedIncR.x + 10, speedIncR.y - 35);
			g.drawString("-", speedDecR.x + 17, speedDecR.y + 205);
		
			g.setFont(Fonts.shopFontSmall);
			g.setColor(Color.WHITE);
			g.drawString("Speed", speedOv.x, speedOv.y + 120);
		}
	}
	
	public void render2D(Graphics2D g)
	{
		shopOut.subtract(new Area(new Rectangle2D.Double(1610, 10, 130, 130)));
		g.fill(shopOut);
	}
	
}
