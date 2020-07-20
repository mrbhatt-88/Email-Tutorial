import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ExistenceOfMail {

	public static void main(String[] args) throws Exception {

		String apiKey = "Your mailboxlayer API key Generate From Link that Show in README.md";
		String email = "Any Mail Address";

		Map<String, Object> emailCheck = checkExistence(apiKey, email);
		System.out.println(
				emailCheck.get("mx_found").equals(true) && emailCheck.get("smtp_check").equals(true) ? "Email is Exist"
						: "Email is not Exist");

	}

	public static Map<String, Object> checkExistence(String apiKey, String email) throws Exception {

		String url = "http://apilayer.net/api/check?access_key=" + apiKey + "&email=" + email + "&smtp=1&format=1";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);

		HttpResponse httpResponse = client.execute(get);
		HttpEntity entity = httpResponse.getEntity();
		String string = EntityUtils.toString(entity);

		JSONObject object = (JSONObject) JSONValue.parse(string);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("format_valid", object.get("format_valid")); // format of mail (Boolean)
		map.put("domain", object.get("domain")); // domain of mail (String)
		map.put("mx_found", object.get("mx_found")); // Mx record of Google (Boolean)
		map.put("smtp_check", object.get("smtp_check")); // smtp_check for Mail Existence (Boolean)
		map.put("user", object.get("user")); // User (String)
		map.put("email", object.get("email")); // Email (String)
		return map;
	}
}
