package view;

public class Combo {
	
	
	public Recipient recipient;
	public Giver giver;
	
	public Combo(Giver giver, Recipient recipient) {
		this.giver = giver;
		this.recipient = recipient;
	}
	
	public String toString() {
		return giver.toString() + ":" + recipient.toString();
	}
	

}
