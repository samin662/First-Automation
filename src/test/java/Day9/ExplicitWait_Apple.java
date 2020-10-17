package Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWait_Apple {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //add chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the driver
        WebDriver driver = new ChromeDriver(options);
         //set the explicit wait command
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //navigate to apple website
        driver.navigate().to("https://www.apple.com");
        //click on mac link using wait
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-analytics-title='mac']"))).click();


    }//end of method
}//end of class
