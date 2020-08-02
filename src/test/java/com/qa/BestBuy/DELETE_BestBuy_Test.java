package com.qa.BestBuy;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.qa.API.Base.BaseClass;
import com.qa.API.client.RestClient_BestBuy;
import com.qa.BestBuy.Data.Services_BestBuy;


public class DELETE_BestBuy_Test extends BaseClass {
	BaseClass bc;
	String serviceurl_BestBuy;
	String apiurl_get_StoreID_BestBuy;
	String apiurl_get_Stores_BestBuy;
	String url;
	RestClient_BestBuy RC;
	Services_BestBuy S_BB;
	CloseableHttpResponse response;
	HashMap<String,String>hashmap;
	
	@BeforeClass(groups="BestBuy")
	public void setup()
	{
		
		serviceurl_BestBuy=prop.getProperty("serviceurl_BestBuy");
		apiurl_get_Stores_BestBuy=prop.getProperty("apiurl_get_Stores_BestBuy");
		url=serviceurl_BestBuy+apiurl_get_Stores_BestBuy+Store_ID;
		
	}
	
	
	@Test(groups="BestBuy")
	public void StatusCode_DELETE_BestBuy() throws JsonGenerationException, JsonMappingException, IOException, JSONException
	{
		RC=new RestClient_BestBuy();
		hashmap=new HashMap<String,String>();
		hashmap.put("Content-Type", "application/json");
		hashmap.put("Accept", "application/json");
		
		response=RC.DELETE(url, hashmap);
		
		
		int statuscode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, StatusCode_DELETE);
		
		
     }
	
	
	
	@Test(dependsOnMethods="StatusCode_DELETE_BestBuy", groups="BestBuy")
	public void JSON_DELETE_BestBuy() throws ParseException, IOException, JSONException
	{
		String Jsonstring=EntityUtils.toString(response.getEntity(),"UTF-8");
		JSONObject JO=new JSONObject(Jsonstring);
		String ActualResult=(String) JO.get("zip");
		String ExpectedResult= Zipcode;
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}

}
