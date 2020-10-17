package ActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Bing {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//define the browser

        ChromeOptions bingSearch = new ChromeOptions();
        // set the chrome options
        bingSearch.addArguments("start-maximized");

        //define the driver
        WebDriver driver = new ChromeDriver(bingSearch);
        String[] hobbies = new String[5];
        hobbies[0] = "Soccer";
        hobbies[1] = "Cricket";
        hobbies[2] = "Gaming";
        hobbies[3] = "Travel";
        hobbies[4] = "Hanging out";
        //set the loop
        for (int i = 0; i < hobbies.length; i++) {


            //start of loop
            driver.navigate().to("https://www.bing.com"); //go to bing homepage
             Thread.sleep(1500);
            driver.findElement(By.name("q")).sendKeys(hobbies[i]);
            Thread.sleep(1500);
            driver.findElement(By.name("q")).submit();
            Thread.sleep(1500);
            String result = driver.findElement(By.className("sb_count")).getText();
            String[] hobbyResult = result.split("Next");

            System.out.println("The search for " +hobbies[i]+ " generated " +hobbyResult[1]);


        }    //end of loop
driver.quit();

    }
}