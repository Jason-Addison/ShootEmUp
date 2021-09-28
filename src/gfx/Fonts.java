package gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fonts 
{

	public static Font font;
	public static Font smallFont;
	public static Font bigFont;
	public static Font shopFontTitle;
	public static Font shopFontMedium;
	public static Font shopFontSmall;
	public static Font tinyFont;
	public static Font special;
	
	public void loadFonts()
	{
		try 
		{
			font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("font.ttf"))).deriveFont(Font.BOLD, 70);
			smallFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("font.ttf"))).deriveFont(Font.BOLD, 40);
			bigFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("font.ttf"))).deriveFont(Font.BOLD, 140);
			shopFontTitle = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("shopfont.ttf"))).deriveFont(Font.BOLD, 160);
			shopFontMedium = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("shopfont.ttf"))).deriveFont(Font.BOLD, 50);
			shopFontSmall = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("shopfont.ttf"))).deriveFont(Font.BOLD, 30); 
			tinyFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("shopfont.ttf"))).deriveFont(Font.BOLD, 20); 
			special = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("shopfont.ttf"))).deriveFont(Font.BOLD, 110); 
		
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (FontFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
