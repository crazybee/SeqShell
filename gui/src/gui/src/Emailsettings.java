package gui.src;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Emailsettings {
	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	
	public Emailsettings(){
		frame = new JFrame("Designed by LIU");
		
	}
	 public void startrun()  {
		 Dimension   screenSize   =   Toolkit.getDefaultToolkit().getScreenSize(); 
	        Dimension   frameSize   =   frame.getSize(); 
	        if   (frameSize.height   >   screenSize.height) 
	            frameSize.height   =   screenSize.height; 
	        if   (frameSize.width   >   screenSize.width) 
	            frameSize.width   =   screenSize.width; 
//	        int frame_height = frameSize.height;
//	    	int frame_width = frameSize.width;
	    	frame.setSize(300,200);
	    	
	    	
	    	
	    	frame.setLocationRelativeTo(null);
			
	        frame.setLayout(new GridBagLayout());
	        
	        JLabel n0 = new JLabel ("username");
	        GridBagConstraints l0 = new GridBagConstraints();
	        	l0.gridx = 0;
	            l0.gridy = 0;
	            l0.gridwidth = 1;
	            l0.gridheight = 1;
	            l0.weightx = 0;
	            l0.weighty = 0;
	            l0.fill = GridBagConstraints.BOTH;
	            l0.anchor = GridBagConstraints.WEST;
	            frame.add(n0, l0);
	            
	            username = new JTextField();
	            GridBagConstraints username1 = new GridBagConstraints();
	            username1.gridx = 0;
	            username1.gridy=1;
	            username1.gridwidth=1;
	            username1.gridheight = 1;
	            username1.weightx = 0;
	            username1.weighty =0;
	            username1.fill = GridBagConstraints.BOTH;
	            username1.anchor = GridBagConstraints.WEST;
	            frame.add (username,username1);
	            
	            
	            JLabel pwl = new JLabel ("password");
		        GridBagConstraints pw1l = new GridBagConstraints();
		        pw1l.gridx = 0;
		        pw1l.gridy = 2;
		        pw1l.gridwidth = 1;
		        pw1l.gridheight = 1;
		        pw1l.weightx = 0;
		        pw1l.weighty = 0;
		        pw1l.fill = GridBagConstraints.BOTH;
		        pw1l.anchor = GridBagConstraints.WEST;
		            frame.add(pwl, pw1l);
		            
		            
	            password = new JPasswordField(10);
	            GridBagConstraints password1 = new GridBagConstraints();
	            password1.gridx = 0;
	            password1.gridy=3;
	            password1.gridwidth=1;
	            password1.gridheight = 1;
	            password1.weightx = 0;
	            password1.weighty =0;
	            password1.fill = GridBagConstraints.BOTH;
	            password1.anchor = GridBagConstraints.WEST;
	            frame.add (password,password1);
	            
	            
	            
	            
	            frame.setVisible(true);
	    	
	 }
	 
	 
	 
}
