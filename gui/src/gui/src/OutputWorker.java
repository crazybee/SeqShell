package gui.src;

import java.io.BufferedReader;

import java.util.*;

import java.io.InputStreamReader;
import java.io.InputStream;

import javax.swing.SwingWorker;
import java.util.List;


public class OutputWorker extends SwingWorker<String, String>{
	private String message;
	private String toEmail;
	private final String commands;
	private final String output;

	public OutputWorker (String output,String commands){
		this.commands = commands;
		this.output = output;
		
	}
@Override
protected String doInBackground() throws Exception{
	Process process = Runtime.getRuntime().exec(commands);
	
	publish ("Executing input commands");
	TextAreaFrame p = new TextAreaFrame(null);	
	InputStream is = process.getErrorStream();
	InputStream ig = process.getInputStream();
	InputStreamReader isr = new InputStreamReader(is);
	
	BufferedReader br = new BufferedReader (isr);
	
	String line = br.readLine();
     String previous = null;
	 while ((line = br.readLine()) != previous){
		line = br.readLine();
		previous = line;
		System.out.println("\n"); 
		p.addition(line+"\n");
		
		 
		if ((line = br.readLine()) == null){
		
		p.addition("End");
		 SendMail s = new SendMail();
		  message = Mediator.getMessage();
		  toEmail = Mediator.getEmail();
		 br.close(); 
		 process.destroy();
		 s.postMail(toEmail,message+"  This work was finished on "+new Date().toString());
	 }
	 }
	 
		
        
	return output;

}
@Override
protected void process (List<String> chunks){
	for (String message :chunks){
		System.out.println(message);
		
	}
}
}

