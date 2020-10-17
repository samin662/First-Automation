package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //set chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maxed
        options.addArguments("start-maximized");

        //define the web driver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(1500);
        //WebElement MonthDD = driver.findElement(By.xpath("//*[@name='sm']"));
        //Select SmDD = new Select(MonthDD);
        //SmDD.selectByVisibleText("Apr");

        //If Dropdown is not under "select//
        driver.findElement(By.xpath("//*[@name='sm']")).click();
        driver.findElement(By.xpath("//*[text()='Apr']")).click();

        WebElement YearDD = driver.findElement(By.xpath("//*[@name='sy']"));
        Select SyDD = new Select(YearDD);
        SyDD.selectByVisibleText("2010");


    }
}
