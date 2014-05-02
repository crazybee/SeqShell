package gui.src;

import java.io.*;

public class WriteToFile {

public static void Write(String line,String filename){

	try {
		File f = new File(filename);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f,true)));
		output.write(line);
		output.newLine();
		output.close();
		
		
	}
	catch (Exception e){
		e.printStackTrace();
		
	}
	
}

}
