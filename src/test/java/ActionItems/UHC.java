package ActionItems;

import Reusable_Library.ReusableMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class UHC {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //add chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the driver
        WebDriver driver = new ChromeDriver(options);
//Set Array List for first and last names
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Lionel");
        firstName.add("Cristiano");
        firstName.add("Neymar");
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Messi");
        lastName.add("Ronaldo");
        lastName.add("Junior");
//set Array List for birth month
        ArrayList<String> DoBmonth = new ArrayList<>();
        DoBmonth.add("June");
        DoBmonth.add("February");
        DoBmonth.add("March");
//Set Array List for birthday day and year
        ArrayList<String> DobDay = new ArrayList<>();
        DobDay.add("25");
        DobDay.add("05");
        DobDay.add("06");
        ArrayList<String> DobYear = new ArrayList<>();
        DobYear.add("1987");
        DobYear.add("1985");
        DobYear.add("1991");
//Set Array List for ssn
        ArrayList<String> ssn = new ArrayList<>();
        ssn.add("123456");
        ssn.add("654321");
        ssn.add("246810");
//set Array List for zip
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11432");
        zipcode.add("10006");
        zipcode.add("10016");
//navigate to www.uhc.com
        driver.navigate().to("https://www.uhc.com");
//verify title
        String title = driver.getTitle();
        if (title == "Health insurance plans"){
            System.out.println("The title matches");
        } else {
            System.out.println("The title does not match. Actual title is " +title);
        } //End of title verification
//Click on Find a doctor
        ReusableMethod.click(driver,"//*[@aria-label='Find a Doctor']", "Find a Doc");
//Click on Sign in To find a provider
        ReusableMethod.click(driver,"//*[@id='btn-sign-in']", "Sign in");
//Switch tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
//Click on register now
        ReusableMethod.click(driver,"//*[@id='registerbutton']","Register now");
//Start for loop
for (int i=0; i < firstName.size(); i++) {
//Fill in the registration tab
    ReusableMethod.sendKeys(driver, "//*[@id='firstName']", firstName.get(i), "First Name");
    Thread.sleep(1500);
    ReusableMethod.sendKeys(driver,"//*[@id='lastName']", lastName.get(i), "Last Name");
    Thread.sleep(1500);
    ReusableMethod.dropdown(driver,"//*[@name='dob_month']", DoBmonth.get(i), "Enter First Name");
    Thread.sleep(1500);
    ReusableMethod.sendKeys(driver,"//*[@id='dob_day']", DobDay.get(i),"Enter birth day");
    Thread.sleep(1500);
    ReusableMethod.sendKeys(driver,"//*[@id='dob_year']", DobYear.get(i),"Enter birth year");
    Thread.sleep(1500);
    ReusableMethod.click(driver,"//*[@for='ssn']","Click on Social security");
    Thread.sleep(1500);
    ReusableMethod.sendKeys(driver,"//*[@id='ssnLastSixDigits']",ssn.get(i),"Enter ssn");
    Thread.sleep(1500);
    ReusableMethod.sendKeys(driver,"//*[@id='zipCode']",zipcode.get(i),"Enter zip code");
    Thread.sleep(1500);
    ReusableMethod.click(driver,"//*[@id='submitBtn']","Click on continue");
String error=ReusableMethod.getText(driver,"//*[@id='plainText_error']","Get error msg");
System.out.println(error);
        }// end of for loop
driver.quit();

    } //end of main method
} //end of class
