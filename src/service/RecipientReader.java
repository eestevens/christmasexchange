package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import view.Recipient;

public class RecipientReader {

	ArrayList<Recipient> recipients;
	File file;

	public RecipientReader() {

		String currentDirectory = System.getProperty("user.dir");
		String filePath = "/src/config/Givers.txt";
		file = new File(currentDirectory + filePath);
		recipients = new ArrayList<Recipient>();

		try {
			this.readFile1(file);
		} catch(Exception e) {
			System.out.println("Could not open file");
		}


	}

	public ArrayList<Recipient> getRecipients() {
		return recipients;

	}

	private static Recipient processLine(String line) {
		String[] parts = line.split(",");
		String id = parts[0];
		String name = parts[1];
		Integer newId = Integer.parseInt(id);

		return new Recipient(name, newId);

	}

	private void readFile1(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);

		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String line = null;
		while ((line = br.readLine()) != null) {
			recipients.add(processLine(line));
		}

		br.close();
	}


}
