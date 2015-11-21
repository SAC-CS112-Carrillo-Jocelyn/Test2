package test2pack;
import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		Dice d = new Dice();
		boolean retry=true;
		
		//Will play until player says n
		while(retry){
			//# of dice player wants in current game
			int dice =Integer.parseInt(JOptionPane.showInputDialog
					("How many dice would you like to roll?"));
			d.DiceThrown(dice);
			
			//JOptionPane.showMessageDialog(null,d.Number());//Debug Purposes
			
			//player guesses if diceNumber is low or high
			String guess = JOptionPane.showInputDialog
					("Was the number rolled in the high range or low, guess.");
			//player is told if they were right or wrong
			JOptionPane.showMessageDialog(null,d.GuessCheck(guess));
			//player is asked if they want to play again
			String again = JOptionPane.showInputDialog("Play again? Yes=y No=n");
			//will continue to play again until player says n here			
			if(again.equals("n")){	
				retry=false;
				//outputs scores
				JOptionPane.showMessageDialog(null, d.Scores());
			
			}
			else
				
				retry=true;
		}
		
	}

}
