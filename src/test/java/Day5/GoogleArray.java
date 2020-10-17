package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleArray {
    public static void main(String[] args) throws InterruptedException {

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
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here
        //navigate to google.com
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Staten Island";
        for (int i = 0; i < cities.length; i++) {
            driver.navigate().to("https://www.google.com");
            //put two second delay
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.name("q")).sendKeys(cities[i]);
            Thread.sleep(2000);
            driver.findElement(By.name("btnK")).click();
            Thread.sleep(2000);
            //capture the results
            String result = driver.findElement(By.id("result-stats")).getText();
            String[] arrayResult = result.split(" ");
            System.out.println("The city is " +cities[i]+ "and the search result is " +arrayResult[0]);

        }
        driver.quit();

    }
}