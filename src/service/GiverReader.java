package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import view.Giver;

public class GiverReader {
	ArrayList<Giver> givers;
	File file;
	
	public GiverReader() {
		
		String currentDirectory = System.getProperty("user.dir");
		String filePath = "/src/config/Givers.txt";
		file = new File(currentDirectory + filePath);
		givers = new ArrayList<Giver>();
		
		try {
		this.readFile1(file);
		} catch(Exception e) {
			System.out.println("Could not open file");
		}
		
		
	}
	
	public ArrayList<Giver> getGivers() {
		return givers;
		
	}
	
	private static Giver processLine(String line) {
		String[] parts = line.split(",");
		String id = parts[0];
		String name = parts[1];
		String emailAddress = parts[2];
		Integer newId = Integer.parseInt(id);
		
		return new Giver(emailAddress, name, newId);
		
	}
	
	private void readFile1(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		while ((line = br.readLine()) != null) {
			givers.add(processLine(line));
		}
	 
		br.close();
	}

}
