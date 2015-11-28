package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import view.Combo;
import view.Giver;
import view.Recipient;

public class ListManager {

	ArrayList<Giver> remainingGivers;
	ArrayList<Recipient> remainingRecipients;
	ArrayList<Combo> currentMatches;
	ArrayList<Giver> startingGivers;
	ArrayList<Recipient> startingRecipients;
	Validator validator;

	public ListManager(ArrayList<Giver> remainingGivers, ArrayList<Recipient> remainingRecipients) {
		this.remainingGivers = new ArrayList<Giver>(remainingGivers);
		this.remainingRecipients = new ArrayList<Recipient>(remainingRecipients);
		currentMatches = new ArrayList<Combo>();
		this.startingGivers = new ArrayList<Giver>(remainingGivers);
		this.startingRecipients = new ArrayList<Recipient>(remainingRecipients);

	}

	public void initialize() {
		currentMatches = new ArrayList<Combo>(0);
		remainingGivers = new ArrayList<Giver>(startingGivers);
		remainingRecipients = new ArrayList<Recipient>(startingRecipients);
		validator = new Validator();


	}

	public ArrayList<Combo> generateAllMatches() {
		initialize();
		generateFakeMatch();
		while(remainingGivers.size() > 0) {
			Giver nextGiver = nextGiver();
			if(validator.possibleMatch(nextGiver, remainingRecipients)) {

				generateMatch(nextGiver);
			}
			else {
				return generateAllMatches();
			}
		}

		return getCombos();
	}

	private void generateMatch(Giver nextGiver) {
		ComboGenerator comGen = new ComboGenerator(nextGiver, remainingRecipients);
		Combo combo = comGen.getCombo();
		currentMatches.add(combo);
		remainingGivers = removeGiver(combo);
		remainingRecipients = removeRecipient(combo);

	}

	private void generateFakeMatch() {
		Giver karen = new Giver("bacpacmac@earthlink.net", "Karen", 31);
		Recipient mike = new Recipient("Mike", 15);
		Combo combo = new Combo(karen, mike);
		currentMatches.add(combo);
		remainingGivers = removeGiver(combo);
		remainingRecipients = removeRecipient(combo);


	}

	public Giver nextGiver() {
		if(remainingGivers.size() > 1) {
			Random random = new Random();
			int nextGiver = random.nextInt(remainingGivers.size());
			return remainingGivers.get(nextGiver);
		}
		return remainingGivers.get(0);
	}

	private ArrayList<Giver> removeGiver(Combo combo) {
		Iterator<Giver> it = remainingGivers.iterator();
		while(it.hasNext()) {
			if(it.next().id == combo.giver.id) {
				it.remove();
			}
		}
		return remainingGivers;

	}

	public ArrayList<Combo> getCombos() {
		return currentMatches;
	}

	private ArrayList<Recipient> removeRecipient(Combo combo) {
		Iterator<Recipient> it = remainingRecipients.iterator();
		while(it.hasNext()) {
			if(it.next().id == combo.recipient.id) {
				it.remove();
			}
		}
		return remainingRecipients;
	}


}
