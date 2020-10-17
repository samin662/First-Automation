package ActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeightWatchers {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //add chrome options
        ChromeOptions WWoptions = new ChromeOptions();
        WWoptions.addArguments("start-maximized");
        WWoptions.addArguments("incognito");

        //define the driver
        WebDriver driver = new ChromeDriver(WWoptions);
//define script executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //set Arraylist
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11432");
        zipCode.add("10006");
        zipCode.add("10013");


        //check Title to see if it matches
        driver.navigate().to("https://www.weightwatchers.com");
        //check to see if title matches
        String title = driver.getTitle();
        if (title == "Weight Watchers: Weight Loss and Wellness Help") {
            System.out.println("The title matches");
        }
        else {
            System.out.println("The title does not match");
        } // end of title check

        // start of for loop
        for (int i = 0; i < zipCode.size(); i++) {
            try {
                driver.navigate().to("https://www.weightwatchers.com");
            } catch (Exception err) {
                System.out.println("Unable to navigate to website " +err);
            }
//click on Find a workshop
           try  {
               driver.findElement(By.xpath("//*[@da-label='Find a Workshop']")).click();
           } catch (Exception err) {
               System.out.println("Unable to click on click " +err);
           }

            driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
//Enter Zipcodes
         try {
             driver.findElement(By.xpath("//*[@placeholder='Enter location']")).sendKeys(zipCode.get(i));
         } catch (Exception err) {
             System.out.println("Unable to enter zipcode " +err);
         }

            driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();

            driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);

            List<WebElement> studio = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));
            if (zipCode.get(i) == "11432") {
              studio.get(1).click();
              Thread.sleep(1000);
                js.executeScript("window.scrollBy(0,900)");
                Thread.sleep(2000);

            }
            if (zipCode.get(i) == "10006"){
                studio.get(2).click();
                Thread.sleep(1000);
                js.executeScript("window.scrollBy(0,900)");
                Thread.sleep(2000);
            }
            if (zipCode.get(i) == "10013") {
                studio.get(0).click();
                Thread.sleep(1000);
                js.executeScript("window.scrollBy(0,900)");
                Thread.sleep(2000);
            }
//Get address and information of the studio
String address = driver.findElement(By.xpath("//*[@class='infoContainer-12kv1 noMap-1gRjF']")).getText();
            System.out.println(address);


//get schedule
String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
            System.out.println("The schedule at the location is " +schedule);


            }//end of loop
        driver.quit();
        } // end of method
}//end of class
