import java.util.*;
import java.io.*;

public class randwfunctions{

	public static String[] readArray(String file) {
		int ct = 0;
		try{
			Scanner s1 = new Scanner(new File(file));
			while(s1.hasNextLine()){
				ct++;
				s1.next();
			}

			String[] lines = new String[ct];

			Scanner s2 = new Scanner(new File(file));
			for(int i = 0; i < ct; i++){
				String tempForFL = s2.nextLine();
				String[] valuesForFL = tempForFL.split(": ");
				String tempFL = valuesForFL[0];
				if(tempFL == "Friendlist2")
					countFriends++;
			}

			return lines;
		}catch(FileNotFoundException e){

		}
		return null;
	}
}