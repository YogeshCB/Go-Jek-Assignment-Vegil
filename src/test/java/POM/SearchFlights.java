package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.CommMeths;
import commonMethods.Logs;

public class SearchFlights {
	WebDriver driver;
	CommMeths cm;
	String info="INFO";
	String pass="PASS";
	String fail="FAIL";
	
	public SearchFlights(WebDriver driver)
	{
		Logs.startLog("Entering the Journey Details");
		Logs.addToReport("Control Enters into LoginPOM Constructor", info);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Logs.addToReport("Control Exits LoginPOM Constructor", info);
		cm = new CommMeths();
	}
	
	@FindBy(id="RoundTrip")
	WebElement RoundTrip_Radio_btn;
	
	@FindBy(id="FromTag")
	WebElement From_Place_Txtbox;
	
	@FindBy(id="ToTag")
	WebElement To_Place_Txtbox;
	
	@FindBy(xpath="//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i")
	WebElement DepartCalendar;
	
	@FindBy(id="ReturnDate")
	WebElement ReturnCalendar;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td")
	List<WebElement> calendar_Depart_date;
	
	@FindBy(id="SearchBtn")
	WebElement SearchBtn;
	
	public void searchFlight()
	{
		RoundTrip_Radio_btn.click();
		Logs.addToReport("Round trip Radio button is available and clicked", info);
		
		String from_location = cm.getInput("From_Place_Name");
		From_Place_Txtbox.sendKeys(from_location);
		Logs.addToReport("From Location Text box is available and value entered", info);
		
		String to_location = cm.getInput("To_Place_Name");
		To_Place_Txtbox.sendKeys(to_location);
		Logs.addToReport("To Location Text box is available and value entered", info);
		
		//Thread.sleep(3000);
		cm.elementExplicitWait(driver, DepartCalendar, 3);
		DepartCalendar.click();
		//Thread.sleep(3000);		
		String from_date = cm.getInput("From_Date");
		pick_depart_date(from_date);
		Logs.addToReport("From date eneterd in Calendar", info);
		
		cm.elementExplicitWait(driver, ReturnCalendar, 3);
		ReturnCalendar.click();
		//Thread.sleep(3000);
		String to_date = cm.getInput("To_Date");
		pick_Return_date(to_date);
		Logs.addToReport("To date eneterd in Calendar", info);
		
		SearchBtn.click();
		Logs.addToReport("Search flight button clicked", info);
		
		String search_page_title = cm.getInput("Search_Page_Title");
		cm.titleExplicitWait(driver, search_page_title, 5);
		String title1 = driver.getTitle();
		//Thread.sleep(200);
		
		if(title1.contains(search_page_title))
			Logs.addToReport("Search Page opened", pass);	
		else
			Logs.addToReport("Search did not work", fail);
	
		Logs.stopLog();
	}
	
	public void pick_depart_date(String DepartOnDate)
	{
		//List <WebElement> fromdate= driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td"));
		//System.out.println(fromdate);
		for(WebElement ele: calendar_Depart_date)
		{
			String date = ele.getText();
			if(date.equalsIgnoreCase(DepartOnDate))
			{
				ele.click();
				break;
			}	  
		}
	}
	
	public void pick_Return_date(String ReturnOnDate)
	{
		//List <WebElement> todate= driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td"));
		//System.out.println(todate);
		for(WebElement ele: calendar_Depart_date)
		{
			String date = ele.getText();
			if(date.equalsIgnoreCase(ReturnOnDate))
			{
				ele.click();
				break;
			}	  
		}
	}
	
	

}
