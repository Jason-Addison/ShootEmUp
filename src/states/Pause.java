package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import gfx.Fonts;
import gfx.Overlay;

public class Pause
{
	
	boolean launch = true;
	Rectangle quitB = new Rectangle (700, 400, 400, 150);
	public static JPanel buttonPanel = new JPanel();
	public void tick()
	{
		if(launch)
		{
			buttonPanel.setLayout(null);
			JButton quit = new JButton();
			quit.setOpaque(false);
			quit.setBounds(quitB);
			quit.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e) 
			    {
					State.currentState = 1;
					Game.frame.requestFocusInWindow();
				}
			}
			);

			buttonPanel.setOpaque(false);
			buttonPanel.add(quit);
			Game.frame.remove(Overlay.buttonPanel);
			Game.frame.add(buttonPanel);

			launch = false;
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(0, 0, 0, 150));
		g.fillRect(0, 0, 1800, 1000);
		g.setColor(new Color(200, 200, 200, 255));
		((Graphics2D) g).fill(quitB);
		g.setColor(Color.BLACK);
		g.setFont(Fonts.bigFont);
		g.drawString("Quit", 760, 500);
	}
	
}
