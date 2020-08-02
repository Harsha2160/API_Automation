package com.qa.API.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;





public class RestClient_Reqres {
	
	public CloseableHttpResponse Get(String URI) throws ClientProtocolException, IOException, JSONException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpGet httpget=new HttpGet(URI);
		//hitting the API
		CloseableHttpResponse response=httpclient.execute(httpget);
		return response;
		
		
		
	}
	
	public CloseableHttpResponse POST(String URI, String entityString, HashMap<String,String>hashmap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//URI
		HttpPost httppost=new HttpPost(URI);
		
		//Pay load
		httppost.setEntity(new StringEntity(entityString));
		
		//Headers
		for (Map.Entry<String, String>entity:hashmap.entrySet()) {
			httppost.addHeader(entity.getKey(), entity.getValue());
			
		}
		
		CloseableHttpResponse response=httpclient.execute(httppost);
		return response;
	}
    }

