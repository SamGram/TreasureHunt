import javax.swing.JOptionPane;
import java.util.Random;
import java.lang.Math;

public class TreasureHunt {
	public static void main(String[] args) {

		boolean hunting = true;
		int counter = 0, xAxis = 5, yAxis = 5, treasureX, treasureY;
		Random rand = new Random();
		treasureX = (rand.nextInt(9) + 1);
		treasureY = (rand.nextInt(9) + 1);


		JOptionPane.showMessageDialog(null, "You are in the very center of a square sandbox.", "Treasure Hunt", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "The sandbox is exactly 9 steps long and 9 steps wide.", "Treasure Hunt", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "There is a treasure hidden somewhere in the sandbox.", "Treasure Hunt", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Here's a shovel, you can keep anything you find.", "Treasure Hunt", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Good Luck!", "Treasure Hunt", JOptionPane.PLAIN_MESSAGE);

		while(hunting) {
			String userChoice = JOptionPane.showInputDialog("[1] Walk\n[2]Dig\n[3]Coordinance\n[4]Hint\n[5]Quit");
			int decision = Integer.parseInt(userChoice);

			switch(decision) {
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
				if(yAxis > 9) {
					JOptionPane.showMessageDialog(null, "You hit the Northern wall of the sandbox and stopped.", "Halt!", JOptionPane.PLAIN_MESSAGE);
					yAxis = 9;
				}
				if(yAxis < 0) {
					JOptionPane.showMessageDialog(null, "You hit the Southern wall of the sandbox and stopped.", "Halt!", JOptionPane.PLAIN_MESSAGE);
					yAxis = 0;
				}
				if(xAxis > 9) {
					JOptionPane.showMessageDialog(null, "You hit the Eastern wall of the sandbox and stopped.", "Halt!", JOptionPane.PLAIN_MESSAGE);
					xAxis = 9;
				}
				if(xAxis < 0) {
					JOptionPane.showMessageDialog(null, "You hit the Western wall of the sandbox and stopped.", "Halt!", JOptionPane.PLAIN_MESSAGE);
					xAxis = 0;
				}
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "*You begin to dig...*" , "Digging...", JOptionPane.PLAIN_MESSAGE);
				if(xAxis == treasureX && yAxis == treasureY){
					JOptionPane.showMessageDialog(null, "Congrats! You found the treasure!" , "$$$ You're Rich! $$$", JOptionPane.PLAIN_MESSAGE);
					hunting = false;
				}
				else	
					JOptionPane.showMessageDialog(null, "Awww, after digging a sizable hole, you found nothing but sand..." , "Keep Hunting!", JOptionPane.PLAIN_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "(" + xAxis + "," + yAxis + ")" , "Coordinance", JOptionPane.PLAIN_MESSAGE);
				break;
			case 4:
				double distance = Math.sqrt((Math.pow(Math.abs(xAxis - treasureX), 2)) + (Math.pow(Math.abs(yAxis - treasureY), 2)));
				JOptionPane.showMessageDialog(null, "You are " + Math.round(distance) + " steps away from the treasure..", "Distance From Treasure", JOptionPane.PLAIN_MESSAGE);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "The treasure was at: (" + treasureX + "," + treasureY + ")" , "X Marks the Spot!", JOptionPane.PLAIN_MESSAGE);
				hunting = false;
				break;
			}
		}	
	}
}