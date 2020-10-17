package Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class USPS_MouseAction {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //add chrome options
        ChromeOptions WWoptions = new ChromeOptions();
        WWoptions.addArguments("start-maximized");
        WWoptions.addArguments("incognito");

        //define the driver
        WebDriver driver = new ChromeDriver(WWoptions);

        //navigate to usps.com
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //set actions
        Actions actions = new Actions(driver);

        //move your mouse to quicktools
        WebElement element = driver.findElement(By.xpath("//*[text='Quick Tools']"));
        actions.moveToElement(element).perform();
        //click on track a package
        WebElement trackPackage = driver.findElement(By.xpath("//*[text='Track a Package']"));
        actions.moveToElement(trackPackage).click().perform();
        Thread.sleep(2500);
        //enter tracking number
        WebElement trackNum = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        trackNum.sendKeys("111111111111111");
         //to submit
        //driver.findElement(By.....).sendKeys(Keys.Enter);

    }
}
