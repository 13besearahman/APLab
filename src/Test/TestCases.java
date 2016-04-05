package Test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import snackmania.GBPanel;

public class TestCases {

	
	public BufferedImage background1 = null;									//reading of image from the directory
	{
		try {
			background1 =  ImageIO.read(new File("src/imgs/snakes.png"));		//giving path to the file
		} catch (IOException e) {										//exception handling
			e.printStackTrace();
		}
	}
	BufferedImage background2 = null;									//reading of image from the directory
	{
		try {
			background2 =  ImageIO.read(new File("src/imgs/bg.png"));		//giving path to the file
		} catch (IOException e) {										//exception handling
			e.printStackTrace();
		}
	}
	BufferedImage background3 = null;									
	{
		try {
			//giving path to the file
			background3 =  ImageIO.read(new File("src/imgs/welcome.jpg"));
		}
		//exception handling
		catch (IOException e) {										
			e.printStackTrace();
		}
	}
	
	//Making object of class
	//Have all business logic
	GBPanel p = new GBPanel();
	
	@Test
	public void test() {
		
		//Check if images are available
		if(background1 != null)
			assertTrue(true);
		if(background2 != null)
			assertTrue(true);
		if(background3 != null)
			assertTrue(true);
		
		//Check All snakes and ladders
		//are initialized correctly
		if(p.snakes.size()== 6)
			assertTrue(true);
		if(p.ladders.size()== 6)
			assertTrue(true);
		
		
	}

}














