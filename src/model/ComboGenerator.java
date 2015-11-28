package model;

import java.util.ArrayList;
import java.util.Random;

import view.Combo;
import view.Giver;
import view.Recipient;

public class ComboGenerator {
	
	Giver giver;
	ArrayList<Recipient> remainingRecipients;
	Validator validator;
	
	public ComboGenerator(Giver giver, ArrayList<Recipient> recipients) {
		this.giver = giver;
		remainingRecipients = recipients;
		validator = new Validator();
		
	}
	
	public Combo getCombo() {
		
		Recipient recipient = remainingRecipients.get(generateRandomIndex());
		Combo combo = new Combo(giver, recipient);
		if(!validator.validateCombo(combo)) {
			return getCombo();
		}
		return combo;
		
	}
	
	public Integer generateRandomIndex() {
		Random random = new Random();
		Integer next = random.nextInt(remainingRecipients.size());
		return next;
		
	}

	
	

}
