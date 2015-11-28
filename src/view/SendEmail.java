package view;

import java.io.UnsupportedEncodingException;
import javax.mail.*;
import javax.mail.internet.*;

import service.EmailServer;

public class SendEmail
{
	private static EmailServer server;

	public static void sendEmail(String toEmailAddress, String toName,
			String subject, String msgBody, boolean testMode)  {

		server = new EmailServer();


		try {
			Message msg = new MimeMessage(server.getSession());
			msg.setFrom(new InternetAddress(server.username, server.name));
			if(testMode) {
				msg.addRecipient(Message.RecipientType.TO,
						new InternetAddress("eedwardstevens@gmail.com", toName));
			} else {
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(toEmailAddress, toName));
			}
			msg.setSubject(subject);
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (AddressException e) {
			
			System.out.println("Couldn't send email to : " + toEmailAddress + "...address exception");
		} catch (MessagingException e) {
			System.out.println("Couldn't send email to : " + toEmailAddress + "...messaging exception");
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("Couldn't send email to : " + toEmailAddress + "...encoding exception");
		}
	}
}