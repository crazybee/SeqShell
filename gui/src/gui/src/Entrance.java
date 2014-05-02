package gui.src;

//Author: Zhe Liu
//Date: June-12-2012
//Version: beta4
/*
This class is used as the first GUI for the using and navigate to other functions

*/

import java.awt.*;

import javax.swing.*;
import javax.swing.JTextArea;  
import java.awt.event.*;




	class information {
		private JFrame frame;
	    private JTextArea contents;
		information(){
			
			contents = new JTextArea();	
			
		}
		public void display(String m,String t){
			frame = new JFrame(t);
			frame.setSize(400,200);
			 frame.setLocation(300,300);
		    
			frame.add(contents);
			contents.setEditable(false);
			contents.setWrapStyleWord(true);
			contents.setLineWrap(true);
			contents.append(m);
			frame.setVisible(true);
		}
	}


public class Entrance {
	private JFrame frame;
	private JMenu menu;
	private JMenu menusettings;
	private JMenuItem aboutMe;
	private JMenuItem how;
	private JMenuItem path4tophat;
	private JMenuItem path4cuff;
	private JMenuBar menuBar;
	public Entrance (){
		frame = new JFrame("RNA-SEQ shell-beta4 by LIU");
		menuBar = new JMenuBar();
		menu = new JMenu("Help");
		menusettings = new JMenu("Settings");
		path4tophat = new JMenuItem("PATH Settings");
//		path4cuff = new JMenuItem("PATH OF Cuffdiff");
		aboutMe = new JMenuItem("About me");
		how = new JMenuItem("How to use");
		
	}
	
		
	
	
	
		
public void run(){
	    frame.setSize(400, 300);
    	Dimension   screenSize   =   Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension   frameSize   =   frame.getSize(); 
        if   (frameSize.height   >   screenSize.height) 
            frameSize.height   =   screenSize.height; 
        if   (frameSize.width   >   screenSize.width) 
            frameSize.width   =   screenSize.width; 
    	
        frame.setLayout(new GridBagLayout());
        frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/ 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        aboutMe.addActionListener(new ActionListener (){
        	 @Override
			public void actionPerformed(ActionEvent e){
        		 information a = new information();
        		 a.display("My name is Liu Zhe \n"+
        					"I am happy to present you this application.\n"+"My email is zheliu@outlook.com\n"+
        					"I made this applicaiton to simplify the sequencing process\n"+
        					"You are free to use this application."+
        					"You must mention the origination of this application in your work.","About me");
        	 }
        } );
        
        how.addActionListener(new ActionListener (){
       	 @Override
		public void actionPerformed(ActionEvent e){
       		information b = new information();
   		 b.display("This applicatioin works by invoking the functions of Tophat and Cuffdiff.\n"+
   				 "You have to make sure that these two applications are properly installed in your system\n"+
   				 "tophat and cuffdiff should be added in PATH of your linux system.\n"+
   				 "Make sure you have JVM 1.6 or higher installed in your system.","How to use");
       	 }
       } );
        
        path4tophat.addActionListener(new ActionListener (){
          	 @Override
   		public void actionPerformed(ActionEvent e){
          		information b = new information();
//      		 b.display("This applicatioin works by invoking the functions of Tophat and Cuffdiff.\n"+
//      				 "You have to make sure that these two applications are properly installed in your system\n"+
//      				 "tophat and cuffdiff should be added in PATH of your linux system.\n"+
//      				 "Make sure you have JVM 1.6 or higher installed in your system.","How to use");
          		Settings settings = new Settings();		
         		settings.startrun();
          	 }
          } );
        
//        path4cuff.addActionListener(new ActionListener (){
//         	 @Override
//  		public void actionPerformed(ActionEvent e){
//         		information b = new information();
//     		 b.display("This applicatioin works by invoking the functions of Tophat and Cuffdiff.\n"+
//     				 "You have to make sure that these two applications are properly installed in your system\n"+
//     				 "tophat and cuffdiff should be added in PATH of your linux system.\n"+
//     				 "Make sure you have JVM 1.6 or higher installed in your system.","How to use");
//         	 }
//         } );
        
        menu.add(aboutMe);
        menu.add(how);
        menusettings.add(path4tophat);
        //menusettings.add(path4cuff);
     
      
        
        JButton tophat =new JButton("Mapping");
        tophat.setPreferredSize(new Dimension (300,100));
        tophat.setFont(new Font("sansserif",Font.BOLD,24));

        GridBagConstraints tophatg= new GridBagConstraints();
        tophatg.gridx=10;
        tophatg.gridy=0;
        tophatg.gridwidth=1;
        tophatg.gridheight = 1;
        tophatg.weightx = 0;
        tophatg.weighty = 0;
        tophatg.fill = GridBagConstraints.BOTH;
        
        tophat.addActionListener(new ActionListener() {
        	
            
      	   @Override
		public void actionPerformed(ActionEvent e) {
      		 Tophat gui = new Tophat();		
     		gui.startrun();
      	   }
      	   });
        
        
        
        frame.add(tophat,tophatg);
        
           
        
        JButton cuffdiff =new JButton("Gene Level Diff");
        cuffdiff.setPreferredSize(new Dimension (300,100));
        cuffdiff.setFont(new Font("sansserif",Font.BOLD,24));

        GridBagConstraints cuffdiffg= new GridBagConstraints();
        cuffdiffg.gridx=10;
        cuffdiffg.gridy=40;
        cuffdiffg.gridwidth=1;
        cuffdiffg.gridheight = 1;
        cuffdiffg.weightx = 0;
        cuffdiffg.weighty = 0;
        cuffdiffg.fill = GridBagConstraints.BOTH;
        
        cuffdiff.addActionListener(new ActionListener() {
        	
            
      	   @Override
		public void actionPerformed(ActionEvent e) {
      		   GUI g = new GUI();
      		   g.startrun();
      	   }
      	   });
        
        
      
        
        frame.add(cuffdiff,cuffdiffg);
        
        
       
        
        
        menuBar.add(menu);
        menuBar.add(menusettings);
        
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
}





	
	public static void main (String args[]){
	Entrance t = new Entrance ();
	t.run();
}

}

	  
