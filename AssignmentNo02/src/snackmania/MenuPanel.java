package snackmania;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

//Menu panel
@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements ActionListener{

	//play button and exit button
	public static JButton play;
	public static JButton exit;
	
	//Default Constructor
	public MenuPanel(){
		
		//Initializing Panel
		this.setVisible(true);
		this.setLayout(null);
		
		//Initilisating button play 
		//and adding action listner
		play = new JButton();
		play.setLocation(686, 153);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.setSize(270, 50);
		play.addActionListener(this);
		this.add(play);
		
		//Initilisating button exit 
		//and adding action listner
		exit = new JButton();
		exit.setLocation(686, 373);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setSize(270, 50);
		exit.addActionListener(this);
		this.add(exit);
		
		repaint();
		validate();
	}
	//action listener implementation
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == play){
			Start_Class.currentFrame.setEnabled(false);
			Start_Class.newFrame = new GSelection();
		}
		if(e.getSource() == exit){
			System.exit(0);
		}
		
	}
	
	//Background image draw using graphics
	//reading of image from the directory
	BufferedImage background = null;									
	{
		try {
			//giving path to the file
			background =  ImageIO.read(new File("src/imgs/welcome.jpg"));
		}
		//exception handling
		catch (IOException e) {										
			e.printStackTrace();
		}
	}
	
	//paint function of the graphics
	protected void paintComponent(Graphics g){
    	super.paintComponents(g);
		
    	if(background != null){
    		g.drawImage(background,0,0, getWidth() , getHeight()-29 ,null );
    	}
    	if(background==null){
    		System.out.println("Background Image not Found");
    	}
    }	
}
