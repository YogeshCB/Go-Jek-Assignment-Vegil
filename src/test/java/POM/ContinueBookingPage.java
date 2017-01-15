package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonMethods.CommMeths;
import commonMethods.Logs;

public class ContinueBookingPage 
{
	
	WebDriver driver;
	CommMeths cm;
	String info="INFO";
	String pass="PASS";
	String fail="FAIL";
	String emailid;
	String fname;
	String lname;
	String dobday;
	String dobmonth;
	String dobyear;
	String nationality;
	String mobnum;

	public ContinueBookingPage(WebDriver driver)
	{
		Logs.startLog(" Validating journey details at Payment Page which are entered and chosen in previous pages");
		Logs.addToReport("Control Enters inside ContinueBookingPage Constructor", info);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Logs.addToReport("Control exits from ContinueBookingPage Constructor", info);
		cm = new CommMeths();
	}
	
	@FindBy(xpath="//*[text()='Book in four simple steps']")
	WebElement header;
	
	@FindBy(xpath="//div[@class='itinerary clearFix onwBlock']/ul/li[1]/div[2]/span")
	WebElement chosenfromflightname;
	
	@FindBy(xpath = "//div[@class='airlineName']//following::div[3]/span[@class='name']")
	WebElement chosentoflightname;
	
	@FindBy(xpath="//*[@id='insurance_confirm']")
	WebElement InsuranceConfirmchckbox;
	
	@FindBy(xpath="//*[@id='itineraryBtn']")
	WebElement ContinueBookingBtn;
	
	@FindBy(xpath="//*[@id='username']")
	WebElement emailbox;
	
	@FindBy(id="LoginContinueBtn_1")
	WebElement EmailContinueButton;
	
	@FindBy(id = "AdultFname1")
	WebElement FnameTxtBox;
	
	@FindBy(id = "AdultLname1")
	WebElement LnameTxtBox;
	
	@FindBy(id="AdultDobDay1")
	WebElement day;
	
	@FindBy(id="AdultDobMonth1")
	WebElement month;
	
	@FindBy(id="AdultDobYear1")
	WebElement year;
	
	@FindBy(xpath="//*[@id='intADDAD1']/div/div/dl[2]/dl/dd/span/input[1]")
	WebElement nationality_textbox;
	
	@FindBy(xpath="//*[text()='India']")
	WebElement AutoExtender;
	
	@FindBy(id = "mobileNumber")
	WebElement MobnumTxtBox;
	
	@FindBy(id = "AdultTitle1")
	WebElement Title;
	
	@FindBy(id = "travellerBtn")
	WebElement DetailsContineBtn;
	
	@FindBy(xpath="//*[@id='ccTitle']")
	WebElement creditcardheader;
	
	@FindBy(xpath="//*[@id='userInfo']/div/h2/span")
	WebElement emailidentered;
	
	@FindBy(xpath="//*[@id='travellerSum']/ul/li/span")
	WebElement nameentered;
	
	public void validateJourneyDetailsOnBookingPage()
	{
		cm.addToHmap("bookingpageheader", header.getText());
		Logs.addToReport("Payment page header: "+header.getText(), info);
		cm.addToHmap("Chosenfromflightname", chosenfromflightname.getText());
		Logs.addToReport("Chosen Flight Name: "+chosenfromflightname.getText(), info);
		cm.addToHmap("Chosentoflightname", chosentoflightname.getText());
		Logs.addToReport("Chosen Flight Name: "+chosentoflightname.getText(), info);
		//System.out.println(CommMeths.hmapjourneydetails);
		
		String fromflightnamechsn = CommMeths.hmapjourneydetails.get("fromflightchosn");
		String toflightnamechsn = CommMeths.hmapjourneydetails.get("toflightchosn");
		
		String frmflightnameappeared = CommMeths.hmapjourneydetails.get("Chosenfromflightname");
		String toflightnameappeared = CommMeths.hmapjourneydetails.get("Chosentoflightname");
		
		if(fromflightnamechsn.equalsIgnoreCase(frmflightnameappeared))
		{
			Logs.addToReport("From Flight Name selected:  "+ fromflightnamechsn + " and "+ "Flight Name appeared in Payment page:  " + frmflightnameappeared + " are same", info);
		}
		else
		{
			Logs.addToReport("From Flight Name selected:  "+ fromflightnamechsn + " and "+ "Flight Name appeared in Payment page:  " + frmflightnameappeared + " are not same", info);
		}
		if (toflightnamechsn.equalsIgnoreCase(toflightnameappeared))
		{
			Logs.addToReport("To Flight Name selected:  "+ toflightnamechsn + " and "+ "Flight Name appeared in Payment page:  " + toflightnameappeared + " are same", info);
		}
		else
		{
			Logs.addToReport("To Flight Name selected:  "+ toflightnamechsn + " and "+ "Flight Name appeared in Payment page:  " + toflightnameappeared + " are not same", info);
		}
		String text = header.getText();
		if(text.isEmpty())
		{
			Logs.addToReport("Payment page did not appear", fail);
		}
		else
			Logs.addToReport("Payment page appeared", pass);
		
		Logs.stopLog();
	}
		
	public void click_insurance()
	{
		Logs.startLog("Selecting Insurance and Click on Continue");
		Logs.addToReport("Control Enters inside Insurance click Method", info);
		
		cm.elementExplicitWait(driver, InsuranceConfirmchckbox, 50);
		
		Logs.addToReport("Insurance box is visible", info);
		InsuranceConfirmchckbox.click();		
		if(ContinueBookingBtn.isDisplayed())
		{
			Logs.addToReport("Clicked Continue button after selecting Insurance", pass);
			ContinueBookingBtn.click();
		}
		else
		{
			Logs.addToReport(" Continue button after Insurance is not clicked", fail);
		}
		Logs.addToReport("Control exits from Insurance click method", info);
		Logs.stopLog();
	}
	
	public void enterEmail()
	{
		Logs.startLog("Entering Email Id and Click on Continue");
		Logs.addToReport("Control Enters inside Entering Email Method", info);
		
		cm.elementExplicitWait(driver, emailbox, 100);
		
		Logs.addToReport("Email text box is visible", info);
		
		emailid = cm.getInput("Email-Id");
		
		emailbox.sendKeys(emailid);
		
		Logs.addToReport("Email entered", info);
		
		if(EmailContinueButton.isDisplayed())
		{
			Logs.addToReport("Clicked Continue button after entering Email id", pass);
			EmailContinueButton.click();
		}
		else
		{
			Logs.addToReport(" Email continue button is not clicked", fail);
		}
		Logs.addToReport("Control exits from Entering Email method", info);
		Logs.stopLog();
	}
	
	public void enterPassengerDetails()
	{
		Logs.startLog("Entering Passenger Name and Mobile number details and Click on Coninue");
		Logs.addToReport("Contorls enters inside enterPassengerDetails method", info);
		
		cm.elementExplicitWait(driver, Title, 50);
		Logs.addToReport("Form to Fill user details is visible", info);
		
		Select titledp = new Select(Title);
		titledp.selectByValue("Mr");
		Logs.addToReport("Mr Value chosen in Drop down", info);
		
		fname = cm.getInput("First Name");
		FnameTxtBox.sendKeys(fname);
		Logs.addToReport("First name: "+ fname + " is entered", info);
		
		lname = cm.getInput("Last Name");
		LnameTxtBox.sendKeys(lname);
		Logs.addToReport("Last name: "+ lname + " is entered", info);
		
		Select daymenu = new Select(day);
		dobday = cm.getInput("D.O.B Day");
		daymenu.selectByValue(dobday);
		Logs.addToReport("D O B Day: "+ dobday + " is entered", info);
		
		Select monthmenu = new Select(month);
		dobmonth = cm.getInput("D.O.B Month");
		monthmenu.selectByValue(dobmonth);
		Logs.addToReport("D O B Month: "+ dobmonth + " is entered", info);
		
		Select yearmenu = new Select(year);
		dobyear = cm.getInput("D.O.B Year");
		yearmenu.selectByValue(dobyear);
		Logs.addToReport("D O B Year: "+ dobyear + " is entered", info);
		
		if(nationality_textbox.isDisplayed())
		{
			nationality = cm.getInput("Nationality");
			nationality_textbox.sendKeys(nationality);
			Logs.addToReport("Nationality value is entered", info);
			cm.elementvisibilityExplicitWait(driver, AutoExtender, 20);
			AutoExtender.click();
			Logs.addToReport("Nationality value: "+ nationality + " is entered", info);
			System.out.println("India Value is chosen");
		}
		
		mobnum = cm.getInput("Mobile Number");
		MobnumTxtBox.sendKeys(mobnum);
		Logs.addToReport("Mobile number: "+ mobnum + " is entered", info);
		
		if(DetailsContineBtn.isDisplayed())
		{
			Logs.addToReport("Continue button is clicked", pass);
			DetailsContineBtn.click();
			Logs.addToReport("Contorls exits enterPassengerDetails method", info);
		}
		else
			Logs.addToReport("Continue button is not clicked", fail);
		Logs.stopLog();
	}
	
	public void checkPaymentPageApperance()
	{
		Logs.startLog("Checking Payment option after entering all details");
		Logs.addToReport("Controls comes inside checkPaymentPageApperance Menthod", info);
		
		cm.elementExplicitWait(driver, creditcardheader, 100);
		
		String text = creditcardheader.getText();
		if (text.contains("Enter your credit card details"))
			Logs.addToReport("Credit Card Payment Page appeared", pass);
		else
			Logs.addToReport("Credit Card Payment Page did not appear", fail);
		Logs.stopLog();
	}
	

}
