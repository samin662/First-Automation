package ActionItems;

import Reusable_Library.ReusableMethod;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Kayak_NG {
    //Set global variables
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;
    //Set Before suite
    @BeforeSuite
    public void setPreConditions() throws IOException, BiffException {
        driver = ReusableMethod.getDriver();

        //Step 1 = locate excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/KayakAI.xls"));
        //Step 2:Locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3:Make a copy of the readable file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/KayakAIresults.xls"),readableFile);
        //Step 4: define writable sheet for the writable file
        writableSheet = writableFile.getSheet(0);
        //Step 5: Get row count
        rowCount = writableSheet.getRows();
    } // end of Before Suite
    @Test
    public void Kayak() throws InterruptedException, WriteException {
        for (int i = 1; i < rowCount; i++) {
            String airport = writableSheet.getCell(0, i).getContents();
            String Startdate = writableSheet.getCell(1, i).getContents();
            String startTime = writableSheet.getCell(2, i).getContents();
            String EndDate = writableSheet.getCell(3, i).getContents();
            String EndTime = writableSheet.getCell(4, i).getContents();
            String vehicle = writableSheet.getCell(5, i).getContents();

            //navigate to kayak
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);
/** below code is inspected before you clicking inside the search field
 and I am using contains id property as initial portion of id value
 is changing **/
            ReusableMethod.click(driver, "//*[contains(@id,'pickup-display')]", "Pick up Location");
            ReusableMethod.sendKeys(driver, "//*[@name='pickup']",airport,"Airport");
/** click on suggesting link once you type your airport
 orelse it will block your calendar so you need to click on suggested link **/
            ReusableMethod.click(driver, "//*[@class='smarty-item-icon']", "Choose Airport Link");
//now put like 1 to 2 seconds then click on start date calendar icon
            Thread.sleep(2000);
//line below is clicking on calendar icon first for start date
            ReusableMethod.click(driver, "//*[contains(@id, 'dateRangeInput-display-start-inner')]", "Start Date");
            Thread.sleep(2000);
            ReusableMethod.typeAndSubmit(driver, "//*[contains(@id, 'pickup-date-input')]", Startdate, "Enter Date");
/** element below is not interactable because you have to close the calendar so click anywhere outside
 like clicking on title search for hundred **/
            ReusableMethod.click(driver,"//*[@class='title dark']","Dark Title");
//put like 1 second
            Thread.sleep(1000);
//before you select the value from start time you need to click on start time icon first
            ReusableMethod.mouseClick(driver, "//*[contains(@id,'start-time-select-display')]","Start Time");
/** also before clicking on the value you should put 1.5 to 2 seconds to slow down selenium
 orlese you will get element not interactable error **/
            Thread.sleep(2500);
//now click on start time value
            ReusableMethod.mouseClick(driver, "//*[contains(@id,'start-time-select-option') and @data-title='"+startTime+"']","Start Time Value");
            //Enter end date
            Thread.sleep(1000);
            ReusableMethod.click(driver,"//*[contains(@id, 'dateRangeInput-display-end-inner')]", "End Date");
            Thread.sleep(2000);
            ReusableMethod.typeAndSubmit(driver,"//*[contains(@id,'dropoff-date-input')]", EndDate, "Enter date");
            ReusableMethod.click(driver,"//*[@class='title dark']","Dark Title");
            Thread.sleep(1000);
            //Enter end time
            ReusableMethod.mouseClick(driver,"//*[contains(@id,'dateRangeInput-end-time-select-display-status')]", "End Time");
            Thread.sleep(2000);
            ReusableMethod.mouseClick(driver,"//*[contains(@id,'end-time-select-option') and @data-title='"+EndTime+"']", "Enter time");
            Thread.sleep(1500);
            //Click on search
            ReusableMethod.mouseClick(driver,"//*[contains(@id,'submit')]","Search");
            //Click on third link
            ReusableMethod.clickByIndex(driver,"//*[text()='View Deal']", 3, "Click third link");
            //Switch to second tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            String amtdue = ReusableMethod.getText(driver,"//*[contains(@color, 'green']","Total due");
            driver.close();
            driver.switchTo().window(tabs.get(0));
            //send this text to empty column
            Label label = new Label(8,i,amtdue);
            writableSheet.addCell(label);

        } //end of loop
    }//end of test
@AfterSuite
    public void close() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
}


}//end of class

