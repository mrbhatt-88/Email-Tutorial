
package OAuth2_0;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OAuth2_0Mail {

	// Without turn on the lessSecure app send mail

	public static void main(String[] args) throws Exception {

		String to = "to mail";
		String from = "from mail";
		String accessToken = "access_token";

		System.out.println(oAuth2_0SendMail(to, from, accessToken));
	}

	public static String oAuth2_0SendMail(String to, String from, String accessToken) throws Exception {

		// outgoing message information
		Properties props = new Properties();
		props.put("mail.smtp.ssl.enable", "true"); // required for Gmail
		props.put("mail.smtp.sasl.enable", "true");
		props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
		props.put("mail.smtp.auth.login.disable", "true");
		props.put("mail.smtp.auth.plain.disable", "true");

		Session session = Session.getInstance(props, null);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));

		message.setSubject("Hi Techie");
		message.setText("You are Developer.");

		// Send Email
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", from, accessToken);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

		return "Mail Sent";
	}
}
