package snackmania;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

//game selection frame
@SuppressWarnings("serial")
public class GSelection extends JFrame {
	
	//default constructor
	public GSelection() {
		//get screen resolution
		//so that i want to display this frame 
		//just between screen boundaries
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Initializing the frame
		this.setTitle("Selection Manual");
		this.setBounds((int)screenSize.getWidth()/2-150, (int)screenSize.getHeight()/2-150, 300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setLayout(null);
		
		//Adding game selection panel to it 
		//after initialization 
		Start_Class.newPanel.setBounds(0, 0, getWidth(), getHeight());
		this.add(Start_Class.newPanel);
		
		validate();
		repaint();
		
	}
	
	

}
