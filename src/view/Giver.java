package view;

public class Giver {
	String emailAddress;
	public String name;
	public Integer id;
	
	public Giver(String emailAddress, String name, Integer id) {
		this.emailAddress = emailAddress;
		this.name = name;
		this.id = id;
	}
	
	public String toString() {
		return  name + "," + emailAddress;
	}

}
