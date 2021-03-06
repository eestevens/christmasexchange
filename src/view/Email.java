package view;

public class Email {

	public String toAddress;
	public String toName;
	public final String fromName = "Erik";
	public String fromAddress = "eedwardstevens@gmail.com";
	public final String subject = "Christmas Exchange";
	String body;

	public Email(String toAddress, String toName, String giftName) {
		this.toAddress = toAddress;
		this.toName = toName;
		
		this.body = "Dear " + toName + ", \nThis year your name is " 
				+ giftName+ ".  We'll see you soon!\n-Erik";
	}

	public Email(Combo combo) {
		this(combo.giver.emailAddress, combo.giver.name, combo.recipient.name);
	}

	public void sendEmail(boolean testMode) {
		SendEmail.sendEmail(toAddress, toName, subject, body, testMode);
	}

}
