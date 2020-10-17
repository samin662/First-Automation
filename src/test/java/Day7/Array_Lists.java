package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Array_Lists {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //set chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maxed
        options.addArguments("start-maximized");

        //define the web driver
        WebDriver driver = new ChromeDriver(options);
        ArrayList<String> smList = new ArrayList<>();
        smList.add("Jan");
        smList.add("Feb");
        smList.add("Mar");
        smList.add("Apr");
        smList.add("May");
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(1500);
        for (int i = 0; i< smList.size(); i++) {
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smDrop = new Select(startMonth);
            smDrop.selectByVisibleText(smList.get(i));

        //if there is no select tag
        driver.findElement(By.xpath("//*[@name='sm']")).click();
        driver.findElement(By.xpath("//*[text()='"+smList+"']")).click();
        }
    } //end of method
} // end of class
