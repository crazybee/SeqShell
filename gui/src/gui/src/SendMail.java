package gui.src;

import javax.mail.*; 
import javax.mail.internet.*; 
import java.util.*;



public class SendMail{    
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";  
//	private static final String SMTP_AUTH_USER = "rnaseqlab1030@gmail.com"; 
//	private static final String SMTP_AUTH_PWD  = "rnaseq1030"; 
 
	public void postMail( String recipient, String message) {
		try { 
			if (recipient =="" || recipient.matches("\\w+([-+.]\\w+)*@\\w+([-+.]\\w+)*\\.\\w+([-+.]\\w+)*")== false){
				System.out.println("Your email address is not correct.");
				
			
				
			}
		boolean debug = false; 
		Properties props = new Properties();  
		props.put("mail.smtp.host", SMTP_HOST_NAME); 
		props.put("mail.smtp.starttls.enable", "true");    
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "587");
		Authenticator auth = new SMTPAuthenticator();    
		Session session = Session.getDefaultInstance(props, auth);    
		session.setDebug(debug); 
		Message msg = new MimeMessage(session);  
		InternetAddress addressFrom = new InternetAddress("rnaseqlab1030@gmail.com");  
		msg.setFrom(addressFrom);   
		
		InternetAddress addressTo = new InternetAddress(recipient);
		
		
		
//		for (int i = 0; i < recipients.length; i++) 
//		{             
//			addressTo[i] = new InternetAddress(recipients[i]);    
//			}      
		msg.setRecipient(Message.RecipientType.TO, addressTo); 
		msg.setText("UTF-8"); 
		msg.setSubject("Your RNA-SEQ result");  
		msg.setSentDate(new Date());
		
		msg.setContent(message, "text/html");  
		Transport.send(msg);   
		}     
		catch (Throwable e)    
		{         e.printStackTrace();     }
		
	
	} 
	

	private class SMTPAuthenticator extends javax.mail.Authenticator {   
		@Override
		public PasswordAuthentication getPasswordAuthentication()     {  
			String username = "rnaseqlab1030@gmail.com";    
			String password = "rnaseq1030";   
			return new PasswordAuthentication(username, password);     }
		} 

} 