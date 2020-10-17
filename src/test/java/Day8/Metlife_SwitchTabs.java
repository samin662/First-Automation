package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Metlife_SwitchTabs {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //add chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to MetLife website
        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();
        Thread.sleep(1500);
        //click on take along dental link
        driver.findElement(By.xpath("//*[text()='Metlife TakeAlong Dental']")).click();
        Thread.sleep(1500);
        //use contain when there is white space in text
        driver.findElement(By.xpath("//*[contains(text(), 'Enroll Now')]")).click();

        //need to store window handle everytime a new tab is opened
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));
        //enter zip code
        driver.findElement(By.xpath("//*[@name='txtZipCode']")).sendKeys("11432");
        driver.close(); //to close tab if work in the tab is done
        driver.switchTo().window(tabs.get(0)); //always have to switch even after closing tab
        //renavigate to metlife
        driver.navigate().to("https://www.metlife.com");




    }//end of method
}//end of class
