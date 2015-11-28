import java.util.ArrayList;
import java.util.List;

import view.Combo;
import view.Email;
import view.ExchangeFactory;


public class ExchangeRunner {
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		System.out.println("Starting...");
		ExchangeFactory factory = new ExchangeFactory();
		List<Combo> combos = factory.run();
		
		List<Email> emails = new ArrayList<Email>();
		for(Combo combo: combos) {
			emails.add(new Email(combo));
		}
		
		for(Email email : emails) {
			System.out.println("Sending Email to " + email.toAddress);
			email.sendEmail();
		}
		System.out.println("Finished");
	}
	
	

}
