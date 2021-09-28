package engine;

import entities.Helicopter;

public class Camera 
{
	private static Helicopter heli = new Helicopter();
	//private Game game = new Game();
	static double cameraOff;
	
	public double getCamera()
	{
		return cameraOff;
	}
	public void camera()
	{
		
		cameraOff += Helicopter.hVelo;
	}
}
