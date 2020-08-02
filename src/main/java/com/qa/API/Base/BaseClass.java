package com.qa.API.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public int StatusCode_GET=200;
	public int StatusCode_POST=201;
	public int StatusCode_PUT=200;
	public int StatusCode_DELETE=200;
	public static int Store_ID;
	public static String Zipcode;
	
	public BaseClass() {
		try {
			PropertyConfigurator.configure("C:\\Users\\101139\\eclipse\\eclipse-workspace\\API_Automation"
					+ "\\src\\main\\java\\com\\qa\\config\\log4j.properties");
			prop=new Properties();
			FileInputStream config_file=new FileInputStream("C:\\Users\\101139\\eclipse\\eclipse-workspace\\"
					+ "API_Automation\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(config_file);
			
		    }  
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
