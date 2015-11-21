package test2pack;

import java.util.ArrayList;
import java.util.List;

public class Dice {
	
	//default constructor
	public Dice(){
		diceNumber = 1;
		playerScore = 0; games = 0;
		mid = 0; high = 0;
		HL="wot u want mate?";
	}
	
	private int diceNumber, playerScore, games, mid, high;
	private String HL; //indicates if diceNumber is high or low
	private List<String> guesses=new ArrayList<String>();
	private List<String> diceList=new ArrayList<String>();
	
	//Throws Dice
	public int DiceThrown(int diceThrown){
		high = (6*diceThrown); mid =(high/2); // find high & low ranges
		diceNumber=0; //resets diceNumber for every game
		
		System.out.println("Starting a new dice roll."); //Debug
		
		//Rolls according to # of diceThrown, while adding results to diceNumber
		for(int i=0; i<diceThrown ;i++){
			int roll = (int)Math.round(((Math.random() * 5.0) + 1));
			diceNumber += roll;
			System.out.println("Rolled a dice with value: " + roll);//Debug
		}
		//Checks whether diceNumber is low or high
		if(diceNumber <= mid)
			HL="low";
		else if(diceNumber > mid)
			HL="high";
		else
			HL="invalid";
		return diceNumber;
	}
	
	//Checks PlayerGuess against HL
	public String GuessCheck(String Guess){
		
		guesses.add(Guess); //adds the guess to the guess history
		diceList.add(((Integer)diceNumber).toString());//adds diceNumber to history
		
		if (Guess.equals(HL)){
			PlayerPoints(true);
			return "You guessed correctly!";
		}
		else
			PlayerPoints(false);
			return "You guessed wrong!";
	}
	
	//To print out scores & history at end
	public String Scores(){ 
		String a=String.format("Total Outcomes\nNumber of Games played: %d\n"
				+ "Player score: %d\nGuess For Each Game: %s\nDice roll for each game: %s" ,
				Games(),PlayerScore(),GameGuesses(),DiceNumbers());
		return a;
	}
		
	//Adds/Subtracts to current player score
	private int PlayerPoints(boolean win){
		games++; //add to total # of games played
		
		if (win){
			playerScore++;
		}
		else{
			playerScore--;
		}
		return playerScore;			
	}
	
	
	//Output player score
	private int PlayerScore(){
		return playerScore;
	}
	//Outputs game #
	private int Games(){
		return games;
	}
	//Output Player Guesses
	private String GameGuesses(){
		return String.join(", ", guesses);	
	}
	//Output Dice rolls
	private String DiceNumbers(){
		return String.join(", ", diceList);
	}
	
	//For Debug purposes
	public String Number(){
		String a =String.format("DN:%d MID:%d High:%d HighorLow:%s",diceNumber,mid,high,HL);
		return a;
	}
	
}
