package Day12;

import Reusable_Library.ReusableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class List_Checkbox {
    @Test
    public void Listcheck() throws InterruptedException {

        WebDriver driver = ReusableMethod.getDriver();
    driver.navigate().to("https://www.yahoo.com");
    Thread.sleep(1500);

    //get count of all links in yahoo webpage
    List <WebElement> links = driver.findElements(By.xpath("//*[@class='_yb_5coqv']"));
    //print out link count
    System.out.println("The link count is " +links.size());
    //verify if signed in button is clicked
    ReusableMethod.click(driver,"//*[@class = '_yb_687jt']","Sign in button");
    Thread.sleep(2000);
    boolean checkBoxclick = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
    if (checkBoxclick == true) {
        System.out.println("Checkbox is selected as expected");
    } else {
        System.out.println("Checkbox is not selected by default");
    }

    }
}
