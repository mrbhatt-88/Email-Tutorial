import java.io.File;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

public class FetchMailAttachment {

	public static void main(String[] args) {

		try {
			String email = "your email";
			String password = "your Account Password";
			fetchAttechment(email, password);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Unread email Attachment Fetch 
	public static void fetchAttechment(String email, String password) throws Exception {

		// Here use pop3 because Download the Fetch Attachment

		Properties properties = System.getProperties();
		properties.put("mail.pop3.host", "pop.gmail.com");
		properties.put("mail.pop3.port", "995");
		properties.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.pop3.socketFactory.fallback", "false");
		properties.setProperty("mail.pop3.socketFactory.port", String.valueOf("995"));

		Session session = Session.getDefaultInstance(properties);
		Store store = session.getStore("pop3");

		// Connect through AMTP and for Fetching Document Through POP3
		store.connect("smtp.gmail.com", email, password);

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		Message[] messages = folder.getMessages();
		for (int i = 0; i < messages.length; i++) {
			Message message = messages[i];
			String typeOfContent = message.getContentType();

			// Attachment Content type is Multipart.
			if (typeOfContent.contains("multipart")) {
				Multipart multiPart = (Multipart) message.getContent();

				for (int j = 0; j < multiPart.getCount(); j++) {
					MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(j);
					if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {

						String fileName = part.getFileName();

						// Save in Computer Folder.
						part.saveFile("G:" + File.separator + fileName);
					}
				}
			}
		}
		folder.close(true);
		System.out.println("Success");
	}
}
