package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YahooXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //set chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maxed
        options.addArguments("start-maximized");
        //set the driver to incognito
        options.addArguments("Incognito");
        //run the driver in headless mode
        //options.addArguments("headless");

        //define the web driver
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here
        //navigate to google.com
        driver.navigate().to("https://www.yahoo.com");
   //driver.findElement(By.xpath("//*[@role='combobox']")).sendKeys("cars");
        driver.findElements(By.xpath("//*[@class=_yb_11qeu _yb_l8c4p  "));


    }//end of method
}//end of class
