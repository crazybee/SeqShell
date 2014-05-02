package gui.src;


public class Mediator {
	static String message;
	static String toMail;
	static String fromMail;
	
	Mediator (){
		
		
	}
	static String getMessage(){
		return message;
		
		
	}
	static String getEmail(){
		return toMail;
	}
	static void setMessage(String m){
		message = m;
		
	}
	static void setEmail(String e){
		toMail = e;
	}

}
