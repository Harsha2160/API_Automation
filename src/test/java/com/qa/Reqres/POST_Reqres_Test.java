package com.qa.Reqres;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.API.Base.BaseClass;
import com.qa.API.client.RestClient_Reqres;
import com.qa.Reqres.Data.User_Reqres;

public class POST_Reqres_Test extends BaseClass  {
	
	BaseClass bc;
	String serviceurl_reqres;
	String apiurl_post_reqres;
	String url;
	RestClient_Reqres RC;
	CloseableHttpResponse response;
	HashMap<String,String>hashmap;
	@BeforeMethod
	public void setup()
	{
		bc=new BaseClass();
		serviceurl_reqres=prop.getProperty("serviceurl_reqres");
		apiurl_post_reqres=prop.getProperty("apiurl_post_reqres");
		url=serviceurl_reqres+apiurl_post_reqres;
		
	}
	@Test
	public void POST() throws JsonGenerationException, JsonMappingException, IOException, JSONException
	{
		RC=new RestClient_Reqres();
		hashmap=new HashMap<String,String>();
		hashmap.put("Content-Type", "application/json");
		
		
		//JackSon API
		
		ObjectMapper OM=new ObjectMapper();
		User_Reqres UR=new User_Reqres("morpheus","leader");
		OM.writeValue(new File("C:\\Users\\101139\\eclipse\\eclipse-workspace"
				+ "\\API_Automation\\src\\main\\java\\com\\qa\\Reqres\\Data\\users.json"), UR);
		String JsonString=OM.writeValueAsString(UR);
	
		System.out.println(JsonString);
		response=RC.POST(url, JsonString, hashmap);
		
		
		int statuscode=response.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		
		String Jsonstring=EntityUtils.toString(response.getEntity(),"UTF-8");
		JSONObject JO=new JSONObject(Jsonstring);
		System.out.println(JO);
		

	}

}
