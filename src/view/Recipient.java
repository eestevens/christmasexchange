package view;

public class Recipient {
	
	String name;
	public Integer id;
	
	public Recipient(String name, Integer id) {
		this.name = name;
		this.id = id;
	}
	
	public String toString() {
		return name;
	}

}
