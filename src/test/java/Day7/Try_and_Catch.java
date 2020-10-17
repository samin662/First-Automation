package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Try_and_Catch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //set chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maxed
        options.addArguments("start-maximized");
        //set the driver to incognito
        options.addArguments("Incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //define the web driver
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.mlcalc.com");
        try {
            WebElement DPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            DPayment.clear();
            DPayment.sendKeys("40");
        } catch (Exception error) {
            System.out.println("Unable to enter down payment " +error);
        }



    }//end of main method
}//end of class