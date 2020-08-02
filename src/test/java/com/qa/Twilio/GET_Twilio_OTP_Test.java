package com.qa.Twilio;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.API.Base.BaseClass;
import com.qa.API.client.RestClient_Twilio;

public class GET_Twilio_OTP_Test extends BaseClass {
	BaseClass BC;
	Navigate_AMAZON_OTP NAO;
	String URI;
	RestClient_Twilio RCT;
	CloseableHttpResponse response;
	String OTP;
	Date d1 = null;
	Date d2 = null;

	@BeforeTest
	public void setup() throws InterruptedException {
		BC = new BaseClass();
		String serviceurl_Twilio = prop.getProperty("serviceurl_Twilio");
		String apiurl_Twilio = prop.getProperty("apiurl_Twilio");
		URI = serviceurl_Twilio + apiurl_Twilio;
		NAO = new Navigate_AMAZON_OTP();

	}

//Annotated Methods cannot return values
	@Test
	public void GetOTP()
			throws ClientProtocolException, IOException, JSONException, InterruptedException, ParseException {

		RCT = new RestClient_Twilio();
		response = RCT.GET(URI);

		// Date format
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

		int status_code = response.getStatusLine().getStatusCode();
		System.out.println(status_code);

		// JSON Response

		String ResponseString = EntityUtils.toString(response.getEntity(), "UTF-8");

		JSONObject jsonresponse = new JSONObject(ResponseString);

		// Getting latest message

		JSONArray Messages = jsonresponse.getJSONArray("messages");
		for (int i = 0; i < Messages.length(); i++) {
			String date_string = (String) Messages.getJSONObject(i).get("date_updated");
			System.out.println(date_string);
			if (i == 0) {
				d1 = sdf.parse(date_string);
			} else {
				d2 = sdf.parse(date_string);
				boolean b = d1.before(d2);
				if (b == true) {
					Date temp = d1;
					d1 = d2;
					d2 = temp;

				} else
					continue;
			}

		}
		String S = sdf.format(d1);

		// Getting OTP of latest Message.

		for (int i = 0; i < Messages.length(); i++) {
			String date_string = (String) Messages.getJSONObject(i).get("date_updated");
			if (date_string.equals(S)) {
				String body_String = (String) Messages.getJSONObject(i).get("body");
				OTP = body_String.replaceAll("[^0-9]", " ");
				System.out.println(OTP);

			}
		}
		driver.findElement(By.id("auth-pv-enter-code")).sendKeys(OTP);

	}
}
