package Day13;

import Reusable_Library.Abstract_class;
import Reusable_Library.ReusableMethod_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HTML_Bing extends Abstract_class {
    @Test
    public void Bing_Search() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to Bing home page");
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2000);
        ReusableMethod_Loggers.sendKeys(driver,"//*[@name='q']","Cars",logger,"Search Field");
        ReusableMethod_Loggers.submit(driver,"//*[@id='sb_form_go']",logger,"Search Button");
        Thread.sleep(2500);
    }//end of test

    @Test(dependsOnMethods = "Bing_Search")
    public void Bing_Search_Result() throws InterruptedException {
        String result = ReusableMethod_Loggers.captureResult(driver,"//*[@class='sb_count']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[0]);
        //after all the test steps per @Test you must end the test as well
    }//end of test

}
