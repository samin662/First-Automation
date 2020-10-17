package Day12;

import Reusable_Library.ReusableMethod;
import Reusable_Library.ReusableMethod_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HTML_Google_Search {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    @BeforeSuite
    public void setDriver(){
        driver = ReusableMethod.getDriver();

        //define where you want to save the report(path)
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html",true);

    }//end of before suite

    @Test
    public void Google_Search() throws InterruptedException {
        logger = reports.startTest("Google Search Result");
        logger.log(LogStatus.INFO,"Navigating to Google home page");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        ReusableMethod_Loggers.sendKeys(driver,"//*[@name='q']","Cars",logger,"Search Field");
        ReusableMethod_Loggers.submit(driver,"//*[@name='btnK']",logger,"Search Button");
        Thread.sleep(2000);
        String result = ReusableMethod_Loggers.captureResult(driver,"//*[@id='result-stats']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[1]);
        //after all the test steps per @Test you must end the test as well
        reports.endTest(logger);
    }//end of test

    @AfterSuite
    public void closeSession(){
        reports.flush();
        //driver.quit();

    }//end of after suite


}//end of java class
