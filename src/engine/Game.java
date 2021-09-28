package engine;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Helicopter;
import gfx.Fonts;
import gfx.Level;
import gfx.Overlay;
import gfx.Sources;
import states.State;

public class Game extends JPanel
{

	int width = 1800;
	int height = 1000;
	static String title = "Fly Game??";
	public static JFrame frame = new JFrame(title);
	boolean inGame = true;
	private Helicopter heli = new Helicopter();
	private Sources src = new Sources();
	private Level lvl = new Level();
	private Key key = new Key();
	private Overlay ol = new Overlay();
	private Fonts font = new Fonts();
	private State state = new State();
	private MouseManager mouse = new MouseManager();
	public void launch()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.add(this);

		frame.setFocusable(true);
		frame.addKeyListener(key);
		frame.addMouseListener(key);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("balloonbomb.png"));
		frame.setVisible(true);
		src.loadImages();
		font.loadFonts();
		
		tick();
	}
	
	public void tick()
	{
		int e = 0;
		

		while(inGame)
		{
			update();
			try 
			{
				Thread.sleep(1000 / 60);
			} 
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	public void update()
	{
		frame.revalidate();
		frame.repaint();
		frame.setFocusable(true);
	}
	
	public void render(Graphics g)
	{
		
		state.ManageStates(g);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		render(g);
	}
}
