package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import view.Email;

public class FileReader {

	File file;

	public FileReader(String filePath) {
		file = new File(filePath);

	}

	public Email readFile1(String name, String email) throws IOException {
		FileInputStream fis = new FileInputStream(file);

		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String line = null;
		List<String> lines = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			lines.add(line);


		}

		br.close();
		return processLines(lines, name, email);
	}


	public Email processLines(List<String> lines, String soughtOutName, String soughtOutEmail) {
		for(String line: lines) {
			String[] strArr = line.split(":");
			String recipientName = strArr[1];
			String giver = strArr[0];
			String giverName = giver.split(",")[0];
			String giverEmail = giver.split(",")[1];
			Email email = new Email(giverEmail, giverName, recipientName);
			if(email.toName.equals(soughtOutName)) {
				if(email.toAddress.equals(soughtOutEmail)) {
					return email;
				}

			}

		}

		return null;
	}




}
