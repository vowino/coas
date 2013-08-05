package cs.mum.mb;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class Helper {
	private static final String from = "prado.prado75@gmail.com";
	private static final String ALPHA_NUMERIC_STRING = "ABrCqDwgEFGfHdIuxJKyekzvLhcMNsjOPtQRSTUiVpWlXYoZ012m34567nb8a9";

	public String getFrom() {
		return from;
	}

	public static String md5(String input) {
		String md5 = null;
		if (null == input) {
			return null;
		}

		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	public static String randomAlphaNumeric(int count) {
			StringBuilder builder = new StringBuilder();
			while (count-- != 0) {
				int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			return builder.toString();
	}

	public void sendMail(String vto, String vmsg, String vsubj) {
		// String result;
		// Recipient's email ID needs to be mentioned.
		// String to = "vctrowino@yahoo.com";

		// Sender's email ID needs to be mentioned
		// from = "prado.prado75@gmail.com";

		// Assuming you are sending email from localhost
		// String host = "localhost";
		String host = "smtp.gmail.com";

		// Get system properties object
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");

		// Get the default Session object.
		Session mailSession = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(mailSession);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					vto));
			// Set Subject: header field
			message.setSubject(vsubj);
			// Now set the actual message
			message.setText(vmsg);

			// Send message
			// Transport.send(message);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(null, from, "_password");
			transport.sendMessage(message, message.getAllRecipients());
			// result = "Sent message successfully....v";
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// result = "Error: unable to send message....";
		}
	}
}