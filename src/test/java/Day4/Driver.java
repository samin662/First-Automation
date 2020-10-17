package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //defining the web driver that you will be using(Chrome, firefox,etc)
        WebDriver driver = new ChromeDriver();

        //lets get to google.com home page
        //driver.get("https://www.google.com");

        //lets navigate to google home page
        driver.navigate().to("https://www.google.com");
        //put two second delay
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("cars");
        driver.findElement(By.name("btnK")).click(); // can use .submit//
        //close driver
        //driver.close();
        //quit the entire session
        driver.quit();


    }
}
