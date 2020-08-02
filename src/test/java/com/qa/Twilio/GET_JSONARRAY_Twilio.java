package com.qa.Twilio;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.API.Base.BaseClass;
import com.qa.API.client.RestClient_Twilio;

public class GET_JSONARRAY_Twilio extends BaseClass {
	BaseClass BC;
	RestClient_Twilio RCT;
	CloseableHttpResponse response;
	String URI;

	@BeforeMethod
	public void setup() {
		BC = new BaseClass();
		String serviceurl_Twilio = prop.getProperty("serviceurl_Twilio");
		String apiurl_Twilio = prop.getProperty("apiurl_Twilio");
		URI = serviceurl_Twilio + apiurl_Twilio;

	}

	@Test
	public void GET() throws org.apache.http.ParseException, IOException, JSONException {

		RCT = new RestClient_Twilio();
		response = RCT.GET(URI);

		// JSON Response
		String ResponseString = EntityUtils.toString(response.getEntity(), "UTF-8");

		JSONObject jsonresponse = new JSONObject(ResponseString);
		// JSONARRAY follows the same Order shown in Response.
		System.out.println(jsonresponse);
		JSONArray messages = jsonresponse.getJSONArray("messages");
		// Getting to second message in the Array
		JSONObject o = messages.getJSONObject(1);
		String S = (String) o.getJSONObject("subresource_uris").get("feedback");
		System.out.println(S);
	}
}
