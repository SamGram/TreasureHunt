import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class randwfiles{
	public static void main(String[] args) {
		String fileName = "randw.txt";
		try{
			File file = new File(fileName);
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter buffer = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(buffer);
			PrintWriter pw = new PrintWriter(buffer);
			Scanner fileScanner = new Scanner(file);

			
			String[] friends = displayFriendlist(fileName);

			for(int i = 0; i < friends.length; i++) {
				System.out.println(friends[i]);
			}
		}catch(IOException e){

		}
		
	}
	public static void hiMom(String file) {
		try{
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			pw.println("Hi mom");
			pw.close();
		}catch(IOException e){

		}
	}

	public static String[] readArray(String file) {
		int ct = 0;
		try{
			Scanner s1 = new Scanner(new File(file));
			while(s1.hasNextLine()){
				ct++;
				s1.nextLine();
			}

			String[] lines = new String[ct];

			Scanner s2 = new Scanner(new File(file));
			for(int i = 0; i < ct; i++) {
				lines[i] = s2.nextLine();
			}

			return lines;
		}catch(FileNotFoundException e){

		}
		return null;
	}

	public static String[] displayFriendlist(String file) {

		try{
			int ct = 0, minusCount = 0, friendCount = 0;
			String fl = "Friendlist";
			Scanner s1 = new Scanner(new File(file));
			while(s1.hasNextLine()){
				ct++;
				s1.nextLine();
			}
			Scanner s2 = new Scanner(new File(file));
			for(int i = 0; i < ct; i++){
				String tempForFL = s2.nextLine();
				String[] valuesForFL = tempForFL.split(": ");
				String tempFL = valuesForFL[0];
				if(!tempFL.equalsIgnoreCase(fl)){
					minusCount++;
				}	
			}
			int newCount = ct - minusCount;
			String[] friends = new String[newCount];

			Scanner s3 = new Scanner(new File(file));
			for(int i = 0; i < ct; i++){
				String tempForFL2 = s3.nextLine();
				String[] valuesForFL2 = tempForFL2.split(": ");
				String tempFL2 = valuesForFL2[0];
				if(valuesForFL2.length > 1){
					if(tempFL2.equalsIgnoreCase(fl)){
						friends[friendCount] = valuesForFL2[1];
						friendCount++;
					}
				}
				
			}

			return friends;
		}catch(FileNotFoundException e){

		}
		return null;

	}
}