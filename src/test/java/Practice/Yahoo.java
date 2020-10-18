package Practice;

import Reusable_Library.Abstract_class;
import Reusable_Library.ReusableMethod_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.ResourceBundle;

public class Yahoo extends Abstract_class {
    @Test
    public void YahooSearch() throws InterruptedException {

        //navigate to yahoo.com
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        //verify title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Yahoo");
        //Get link count
        List <WebElement> links = driver.findElements(By.xpath("//*[@class='_yb_e0gik']"));
        logger.log(LogStatus.PASS,"Tab count is " +links.size());
        Thread.sleep(2000);
        //Enter Nutrition in search
        ReusableMethod_Loggers.sendKeys(driver,"//*[@name='p']", "Nutrition",logger,"Search");
        ReusableMethod_Loggers.mouseClick(driver,"//*[@value='Search']", logger, "Search");
        Thread.sleep(2000);
        //Scroll down
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(1500);
        //Capture results
String result = ReusableMethod_Loggers.captureResult(driver,"//*[@class='compPagination']",logger,"Result");
String[] result1 = result.split("Next");
logger.log(LogStatus.PASS,"The search yielded " +result1[1]);
        //Scroll up and click on image
        js.executeScript("window.scrollBy(0,-5000)");
        ReusableMethod_Loggers.mouseClick(driver,"//*[@class='fl-l mr-5 last']",logger,"Image");
  List <WebElement> imageLinks = driver.findElements(By.xpath("//*[@class='ld  r0']"));
        logger.log(LogStatus.PASS,"The number of images are " +imageLinks.size());
        Thread.sleep(2000);
        //Click on sign in
        ReusableMethod_Loggers.mouseClick(driver,"//*[@class='text signin']",logger,"Sign in");
        boolean checkbox = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        if (checkbox == true) {
            logger.log(LogStatus.PASS,"Checkbox is selected as expected");
        } else {
           logger.log(LogStatus.FAIL,"Checkbox is not selected by default");
        }
    ReusableMethod_Loggers.sendKeys(driver,"//*[@name='username']","sfsf",logger,"Username");
    ReusableMethod_Loggers.mouseClick(driver,"//*[@id='login-signin']",logger,"Next");
    String error = ReusableMethod_Loggers.captureResult(driver,"//*[@class='error-msg']",logger,"Error");
    logger.log(LogStatus.FAIL,"Error message is " +error);
    if (error == "Sorry, we don't recognize this email."){
        logger.log(LogStatus.PASS,"Error matches");
    } else {
        logger.log(LogStatus.FAIL,"Error does not match");
    }

    }// end of method
}
