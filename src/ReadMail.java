import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class ReadMail {

	static Folder inbox;

	public static void main(String[] args) throws Exception {

		System.out.println(unReadEmailData());

	}

	public static Object unReadEmailData() throws Exception {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");

		store.connect("imap.gmail.com", "darshanbhatt19990@gmail.com", "Darshan@#@123");
		inbox = store.getFolder("INBOX");

		inbox.open(Folder.READ_ONLY);
		Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
		FetchProfile fp = new FetchProfile();
		fp.add(FetchProfile.Item.ENVELOPE);
		fp.add(FetchProfile.Item.FLAGS);

		inbox.fetch(messages, fp);
		for (int i = 0; i < messages.length; i++) {

			Map<String, Object> map = new HashMap<>();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

			Address[] a;
			// FROM
			if ((a = messages[i].getFrom()) != null) {
				for (int j = 0; j < a.length; j++) {
					map.put("from", "\"" + a[j] + "\"");
				}
			}
			// TO
			if ((a = messages[i].getRecipients(Message.RecipientType.TO)) != null) {
				for (int j = 0; j < a.length; j++) {
					map.put("to", "\"" + a[j] + "\"");
				}
			}
			map.put("receiveDate", format.format(messages[i].getReceivedDate()));
			map.put("subject", messages[i].getSubject());
			map.put("sentDate", format.format(messages[i].getSentDate()));
			map.put("messageNumber", messages[i].getMessageNumber());
			map.put("readStatus", true);
			list.add(map);

		}

		return list;
	}

}
