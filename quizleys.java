import java.util.Scanner;
import java.util.Random;
import java.util.NoSuchElementException;
import java.io.*;
import java.lang.Math;


public class quizleys {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		try{
			File file = new File("QuizCards.txt");
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter buffer = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(buffer);
			Scanner fileScanner = new Scanner(file);
			functions func = new functions();
			
		
			System.out.println("Enter how many flashcards would you like to make?");
			int quesCount = input.nextInt();
			int ct = 1, count = 0, lnNumber = 0;
			boolean quizleys = true, quizzo = true;
			Random rand = new Random();
			String ques[] = new String[quesCount + 1];
			String answ[] = new String[quesCount + 1];
			ques[ct] = input.nextLine();

			if(file.exists()){
				FileReader fr = new FileReader(file);
				LineNumberReader lnr = new LineNumberReader(fr);
				while(lnr.readLine() != null) {
					lnNumber++;
				}
			}

			while(ct <= quesCount) {				
				System.out.println(ct + ") [Enter Question]");
				ques[ct] = input.nextLine();
				System.out.println(ct + ") [Enter Answer to that question]");
				answ[ct] = input.nextLine();

				if(lnNumber == 0)
					printWriter.print(ct + ") Question " + ct + ": " + ques[ct] + "\t>Answer " + ct + ": "  + answ[ct]);
				else
					printWriter.print((lnNumber + ct) + ") Question " + (lnNumber + ct) + ": " + ques[ct] + "\t>Answer " + (lnNumber + ct) + ": " + answ[ct]);
				if(ct != quesCount)
					System.out.print("\n");
				ct++;
			}
			printWriter.close();


			//Refreshing line number
			if(file.exists()){
				FileReader fr = new FileReader(file);
				LineNumberReader lnr = new LineNumberReader(fr);
				lnNumber = 0;
				while(lnr.readLine() != null) {
					lnNumber++;
				}

			}

			String totalQues[] = new String[lnNumber + 1];
			String totalAnsw[] = new String[lnNumber + 1];
			for(int ct3 = 1; ct3 < lnNumber + 1; ct3++){
				String temp = fileScanner.nextLine();
				if(temp != null){
					String[] values = temp.split(">");
					totalQues[ct3] = values[0];
					totalAnsw[ct3] = values[1];	
				}
			}	
			
				
			System.out.println("\nAll your data has been input\n");

			do{
				System.out.println("Select an option by pressing the number next to it:");
				System.out.println("1. Randomized Quiz");
				System.out.println("2. Select Specific Q & A's");
				System.out.println("3. Display Results");
				System.out.println("4. Orderly Quiz");
				System.out.println("0. Exit");
				int userInput = input.nextInt();
				switch(userInput){
				case 1:
					func.shuffleArray(totalQues, totalAnsw);
					func.randomizedQuiz(totalQues, totalAnsw);
					func.resetTotalArrays(totalQues, totalAnsw, lnNumber, file);
					break;
				case 2:
					System.out.println("[Enter any #1-" + (totalQues.length) + " for the question, then the \"Enter\" key for the answer]");
					input.nextLine();
					System.out.println("Also, press 0 and \"Enter\" twice to exit this mode.");
					do{

						int temp = input.nextInt();
						if (temp != 0){
							System.out.print(totalQues[temp]);
							input.nextLine();
							input.nextLine();
							System.out.println(totalAnsw[temp]);
						}
						else
							quizzo = false;
					}while(quizzo);
					break;
				case 3:
					for(int ct2 = 0; ct2 < totalQues.length; ct2++) {
						System.out.println(totalQues[ct2] + ">>>>>\t" + totalAnsw[ct2] );
					}
					input.nextLine();
					input.nextLine();
					break;
				case 4:
					input.nextLine();
					for(int ct4 = 0; ct4 < totalQues.length; ct4++) {
						System.out.print(totalQues[ct4]);
						input.nextLine();
						System.out.println(totalAnsw[ct4]);
						input.nextLine();
					}
					break;
				case 0:
					quizleys = false;
					break;
				}//end switch statement	
			}while(quizleys);	
		}catch(IOException e){
			System.out.println("You have an error.");
		}

	}
}