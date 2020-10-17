package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
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
      System.out.println("Enter google.com");
      driver.navigate().to("https://www.google.com");
      Thread.sleep(2000);
      //capture the home page title and verify it matches expected title
        //which is GOOGLE
        String actualTitle = driver.getTitle();
        if (actualTitle == "GOOGLE") {
            System.out.println("The title matches");
        }
        else {
            System.out.println("The title does not match. Actual title is " +actualTitle);
        }
    }
}//end of java class
