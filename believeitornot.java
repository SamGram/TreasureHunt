import java.util.Scanner;

public class believeitornot {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		bionmethods bion = new bionmethods();
		boolean game = true, stop = true;
		String user1Name = "", user2Name = "";
		int user1Answer, user2Answer, user1Guess, user2Guess, user1Score = 0, user2Score = 0;

		while(game) {
			System.out.println("Select an option by pressing the number next to it:");
			System.out.println("1. Play");
			System.out.println("0. Exit");
			int userInput = input.nextInt();
			switch (userInput){
			case 1:
				bion.setUsernames(user1Name, user2Name);
				user1Name = bion.getUserName1();
				user2Name = bion.getUserName2();
				while(game){
					//***************************************************************************************User 1 Statment
					int answer = bion.setUser1Statement();
					bion.inputSecurity(answer, stop);
					int guess = bion.setUser2Guess();
					bion.inputSecurity(guess, stop);
					if(answer == guess){
						user2Score++;
						System.out.println("\n\nYou believed right! [" + user2Name + " +1]\n");
					}
					else
					{
						user1Score++;
						System.out.println("\n\nYou believed wrong! [" + user1Name + " +1]\n");
					}
					bion.displayScore(user1Score, user2Score, user1Name, user2Name);

					//**************************************************************************************User 2 Statment
					answer = bion.setUser2Statment();
					bion.inputSecurity(answer, stop);
					guess = bion.setUser1Guess();
					bion.inputSecurity(guess, stop);
					if(answer == guess){
						user1Score++;
						System.out.println("\n\nYou believed right! [" + user1Name + " +1]\n");
					}
					else
					{
						user2Score++;
						System.out.println("\n\nYou believed wrong! [" + user2Name + " +1]\n");
					}
					bion.displayScore(user1Score, user2Score, user1Name, user2Name);

					game = false;
				}
				game = true;
				break;
			case 0:
				game = false;
				break;
			}// end of switch statement
		}
	}
}