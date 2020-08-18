package com.qa.API.DataDriven;

import java.io.IOException;

import com.qa.API.ExtentReport.Testlisten;



public class ObjectArray_Input extends Testlisten
   {
	
	static String path = "C:\\Users\\101139\\eclipse\\eclipse-workspace\\API_Automation"
			+ "\\src\\main\\java\\com\\qa\\BestBuy\\Data\\Test Data.xlsx";
	static String Sheet_name=null;
    public static Object[][] name;
    
    public static Object[][] Fetch_Data() throws IOException {
		 
        Sheet_name = "Sheet"+Sheetnum;
	    name = ExcelOperations.Read(path,Sheet_name);
	    Sheetnum++;
		return name;

	}

	}
