package snackmania;

import java.util.ArrayList;

public class DataGathering {
	
	//Class variables
	public Double avg;
	public Integer min;
	public Integer max;
	
	//array list to store the moves
	public ArrayList<Integer> moves = null;

	//default constructor
	public DataGathering() {
		
		//initilazing the class variables
		moves = new ArrayList<Integer>();
		avg = 0.0;
		min = 0;
		max = 0;
	}
	
	//function to calculate and display the status of game
	public void showStats(){
		
		//calculating average
		int sum = 0;
		for(int i=0; i<moves.size() ; i++)
			sum += moves.get(i);
		if(moves.size()<=0)
			this.avg = 0.0;
		else
			avg = (double) (sum/moves.size());
		GBPanel.jl[2][1].setText(""+this.avg);
		System.out.println("Average no of moves are "+this.avg);
		
		//Calculating the maximum moves to end game
		for(int i=0; i<moves.size() ; i++){
			if(max < moves.get(i)){
				max = moves.get(i);
			}
		}
		GBPanel.jl[0][1].setText(""+this.max);
		System.out.println("Maximum no of moves are "+this.max);
		
		//calculating the minimum moves to end game
		min = max;
		for(int i=0; i<moves.size() ; i++){
			if(min > moves.get(i)){
				min = moves.get(i);
			}
		}
		GBPanel.jl[1][1].setText(""+this.min);
		System.out.println("Minimum no of moves are "+this.min);
		
	}
	
	
}
