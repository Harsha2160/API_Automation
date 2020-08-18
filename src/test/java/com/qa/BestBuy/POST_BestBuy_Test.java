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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.API.Base.BaseClass;
import com.qa.API.DataDriven.ObjectArray_Input;
import com.qa.API.client.RestClient_BestBuy;
import com.qa.BestBuy.Data.Services_BestBuy;
import com.qa.BestBuy.Data.Store_BestBuy;

public class POST_BestBuy_Test extends BaseClass {
	BaseClass bc;
	String serviceurl_BestBuy;
	String apiurl_get_Stores_BestBuy;
	String url;
	Services_BestBuy S_BB;
	RestClient_BestBuy RC;
	Store_BestBuy SB;
	CloseableHttpResponse response;
	HashMap<String,String>hashmap;
	
	
	
	@BeforeClass(groups="BestBuy")
	public void setup()
	{
		
		serviceurl_BestBuy=prop.getProperty("serviceurl_BestBuy");
		apiurl_get_Stores_BestBuy=prop.getProperty("apiurl_get_Stores_BestBuy");
		url=serviceurl_BestBuy+apiurl_get_Stores_BestBuy;
		
	}
	
	
	
	@DataProvider
	public Object[][] POST_Data() throws IOException {
		return ObjectArray_Input.Fetch_Data();                    //Returning Method inside a Method
	}
	
	
	@Test(dataProvider="POST_Data",groups="BestBuy")
	public void StatusCode_POST_BestBuy(String HomeDelivery,String Store_Name,String Store_Type,String Address,String Address2,
	String City,String State,String Zip,long lat,long lng,
	String hours,String ServicesClassObject) throws JsonGenerationException, JsonMappingException, IOException, JSONException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		RC=new RestClient_BestBuy();
		Zipcode=Zip;
		//Input Headers
		hashmap=new HashMap<String,String>();
		hashmap.put("Content-Type", "application/json");
		hashmap.put("Accept", "application/json");
		
		
		//Converting String to Class Object
		
		Class <?>C=Class.forName(ServicesClassObject);
		S_BB=(Services_BestBuy) C.newInstance();
		S_BB=new Services_BestBuy(HomeDelivery);
		SB=new Store_BestBuy(Store_Name,Store_Type, 
				Address, Address2, City, State, Zipcode, lat, lng, hours,S_BB);
		
		//JackSon API
		
		ObjectMapper OM=new ObjectMapper();
		String JsonString=OM.writeValueAsString(SB);
		System.out.println(JsonString);
		response=RC.POST(url, JsonString, hashmap);
		
		
		int statuscode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, StatusCode_POST);
		
		
	}
	
	
	@Test(dependsOnMethods="StatusCode_POST_BestBuy", groups="BestBuy")
	public void JSON_POST_BestBuy() throws ParseException, IOException, JSONException
	{
		String Jsonstring=EntityUtils.toString(response.getEntity(),"UTF-8");
		JSONObject JO=new JSONObject(Jsonstring);
		Store_ID=(Integer) JO.get("id");
		System.out.println(Store_ID);
		String ActualResult=(String) JO.get("zip");
		String ExpectedResult=Zipcode;
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}

}
