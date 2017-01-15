package TestCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import POM.*;
import commonMethods.CommMeths;
import commonMethods.Logs;

public class CommonTestCases {
	
	WebDriver driver;
	CommMeths commeths;
	String info="INFO";
	String pass="PASS";
	String fail="FAIL";
	SoftAssert assertion = new SoftAssert();
	
	DriverInitalization driverini;
	OpenUrl openurl;
	SearchFlights sf;
	ChoosingFlightPage cfp;
	ContinueBookingPage cbp;
	String filepath = "./Reports/Screenshots/";
	
	/*public CommonTestCases(String browser)
	{
		initalizeDriver(browser);
	}*/
	
	public void initalizeDriver(String browser)
	{
		driverini = new DriverInitalization();
		driver = driverini.initalizeDriver(driver, browser);
	}
	
	public void openUrl()
	{
		openurl = new OpenUrl(driver);
	}
	
	public void enterJourneyDetails()
	{
		sf = new SearchFlights(driver);
		sf.searchFlight();
	}
	
	public void validateDetailsInSearchResultsPage()
	{
		cfp = new ChoosingFlightPage(driver);
		cfp.validateEnteredjourneyDetailsInSearchFlightsPage();
	}
	
	public void chooseFlight()
	{
		cfp.continuefirstfligt();
	}
	
	public void verifyFlightsChosenOnSearchPage()
	{
		cbp = new ContinueBookingPage(driver);
		cbp.validateJourneyDetailsOnBookingPage();
	}
	public void choseInsurance()
	{
		cbp.click_insurance();
	}
	public void enterEmailDetails()
	{
		cbp.enterEmail();
	}
	public void enterPassengerDetails()
	{
		cbp.enterPassengerDetails();
	}
	public void checkPaymentPage()
	{
		cbp.checkPaymentPageApperance();
	}
	
	public void takeScreenShotOnFailure(String screenshotfilename)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		try 
		{
			FileUtils.copyFile(scrFile, new File(filepath+screenshotfilename+".png"));
			Logs.addScreenshot(filepath, " Screen shot captured for failed Test case ", "FAIL");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void flushLogs()
	{
		Logs.flushLog();
	}
	
	public void closeDriver()
	{
		driver.close();
		driver.quit();
		
	}
}
