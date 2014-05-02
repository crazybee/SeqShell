package gui.src;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Tophat {

	private JFrame frame;
	private String [] name;
	private String [] coren;
	private String [] mism;
	public String index;
	public String [] segn;
	public  static String commandline;
	public String filepath;
	public int i;
	public static String rawfile;
	public static String[] rawfiles;
	public static String[] outputdirs;
	public static String outputdir;
	public static String pathtotophat;
	public static String tophatrun;
	public Tophat () {
		
		frame = new JFrame("Tophat-shell-beta3 by LIU");
		
		String n [] = {"Annotation file",
				       "Raw file ",
				       "CPU process usage",
				       "Allowed mismatchs",
				       "Output dir",
				       "Segment length" +
				       "(<=50 integer only)",
				       "index file"
		               };
		String [] cn  = {"1","2","3","4","5","6","7","8"};
		String [] mismn  ={"0","1","2","3"};
		String [] segnum  = new String [50];
	  
	
		name = n;
		coren = cn;
		mism = mismn;
		
		 for (i=0;i<=49;i++){
      segnum [i] = String.valueOf(i+10);}
		 {
			 segn = segnum;}
		 }
				
        	
        
       
			
		

	public void startrun (){
	
        frame.setSize(600, 400);
    	Dimension   screenSize   =   Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension   frameSize   =   frame.getSize(); 
        if   (frameSize.height   >   screenSize.height) 
            frameSize.height   =   screenSize.height; 
        if   (frameSize.width   >   screenSize.width) 
            frameSize.width   =   screenSize.width; 
        int frame_height = frameSize.height;
        int frame_width = frameSize.width;
        
        frame.setLayout(new GridBagLayout());
        frame.setLocation((screenSize.width-frame_width)/2,(screenSize.height-frame_height)/ 2);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
       
        
        JLabel n0 = new JLabel (name[0]);
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
            
            
            final JTextField anno= new JTextField();
            GridBagConstraints annot = new GridBagConstraints();
            annot.gridx = 10;
            annot.gridy=0;
            annot.gridwidth=40;
            annot.gridheight = 1;
            annot.weightx = 0;
            annot.weighty =0;
            annot.fill = GridBagConstraints.BOTH;
            annot.anchor = GridBagConstraints.WEST;
            frame.add (anno,annot);
            
            
            JButton annofile =new JButton("select annotation file");
            GridBagConstraints annofilejb= new GridBagConstraints();
            annofilejb.gridx=10;
            annofilejb.gridy=1;
            annofilejb.gridwidth=1;
            annofilejb.gridheight = 1;
            annofilejb.weightx = 0;
            annofilejb.weighty = 0;
            annofilejb.fill = GridBagConstraints.BOTH;
            
            annofile.addActionListener(new ActionListener() {
            	
                
          	   @Override
			public void actionPerformed(ActionEvent e) {
          	    JFileChooser jfc = new JFileChooser();
                  jfc. setFileSelectionMode(0);
          	    int result=jfc.showOpenDialog(frame);
          	    if(result==JFileChooser.APPROVE_OPTION ){
          	    anno.setText((jfc.getSelectedFile().getAbsolutePath().toString()));}

          	    }
          	   });
            
            frame.add(annofile,annofilejb);
            
            
            
            
         JLabel n1 = new JLabel (name[1]);
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
                
                
                final JTextField raw= new JTextField();
                GridBagConstraints rawf = new GridBagConstraints();
                rawf.gridx = 10;
                rawf.gridy=2;
                rawf.gridwidth=40;
                rawf.gridheight = 1;
                rawf.weightx = 0;
                rawf.weighty =0;
                rawf.fill = GridBagConstraints.BOTH;
                rawf.anchor = GridBagConstraints.WEST;
                frame.add (raw,rawf);
         
                
                
                JButton rawfile =new JButton("select RAW file (fastq)");
                GridBagConstraints rawfilejb= new GridBagConstraints();
                rawfilejb.gridx=10;
                rawfilejb.gridy=3;
                rawfilejb.gridwidth=1;
                rawfilejb.gridheight = 1;
                rawfilejb.weightx = 0;
                rawfilejb.weighty = 0;
                rawfilejb.fill = GridBagConstraints.BOTH;
                
                rawfile.addActionListener(new ActionListener() {
                	
                    
              	   @Override
				public void actionPerformed(ActionEvent e) {
              	    JFileChooser jfc = new JFileChooser();
                      jfc. setFileSelectionMode(0);
              	    int result=jfc.showOpenDialog(frame);
              	    if(result==JFileChooser.APPROVE_OPTION ){
              	    	 final String rawfile = jfc.getSelectedFile().getAbsolutePath().toString();
              	    raw.setText(rawfile);}

              	    }
              	   });
                
                frame.add(rawfile,rawfilejb);
                
                JButton addraw =new JButton("Add more");
                GridBagConstraints addrawjb= new GridBagConstraints();
                addrawjb.gridx=15;
                addrawjb.gridy=3;
                addrawjb.gridwidth=1;
                addrawjb.gridheight = 1;
                addrawjb.weightx = 0;
                addrawjb.weighty = 0;
                addrawjb.fill = GridBagConstraints.BOTH;
                
                addraw.addActionListener(new ActionListener() {
                	
                    
              	   @Override
				public void actionPerformed(ActionEvent e) {
              	    JFileChooser jfc = new JFileChooser();
                      jfc. setFileSelectionMode(0);
              	    int result=jfc.showOpenDialog(frame);
              	    if(result==JFileChooser.APPROVE_OPTION ){
              	    	
              	    raw.setText((raw.getText()+","+jfc.getSelectedFile().getAbsolutePath().toString()));}

              	    }
              	   });
                
                frame.add(addraw,addrawjb);
        
         JLabel n2 = new JLabel (name[2]);
            GridBagConstraints l2 = new GridBagConstraints();
                l2.gridx = 0;
                l2.gridy = 4;
                l2.gridwidth = 1;
                l2.gridheight = 1;
                l2.weightx = 0;
                l2.weighty = 0;
                l2.fill = GridBagConstraints.BOTH;
                l2.anchor = GridBagConstraints.WEST;
                frame.add(n2, l2);
           
               final JComboBox jccore = new JComboBox(coren);
                GridBagConstraints jccoref = new GridBagConstraints();
                jccoref.gridx = 10;
                jccoref.gridy = 4;
                jccoref.gridwidth = 1;
                jccoref.gridheight = 1;
                jccoref.weightx = 0;
                jccoref.weighty = 0;
                jccoref.fill = GridBagConstraints.NONE;
                jccoref.anchor = GridBagConstraints.WEST;
                frame.add(jccore, jccoref); 
                
          JLabel n3 = new JLabel (name[3]);
          GridBagConstraints l3 = new GridBagConstraints();
                  l3.gridx = 0;
                  l3.gridy = 5;
                  l3.gridwidth = 1;
                  l3.gridheight = 1;
                  l3.weightx = 0;
                  l3.weighty = 0;
                  l3.fill = GridBagConstraints.BOTH;
                  l3.anchor = GridBagConstraints.WEST;
                  frame.add(n3, l3);
                  
          final JComboBox allmis = new JComboBox(mism);
                  GridBagConstraints allmisj = new GridBagConstraints();
                  allmisj.gridx =10;
                  allmisj.gridy = 5;
                  allmisj.gridwidth = 1;
                  allmisj.gridheight = 1;
                  allmisj.weightx = 0;
                  allmisj.weighty = 0;
                  allmisj.fill = GridBagConstraints.BOTH;
                  allmisj.anchor = GridBagConstraints.WEST;
                  frame.add(allmis, allmisj);       
           
                  
          JLabel n4 = new JLabel (name [4]);
          GridBagConstraints l4 = new GridBagConstraints();
          l4.gridx = 0;
          l4.gridy = 6;
          l4.gridwidth = 1;
          l4.gridheight = 1;
          l4.weightx = 0;
          l4.weighty = 0;
          l4.fill = GridBagConstraints.BOTH;
          l4.anchor = GridBagConstraints.WEST;
          frame.add(n4,l4);
                  
                  
          JLabel seg =  new JLabel (name [5]);
          GridBagConstraints segg = new GridBagConstraints();
          segg.gridx = 0;
          segg.gridy = 8;
          segg.gridwidth = 1;
          segg.gridheight = 1;
          segg.weightx = 0;
          segg.weighty = 0;
          segg.fill = GridBagConstraints.BOTH;
          segg.anchor = GridBagConstraints.WEST;
          frame.add(seg,segg);
          
          final JLabel index =  new JLabel (name [6]);
          GridBagConstraints indexg = new GridBagConstraints();
          indexg.gridx = 0;
          indexg.gridy = 9;
          indexg.gridwidth = 1;
          indexg.gridheight = 1;
          indexg.weightx = 0;
          indexg.weighty = 0;
          indexg.fill = GridBagConstraints.BOTH;
          indexg.anchor = GridBagConstraints.WEST;
          frame.add(index,indexg);
          
          final JTextField indexf = new JTextField();
          GridBagConstraints indexfg = new GridBagConstraints();
          indexfg.gridx = 10;
          indexfg.gridy=9;
          indexfg.gridwidth=40;
          indexfg.gridheight = 1;
          indexfg.weightx = 0;
          indexfg.weighty =0;
          indexfg.fill = GridBagConstraints.BOTH;
          indexfg.anchor = GridBagConstraints.WEST;
          frame.add (indexf,indexfg);
          
          JButton indexfb =new JButton("select index file dir");
          GridBagConstraints indexfbg = new GridBagConstraints();
          indexfbg.gridx=10;
          indexfbg.gridy=10;
          indexfbg.gridwidth=1;
          indexfbg.gridheight = 1;
          indexfbg.weightx = 0;
          indexfbg.weighty = 0;
          indexfbg.fill = GridBagConstraints.BOTH;
          
          indexfb.addActionListener(new ActionListener() {
          	
              
        	   @Override
			public void actionPerformed(ActionEvent e) {
        	    JFileChooser jfc = new JFileChooser();
                jfc. setFileSelectionMode(1);
        	    int result=jfc.showOpenDialog(frame);
        	    if(result==JFileChooser.APPROVE_OPTION ){
        	    indexf.setText((jfc.getSelectedFile().getAbsolutePath().toString())); 
        	   }
               
        	    }
        	   });
          
          frame.add(indexfb,indexfbg);
          
          
          final JComboBox segnum = new JComboBox(segn);
          GridBagConstraints segnumg = new GridBagConstraints();
          segnumg.gridx = 10;
          segnumg.gridy=8;
          segnumg.gridwidth=40;
          segnumg.gridheight = 1;
          segnumg.weightx = 0;
          segnumg.weighty =0;
          segnumg.fill = GridBagConstraints.BOTH;
          segnumg.anchor = GridBagConstraints.WEST;
          frame.add (segnum,segnumg);
          
          final JTextField output= new JTextField();
          GridBagConstraints outputg = new GridBagConstraints();
          outputg.gridx = 10;
          outputg.gridy=6;
          outputg.gridwidth=40;
          outputg.gridheight = 1;
          outputg.weightx = 0;
          outputg.weighty =0;
          outputg.fill = GridBagConstraints.BOTH;
          outputg.anchor = GridBagConstraints.WEST;
          frame.add (output,outputg);
          
          
          JButton outputdir =new JButton("select output dir");
          GridBagConstraints outputdirg= new GridBagConstraints();
          outputdirg.gridx=10;
          outputdirg.gridy=7;
          outputdirg.gridwidth=1;
          outputdirg.gridheight = 1;
          outputdirg.weightx = 0;
          outputdirg.weighty = 0;
          outputdirg.fill = GridBagConstraints.BOTH;
          
          outputdir.addActionListener(new ActionListener() {
          	
              
        	   @Override
			public void actionPerformed(ActionEvent e) {
        	    JFileChooser jfc = new JFileChooser();
                jfc. setFileSelectionMode(1);
        	    int result=jfc.showOpenDialog(frame);
        	    if(result==JFileChooser.APPROVE_OPTION ){
        	    output.setText((jfc.getSelectedFile().getAbsolutePath().toString()));}

        	    }
        	   });
          
          frame.add(outputdir,outputdirg);
          
          
          
          
          JLabel errorm = new JLabel("         Error msg:");
          GridBagConstraints errormg = new GridBagConstraints();
          errormg.gridx = 0;
          errormg.gridy = 11;
          errormg.gridwidth = 5;
          errormg.gridheight = 1;
          errormg.weightx = 0;
          errormg.weighty = 0;
          errormg.fill = GridBagConstraints.BOTH;
          errormg.anchor = GridBagConstraints.EAST;
          frame.add(errorm, errormg);   
          
          
          final JLabel errorout= new JLabel("");
          GridBagConstraints erroroutmg = new GridBagConstraints();
          erroroutmg.gridx = 10;
          erroroutmg.gridy = 11;
          erroroutmg.gridwidth = 5;
          erroroutmg.gridheight = 1;
          erroroutmg.weightx = 0;
          erroroutmg.weighty = 0;
          erroroutmg.fill = GridBagConstraints.BOTH;
          erroroutmg.anchor = GridBagConstraints.EAST;
          frame.add(errorout, erroroutmg);   
          
          final JTextField emailadd = new JTextField();
          GridBagConstraints emailaddg = new GridBagConstraints();
          emailaddg.gridx = 6;
          emailaddg.gridy=31;
          emailaddg.gridwidth=40;
          emailaddg.gridheight = 1;
          emailaddg.weightx = 0;
          emailaddg.weighty =0;
          emailaddg.fill = GridBagConstraints.BOTH;
          emailaddg.anchor = GridBagConstraints.WEST;
          frame.add (emailadd,emailaddg); 
          
          JLabel emailaddm = new JLabel("              Your email address:");
          GridBagConstraints  emailaddmg = new GridBagConstraints();
          emailaddmg.gridx = 0;
          emailaddmg.gridy = 31;
          emailaddmg.gridwidth = 5;
          emailaddmg.gridheight = 1;
          emailaddmg.weightx = 0;
          emailaddmg.weighty = 0;
          emailaddmg.fill = GridBagConstraints.BOTH;
          emailaddmg.anchor = GridBagConstraints.EAST;
          frame.add(emailaddm, emailaddmg);
          
          
          final JButton ok = new JButton("OK");
          
          GridBagConstraints c9 = new GridBagConstraints();
          c9.gridx = 20;
          c9.gridy = 30;
          c9.gridwidth = 1;
          c9.gridheight = 1;
          c9.weightx = 0;
          c9.weighty = 0;
          c9.fill = GridBagConstraints.NONE;
          c9.anchor = GridBagConstraints.SOUTH;
          ok.addActionListener(new ActionListener() {         
          	@Override
			public void actionPerformed(ActionEvent e) {
          		String email = emailadd.getText().toString();
          	    	
          	  	if (output.getText()== null||output.getText().trim().equals("")){
              		
              		System.out.println("please specify output dir");
              		errorout.setText("please specify output dir");
              	}
              	else if (anno.getText()== null||anno.getText().trim().equals("")){
              			System.out.println("please specify gtf  file");
              			errorout.setText("please specify gtf file");
              		}
              	else if (raw.getText()== null||raw.getText().trim().equals("")){
              		System.out.println("please specify Raw file");
              		errorout.setText("please specify Raw file");
              	}
              	else if (email =="" || email.matches("\\w+([-+.]\\w+)*@\\w+([-+.]\\w+)*\\.\\w+([-+.]\\w+)*")== false){
            		System.out.println("Your email format is not correct.");
            		errorout.setText("Incorrect email");
            	} 
              	
              
              		
              	
              	else{
              		 String index = indexf.getText().toString();
					 
              		
						 index = index + "/mm9";
              		 
              		String rawtemp =raw.getText().toString();
              		String outputdir =output.getText().toString();
              		String [] rawsplit = rawtemp.split(",");
              		String [] rawfile = rawtemp.split(",");
              		String commandline [] = new String [rawsplit.length];
                 for (int j =0; j<rawsplit.length;j++){
                    	File folder = new File (outputdir+"/"+rawsplit[j]);
                    	folder.mkdir();
                    	}
                try{
                	FileOutputStream erasor = new FileOutputStream("tophat.sh");
                
                 erasor.close();
                }
                catch (Exception ee){
                	ee.printStackTrace();
                	
                }
                File t = new File("tophatpath");
               
            if (t.exists()){
           	 try {
				if (FileUtils.readFile("tophatpath").length()!=0 ){
				
					pathtotophat = FileUtils.readFile("tophatpath").replace('\n', ' ');
				

					tophatrun = pathtotophat+"-p";
				 }
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
            else {
				tophatrun = "tophat -p";
				}
                    for (int k = 0; k<rawsplit.length;k++){	 
                    	String temp = rawsplit[k];
                    	String temp1 [] =temp.split("/");
                    	rawsplit[k] = temp1[temp1.length-1];
                    	System.out.println(tophatrun);
                    	commandline [k]= tophatrun +jccore.getSelectedItem().toString()+" -o "+outputdir+"/"+rawsplit[k]+
          			" --segment-length "+segnum.getSelectedItem().toString()+" -G "+anno.getText().toString()+" --coverage-search --butterfly-search "
          			+"--segment-mismatches "+allmis.getSelectedItem().toString()+" "+index+" "+rawfile[k];
                    
                    	WriteToFile.Write(commandline[k],"tophat.sh");
                    	
                    	
                    }
                   			
              	
              			 
             
             
              		try {
                 		
          	              //PrintWriter brw =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("tophat.sh"))));
          						
          					ok.setEnabled(false);
          					//brw.print(commandline);
          	                //brw.close();	
          	              String outputafterregt = output.getText().toString();
          	            outputafterregt= outputafterregt.replaceAll("/home", "\\\\\\\\beasty.erasmusmc.nl");
          	    		outputafterregt = outputafterregt.replaceAll("/", "\\\\");
          	            
          	               Mediator.setMessage("Your alignment job started at "+new Date().toString()+" has finished "+"\n"+" Your result is located in "
          	            		   +outputafterregt);
          	               Mediator.setEmail(emailadd.getText().toString());	

          	          SwingUtilities.invokeLater(new Runnable(){
          	        	  @Override
						public void run(){
          	          outputwindowt output = new outputwindowt();
          	          output.interfaceiniti();
          	          output.pack();
          	          
          	          }
          	          
          	          });
          	      
              	 } 
          	          
          			
             
          	        catch (Exception err) {
          	        	      err.printStackTrace();
          	        	    } 
    	
              	}}
          
          
          });
          
          
          frame.add(ok,c9);	 
          
          
           JButton clear = new JButton("Clear");
        GridBagConstraints clearg = new GridBagConstraints();
        clearg.gridx = 15;
        clearg.gridy = 30;
        clearg.gridwidth = 1;
        clearg.gridheight = 1;
        clearg.weightx = 0;
        clearg.weighty = 0;
        clearg.fill = GridBagConstraints.NONE;
        clearg.anchor = GridBagConstraints.SOUTH;
        frame.add(clear, clearg);
        clear.addActionListener(new ActionListener(){
        	@Override
			public void actionPerformed(ActionEvent e){
        		anno.setText("");
        		anno.getText( );
        		indexf.setText("");
        		indexf.getText( );
        		errorout.setText("");
        		errorout.getText( );
        		raw.setText("");
				raw.getText();
				output.setText("");
				output.getText( );
        		
        	}
        });
          
          
          
          
          frame.setVisible(true);                   
              
	}
	
	
          public static class outputwindowt extends JFrame {
     		 
     		private static final long serialVersionUID = 1L;
     		
     		 public void interfaceiniti() {
     			
     			 /*Informable informable = new Informable(){
     				
     				 public void messageChanged( String message){
     					
     					 }
     			 };*/
     			 

     			 
     	final String output = "Run log";
     	OutputWorker worker = new OutputWorker (output,"sh tophat.sh");
     	
     	worker.execute();
     		 
     		 }
     		
	
}
//     public static void main(String[] args){
//    	 Tophat t = new Tophat();
//    	 t.startrun();
//     }
       
         

}

