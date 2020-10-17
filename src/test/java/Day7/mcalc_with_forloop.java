package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class mcalc_with_forloop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //set chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maxed
        options.addArguments("start-maximized");

        //define the web driver
        WebDriver driver = new ChromeDriver(options);
        ArrayList<String> PpaymentList = new ArrayList<>();
        PpaymentList.add("350000");
        PpaymentList.add("4000000");

        ArrayList<String> dPaymentList = new ArrayList<>();
        dPaymentList.add("40");
        dPaymentList.add("35");
        //call for the loop
        for (int i = 0; i< PpaymentList.size(); i++) {
            driver.navigate().to("https://www.mlcalc.com");
            try {
                System.out.println("Enter down payment");
                WebElement DPayment = driver.findElement(By.xpath("//*[@name='dp']"));
                DPayment.clear();
                DPayment.sendKeys(dPaymentList.get(i));
            } catch (Exception error) {
                System.out.println("Unable to enter down payment " + error);
            }//end of catch
            try {
                System.out.println("Enter purchase price");
                WebElement PPayment = driver.findElement(By.xpath("//*[@name='ma']"));
                PPayment.clear();
                PPayment.sendKeys(PpaymentList.get(i));
            }
            catch (Exception error) {
                System.out.println("Unable to enter purchase price " + error);
            }
            try {
                System.out.println("Click on calc button");
                driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
            } catch (Exception error) {
                System.out.println("Unable to click calc " +error);
            }//end of catch

            try {
                System.out.println("Calculate your monthly payment");
            String mthPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
            System.out.println("Your monthly payment is " +mthPayment); }
            catch (Exception error) {
                System.out.println("Unable to calculate monthly payment" +error);
            }



        }//end of loop
driver.quit();

    }//end of method
}//end of class
