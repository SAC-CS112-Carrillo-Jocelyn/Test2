package test2pack;
import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		Dice d = new Dice();
		boolean retry=true;
		
		while(retry){
			int dice =Integer.parseInt(JOptionPane.showInputDialog
					("How many dice would you like to roll?"));
			d.DiceThrown(dice);
			
			JOptionPane.showMessageDialog(null,d.Number());//Debug Purposes
			
			String guess = JOptionPane.showInputDialog
					("Was the number rolled in the high range or low, guess.");
			JOptionPane.showMessageDialog(null,d.GuessCheck(guess));
			
			String again = JOptionPane.showInputDialog("Play again? Yes=y No=n");
			d.GameGuesses(); d.DiceNumbers();d.Games(); d.PlayerScore(); 
			if(again.equals("n")){	
				retry=false;
				JOptionPane.showMessageDialog(null, d.Scores());
			
			}
			else
				
				retry=true;
		}
		
	}

}
