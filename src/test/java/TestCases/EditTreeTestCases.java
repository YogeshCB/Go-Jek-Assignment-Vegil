package TestCases;

import POM.*;
import commonMethods.CommMeths;
import commonMethods.Logs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;


public class EditTreeTestCases {

        WebDriver driver;
        CommMeths commeths;
        String info="INFO";
        String pass="PASS";
        String fail="FAIL";
        SoftAssert assertion = new SoftAssert();

        DriverInitalization driverini;
        OpenAidash OpenAidash;
        Ai_dash_login_screen login;
        Ai_Dash_Home_Page expandMUIScreen;
        Ai_Dash_Tree_List_Page EditTree;
        Ai_Dash_Edit_Tree EditTreePage;
        Ai_Dash_create_Tree_page createTree;
        Ai_dash_create_tree_screen2 create_tree_screen2;




        String filepath = "./Reports/Screenshots/";



        public void initalizeDriver(String browser)
        {

            driverini = new DriverInitalization();
            driver = driverini.initalizeDriver(driver, browser);
        }


        public void OpenAidash()
        {

            OpenAidash = new OpenAidash(driver);
        }

        public void Ai_dash_login_screen()
        {

            login= new Ai_dash_login_screen(driver);
            login.enterEmail();
            login.enterPassword();
            login.clickLoginButton();
        }

        public void Ai_Dash_Home_Page()
        {

            expandMUIScreen= new Ai_Dash_Home_Page(driver);
            expandMUIScreen.clickMUIButton();
            expandMUIScreen.HazardTreeMUIButton();
            expandMUIScreen.TreeRemovalButton();

        }


        public void Ai_Dash_Tree_List_Page()
        {


            EditTree= new Ai_Dash_Tree_List_Page(driver);
            EditTree.TreeCard();

        }

        public void Ai_Dash_Edit_Tree()
        {


            EditTreePage= new Ai_Dash_Edit_Tree(driver);
            EditTreePage.EditTreeButton();

        }

    public void Ai_Dash_create_Tree_page() throws InterruptedException
    {

        createTree= new Ai_Dash_create_Tree_page(driver);
        createTree.ClickOnNextButton();
        createTree.SpeciesDropdownButton();
        createTree.TreeConditionDropdownButton();
        createTree.DistanceToLineButton();
        createTree.TreeHeightDropdownButton();
        createTree.DiameterAtBreastHeightButton();
        createTree.RiskLevelButton();
        createTree.Action();
        createTree.NextButtonTreeCreateButton();
    }

    public void Ai_dash_create_tree_screen2()
    {

        create_tree_screen2= new Ai_dash_create_tree_screen2(driver);
        create_tree_screen2.NearestCircuit();
        create_tree_screen2.NoOfphases();
        create_tree_screen2.SubmitButton();
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
