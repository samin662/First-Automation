package Day12;

import Reusable_Library.ReusableMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_Google {

    @Test
    public void assertion() {
        WebDriver driver = ReusableMethod.getDriver();

        driver.navigate().to("https://www.google.com");
        //Verify title using hard asset
        //Assert.assertEquals("Google", driver.getTitle());

        //Verify title using soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"GOOGLE");

        //enter keyword on search
        ReusableMethod.sendKeys(driver,"//*[@name='q']", "cars", "Search");
        softAssert.assertAll(); //this store all errors coming from soft errors and shows it to console

    }
}
