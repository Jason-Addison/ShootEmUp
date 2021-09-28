package engine;

import java.awt.MouseInfo;

public class MouseManager
{

	double mouseX = 0;
	double mouseY = 0;
	public double getMouseX()
	{
		mouseX = MouseInfo.getPointerInfo().getLocation().x - 10;
		return mouseX;
	}
	
	public double getMouseY()
	{
		mouseY = MouseInfo.getPointerInfo().getLocation().y - 35;
		return mouseY;
	}
	
}
