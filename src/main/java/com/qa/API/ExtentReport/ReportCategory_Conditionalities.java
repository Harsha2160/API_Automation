package com.qa.API.ExtentReport;

public class ReportCategory_Conditionalities extends Testlisten {
	
	public ReportCategory_Conditionalities()
	{
	if(packagename.equals("com.qa.Twilio"))
	{
	String category="Twilio";
	logger.assignCategory(category);
	}
	else if(packagename.equals("com.qa.Reqres"))
	{
	String category="Reqres";
	logger.assignCategory(category);
	}
	else if(packagename.equals("com.qa.BestBuy"))
	{
	String category="BestBuy";
	logger.assignCategory(category);
	}

}
}
