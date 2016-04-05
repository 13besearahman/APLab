package snackmania;

import javax.swing.JFrame;

//game Menu frame that will open first 
//when game run
@SuppressWarnings("serial")
public class Menu extends JFrame{
	
	//Default constructor
	public Menu() {
		//Initializing the frame values
		this.setTitle("Snake Mania");
		this.setBounds(200, 60, 1000, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//Initializing the menu panel and
		//add this in the current frame
		Start_Class.currentPanel.setBounds(0, 0, getWidth(), getHeight());
		this.add(Start_Class.currentPanel);
		
		//repaint the graphics
		validate();
		repaint();
	}

}
