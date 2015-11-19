package test2pack;

public class Dice {
	
	//default constructor
	public Dice(){
		diceNumber = 1;
		playerScore = 0; games = 0;
		mid = 0; high = 0;
		HL="a";
	}
	
	private int diceNumber;
	private int playerScore, games;
	private int mid, high;
	private String HL, playerGuess, diceString;
	private String guesses[]=new String[20], guessString;
	private int diceList[]= new int[20];
	
	//Throws Dice
	public int DiceThrown(int diceThrown){
		high = (6*diceThrown); mid =(high/2);
		if(mid>diceNumber)
			HL="low";
		else if((mid+1)<diceNumber)
			HL="high";
		else
			HL="invalid";
		return diceNumber=(1*(int)(Math.random()*(high)));
	}
	
	//Checks PlayerGuess against Dice location
	public String GuessCheck(String Guess){
		playerGuess=Guess;
		if (Guess.equals(HL)){
			PlayerPoints("w");
			return "You guessed correctly!";
		}
		else
			PlayerPoints("l");
			return "You guessed wrong!";
	}
	//Tells us if the diceNumber is in the HIGH or LOW RANGE

	//Adds/Subtracts to current player score
	private int PlayerPoints(String a){
		switch (a){
			case "w":
				playerScore++;break;
			case "l":
				playerScore--;break;
		}
		return playerScore;			
	}
	
	public String Scores(){ 
		String a=String.format("Total Outcomes:\nNumber of Games played:%d\n"
				+ "Player score:%d\nGuess For Each Game:%s\nDice roll for each game:%s" ,
				Games(),PlayerScore(),guessString,diceString);
		return a;
	}
	//Return player score
	public int PlayerScore(){
		return playerScore;
	}
	//Game #
	public int Games(){
		return games++;
	}
	public String GameGuesses(){
		guesses[games]=playerGuess;
		if(guesses[games]==null)
			return guessString;
		else
			return guessString =guessString+" "+guesses[games];
			
		
	}
	public String DiceNumbers(){
		diceList[games] = diceNumber;
		if(diceList[games]==0)
			return diceString;
		else
			return diceString= diceString+" "+diceList[games];
	}
	
	//For Debug purposes
	public String Number(){
		String a =String.format("DN:%d MID:%d High:%d HighorLow:%s",diceNumber,mid,high,HL);
		return a;
	}
	
}
