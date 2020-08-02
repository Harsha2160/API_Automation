package com.qa.API.DataDriven;

import java.io.IOException;

public class ObjectArray_Input 
   {
	
	static String path = "C:\\Users\\101139\\eclipse\\eclipse-workspace\\API_Automation"
			+ "\\src\\main\\java\\com\\qa\\BestBuy\\Data\\Test Data.xlsx";
	static String Sheet_name=null;
    
    
	public static Object[][] POST_DATA() throws IOException {
		Object[][] name = new Object[100][100];
        Sheet_name = "Sheet1";
	    name = ExcelOperations.Read(path,Sheet_name);
		return name;

	}

	public static Object[][] PUT_DATA() throws IOException {
		Object[][] name = new Object[100][100];
        Sheet_name = "Sheet2";
        name = ExcelOperations.Read(path,Sheet_name);
		return name;

	}
	
	
	public static Object[][] Twilio_GET_DATA() throws IOException {
		Object[][] name = new Object[100][100];
        Sheet_name = "Sheet3";
        name = ExcelOperations.Read(path,Sheet_name);
		return name;

	}
	
	
	public static Object[][] Reqres_GET_DATA() throws IOException {
		Object[][] name = new Object[100][100];
        Sheet_name = "Sheet4";
        name = ExcelOperations.Read(path,Sheet_name);
		return name;

	}
	
    }
