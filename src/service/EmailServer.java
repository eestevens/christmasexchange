package service;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailServer {
	
	public final String username = "eedwardstevens@gmail.com";
	public final String password = "2Runners";
	public final String name = "Erik";
	public Properties properties;
	
	public EmailServer() {
		
		properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
 
		
	}
	
	public Session getSession() {
		
		Session session = Session.getInstance(properties,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		return session;
		
	}

}
