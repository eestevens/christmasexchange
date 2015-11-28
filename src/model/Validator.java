package model;

import java.util.ArrayList;

import view.Combo;
import view.Giver;
import view.Recipient;

public class Validator {
	
	
	public Validator() {
		
	}
	
	public boolean validateCombo(Combo combo) {
		
		return validateCombo(combo.giver, combo.recipient);
		
		
	}
	
	private boolean validateCombo(Giver giver, Recipient recip) {
		Integer giverId = giver.id;
		Integer recipientId = recip.id;
		Integer familyIdGiver = giverId/10;
		Integer familyIdRecipient = recipientId/10;
		if(familyIdGiver == familyIdRecipient) {
			return false;
		}
		return true;
		
	}
	
	public boolean validateAllCombos(ArrayList<Combo> combos) {
		for(Combo combo : combos) {
			if(!validateCombo(combo)) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean possibleMatch(Giver giver, ArrayList<Recipient> potentialRecipients) {
		for(Recipient recip : potentialRecipients) {
			if(this.validateCombo(giver, recip)) {
				return true;
			}
		}
		return false;
		
	}
	

}
