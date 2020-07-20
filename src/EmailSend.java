import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSend {

	public static void main(String[] args) {
		try {
			String from = "your email";
			String to = "other email";
			String password = "your Account Password";

			sendMail(from, to, password);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void sendMail(String from, String to, String password) {
		try {
			// outgoing message information
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");

			Session session = Session.getInstance(properties, null);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));

			message.setSubject("Send Mail Using JavaMail API");
			message.setText("Below file is Amazing");

			// Use Multipart because Attachment Content type is Multipart
			MimeMultipart multipart = new MimeMultipart("");

			// Set bodyPart
			BodyPart bodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">";
			bodyPart.setContent(htmlText, "text/html");

			multipart.addBodyPart(bodyPart);

			bodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("G:/Chrome/Nice.jpg");

			bodyPart.setDataHandler(new DataHandler(fds));
			bodyPart.setHeader("Content-ID", "<image>");

			// add body in multipart because body contain images.
			multipart.addBodyPart(bodyPart);

			// Add MimeMultipart in message
			message.setContent(multipart);

			// Send Email
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", from, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Send Success Fully");
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
