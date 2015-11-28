package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import service.GiverReader;
import service.RecipientReader;
import model.ListManager;

public class ExchangeFactory {

	static ArrayList<Giver> givers;
	static ArrayList<Recipient> recipients;
	static ArrayList<Combo> combos;

	ListManager listManager;

	public ExchangeFactory() {
		GiverReader giverReader = new GiverReader();
		RecipientReader recipientReader = new RecipientReader();

		givers = giverReader.getGivers();
		recipients = recipientReader.getRecipients();

		listManager = new ListManager(givers, recipients);

	}


	public List<Combo> run() {
		
		combos = listManager.generateAllMatches();

		while(combos == null) {
			combos = listManager.generateAllMatches();
		}

		File file = new File("output.txt");
		
		BufferedWriter bw;
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);

			for(Combo combo : combos) {

				bw.write(combo.toString());
				bw.write("\n");


				
			}
			bw.close();
		} catch(Exception e) {
			System.out.println("File writing unsuccessful");
		} finally {
			
		}
		
		return combos;


	}

}
