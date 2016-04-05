package snackmania;

import java.util.Random;

//player class
public class Player {

	//player basic attributes
	public int score;
	public int currentPosition;
	public boolean status;
	
	//default constructor
	public Player(){
		//initilazing the player 
		score = 0;
		currentPosition = 0;
		status = false;
	}
	//send player move score every time he play
	public int playerMove(){
		Random rand = new Random();
		return (int)rand.nextInt(6)+1;
	}
	
}
