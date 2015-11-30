import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class newFile {

	

	public void openFile(){
	
	}

	public void addRecords(String ques[], String answ[], int ct){
			file.format(ct + ". " + ques[ct] + " >>>>> " + (answ[ct]) + "%n%n");			
	}

	public void closeFile(){
		file.close();
	}
}


