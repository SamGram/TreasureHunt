import java.util.Scanner;

public class bionmethods {
	private String user1, user2, user1Statement, user2Statement;
	private int user1Answer, user2Answer, user1Guess, user2Guess, user1Score = 0, user2Score = 0, error = 1;

	public void setUsernames(String u1, String u2) {
		Scanner input = new Scanner(System.in);
		System.out.println("[Enter first user's name]");
		u1 = input.nextLine();
		user1 = u1; // setting user 1's name 
		System.out.println("[Enter second user's name]");
		u2 = input.nextLine();
		user2 = u2; // setting user 2's name
	}

	public int setUser1Statment() {
		Scanner input = new Scanner(System.in);
		do{
			try{
				System.out.println(user1 + ": [Enter a statement that's either True or False...");
				user1Statement = input.nextLine();
				System.out.println("Press [1] if your statement is true or [2] if it's false.");
				user1Answer = input.nextInt();
				error = 0;
			}catch(Exception e){
				System.out.print("");
			}
			return user1Answer;
		}while(error == 1);
	}
	public int setUser2Statement() {
		Scanner input = new Scanner(System.in);
		do{
			try{
				System.out.println(user2 + ": [Enter a statement that's either True or False...");
				user2Statement = input.nextLine();
				System.out.println("Press [1] if your statement is true or [2] if it's false.");
				user2Answer = input.nextInt();
				error = 0;
			}catch(Exception e){
				System.out.print("");
			}
			return user2Answer;
		}while(error == 1);	
	}

	public void inputSecurity(int x, boolean halt) {
		Scanner input = new Scanner(System.in);

		if(x == 1 || x == 2)
			halt = false;
		if(halt)
		do{
			try{	
				System.out.println("Incorrect input. Try again: ");
				x = input.nextInt();
				if(x == 1 || x == 2)
					halt= false;
			}catch(Exception e){
				input.nextLine();
			}
		}while(halt == true);
		halt = true;
	}

	public int setUser2Guess() {
		Scanner input = new Scanner(System.in);
		do{
			try{
				System.out.println("Believe it or not: " + user1Statement + "...");
				System.out.println("\n\n" + user2 + ": Press [1] if you believe " + user1 + "'s statement or [2] if you don't.");
				user2Guess = input.nextInt();
				error = 0;
			}catch(Exception e){
				System.out.print("");
			}
			return user2Guess;
		}while(error == 1);	
	}

	public int setUser1Guess() {
		Scanner input = new Scanner(System.in);
		do{
			try{
				System.out.println("Believe it or not: " + user2Statement + "...");
				System.out.println("\n\n" + user1 + ": Press [1] if you believe " + user2 + "'s statement or [2] if you don't.");
				user1Guess = input.nextInt();
				error = 0;
			}catch(Exception e){
				System.out.print("");
			}
			return user1Guess;
		}while(error == 1);	
	}

	public void displayScore(int aScore, int gScore, String aName, String gName) {
		System.out.println("\n" + "Score\n" + "-----");
		System.out.println(aName + " : " + aScore);
		System.out.println(gName + " : " + gScore);
	}


	public String getUserName1() {
		return user1;
	}
	public String getUserName2() {
		return user2;
	}
}