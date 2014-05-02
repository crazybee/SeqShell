package gui.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFIle {
	public static String returned;
	public static String read (String name){
		File infile = new File(name);
	
		
		 try 
		    {
		        BufferedReader in = new BufferedReader(new FileReader(infile));
		       
		        while ((returned = in.readLine()) != null) 
		        {
		              System.out.println(returned);
		        }
		        in.close();
		       
		    } 
		    catch (IOException e) 
		    {
		        e.getStackTrace();
		    }
		return returned;
		
	}
	
   

    

}
