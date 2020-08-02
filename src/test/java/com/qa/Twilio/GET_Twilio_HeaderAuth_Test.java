package com.qa.Twilio;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.API.Base.BaseClass;
import com.qa.API.DataDriven.ObjectArray_Input;
import com.qa.API.Utilities.Encode_Auth_Twilio;
import com.qa.API.client.RestClient_Twilio;

public class GET_Twilio_HeaderAuth_Test extends BaseClass {
	BaseClass BC;
	
	RestClient_Twilio RCT;
	CloseableHttpResponse response;
	String URI;
	HashMap<String,String>hashmap;
	
	
	@BeforeClass(groups="Twilio")
	public void setup()
	{
	BC=new BaseClass();
	String serviceurl_Twilio_WithoutAuth=prop.getProperty("serviceurl_Twilio_WithoutAuth");
	String apiurl_Twilio =prop.getProperty("apiurl_Twilio");
	URI=serviceurl_Twilio_WithoutAuth+apiurl_Twilio;
	}
	
	
	@Test(groups="Twilio")
	public void StatusCode_GET_Twilio() throws ClientProtocolException, IOException
	{
		
		String Auth_String=Encode_Auth_Twilio.Auth_Encode();
		hashmap=new HashMap<String,String>();
		hashmap.put("Authorization", Auth_String);
		RCT=new RestClient_Twilio();
		response=RCT.GET(URI, hashmap);
		//Status Code
		int StatusCode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(StatusCode, StatusCode_GET);
		
	}
	@DataProvider
	public Object[][] Twilio_GET_Data() throws IOException {
		return ObjectArray_Input.Twilio_GET_DATA();                    //Returning Method inside a Method
	}
	
	@Test(dataProvider="Twilio_GET_Data",dependsOnMethods="StatusCode_GET_Twilio", groups="Twilio")
	public void JSON_GET_Twilio(String ExpectedString) throws ParseException, IOException, JSONException
	{
		// JSON Response

		String ResponseString = EntityUtils.toString(response.getEntity(), "UTF-8");

		JSONObject jsonresponse = new JSONObject(ResponseString);
		String ActualString=(String) jsonresponse.get("first_page_uri");
		Assert.assertEquals(ActualString, ExpectedString);
	}
	

}
