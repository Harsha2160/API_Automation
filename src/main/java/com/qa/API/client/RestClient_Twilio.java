package com.qa.API.client;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class RestClient_Twilio {

	public CloseableHttpResponse GET(String URI) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet(URI);
		
		//hitting the API
		
		CloseableHttpResponse response=httpclient.execute(httpget);
		return response;
		
		
	}
	
	public CloseableHttpResponse GET(String URI, HashMap<String,String>hashmap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet(URI);
		
		//Adding Authentication Header
		for (Map.Entry<String, String> entry:hashmap.entrySet()) {
			
			httpget.addHeader(entry.getKey(), entry.getValue());
		
		}
		//hitting the API
		
		CloseableHttpResponse response=httpclient.execute(httpget);
		return response;
		
		
	}
}
