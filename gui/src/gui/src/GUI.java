package gui.src;

//Author: Zhe Liu
//Date: Feb-7-2014
//
//Version: beta5
/*
This is the functional class for performing gene expression analysis using the cuffdiff tool

*/
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
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;




public class GUI  {
    private JFrame frame1;

    public static String code;
    private String[] name;
    private String[] f;
    private String[] min;
    private String[] coren;
    private String[] mfln;
    private String[] sdn;
    public String t;
    public String total;
    public String sample2location;
    public String sample1location;
    public static String pathtocuffdiff;
    public static String cuffdiffrun;
   
    public int i;
    public String userinput;
    public static String commandline;
   
    public GUI() {
    	
        frame1 = new JFrame("cuffdiff-shell-beta5 by LIU");
        String n[] = {"FDR", 
                      "Min-Align-number", 
                      "Processor core", 
                      "Name of Group 1",
                      "Name of Group 2",                    
                      "mean fragment length", 
                      "SD for fragment length",
                      "Output Directory",
                      "Gene annotation file",
                      "Specify sample(s) in Group 1",
                      "Specify sample(s) in Group 2"
                      };
        String fdr[]={"0.01",
        		      "0.02",
        		      "0.05",
        		      "0.1",
        		      "0.2",
        		      "0.25",
        		      "0.3"};
        String c[]={"0","1","2","5","10","20","30"};
        String core[]={"1","2","3","4","5","6","7","8"};
        String mfl[]={"150","200","250","300","350"};
        String sd[]={"50","80","100"};
        
        name = n;
        f=fdr;
        min=c;
        coren=core;
        mfln=mfl;
        sdn=sd;
        
        
        
    }
     
    public void startrun()  {
    	
    	Dimension   screenSize   =   Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension   frameSize   =   frame1.getSize(); 
        if   (frameSize.height   >   screenSize.height) 
            frameSize.height   =   screenSize.height; 
        if   (frameSize.width   >   screenSize.width) 
            frameSize.width   =   screenSize.width; 
        int frame_height = frameSize.height;
    	int frame_width = frameSize.width;
    	frame1.setSize((screenSize.width-frame_width)/2,(screenSize.height-frame_height)/2);
    	
    	frame1.setLocationRelativeTo(null);
	
        frame1.setLayout(new GridBagLayout());
        
        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   
        JLabel n0 = new JLabel (name[0]);
        GridBagConstraints l0 = new GridBagConstraints();
        	l0.gridx = 0;
            l0.gridy = 0;
            l0.gridwidth = 1;
            l0.gridheight = 1;
            l0.weightx = 0;
            l0.weighty = 0;
            l0.fill = GridBagConstraints.NONE;
            l0.anchor = GridBagConstraints.WEST;
            frame1.add(n0, l0);
        
        
        final JComboBox jc0 = new JComboBox(f);
        GridBagConstraints c0 = new GridBagConstraints();
        c0.gridx = 6;
        c0.gridy = 0;
        c0.gridwidth = 1;
        c0.gridheight = 1;
        c0.weightx = 0;
        c0.weighty = 0;
        c0.fill = GridBagConstraints.NONE;
        c0.anchor = GridBagConstraints.WEST;
        frame1.add(jc0, c0);
        
        
         
        JLabel n1 = new JLabel(name[1]);
        GridBagConstraints l1 = new GridBagConstraints();
        l1.gridx = 0;
        l1.gridy = 1;
        l1.gridwidth = 1;
        l1.gridheight = 1;
        l1.weightx = 0;
        l1.weighty = 0;
        l1.fill = GridBagConstraints.NONE;
        l1.anchor = GridBagConstraints.WEST;
        frame1.add(n1, l1);
        
        final JComboBox jc1 = new JComboBox(min);
        GridBagConstraints  c1= new GridBagConstraints();
        c1.gridx = 6;
        c1.gridy = 1;
        c1.gridwidth = 1;
        c1.gridheight = 1;
        c1.weightx = 0;
        c1.weighty = 0;
        c1.fill = GridBagConstraints.NONE;
        c1.anchor = GridBagConstraints.WEST;
        frame1.add(jc1, c1);
         
        JLabel n2 = new JLabel(name[2]);
        GridBagConstraints l2 = new GridBagConstraints();
        l2.gridx = 0;
        l2.gridy = 2;
        l2.gridwidth = 1;
        l2.gridheight = 1;
        l2.weightx = 0;
        l2.weighty = 0;
        l2.fill = GridBagConstraints.BOTH;
        l2.anchor = GridBagConstraints.WEST;
        frame1.add(n2, l2);
 
        
        final JComboBox jc2 = new JComboBox(coren);
        GridBagConstraints  c2= new GridBagConstraints();
        c2.gridx = 6;
        c2.gridy = 2;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.weightx = 0;
        c2.weighty = 0;
        c2.fill = GridBagConstraints.NONE;
        c2.anchor = GridBagConstraints.WEST;
        frame1.add(jc2, c2);
        
        
        JLabel gtf = new JLabel(name[8]);
        GridBagConstraints gtfl = new GridBagConstraints();
        gtfl.gridx = 0;
        gtfl.gridy = 3;
        gtfl.gridwidth = 1;
        gtfl.gridheight = 1;
        gtfl.weightx = 0;
        gtfl.weighty = 0;
        gtfl.fill = GridBagConstraints.BOTH;
        gtfl.anchor = GridBagConstraints.WEST;
        frame1.add(gtf,gtfl);
        
        final JTextField gtft = new JTextField("The selected gtf file will be displayed here.");
        GridBagConstraints gtftl = new GridBagConstraints();
        gtftl.gridx = 6;
        gtftl.gridy=3;
        gtftl.gridwidth=40;
        gtftl.gridheight = 1;
        gtftl.weightx = 0;
        gtftl.weighty =0;
        gtftl.fill = GridBagConstraints.BOTH;
        gtftl.anchor = GridBagConstraints.WEST;
        frame1.add (gtft,gtftl);
        
        JButton gtfb =new JButton("select a GTF file");
        GridBagConstraints gtfbl= new GridBagConstraints();
        gtfbl.gridx=6;
        gtfbl.gridy=4;
        gtfbl.gridwidth=1;
        gtfbl.gridheight = 1;
        gtfbl.weightx = 0;
        gtfbl.weighty = 0;
        gtfbl.fill = GridBagConstraints.BOTH;
        gtfb.addActionListener (new ActionListener() {
        	
            
      	   @Override
		public void actionPerformed(ActionEvent e) {
      	    JFileChooser jfc = new JFileChooser();
      	  FileNameExtensionFilter filter = new FileNameExtensionFilter(
        	        "GTF File", "gtf");
      	  jfc.setFileFilter(filter);
              jfc. setFileSelectionMode(0);
      	    int result=jfc.showOpenDialog(frame1);
      	    if(result==JFileChooser.APPROVE_OPTION ){
      	     gtft.setText((jfc.getSelectedFile().getAbsolutePath().toString()));}

      	    }
      	   });
        frame1.add(gtfb,gtfbl);
        
        
        JLabel n3 = new JLabel(name[3]);
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 5;
        c3.gridwidth = 1;
        c3.gridheight = 1;
        c3.weightx = 0;
        c3.weighty = 0;
        c3.fill = GridBagConstraints.BOTH;
        c3.anchor = GridBagConstraints.WEST;
        frame1.add(n3, c3);
        
        
        final JTextField t3 = new JTextField();
        GridBagConstraints tf3 = new GridBagConstraints();
        tf3.gridx = 6;
        tf3.gridy=5;
        tf3.gridwidth=40;
        tf3.gridheight = 1;
        tf3.weightx = 0;
        tf3.weighty =0;
        tf3.fill = GridBagConstraints.BOTH;
        tf3.anchor = GridBagConstraints.WEST;
        frame1.add (t3,tf3);
        
        JLabel sam1l=new JLabel(name[9]);
        GridBagConstraints sam1ll = new GridBagConstraints();
        sam1ll.gridx = 0;
        sam1ll.gridy = 6;
        sam1ll.gridwidth = 1;
        sam1ll.gridheight = 1;
        sam1ll.weightx = 0;
        sam1ll.weighty = 0;
        sam1ll.fill = GridBagConstraints.BOTH;
        sam1ll.anchor = GridBagConstraints.WEST;
        frame1.add(sam1l, sam1ll);
        
//        final JTextField sample1location = new JTextField("The selected BAM/SAM files in Group 1 will be displayed here.");
//        GridBagConstraints sample1locationl = new GridBagConstraints();
//        sample1locationl.gridx = 6;
//        sample1locationl.gridy=6;
//        sample1locationl.gridwidth=40;
//        sample1locationl.gridheight = 1;
//        sample1locationl.weightx = 0;
//        sample1locationl.weighty =0;
//        sample1locationl.fill = GridBagConstraints.BOTH;
//        sample1locationl.anchor = GridBagConstraints.WEST;
//        frame1.add (sample1location,sample1locationl);
        
        JButton sample1 =new JButton("select sample(s) (SAM/BAM format)");
        GridBagConstraints sample1l= new GridBagConstraints();
        sample1l.gridx=6;
        sample1l.gridy=6;
        sample1l.gridwidth=1;
        sample1l.gridheight = 1;
        sample1l.weightx = 0;
        sample1l.weighty = 0;
        sample1l.fill = GridBagConstraints.BOTH;
        sample1.addActionListener(new ActionListener() {
        	
            
      	   @Override
		public void actionPerformed(ActionEvent e) {
      	    JFileChooser jfc = new JFileChooser();
      	   FileNameExtensionFilter filter = new FileNameExtensionFilter(
      	        "BAM & SAM Files", "bam", "sam");
      	   jfc.setFileFilter(filter);
              jfc. setFileSelectionMode(0);
              jfc. setMultiSelectionEnabled(true);
      	    int result=jfc.showOpenDialog(frame1);
      	    if(result==JFileChooser.APPROVE_OPTION ){
      	    	
      	    	File j[] = jfc.getSelectedFiles();
      	    	String file = "";
      	    	for (int i=0; i < j.length; i++){
      	    		
      	    		file += j[i].getAbsolutePath()+",";
      	    		
      	    		System.out.println("file selected is "+file);
      	    		
      	    		
      	    	}
      	     file = file.substring(0, file.length()-1);
      	     sample1location = file;
      	     }

      	    }
      	   });
        frame1.add(sample1,sample1l);
        
//        JButton sample1add =new JButton("more replicates in this group");
//        GridBagConstraints sample1addjb= new GridBagConstraints();
//        sample1addjb.gridx=10;
//        sample1addjb.gridy=7;
//        sample1addjb.gridwidth=1;
//        sample1addjb.gridheight = 1;
//        sample1addjb.weightx = 0;
//        sample1addjb.weighty = 0;
//        sample1addjb.fill = GridBagConstraints.BOTH;
//        sample1add.addActionListener(new ActionListener() {
//        	
//            
//      	   public void actionPerformed(ActionEvent e) {
//      	    JFileChooser jfc = new JFileChooser();
//              jfc. setFileSelectionMode(0);
//      	    int result=jfc.showOpenDialog(frame1);
//      	    if(result==JFileChooser.APPROVE_OPTION ){
//      	     sample1location.setText((sample1location.getText()+","+jfc.getSelectedFile().getAbsolutePath().toString()));}
//
//      	    }
//      	   });
//        frame1.add(sample1add,sample1addjb);
        
        
        final JLabel n4 = new JLabel(name[4]);
        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 0;
        c4.gridy = 8;
        c4.gridwidth = 1;
        c4.gridheight = 1;
        c4.weightx = 0;
        c4.weighty = 0;
        c4.fill = GridBagConstraints.BOTH;
        c4.anchor = GridBagConstraints.WEST;
        frame1.add(n4, c4);
        
        final JTextField t4 = new JTextField();
        GridBagConstraints tf4 = new GridBagConstraints();
        tf4.gridx = 6;
        tf4.gridy=8;
        tf4.gridwidth=40;
        tf4.gridheight = 1;
        tf4.weightx = 0;
        tf4.weighty =0;
        tf4.fill = GridBagConstraints.BOTH;
        tf4.anchor = GridBagConstraints.WEST;
        frame1.add (t4,tf4);
        
        JLabel sam2l=new JLabel(name[10]);
        sam2l.setToolTipText("Select file(s) by clicking the select button");
        GridBagConstraints sam2ll = new GridBagConstraints();
        sam2ll.gridx = 0;
        sam2ll.gridy = 9;
        sam2ll.gridwidth = 1;
        sam2ll.gridheight = 1;
        sam2ll.weightx = 0;
        sam2ll.weighty = 0;
        sam2ll.fill = GridBagConstraints.BOTH;
        sam2ll.anchor = GridBagConstraints.WEST;
        
        frame1.add(sam2l, sam2ll);
        
//        final JTextField sample2location = new JTextField("The selected BAM/SAM files in Group 2 will be displayed here.");
//        GridBagConstraints sample2locationl = new GridBagConstraints();
//        sample2locationl.gridx = 6;
//        sample2locationl.gridy=9;
//        sample2locationl.gridwidth=40;
//        sample2locationl.gridheight = 1;
//        sample2locationl.weightx = 0;
//        sample2locationl.weighty =0;
//        sample2locationl.fill = GridBagConstraints.BOTH;
//        sample2locationl.anchor = GridBagConstraints.WEST;
//        frame1.add (sample2location,sample2locationl);
        
        JButton sample2 =new JButton("select sample(s) (SAM/BAM format)");
        GridBagConstraints sample2l= new GridBagConstraints();
        sample2l.gridx=6;
        sample2l.gridy=9;
        sample2l.gridwidth=1;
        sample2l.gridheight = 1;
        sample2l.weightx = 0;
        sample2l.weighty = 0;
        sample2l.fill = GridBagConstraints.BOTH;
        sample2.addActionListener(new ActionListener() {
        	
            
     	   @Override
		public void actionPerformed(ActionEvent e) {
     		  JFileChooser jfc = new JFileChooser();
     		  FileNameExtensionFilter filter = new FileNameExtensionFilter(
           	        "BAM & SAM Files", "bam", "sam");
           	  jfc.setFileFilter(filter);
              jfc. setFileSelectionMode(0);
              jfc. setMultiSelectionEnabled(true);
      	    int result=jfc.showOpenDialog(frame1);
      	    if(result==JFileChooser.APPROVE_OPTION ){
      	    	
      	    	File j[] = jfc.getSelectedFiles();
      	    	String file = "";
      	    	for (int i=0; i < j.length; i++){
      	    		
      	    		file += j[i].getAbsolutePath()+",";
      	    		
      	    		System.out.println("file selected is "+file);
      	    		
      	    		
      	    	}
      	     file = file.substring(0, file.length()-1);
      	     sample2location = file;
      	     System.out.println("sample2location is "+sample2location);
      	    // sample2location.setText(file);
     	    }
     	   }
     	   });
        frame1.add(sample2,sample2l);
        
//        JButton sample2add =new JButton("more replicates in this group");
//        GridBagConstraints sample2addjb= new GridBagConstraints();
//        sample2addjb.gridx=10;
//        sample2addjb.gridy=10;
//        sample2addjb.gridwidth=1;
//        sample2addjb.gridheight = 1;
//        sample2addjb.weightx = 0;
//        sample2addjb.weighty = 0;
//        sample2addjb.fill = GridBagConstraints.BOTH;
//        sample2add.addActionListener(new ActionListener() {
//        	
//            
//     	   public void actionPerformed(ActionEvent e) {
//     	    JFileChooser jfc = new JFileChooser();
//             jfc. setFileSelectionMode(0);
//     	    int result=jfc.showOpenDialog(frame1);
//     	   if(result==JFileChooser.APPROVE_OPTION ){
//        	     sample2location.setText((sample2location.getText()+","+jfc.getSelectedFile().getAbsolutePath().toString()));}
//
//
//     	    }
//     	   });
//        frame1.add(sample2add,sample2addjb);
        
        
                
        JLabel m = new JLabel(name[5]);
        GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 0;
        c5.gridy = 11;
        c5.gridwidth = 1;
        c5.gridheight = 1;
        c5.weightx = 0;
        c5.weighty = 0;
        c5.fill = GridBagConstraints.BOTH;
        c5.anchor = GridBagConstraints.WEST;
        frame1.add(m, c5);
        
        final JComboBox jc3 = new JComboBox(mfln);
        GridBagConstraints  c6= new GridBagConstraints();
        c6.gridx = 6;
        c6.gridy = 11;
        c6.gridwidth = 1;
        c6.gridheight = 1;
        c6.weightx = 0;
        c6.weighty = 0;
        c6.fill = GridBagConstraints.NONE;
        c6.anchor = GridBagConstraints.WEST;
        frame1.add(jc3, c6);
        
        JLabel n6 = new JLabel(name[6]);
        GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 0;
        c7.gridy = 12;
        c7.gridwidth = 1;
        c7.gridheight = 1;
        c7.weightx = 0;
        c7.weighty = 0;
        c7.fill = GridBagConstraints.BOTH;
        c7.anchor = GridBagConstraints.WEST;
        frame1.add(n6, c7);
         
        final JComboBox jc4 = new JComboBox(sdn);
        GridBagConstraints  c8= new GridBagConstraints();
        c8.gridx = 6;
        c8.gridy = 12;
        c8.gridwidth= 1;
        c8.gridheight = 1;
        c8.weightx = 0;
        c8.weighty = 0;
        c8.fill = GridBagConstraints.NONE;
        c8.anchor = GridBagConstraints.WEST;
        frame1.add(jc4, c8);
        
        JLabel outputl = new JLabel(name[7]);
        GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 0;
        c12.gridy = 13;
        c12.gridwidth = 1;
        c12.gridheight = 1;
        c12.weightx = 0;
        c12.weighty = 0;
        c12.fill = GridBagConstraints.BOTH;
        c12.anchor = GridBagConstraints.WEST;
        frame1.add(outputl,c12);
        
        
        
        
        final JTextField output = new JTextField ();
        GridBagConstraints c11 = new GridBagConstraints();
        c11.gridx = 6;
        c11.gridy = 13;
        c11.gridwidth = 40;
        c11.gridheight = 1;
        c11.weightx = 0;
        c11.weighty = 0;
        c11.fill = GridBagConstraints.BOTH;
        c11.anchor = GridBagConstraints.WEST;
        frame1.add(output, c11);
        
       
        
        final JLabel errorout= new JLabel("");
        GridBagConstraints erroroutmg = new GridBagConstraints();
        erroroutmg.gridx = 6;
        erroroutmg.gridy = 16;
        erroroutmg.gridwidth = 5;
        erroroutmg.gridheight = 6;
        erroroutmg.weightx = 0;
        erroroutmg.weighty = 0;
        erroroutmg.fill = GridBagConstraints.BOTH;
        erroroutmg.anchor = GridBagConstraints.EAST;
        frame1.add(errorout, erroroutmg);   
        
        JLabel errorm = new JLabel("                    System msg:");
        GridBagConstraints errormg = new GridBagConstraints();
        errormg.gridx = 0;
        errormg.gridy = 16;
        errormg.gridwidth = 5;
        errormg.gridheight = 1;
        errormg.weightx = 0;
        errormg.weighty = 0;
        errormg.fill = GridBagConstraints.BOTH;
        errormg.anchor = GridBagConstraints.EAST;
        frame1.add(errorm, errormg);
        
        final JButton outputdir =new JButton("Set Output Directory");
        GridBagConstraints outputdirl= new GridBagConstraints();
        outputdirl.gridx=6;
        outputdirl.gridy=14;
        outputdirl.gridwidth=1;
        outputdirl.gridheight = 1;
        outputdirl.weightx = 0;
        outputdirl.weighty = 0;
        outputdirl.fill = GridBagConstraints.BOTH;
        
        
        
        outputdir.addActionListener(new ActionListener() {
        	
        
        	   @Override
			public void actionPerformed(ActionEvent e) {
        	    JFileChooser jfc = new JFileChooser();
                jfc. setFileSelectionMode(1);
        	    int result=jfc.showOpenDialog(frame1);
        	    if(result==JFileChooser.APPROVE_OPTION ){
        	     output.setText((jfc.getSelectedFile().getAbsolutePath().toString()));}

        	    }
        	   });
           
        frame1.add(outputdir,outputdirl);
        
        
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
        frame1.add (emailadd,emailaddg); 
        
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
        frame1.add(emailaddm, emailaddmg);
       
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
        	if (output.getText()==null||output.getText().trim().equals("")){
        		
        		System.out.println("please specify output dir");
        		errorout.setText("please specify output dir");
        	}
        	else if (gtft.getText()==null||gtft.getText().trim().equals("")){
        			System.out.println("please specify gtf file");
        			errorout.setText("please specify gtf file");
        		}
        	else if (sample1location == null||sample1location.trim().equals("")){
        			System.out.println("please specify sample1 location");
        			errorout.setText("please specify sample1 location");
        		}
        		
        	else if (sample2location==null||sample2location.trim().equals("")){
        		System.out.println("please specify sample2 location");
        		errorout.setText("please specify sample2 location");
        	}
        	else if (email =="" || email.matches("\\w+([-+.]\\w+)*@\\w+([-+.]\\w+)*\\.\\w+([-+.]\\w+)*")== false){
        		System.out.println("Your email format is not correct.");
        		errorout.setText("Incorrect email");
        	}
        	
        	
        
        	else {
        		
        		File c = new File("cuffdiffpath");
                
            	if (c.exists()){
               	 try {
    				if (FileUtils.readFile("cuffdiffpath").length()!=0 ){
    				
    				    pathtocuffdiff = FileUtils.readFile("cuffdiffpath").replace('\n', ' ');
    				

    					cuffdiffrun = pathtocuffdiff+"-p";
    				 }
    				
    				
    				
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
                }
                else {
    				cuffdiffrun = "cuffdiff -p";
    				}
        		sample1location = "\""+sample1location+"\"";
        		sample2location = "\""+sample2location+"\"";
        		System.out.println(cuffdiffrun);
        		String gtftt = "\""+gtft.getText().toString()+"\"";
        		cuffdiffrun = "\""+cuffdiffrun+"\"";
        		String outputt = "\""+output.getText().toString()+"\"";
        		commandline = cuffdiffrun+" "+jc2.getSelectedItem().toString()+" -o "+outputt+" -m "
        		+jc3.getSelectedItem().toString()+" -s "+jc4.getSelectedItem().toString()+" --FDR "+jc0.getSelectedItem().toString()+
        		" -c "+jc1.getSelectedItem().toString()+" -u"+" -L "+t3.getText().toString()+","+t4.getText().toString()
        			+" "+gtftt+" "+sample1location+" "+sample2location;
        		
        		//commandline = "/home/crazybee/cufflinks/cufflinks ./test_data.sam";
       	        	System.out.println(commandline);
        try {
        		
              BufferedWriter brw =  new BufferedWriter(new FileWriter("cuffdiff.sh"));
					
              ok.setEnabled(false);
				brw.write(commandline);
                brw.close();
                System.out.println("sh file created");
            String afterreg = output.getText().toString();
            afterreg = afterreg.replaceAll("/home", "\\\\\\\\beasty.erasmusmc.nl");
    		afterreg = afterreg.replaceAll("/", "\\\\");
               Mediator.setMessage("The gene level analysis work started at "+new Date().toString()+" has finished."+"\n"+"  Your result is located in "
	            		   +afterreg);
               Mediator.setEmail(emailadd.getText().toString());
              
               
					

               SwingUtilities.invokeLater(new Runnable(){
   	        	  @Override
				public void run(){
   	        		  System.out.println("inside swingutilities");
   	          outputwindow output = new outputwindow();
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
        
     
        frame1.add(ok, c9);	
        
        
        
        JButton clear = new JButton("Clear");
        GridBagConstraints c10 = new GridBagConstraints();
        c10.gridx = 15;
        c10.gridy = 30;
        c10.gridwidth = 1;
        c10.gridheight = 1;
        c10.weightx = 0;
        c10.weighty = 0;
        c10.fill = GridBagConstraints.NONE;
        c10.anchor = GridBagConstraints.SOUTH;
        frame1.add(clear, c10);
        clear.addActionListener(new ActionListener(){
        	@Override
			public void actionPerformed(ActionEvent e){
        		output.setText("");
        		output.getText( );
        		gtft.setText("");
        		gtft.getText( );
        		t3.setText("");
        		t3.getText( );
        		t4.setText("");
        		t4.getText( );
        		sample1location = "";
        		
        		
        		sample2location = "";
        		errorout.setText("");
        		errorout.getText();
        		
        	}
        });
        
        
        
        
        
       frame1.setVisible(true);       
        
       
    }


    public static class outputwindow extends JFrame {
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		 public void interfaceiniti() {
			
//			 Informable informable = new Informable(){
//				
//				 @Override
//				public void messageChanged( String message){
//					System.out.println("this is inferfaceiniti");
//					 }
//			 };
			 

			 
	final String output = "Run log";
	System.out.println("outputworker is running");
	OutputWorker worker = new OutputWorker (output,"sh cuffdiff.sh");
	
	worker.execute();
		 
		 }
		
		  




	

}

/*public static void main(String args[])throws IOException, InterruptedException  {
    	
		GUI gui = new GUI();		
		gui.startrun();
		
		
		
	}*/
}

