package gui.src;
import javax.swing.*;

	
public class TextAreaFrame  {  
 
  public JProgressBar jb = new JProgressBar();
  public JTextArea textArea = new JTextArea(100, 10);  
  
  public JScrollPane scrollPane = new JScrollPane(textArea);  
   JPanel p = new JPanel();
   JFrame j = new JFrame();
  public TextAreaFrame(String m) {  
     
    textArea.setWrapStyleWord(true);  
      textArea.setLineWrap(true);  
      scrollPane.validate();  
    j.getContentPane().add(p, "South"); 	
    j.getContentPane().add(jb,"North");
    j.getContentPane().add(scrollPane, "Center");   
    j.setTitle("Output information");  
    j.setSize(600, 300); 
    
  
     
  }  
 
  public void addition(String m){
	  jb.setVisible(true);
	  jb.setStringPainted(false);
	  j.setVisible(true);
	  textArea.setVisible(true);
	  textArea.setVisible(true);
	  textArea.append(m);
	  textArea.setCaretPosition(textArea.getText().length());
	 if (m != "End"){
		  
         jb.setIndeterminate(true);
         jb.setString("Processing");
	  }
	 else if (m == "End"){
		  jb.setIndeterminate(false);
		  jb.setString("Done");
		 
		 
		  
	  }
  }
} 
