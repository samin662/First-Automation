package ActionItems;

import Reusable_Library.Abstract_class_crossbrowser;
import Reusable_Library.ReusableMethod_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class FedEx {


    public class Fedex extends Abstract_class_crossbrowser {
        @Test
        public void FedExUpload() throws InterruptedException, AWTException {
            //navigate to FedEx homepage
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.fedex.com/en-us/home.html");
            Thread.sleep(2000);
            //Click Design and printing
            ReusableMethod_Loggers.mouseClick(driver,"//*[@aria-label='Open Design & Print menu']",logger,"Design");
            Thread.sleep(2000);
            ReusableMethod_Loggers.mouseClick(driver,"//*[@alt='Upload a Print-Ready File']",logger,"Upload");
            Thread.sleep(4000);
            try {
                ReusableMethod_Loggers.mouseClick(driver, "//*[@alt='no']", logger, "No");
                logger.log(LogStatus.INFO,"Pop up closed");
            } catch (Exception err){
                logger.log(LogStatus.INFO,"Pop up unavailable");
            }
            ReusableMethod_Loggers.mouseClick(driver,"//*[@alt='Document Printing']",logger,"Doc Printing");
            Thread.sleep(1000);
            ReusableMethod_Loggers.mouseClick(driver,"//*[@alt='Copies & Custom Projects']",logger,"Copies");
            Thread.sleep(1000);
            ReusableMethod_Loggers.mouseClick(driver,"//*[@name='upload-files-button']",logger,"Use your file");
            Thread.sleep(4000);
            ReusableMethod_Loggers.uploadFile("C:\\Users\\Shafqat Amin\\Desktop\\QA_projects\\src\\main\\resources\\soft assertion.png");
            Thread.sleep(2000);
            ReusableMethod_Loggers.mouseClick(driver,"//*[text()='CONTINUE WITH EXISTING']",logger,"Continue");
            Thread.sleep(3000);
            ReusableMethod_Loggers.sendKeys(driver,"//*[@name='item-quantity']","5",logger,"Quantity");
            Thread.sleep(2000);
            ReusableMethod_Loggers.mouseClick(driver,"//*[@name='update_quanity-addToCart-lbl']",logger,"Add to cart");
            Thread.sleep(2000);
            ReusableMethod_Loggers.mouseClick(driver,"//*[@id='cartToCheckoutBtn']",logger,"Continue");
            Thread.sleep(3000);
            try {
                ReusableMethod_Loggers.mouseClick(driver,"//*[@alt='no']",logger,"Pop up");
                logger.log(LogStatus.INFO,"Pop up closed");
            } catch (Exception err){
                logger.log(LogStatus.INFO,"There was no pop up");
            }
            Thread.sleep(2000);
            ReusableMethod_Loggers.mouseClick(driver,"//*[@id='continueAsGuest']",logger,"As Guest");
            Thread.sleep(2000);
            ReusableMethod_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']","5 Miles",logger,"5 miles");
            ReusableMethod_Loggers.sendKeys(driver,"//*[@name='locSearchTxt']","11432",logger,"Zip");
            ReusableMethod_Loggers.mouseClick(driver,"//*[@id='saveNContBtn']",logger,"Continue");
            Thread.sleep(2000);
            String addy = ReusableMethod_Loggers.captureResult(driver,"//*[@class='active']",logger,"Address");
            logger.log(LogStatus.INFO,addy);

        }//end of test


    }//end of class

}
