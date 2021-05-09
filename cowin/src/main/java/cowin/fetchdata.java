package cowin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fetchdata {

	
	
	
	public void a() throws FileNotFoundException {
		String filename = "D:\\cowin.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try{
		  String line;
		  //as long as there are lines in the file, print them
		  while((line = reader.readLine()) != null){ 
		    System.out.println(line);
		    
		    
		    String[] pin=line.split(",");
		    for(int i=0; i<pin.length; i++) {
		    	System.out.println(pin[i]);
		    }
		  }
		} catch (IOException e) {
		  e.printStackTrace();
		}
	}

}
