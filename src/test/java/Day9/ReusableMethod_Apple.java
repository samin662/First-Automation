package Day9;

import Reusable_Library.ReusableMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReusableMethod_Apple {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //add chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to apple.com page
        driver.navigate().to("https://www.apple.com");
        //call the Reusable click method to click on mac
        ReusableMethod.click(driver, "//*[@data-analytics-title='mac']", "Mac Link");
        ReusableMethod.click(driver, "//*[text()='MacBook Air']", "Mac Book Air");
        ReusableMethod.click(driver, "//*[@data-analytics-title ='search']", "Search");
        ReusableMethod.sendKeys(driver, "//*[@placeholder='Search apple.com']", "iphone", "Search Iphone");
      ReusableMethod.submit(driver, "//*[@placeholder='Search apple.com']", "search");

    } //end of method
}//end of class
