package service;

public class EmailBodyFactory {
	
	public String giver;
	public String recipient;
	public String emailBody;
	
	public EmailBodyFactory(String giver, String recipient) {
		this.giver = giver;
		this.recipient = recipient;
		emailBody = "Dear " + giver + ".  Your name for Christmas 2014 is " + recipient;
		
	}
	
	public String getEmailBody() {
		return emailBody;
		
	}

}
