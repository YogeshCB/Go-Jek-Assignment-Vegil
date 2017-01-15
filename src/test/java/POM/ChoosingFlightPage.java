package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.CommMeths;
import commonMethods.Logs;

public class ChoosingFlightPage {
	
	WebDriver driver;
	CommMeths cm;
	String info="INFO";
	String pass="PASS";
	String fail="FAIL";
	
	@FindBy(xpath ="//*[@id='flightForm']/section[2]/div[3]/div[3]//following::button[2]")
	WebElement BookBtn;
	
	@FindBy(xpath = "//*[@id='flightForm']/section[2]/div[4]/div[1]/div/div/strong")
	WebElement FromTripHeader;
	
	@FindBy(xpath = "//*[@id='flightForm']/section[2]/div[4]/div[1]/div/div/span")
	WebElement FromTripDate;
	
	@FindBy(xpath="//*[@id='flightForm']/section[2]/div[4]/div[2]/div/div/strong")
	WebElement ToTripHeader;
	
	@FindBy(xpath = "//*[@id='flightForm']/section[2]/div[4]/div[2]/div/div/span")
	WebElement ToTripDate;
	
	@FindBy(xpath="//*[@id='flightForm']/section[2]/div[3]/div[2]/div[1]/div/strong")
	WebElement FromFlightName;
	
	@FindBy(xpath = ".//*[@id='flightForm']/section[2]/div[3]/div[2]/div[2]/div/strong")
	WebElement ToFlightName;
	
	@FindBy(xpath = ".//*[@id='flightForm']/section[2]/div[3]/div[1]/h2")
	WebElement flightprice;
	
	public ChoosingFlightPage(WebDriver driver)
	{
		Logs.startLog("Verifying the Journey details entered in Previous page in Search Page");
		Logs.addToReport("Control enters into ChoosingFlightPage constructor", info);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Logs.addToReport("Control exits ChoosingFlightPage Constructor", info);
		cm = new CommMeths();
	}
	
	public void validateEnteredjourneyDetailsInSearchFlightsPage()
	{
		Logs.addToReport("Control enters into validateEnteredjourneyDetailsInSearchFlightsPage Method", info);
		
		String fromTriplocation = ReterivePlaceName(FromTripHeader.getText());
		cm.addToHmap("From_Place_Name", FromTripHeader.getText());
		Logs.addToReport("From Portal: "+ FromTripHeader.getText() + " After trimming: "+ fromTriplocation, info);
		String from_location = cm.getInput("From_Place_Name");
		if (from_location.contains(fromTriplocation))
			Logs.addToReport("Given from location "+ from_location +" is correctly appearing in Flights search page. ", info);
		else
			Logs.addToReport("Given from location "+ from_location +" is not appearing in Flights search page. ", info);
		
		String toTripLocaiton = ReterivePlaceName(ToTripHeader.getText());
		cm.addToHmap("To_Place_Name", ToTripHeader.getText());
		Logs.addToReport("From Portal: "+ ToTripHeader.getText() + " After trimming: "+ toTripLocaiton, info);
		String tolocation = cm.getInput("To_Place_Name");
		if(tolocation.contains(toTripLocaiton))
			Logs.addToReport("Given to location "+ tolocation + " is correctly appearing in Flights search page. ", info);
		else
			Logs.addToReport("Given to location "+ tolocation + " is not appearing in Flights search page. ", info);
		
		String fromtripdate = FromTripDate.getText();
		String fromdate = cm.getInput("From_Date");
		cm.addToHmap("From_Date", FromTripDate.getText());
		if(fromtripdate.contains(fromdate))
			Logs.addToReport("Given Start Date "+ fromdate + " is correctly appearing in Flights search page. ", info);
		else
			Logs.addToReport("Given Start Date "+ fromdate + " is not appearing in Flights search page. ", info);
		
		String totripdate = ToTripDate.getText();
		String todate = cm.getInput("To_Date");
		cm.addToHmap("To_Date", ToTripHeader.getText());
		if(totripdate.contains(todate))
			Logs.addToReport("Given Start Date "+ todate + " is correctly appearing in Flights search page. ", info);
		else
			Logs.addToReport("Given Start Date "+ todate + " is not appearing in Flights search page. ", info);
		
		cm.addToHmap("Flight Price", flightprice.getText());
		Logs.addToReport(" Flight Price: "+ flightprice.getText(), info);
		cm.addToHmap("fromflightchosn",FromFlightName.getText());
		Logs.addToReport(" From Flight Chosen: "+ FromFlightName.getText(), info);
		cm.addToHmap("toflightchosn",ToFlightName.getText());
		Logs.addToReport(" To Flight Chosen: "+ ToFlightName.getText(), info);
		Logs.stopLog();
	}
	
	public void continuefirstfligt()
	{
		Logs.startLog("Choose the First Flight option and Click on Book");
		Logs.addToReport("Control enters into continuefirstfligt Method", info);
		
		cm.elementExplicitWait(driver, BookBtn, 50);
		
		if(BookBtn.isDisplayed())
		{
			Logs.addToReport( "Booking option is available ", info);
			BookBtn.click();
			Logs.addToReport("First Flight option choosing Button is available", info);
			Logs.addToReport( "Booking button is clicked ", pass);
		}
		else
			Logs.addToReport(" Booking button is not available", fail);
		
		Logs.stopLog();
	}
	
	String ReterivePlaceName(String input)
	{
		input.trim();
		char c[]=input.toCharArray();
		int count =0;
		for( int i=0; i<=c.length-1 ; i++)
		{
			if (c[i]== ' ')
				break;
			count++;
		}
		String temp=input.substring(0, count);
		return temp;
	}
	
}
