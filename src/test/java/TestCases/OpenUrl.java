package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import commonMethods.CommMeths;
import commonMethods.Logs;


public class OpenUrl {
	
	WebDriver driver;
	CommMeths commeths;
	String info="INFO";
	String pass="PASS";
	String fail="FAIL";
	SoftAssert assertion = new SoftAssert();
	
	public OpenUrl(WebDriver driver)
	{
		this.driver=driver;
		commeths = new CommMeths();
		openUrlMethod();
	}
	
	public void openUrlMethod()
	{
		String url = commeths.getInput("url");
		Logs.startLog("Opening the "+url+" page");
		Logs.addToReport("Trying to open the "+url+" page", info);
		driver.get(url);
		Logs.addToReport("Page opening", info);
		
		String expected_title = commeths.getInput("Web_Page_title");
		
		commeths.titleExplicitWait(driver, expected_title, 20);
		
		String title = driver.getTitle();		

		assertion.assertTrue(title.contains(expected_title), "Web page opened");
		if(title.contains(expected_title))
			Logs.addToReport("Web page opened, Title has "+expected_title+ "value", pass);
		else
			Logs.addToReport("Some problem in Web page opening, Title does not have "+expected_title+ "value", fail);
		Logs.stopLog();
	}
}
