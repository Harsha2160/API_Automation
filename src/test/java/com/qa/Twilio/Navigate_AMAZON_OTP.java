package com.qa.Twilio;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.API.Base.BaseClass;

public class Navigate_AMAZON_OTP extends BaseClass {

	public Navigate_AMAZON_OTP() throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\101139\\eclipse\\eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");

	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//span[text()='Account & Lists']")).click();
	driver.findElement(By.id("createAccountSubmit")).click();
	driver.findElement(By.id("ap_customer_name")).sendKeys("Test_name");
	driver.findElement(By.id("auth-country-picker-container")).click();
	List<WebElement> list = driver
			.findElements(By.xpath("//div[@class='a-popover-wrapper']//div//ul//descendant::li"));
	for (int i = 0; i < list.size(); i++) {
		String S = list.get(i).getText();
		if (S.equals("United States +1")) {
			list.get(i).click();
			break;
		}

	}
	driver.findElement(By.id("ap_phone_number")).sendKeys("2058904980");
	driver.findElement(By.id("ap_password")).sendKeys("ghqcvxhgcxhc");
	driver.findElement(By.id("continue")).click();
	Thread.sleep(50000);
	
	
	
		
	
	}
}


