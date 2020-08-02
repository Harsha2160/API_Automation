package com.qa.Reqres;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.API.Base.BaseClass;
import com.qa.API.client.RestClient_Reqres;

public class GET_Reqres_ID extends BaseClass{
	BaseClass bc;
	String serviceurl_reqres;
	String apiurl_get_reqres;
	String url;
	RestClient_Reqres RC;
	CloseableHttpResponse response;
	
	@BeforeClass
	public void setup()
	{
		bc=new BaseClass();
		serviceurl_reqres=prop.getProperty("serviceurl_reqres");
		apiurl_get_reqres=prop.getProperty("apiurl_get_reqres");
		url=serviceurl_reqres+apiurl_get_reqres;
		
	}
	@Test
	public void StatusCode_GET_Reqres() throws ClientProtocolException, IOException, JSONException
	{
		RC=new RestClient_Reqres();
		response=RC.Get(url);
		int statuscode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
	
	@Test(dependsOnMethods="StatusCode_GET_Reqres")
	public void Json_Reqres() throws JSONException, ParseException, IOException
	{
				
		//JSON Response
	    String ResponseString=EntityUtils.toString(response.getEntity(), "UTF-8");
	    JSONObject Jsonresponse=new JSONObject(ResponseString);
	    System.out.println("JsonJsonformat Response"+Jsonresponse);
			   
			    
			   
		 //Header Array
	    //Headers will not follow the same order as in POSTMAN.
		 Header[] headerArray=response.getAllHeaders();
		 HashMap<String,String> allHeaders=new HashMap<String,String>();
		 for(int i=0;i<headerArray.length;i++)
		 {
		 allHeaders.put(headerArray[i].getName(), headerArray[i].getValue());
		 }
		 //Prints the value of a Key in String format.
		 System.out.println(allHeaders.get("Date"));
	 
		 //get all IDs in the Array
		 
		 JSONArray data_Array=Jsonresponse.getJSONArray("data");
		 
		 for (int i = 0; i < data_Array.length(); i++) {
			 int ID=(Integer) data_Array.getJSONObject(i).get("id");
			 System.out.println(ID);
			
	}	
		 
	}

}
