package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import states.State;

public class Key implements KeyListener, MouseListener
{

	public static boolean up, down, left, right, shoot, hydra, leftLock;
	public static boolean healthUp, healthDown;
	public static int menuSelect = 1;
	public static boolean incBalloon, incBiplane, incC130;
	public static boolean pause, stop;
	public static boolean showHealth = false;
	int menuMaxSelect = 4;
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_W)
		{
			up = true;
		}
		if(keyCode == KeyEvent.VK_S)
		{
			down = true;
		}
		if(keyCode == KeyEvent.VK_A)
		{
			left = true;
			if(!right)
			{
				leftLock = true;
			}
		}
		if(keyCode == KeyEvent.VK_D)
		{
			right = true;
			if(!left)
			{
				leftLock = false;
			}
		}
		if(keyCode == KeyEvent.VK_E)
		{
			shoot = true;
		}
		
		if(keyCode == KeyEvent.VK_Q)
		{
			hydra = true;
		}
		
		if(keyCode == KeyEvent.VK_PAGE_UP)
		{
			if(Upgrades.health < 100)
			{
				healthUp = true;
				healthDown = false;
			}
		}
		if(keyCode == KeyEvent.VK_PAGE_DOWN)
		{
			if(Upgrades.health > 0)
			{
				healthUp = false;
				healthDown = true;
			}
		}
		if(keyCode == KeyEvent.VK_DOWN)
		{
			if(menuSelect < menuMaxSelect)
			{
				menuSelect++;
			}
			else
			{
				menuSelect = 1;
			}
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			if(menuSelect > 0)
			{
				menuSelect--;
			}
			else
			{
				menuSelect = menuMaxSelect;
			}
		}
		if(keyCode == KeyEvent.VK_ENTER)
		{
			if(menuSelect == 1)
			{
				State.currentState = 0;
			}
			if(menuSelect == 2)
			{
				State.currentState = 1;
			}
			if(menuSelect == 3)
			{
				State.currentState = 2;
			}
			if(menuSelect == 2)
			{
				State.currentState = 4;
			}
		}
		if(keyCode == KeyEvent.VK_1)
		{
			incBalloon = true;
		}
		if(keyCode == KeyEvent.VK_2)
		{
			if(showHealth)
			{
				showHealth = false;
			}
			else if(!showHealth)
			{
				showHealth = true;
			}
		}
		if(keyCode == KeyEvent.VK_3)
		{
			if(Upgrades.cheatMode)
			{
				Upgrades.cheatMode = false;
			}
			else
			{
				Upgrades.cheatMode = true;
			}
		}
		if(keyCode == KeyEvent.VK_T)
		{
			incBiplane = true;
		}
		if(keyCode == KeyEvent.VK_F)
		{
			if(State.currentState == 3)
			{
				State.currentState = 0;
			}
			else
			{
				State.currentState = 3;
			}
		}
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			if(pause)
			{
				pause = false;
			}
			else
			{
				pause = true;
			}
		}
		if(keyCode == KeyEvent.VK_G)
		{
			if(stop)
			{
				stop = false;
			}
			else
			{
				stop = true;
			}
		}
				
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_W)
		{
			up = false;
		}
		if(keyCode == KeyEvent.VK_S)
		{
			down = false;
		}
		if(keyCode == KeyEvent.VK_A)
		{
			left = false;
		}
		if(keyCode == KeyEvent.VK_D)
		{
			right = false;
		}
		if(keyCode == KeyEvent.VK_E)
		{
			shoot = false;
		}
		if(keyCode == KeyEvent.VK_Q)
		{
			hydra = false;
		}
		if(keyCode == KeyEvent.VK_PAGE_UP)
		{
			if(Upgrades.health < 100)
			{
				healthUp = false;
			}
		}
		if(keyCode == KeyEvent.VK_PAGE_DOWN)
		{
			if(Upgrades.health > 0)
			{
				healthDown = false;
			}
		}
		if(keyCode == KeyEvent.VK_1)
		{
			incBalloon = false;
		}
		if(keyCode == KeyEvent.VK_R)
		{
			if(State.currentState == 2)
			{
				State.currentState = 0;
			}
			else
			{
				State.currentState = 2;
			}
		}
		
		if(keyCode == KeyEvent.VK_T)
		{
			incBiplane = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			//shoot = true;
		}
		if(!(e.getButton() == MouseEvent.BUTTON1))
		{
			//shoot = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
		//	shoot = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

}
