package Day13;

import Reusable_Library.Abstract_class;
import Reusable_Library.ReusableMethod_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HTML_Abstract_Google extends Abstract_class {
    @Test
    public void Google_Search() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to Google home page");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        ReusableMethod_Loggers.sendKeys(driver,"//*[@name='q']","Cars",logger,"Search Field");
        ReusableMethod_Loggers.submit(driver,"//*[@name='btnK']",logger,"Search Button");
        Thread.sleep(2000);
    }//end of test
    //this is test 123

    @Test(dependsOnMethods = "Google_Search")
    public void Google_Search_Result() throws InterruptedException {
        String result = ReusableMethod_Loggers.captureResult(driver,"//*[@id='result-stats']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[1]);
        //after all the test steps per @Test you must end the test as well
    }//end of test



}
