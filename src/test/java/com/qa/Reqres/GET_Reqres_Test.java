
	package com.qa.Reqres;

	import java.io.IOException;
	import java.util.HashMap;
	import org.apache.http.Header;
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
import com.qa.API.client.RestClient_Reqres;

	public class GET_Reqres_Test extends BaseClass{
		BaseClass bc;
		String serviceurl_reqres;
		String apiurl_get_reqres;
		String url;
		RestClient_Reqres RC;
		CloseableHttpResponse response;
		
		@BeforeClass(groups="Reqres")
		public void setup()
		{
			
			serviceurl_reqres=prop.getProperty("serviceurl_reqres");
			apiurl_get_reqres=prop.getProperty("apiurl_get_reqres");
			url=serviceurl_reqres+apiurl_get_reqres;
			
		}
		@Test(groups="Reqres")
		public void StatusCode_GET_Reqres() throws ClientProtocolException, IOException, JSONException
		{
			RC=new RestClient_Reqres();
			response=RC.Get(url);
			int statuscode=response.getStatusLine().getStatusCode();
			Assert.assertEquals(statuscode, StatusCode_GET);
			
		}
		
		
		@DataProvider
		public Object[][] Reqres_GET_DATA() throws IOException {
			return ObjectArray_Input.Reqres_GET_DATA();                    //Returning Method inside a Method
		}
		
		
		
		@Test(dataProvider="Reqres_GET_DATA",dependsOnMethods="StatusCode_GET_Reqres", groups="Reqres")
		public void JSON_GET_Reqres(String ExpectedResult) throws JSONException, ParseException, IOException
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
			 String ActualResult=allHeaders.get("Server");
			 Assert.assertEquals(ActualResult,ExpectedResult);
		 
			 
				
		}	
			 
		}


	