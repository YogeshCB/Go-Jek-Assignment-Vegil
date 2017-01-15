/*
 * Author: Vegil
 * Purpose: This java file contains the basic functional test cases for clearmy trip website automation
 * 
 */

package TestExecutionSuite;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.*;

import TestCases.CommonTestCases;


public class BasicFunctionalExecutionSuite {

	CommonTestCases ctcs;
		
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("Go-Jek Assigment Execution Suite starts");
	}

	@BeforeTest
	public void setup() throws IOException
	{
		System.out.println("Go-Jek Assigment Execution Suite Test starts");
	}

	@Test (priority = 0)
	@Parameters("browser")
	public void driverInitalization(String browser) 
	{
		ctcs = new CommonTestCases();
		ctcs.initalizeDriver(browser);
	}

	@Test (priority = 1)
	public void openUrl() 
	{
		ctcs.openUrl();
	}
	
	@Test (priority = 2)
	public void enterJourneyDetails()
	{
		ctcs.enterJourneyDetails();
	}
	
	@Test (priority = 3)
	public void validateDetailsEntereInSearchPage()
	{
		ctcs.validateDetailsInSearchResultsPage();
	}
	
	@Test (priority = 4)
	public void chooseFlight()
	{
		ctcs.chooseFlight();
	}
	
	@Test (priority = 5)
	public void validateFlightsChosenInPaymentPage()
	{
		ctcs.verifyFlightsChosenOnSearchPage();
	}
	
	@Test (priority = 6)
	public void selectInsurance()
	{
		ctcs.choseInsurance();
	}
	
	@Test (priority = 7)
	public void enterEmail()
	{
		ctcs.enterEmailDetails();
	}
	
	@Test (priority = 8)
	public void enterPassengerDetails()
	{
		ctcs.enterPassengerDetails();
	}
	
	@Test (priority = 9)
	public void verifyPaymentPage()
	{
		ctcs.checkPaymentPage();
	}	
	
	@AfterMethod
	public void afterEveryMethod(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			ctcs.takeScreenShotOnFailure(result.getTestName());
		}
	}
	
	@AfterTest
	public void teardown()
	{
		ctcs.flushLogs();
	}

	@AfterSuite
	public void aftersuite()
	{
		ctcs.closeDriver();
	}

}
