package snackmania;

import javax.swing.JFrame;
import javax.swing.JPanel;


//Main class for Game
public class Start_Class {
	
	//Defining frames and panels for the game
	//that will change when user play game
	public static JFrame currentFrame;
	public static JPanel currentPanel;
	public static JFrame newFrame;
	public static JPanel newPanel;
	
	//No of players and how many
	//times u run the game
	public static int noofplayers;
	public static int nooftimesrun;
	
	//default constructor
	public Start_Class(){
		
		//Initializing the panel and frames for the first run
		currentPanel = new MenuPanel();
		currentFrame = new Menu();
		newPanel = new GSelectionPanel();
	}

	//Starting main function
	public static void main(String[] args) {
		new Start_Class();
	}

}
