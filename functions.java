import java.util.Scanner;
import java.util.Random;
import java.util.NoSuchElementException;
import java.io.*;
import java.lang.Math;

public class functions {
	public static void shuffleArray(String[] list, String[] lists) {

		for(int ct = 0; ct < list.length; ct++){

			int randIndenx = (int)(Math.random() * list.length);
			String temp = list [ct]; 
			list[ct] = list[randIndenx];
			list[randIndenx] = temp;
			String temp1 = lists[ct];
			lists[ct] = lists[randIndenx];
			lists[randIndenx] = temp1;
		}
	}

	//Displays quiz after it's been randomized
	public static void randomizedQuiz(String[] totalQues, String[] totalAnsw) {
		Scanner input = new Scanner(System.in);
		for(int ct4 = 0; ct4 < totalQues.length; ct4++) {
			System.out.print(totalQues[ct4] + '\t');
			input.nextLine();
			System.out.println(totalAnsw[ct4]);
			input.nextLine();
		}
	}

	//Rests the total arrays back to numerical ascending order
	public static void resetTotalArrays(String[] totalQues, String[] totalAnsw, int lnNumber, File file){
		try{
			Scanner fileResetScanner = new Scanner(file);
			for(int ct3 = 0; ct3 < lnNumber; ct3++){
				String temp = fileResetScanner.nextLine();
				String[] values = temp.split(">");
				totalQues[ct3] = values[0];
				totalAnsw[ct3] = values[1];	
			}
		}catch(Exception e){
			System.out.println("You can't do that!");
		}
			
	}//end of createTotalArrays
}//end of class