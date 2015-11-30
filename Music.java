import javax.swing.JOptionPane;
import java.util.Random;
import java.lang.Math;

public class Music {
	public static void main(String[] args) {

		boolean game = true;
		int xAxis = 5; yAxis = 5, treasureY, treasureX;
		Random rand = new Random();
		treasureX = 1+rand.nextInt(9);
		treasureY = 1+rand.nextInt(9);
		

		JOptionPane.showMessageDialog(null, "You are in the center of a square sandbox", "TreasureHunt", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "The sandbox is exactly 9 steps long and 9 steps wide", "TreasureHunt", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Somewhere hidden within the sandbox is a fantastic treasure!", "TreasureHunt", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Here is a shovel, try your best to find it!", "TreasureHunt", JOptionPane.PLAIN_MESSAGE);

		//game loop
		while(game){
			//menu
			String userInput = JOptionPane.showInputDialog("[1]Walk\n[2]Dig\n[3]Coordinance\n[4]Hint\n[5]Quit");
			int selection = Integer.parseInt(userInput);

			switch(selection){
			//walk
			case 1:
				String inputSteps = JOptionPane.showInputDialog("How many steps would you like to take?");
				int steps = Integer.parseInt(inputSteps);
				String inputDirection = JOptionPane.showInputDialog("Which direction would you like to go?\n[1]North\n[2]East\n[3]South\n[4]West");
				int direction = Integer.parseInt(inputDirection);
				if(direction == 1)
					yAxis = yAxis + steps;
				if(direction == 2)
					xAxis = xAxis + steps;
				if(direction == 3)
					yAxis = yAxis - steps;
				if(direction == 4)
					xAxis = xAxis - steps;
				if(yAxis > 9){
					JOptionPane.showMessageDialog(null, "You ran into the Northern wall and stopped", "Halt!", JOptionPane.ERROR_MESSAGE);
					yAxis = 9;
				}
				if(xAxis > 9){
					JOptionPane.showMessageDialog(null, "You ran into the Eastern wall and stopped", "Halt!", JOptionPane.ERROR_MESSAGE);
					xAxis = 9;
				}
				if(yAxis > 0){
					JOptionPane.showMessageDialog(null, "You ran into the Southern wall and stopped", "Halt!", JOptionPane.ERROR_MESSAGE);
					yAxis = 0;
				}
				if(xAxis > 0){
					JOptionPane.showMessageDialog(null, "You ran into the Western wall and stopped", "Halt!", JOptionPane.ERROR_MESSAGE);
					xAxis = 0;
				}
				break;
			//dig
			case 2:
				JOptionPane.showMessageDialog(null, "*You begin to dig*", "Digging...", JOptionPane.PLAIN_MESSAGE);
				if(yAxis == treasureY && xAxis == treasureX){
					JOptionPane.showMessageDialog(null, "CONGRATS! YOU HAVE FOUND THE TREASURE!", "$$$$$$", JOptionPane.PLAIN_MESSAGE);
					game = false;
				}else
					JOptionPane.showMessageDialog(null, "Sorry, you dug a sizable hole and found nothin but sand...", "Keep Huntin!", JOptionPane.PLAIN_MESSAGE);
				break;
			//coordinance
			case 3:	

				break;
			//hint
			case 4:

				break;
			//quit
			case 5:
				game = false;	
				break;
			}//end of switch statement	
		}
	}
}
