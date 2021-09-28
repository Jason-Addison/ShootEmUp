package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import engine.MouseManager;
import gfx.Fonts;
import gfx.Overlay;
import gfx.ShopItem;
import gfx.Sources;

public class Shop implements ActionListener, MouseListener
{

	int shopItemLim = 10;
	int itemInt = 270;
	int itemScale = 200;
	
	ShopItem[] mainAttack = new ShopItem[shopItemLim];
	ShopItem[] heliUpgrade = new ShopItem[shopItemLim];
	private MouseManager mousse = new MouseManager();
	boolean ye = true;
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		if(ye)
		{
			ye = false;
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(null);
			JButton e = new JButton("DSA");
			e.setOpaque(false);
			
			e.addActionListener(this);
			buttonPanel.add(e);
			buttonPanel.setOpaque(false);
			Game.frame.add(buttonPanel);
			
			mainAttack[0] = new ShopItem("Minigun", "Adds a fast firing", "gun to the side of", "the helicopter.", Sources.minigun, new Rectangle(430, 250, 150, 150), new Rectangle(442, 280, 130, 65), 10);
			mainAttack[1] = new ShopItem("Dual Guns", "Adds a second", "minigun to the", "helicopter.", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			mainAttack[2] = new ShopItem("Hydra", "Adds the ability", "to shoot light", "rockets.",Sources.hydraR, new Rectangle(830, 250, 150, 150), new Rectangle(320, 270, 100, 100), 33);
			mainAttack[3] = new ShopItem("REKT Rocket", "A large rocket", "capable of damaging", "a huge area.", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(235, 290, 120, 60), 20);
			mainAttack[4] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.minigun, new Rectangle(100, 250, 150, 150), new Rectangle(165, 290, 120, 60), 20);
			mainAttack[5] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			mainAttack[6] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			mainAttack[7] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			mainAttack[8] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			mainAttack[9] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			
			heliUpgrade[0] = new ShopItem("Minigun", "Adds a fast firing", "gun to the side of", "the helicopter.", Sources.minigun, new Rectangle(430, 250, 150, 150), new Rectangle(442, 280, 130, 65), 10);
			heliUpgrade[1] = new ShopItem("Dual Guns", "Adds a second", "minigun to the", "helicopter.", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			heliUpgrade[2] = new ShopItem("Hydra", "Adds the ability", "to shoot light", "rockets.",Sources.hydraR, new Rectangle(830, 250, 150, 150), new Rectangle(320, 270, 100, 100), 33);
			heliUpgrade[3] = new ShopItem("REKT Rocket", "A large rocket", "capable of damaging", "a huge area.", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(235, 290, 120, 60), 20);
			heliUpgrade[4] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.minigun, new Rectangle(100, 250, 150, 150), new Rectangle(165, 290, 120, 60), 20);
			heliUpgrade[5] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			heliUpgrade[6] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			heliUpgrade[7] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			heliUpgrade[8] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			heliUpgrade[9] = new ShopItem("cool", "desc1", "desc2", "desc 3", Sources.dualguns, new Rectangle(630,250, 150, 150), new Rectangle(375, 290, 120, 60), 20);
			e.setBounds(mainAttack[0].pos.x, mainAttack[0].pos.y, mainAttack[0].pos.width, mainAttack[0].pos.height);
		}

		renderGui(g);
	}
	
	public void renderGui(Graphics g)
	{
	//	g.fillRect(mainAttack[4].pos.x, mainAttack[4].pos.y, mainAttack[4].pos.width, mainAttack[4].pos.height);
		Rectangle mouse = new Rectangle((int)mousse.getMouseX(), (int)mousse.getMouseY(), 10, 10);
		g.fillRect(mouse.x,mouse.y,mouse.width,mouse.height);
		g.setColor(new Color(0f, 0.7f, 0f, 1f));
		g.fillRect(0, 0, 1800, 200);
		g.setFont(Fonts.shopFontTitle);
		g.setColor(Color.WHITE);
		g.drawString("Shop", 630, 170);
		g.drawImage(Sources.cash, 20, -5, 200, 200, null);
		g.setFont(Fonts.bigFont);
		g.drawString("x" + Overlay.score, 230, 158);
		g.setColor(new Color(0.8f, 0.8f, 0.8f, 1f));
		g.fillRect(0, 200, 400, 800);
		g.setFont(Fonts.smallFont);
		g.setColor(Color.BLACK);
		g.drawString("Main Attack", 430, 235);
		g.drawString("Helicopter Upgrades", 430, 750);
		for(int i = 0; i < shopItemLim; i++)
		{
			g.drawImage(mainAttack[i].image, mainAttack[i].img.x + i * itemInt, mainAttack[i].img.y, mainAttack[i].img.width, mainAttack[i].img.height, null);
			
			if(mainAttack[i].cost > Overlay.score)
			{
				g.drawImage(Sources.expensive, i * itemScale + 430, 250, 150, 150, null);
			}
			
			else if(mainAttack[i].cost <= Overlay.score)
			{
				g.drawImage(Sources.buy, i * itemScale + 430, 250, 150, 150, null);
			}
			
			if(heliUpgrade[i].cost > Overlay.score)
			{
				g.drawImage(Sources.expensive, i * itemScale + 430, 770, 150, 150, null);
			}
			
			else if(heliUpgrade[i].cost <= Overlay.score)
			{
				g.drawImage(Sources.buy, i * itemScale + 430, 250, 150, 150, null);
			}
			
			if (mouse.intersects(mainAttack[i].pos))
			{
				g.setColor(Color.BLACK);
				g.setFont(Fonts.shopFontMedium);
				g.drawString(mainAttack[i].title, 20, 280);
				g.setColor(Color.WHITE);
				g.setFont(Fonts.shopFontSmall);
				g.drawString(mainAttack[i].desc1, 20, 330);
				g.drawString(mainAttack[i].desc2, 20, 360);
				g.drawString(mainAttack[i].desc3, 20, 390);
				g.fillRect(20, 400, 350, 20);
				g.drawString("Price : " + mainAttack[i].cost + "", 20, 460);
				g.drawImage(Sources.cash, 250, 420, 50, 50, null);
			}
			
			g.setColor(Color.GREEN);
			//g.fillRect(mainAttack[4].pos.x, mainAttack[4].pos.y, mainAttack[4].pos.width, mainAttack[4].pos.height);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("Yolo");
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
	
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
