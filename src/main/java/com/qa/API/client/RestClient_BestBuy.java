package com.qa.API.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient_BestBuy {
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

	
	
	public CloseableHttpResponse PUT(String URI, String entityString, HashMap<String,String>hashmap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//URI
		HttpPut httpput=new HttpPut(URI);
		
		//Pay load
		httpput.setEntity(new StringEntity(entityString));
		
		//Headers
		for (Map.Entry<String, String>entity:hashmap.entrySet()) {
			httpput.addHeader(entity.getKey(), entity.getValue());
			
		}
		
		CloseableHttpResponse response=httpclient.execute(httpput);
		return response;
	}
	
	
	
	public CloseableHttpResponse DELETE(String URI, HashMap<String,String>hashmap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//URI
		HttpDelete httpdelete=new HttpDelete(URI);
		
		
		//Headers
		for (Map.Entry<String, String>entity:hashmap.entrySet()) {
			httpdelete.addHeader(entity.getKey(), entity.getValue());
			
		}
		CloseableHttpResponse response=httpclient.execute(httpdelete);
		return response;
}
}
