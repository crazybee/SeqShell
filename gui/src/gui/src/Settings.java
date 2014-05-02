package gui.src;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Settings {
	private JFrame frame;
	private JTextField tophatpath;
	private JTextField cuffdiffpath;
	private String tophatpath1;
	private String cuffdiffpath1;
	
	
	public Settings(){
		frame = new JFrame("cuffdiff-shell-beta5 by LIU");
		
		
		
		
		
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
	    	frame.setSize(350,200);
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	frame.setLocationRelativeTo(null);
		
	        frame.setLayout(new GridBagLayout());
	        
	        
	        JLabel n0 = new JLabel ("Location of Tophat executable binary:");
	        GridBagConstraints l0 = new GridBagConstraints();
	        	l0.gridx = 0;
	            l0.gridy = 0;
	            l0.gridwidth = 1;
	            l0.gridheight = 1;
	            l0.weightx = 0;
	            l0.weighty = 0;
	            l0.fill = GridBagConstraints.NONE;
	            l0.anchor = GridBagConstraints.WEST;
	            frame.add(n0, l0);
	            
	            
	            tophatpath = new JTextField();
	            GridBagConstraints tophatl = new GridBagConstraints();
	            tophatl.gridx = 0;
	            tophatl.gridy=1;
	            tophatl.gridwidth=1;
	            tophatl.gridheight = 1;
	            tophatl.weightx = 0;
	            tophatl.weighty =0;
	            tophatl.fill = GridBagConstraints.BOTH;
	            tophatl.anchor = GridBagConstraints.WEST;
	            frame.add (tophatpath,tophatl);
	            
	            JButton gtfb =new JButton("Select");
	            GridBagConstraints gtfbl= new GridBagConstraints();
	            gtfbl.gridx=1;
	            gtfbl.gridy=1;
	            gtfbl.gridwidth=1;
	            gtfbl.gridheight = 1;
	            gtfbl.weightx = 0;
	            gtfbl.weighty = 0;
	            gtfbl.fill = GridBagConstraints.BOTH;
	            gtfb.addActionListener (new ActionListener() {
	            	
	                
	          	   @Override
	    		public void actionPerformed(ActionEvent e) {
	          	    JFileChooser jfc = new JFileChooser();
//	          	  FileNameExtensionFilter filter = new FileNameExtensionFilter(
//	            	        "GTF File", "gtf");
//	          	  jfc.setFileFilter(filter);
	                  jfc. setFileSelectionMode(0);
	          	    int result=jfc.showOpenDialog(frame);
	          	    if(result==JFileChooser.APPROVE_OPTION ){
	          	    	tophatpath.setText((jfc.getSelectedFile().getAbsolutePath().toString()));}

	          	    }
	          	   });
	            frame.add(gtfb,gtfbl);
	            
	            JLabel n1 = new JLabel ("Location Cuffdiff executable binary:");
	            GridBagConstraints l1 = new GridBagConstraints();
	            	l1.gridx = 0;
	                l1.gridy = 2;
	                l1.gridwidth = 1;
	                l1.gridheight = 1;
	                l1.weightx = 0;
	                l1.weighty = 0;
	                l1.fill = GridBagConstraints.BOTH;
	                l1.anchor = GridBagConstraints.WEST;
	                frame.add(n1, l1);  
	            
	                cuffdiffpath = new JTextField();
		            GridBagConstraints cuffdiff = new GridBagConstraints();
		            cuffdiff.gridx = 0;
		            cuffdiff.gridy=3;
		            cuffdiff.gridwidth=1;
		            cuffdiff.gridheight = 1;
		            cuffdiff.weightx = 0;
		            cuffdiff.weighty =0;
		            cuffdiff.fill = GridBagConstraints.BOTH;
		            cuffdiff.anchor = GridBagConstraints.WEST;
		            frame.add (cuffdiffpath,cuffdiff);
		            
		            
		            JButton cuffdiffsel =new JButton("Select");
		            GridBagConstraints cuffdiff1= new GridBagConstraints();
		            cuffdiff1.gridx=1;
		            cuffdiff1.gridy=3;
		            cuffdiff1.gridwidth=1;
		            cuffdiff1.gridheight = 1;
		            cuffdiff1.weightx = 0;
		            cuffdiff1.weighty = 0;
		            cuffdiff1.fill = GridBagConstraints.BOTH;
		            cuffdiffsel.addActionListener (new ActionListener() {
		            	
		                
		          	   @Override
		    		public void actionPerformed(ActionEvent e) {
		          	    JFileChooser jfc = new JFileChooser();
//		          	  FileNameExtensionFilter filter = new FileNameExtensionFilter(
//		            	        "GTF File", "gtf");
//		          	  jfc.setFileFilter(filter);
		                  jfc. setFileSelectionMode(0);
		          	    int result=jfc.showOpenDialog(frame);
		          	    if(result==JFileChooser.APPROVE_OPTION ){
		          	    	cuffdiffpath.setText((jfc.getSelectedFile().getAbsolutePath().toString()));}

		          	    }
		          	   });
		            frame.add(cuffdiffsel,cuffdiff1);
		            
		            
		            JButton save =new JButton("Save");
		            GridBagConstraints savel= new GridBagConstraints();
		            savel.gridx=1;
		            savel.gridy=4;
		            savel.gridwidth=1;
		            savel.gridheight = 1;
		            savel.weightx = 0;
		            savel.weighty = 0;
		            savel.fill = GridBagConstraints.BOTH;
		            save.addActionListener (new ActionListener() {
		            	
		                
		          	   @Override
		    		public void actionPerformed(ActionEvent e) {
		          		   
		          	    //JFileChooser jfc = new JFileChooser();
//		          	  FileNameExtensionFilter filter = new FileNameExtensionFilter(
//		            	        "GTF File", "gtf");
//		          	  jfc.setFileFilter(filter);
//		                  jfc. setFileSelectionMode(0);
//		          	    int result=jfc.showOpenDialog(frame);
//		          	    if(result==JFileChooser.APPROVE_OPTION ){
//		          	     gtft.setText((jfc.getSelectedFile().getAbsolutePath().toString()));}
		          		
                      
                     File t = new File("tophatpath");
                     File c = new File("cuffdiffpath");
                     FileWriter t1;
                     FileWriter c1;
					try {
						t1 = new FileWriter(t);
						 BufferedWriter bt1 = new BufferedWriter(t1);
						 bt1.write("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						c1 = new FileWriter(c);
						 BufferedWriter bc1 = new BufferedWriter(c1);
						 bc1.write("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
                    
//                  if (t.exists() || tophatpath.getText().length() != 0){
//                	  tophatpath.setText(ReadFromFIle.read("tophatpath"));
//                      //tophatpath1 = tophatpath.getText().toString();
//                	  
//                  }
                 
//                  else if (c.exists() || cuffdiffpath.getText().length() != 0){
//                	  cuffdiffpath.setText(ReadFromFIle.read("cuffdiffpath"));
//                	  cuffdiffpath1 = cuffdiffpath.getText().toString();
//                	  
//                  }
//                   if (tophatpath.getText().length()==0 || cuffdiffpath.getText().length()==0){
//                	   
//                	   JOptionPane.showMessageDialog(null, "成功");
//                	   
//                   }
                     
                 
                      WriteToFile.Write(tophatpath.getText().toString(), "tophatpath");
                      WriteToFile.Write(cuffdiffpath.getText().toString(), "cuffdiffpath");
                     
                      frame.setVisible(false); 
                
                      
                   
           
                    
                      
                      
                      
		          	    }

					
		          	   });
		            frame.add(save,savel);
		 
	        frame.setVisible(true);
	        try {
				findview();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
	 }
	 private void findview() throws IOException {
		// TODO Auto-generated method stub
		  if (tophatpath.getText().length()==0 || cuffdiffpath.getText().length()==0){
       	   
       	   JOptionPane.showMessageDialog(null, "You need either specify the location of the executables here or set them in your linux PATH");
       	   
          }
		 File t = new File("tophatpath");
         File c = new File("cuffdiffpath");
     if (t.exists() || c.exists()){
    	 if (FileUtils.readFile("tophatpath").length()!=0 || FileUtils.readFile("cuffdiffpath").length()!=0){
   	  tophatpath.setText(FileUtils.readFile("tophatpath"));
//         //tophatpath1 = tophatpath.getText().toString();
   	  cuffdiffpath.setText(FileUtils.readFile("cuffdiffpath"));
    	 }
     }
	 }
	private void check() {
			// TODO Auto-generated method stub
		 
		 if (tophatpath.getText() == null||tophatpath.getText().trim().equals("")){
     		
     		System.out.println("Please specify the location of tophat executable");
     		
     	}
     	else if (cuffdiffpath.getText()==null||cuffdiffpath.getText().trim().equals("")){
     			System.out.println("please specify the location of cuffdiff executable");
     			
     		}
     	
			
		}

}
