package snackmania;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Game selection panel
@SuppressWarnings("serial")
public class GSelectionPanel extends JPanel implements ActionListener {

	//class variables for the panel
	public static int howManyTime=0;
	public JLabel l1;
	public JLabel l2;
	public JSpinner js1;
	public JSpinner js2;
	public JButton ok;
	public JButton cancel;
	public JCheckBox random;
	
	//default constructor
	public GSelectionPanel(){
		
		//Initializing the panel
		this.setVisible(true);
		this.setLayout(null);
		
		//Initialization of the label 1 and spinner 
		//for the player count
		l1 = new JLabel("Please Choose the no ( 2 to 4 ) of Players :");
		l1.setForeground(Color.white);
		l1.setBounds(10, 30, 300, 30);
		this.add(l1);
		js1 = new JSpinner(new SpinnerNumberModel(2, 2, 4, 1));
		js1.setBounds(20, 70, 210, 25);
		this.add(js1);
		
		//Initialization of the label 2 and spinner 
		//for the game count
		l2 = new JLabel("Choose How many Time ( 1 to 100 ) to run Game :");
		l2.setForeground(Color.white);
		l2.setBounds(10, 110, 300, 30);
		this.add(l2);
		js2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		js2.setBounds(20, 150, 210, 25);
		this.add(js2);
		
		//Initialization of the check box
		//for the random player selection
		random = new JCheckBox("Random");
		random.setBounds(180, 178, 80, 30);
		random.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(e.getSource()==random){
					selectionCheck();
				}
			}
		});
		this.add(random);
		
		//Initialization of the ok button and add in the panel
		ok = new JButton("OK");
		ok.setBounds(70, 210, 100, 25);
		ok.addActionListener(this);
		this.add(ok);
		
		//Initialization of the cancel button and add in the panel
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 210, 100, 25);
		cancel.addActionListener(this);
		this.add(cancel);
		
		selectionCheck();
		repaint();validate();
	}
	
	//Action listener implementation
	public void actionPerformed(ActionEvent e) {

		//if button press is ok
		if(e.getSource() == ok){
			if( (int) js1.getValue()>1 && (int) js1.getValue()<5 ){
				
				//if random is checked then initialize it with 0
				if(random.isSelected())
					Start_Class.noofplayers = 0;
				//otherwise get value from the spinner
				//set it in player count
				else
					Start_Class.noofplayers = (int) js1.getValue();
				
				//get game count how many time it will run
				Start_Class.nooftimesrun = (int) js2.getValue();
				
				//closing the selection small frame
				Start_Class.newFrame.dispose();
				Start_Class.currentFrame.setEnabled(true);
				Start_Class.currentFrame.setVisible(true);
	
				//and exchanging the current panel by new panel of game
				Start_Class.currentPanel.setVisible(false);
				Start_Class.currentPanel = null;
				Start_Class.currentPanel = new GBPanel();
				Start_Class.currentPanel.setBounds(0, 0, Start_Class.currentFrame.getWidth(), Start_Class.currentFrame.getHeight()-30);
				Start_Class.currentFrame.add(Start_Class.currentPanel);
				repaint();validate();
			}
		}
		//if cancel then go back to the current frame and pannel
		//enable the frame
		if(e.getSource()== cancel){
			Start_Class.newFrame.dispose();
			Start_Class.currentFrame.setEnabled(true);
			Start_Class.currentFrame.setVisible(true);
			repaint();validate();
		}
	}
	
	//function for selection check of random player count
	public void selectionCheck(){
		if(random.isSelected()){
			l1.setEnabled(false);
			js1.setEnabled(false);
		}
		else{
			l1.setEnabled(true);
			js1.setEnabled(true);
		}
	}
	
	BufferedImage background = null;									//reading of image from the directory
	{
		try {
			background =  ImageIO.read(new File("src/imgs/bg.png"));		//giving path to the file
		} catch (IOException e) {										//exception handling
			e.printStackTrace();
		}
	}
	protected void paintComponent(Graphics g){
    	super.paintComponent(g);
    	
		if(background != null){
			g.drawImage(background,0,0, getWidth() , getHeight() ,null );
    	}
    	if(background==null){
    		System.out.println("Background Null ");
    	}
    }
}
