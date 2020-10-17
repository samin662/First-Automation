package Day11;

import Reusable_Library.ReusableMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Google {
    //call before suite to set up your chromedriver
    //precondition
//driver need to be initialized outside of all method so it can be reusable
    WebDriver driver;
    //Before suite. Set Chrome driver and prerequisites
    @BeforeSuite
    public void setChromedriver() {
        driver = ReusableMethod.getDriver();
    } //end of before suite

@Test(priority = 1)
    public void searchKeyword() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(1500);
        ReusableMethod.sendKeys(driver,"//*[@name='q']","cars","Search Field");
        ReusableMethod.submit(driver,"//*[@name='btnK']","Search Button");
        Thread.sleep(1500);
} //end of test 1
@Test(priority = 2)
    public void getSearchResult() {
        String result = ReusableMethod.getText(driver,"//*[@id='result-stats']", "Results");
        System.out.println(result);
} //end of test 2
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }//end of after suite


} //end of class