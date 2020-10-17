package ActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class YahooSearch {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //set chrome options
        ChromeOptions yahooSearch = new ChromeOptions();

//Set the options
yahooSearch.addArguments("start-maximized");
//define the driver
WebDriver driver = new ChromeDriver(yahooSearch);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String[] hobbies = new String[5];
        hobbies[0] = "Soccer";
        hobbies[1] = "Cricket";
        hobbies[2] = "Gaming";
        hobbies[3] = "Travel";
        hobbies[4] = "Hanging out";
        //set the loop
        for (int i = 0; i < hobbies.length; i++) {
          //go to yahoo.com homepage
            driver.navigate().to("https://www.yahoo.com");
            Thread.sleep(1500);
            driver.findElement(By.name("p")).sendKeys(hobbies[i]);
            Thread.sleep(1500);
            driver.findElement(By.name("p")).submit();
            Thread.sleep(1500);
            js.executeScript("window.scrollBy(0,4000)");
            Thread.sleep(1500);
            String result = driver.findElement(By.className("compPagination")).getText();
            String[] hobbyResult = result.split("Next");
            String[] hobs = hobbyResult[1].split("results");
            System.out.println("The search for " +hobbies[i]+ "is" +hobs[i]);
        }//end of loop
    driver.quit();


    } // end of main method
} //end of class

