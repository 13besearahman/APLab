package snackmania;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.validator.PublicClassValidator;


//Game panel
//include all business logic of game
@SuppressWarnings("serial")
public class GBPanel extends JPanel{
	
	//defining board amd other class variables
	public int[][] board ;
	public int totalplayer;
	public Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
	public Map<Integer, Integer> ladders = new HashMap<Integer, Integer>();
	public Player[] players;
	public static JLabel[][] jl;
	
	//default constructor
	public GBPanel(){
		
		//initilizating the panel
		setVisible(true);
		setLayout(null);
		
		//initilizing the lables
		jl = new JLabel[3][2];
		for(int i=0;i<3;i++)
			for(int j=0;j<2;j++)
				jl[i][j] = new JLabel();
		//set sizes location and text of lables
		jl[0][0].setText("Maximum No of Moves");
		jl[0][0].setBounds(830, 50, 200, 40);
		this.add(jl[0][0]);
		jl[0][1].setBounds(830, 100, 200, 40);
		this.add(jl[0][1]);
		
		//set sizes location and text of lables
		jl[1][0].setText("Minimum No of Moves");
		jl[1][0].setBounds(830, 150, 200, 40);
		this.add(jl[1][0]);
		jl[1][1].setBounds(830, 200, 200, 40);
		this.add(jl[1][1]);
		
		//set sizes location and text of lables
		jl[2][0].setText("Average No of Moves");
		jl[2][0].setBounds(830, 250, 200, 40);
		this.add(jl[2][0]);
		jl[2][1].setBounds(830, 300, 200, 40);
		this.add(jl[2][1]);
		
		//if player count is not 0 then get its value
		if(Start_Class.noofplayers != 0)
			players = new Player[Start_Class.noofplayers];
		
		initilizeBoard();
		run();
		
	}
	
	//initilzating the game board
	public void initilizeBoard(){
		board = new int[10][10];
		int x = 1;
		for(int i=0 ; i<10 ; i++)
			for(int j=0 ; j<10 ; j++)
				board[i][j] = x++;	
		
		snakes.put(45, 4);
		snakes.put(54, 35);
		snakes.put(64, 38);
		snakes.put(69, 28);
		snakes.put(76, 44);
		snakes.put(97, 84);
		
		ladders.put(7 , 32 );
		ladders.put(21, 40 );
		ladders.put(62, 100);
		ladders.put(68, 87 );
		ladders.put(72, 93 );
		ladders.put(78, 98 );

	}
	
	//Business logic function for game
	public void run(){
		
		//getting the how many time the game has to run
		int currentMove = 1; int finalMove = Start_Class.nooftimesrun; 
		//data gathering class where we have to save data
		DataGathering dc = new DataGathering();
		
		//loop for the game count
		while(currentMove++ <= finalMove){
			
			int playerCount;
			//if player count is zero then randomly choose
			//every time and make new players by new Player Object
			if(Start_Class.noofplayers == 0){
				Random rand = new Random();
				playerCount = (int)rand.nextInt(4)+1;
				System.out.println("No of player this time: "+ playerCount);
				players = new Player[playerCount];
				
				//initilizating players
				for(int i=0 ; i< playerCount; i++)
					players[i] = new Player();
			}
			//if player count is not 0 then 
			//initilizating after getting its value
			else{
				playerCount = Start_Class.noofplayers;
				for(int i=0 ; i<playerCount ; i++)
					players[i] = new Player();
			}	
			
			//saving current move
			int move = 1;
			
			//boolen type for the break of the loop
			//so that a player win the game
			boolean looprun = true;
			
			//while loop
			//for the game moves
			//after all player do their turn
			//it one loop completes
			while(looprun){
				
				//increase game counter
				//how many mover are done yet
				move++;
				
				//for loop to give every player a chance to run
				//distribute turn among players
				for(int i=0 ; i<playerCount ; i++){
					
					//save the player move score
					int thismove = 0;
					thismove = players[i].playerMove();
					
					//Temporary store of position of this move
					int temp = players[i].currentPosition + thismove;
					
					//CHeck if it is on a snake or not
					if(snakes.containsKey(temp)){
						players[i].currentPosition = snakes.get(temp);
						//transfer the turn to other player 
						continue;
					}
					//check it is on a ladder or not
					else if(ladders.containsKey(temp)){
						temp = ladders.get(temp);
						
					}
					//if a player gets 6 new turn again and again 
					while(true){
						if(thismove == 6)
							thismove += players[i].playerMove();
						else
							break;
					}
					
					//again check after complete the turn
					//if it is on snake or in ladder 
					temp = players[i].currentPosition + thismove;
					if(snakes.containsKey(temp)){
						players[i].currentPosition = snakes.get(temp);
						continue;
					}
					else if(ladders.containsKey(temp)){
						temp = ladders.get(temp);
					}
					
					//if player current position is greter then 100
					//no move
					if(players[i].currentPosition + thismove > 100)
						break;
					
					//if player current position is equal to  100
					//move to 100
					//player wins
					//player win status true
					else if(players[i].currentPosition + thismove == 100){
						players[i].status = true;
						System.out.println("Player "+(i+1)+" Wins.");
						looprun = false;
						break;
					}
					//otherwise move him to new position
					//and turn the next person
					else
						players[i].currentPosition += thismove;
				}//ending player turn loop
				
			}//ending total moves loop
			
			//add every times after how many turns
			//a game ends
			dc.moves.add(move);
			//print total moves of a game
			System.out.println("Move "+ move);
			System.out.println();
		}
		//Show game statistics
		dc.showStats();
	}
	
	//Getting image from the images
	public BufferedImage background = null;									//reading of image from the directory
	{
		try {
			background =  ImageIO.read(new File("src/imgs/snakes.png"));		//giving path to the file
		} catch (IOException e) {										//exception handling
			e.printStackTrace();
		}
	}
	//printing the image using graphics
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
    	
		if(background != null){
			g.drawImage(background,0,0, getWidth()-200 , getHeight() ,null );
    	}
    	if(background==null){
    		System.out.println("Background Null ");
    	}
    }

}
