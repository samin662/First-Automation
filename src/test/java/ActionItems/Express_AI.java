package ActionItems;

import Reusable_Library.Abstract_class;
import Reusable_Library.ReusableMethod;
import Reusable_Library.ReusableMethod_Loggers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class Express_AI extends Abstract_class {
  @Test
  public void ExpressExcel() throws IOException, BiffException, InterruptedException, WriteException {
//Locate excel workbook
      Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/express.xls"));
//Locate excel sheet
      Sheet readableSheet = readableFile.getSheet(0);
//Make a copy
      WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/expressResults.xls"), readableFile);
      WritableSheet writableSheet = writableFile.getSheet(0);
      int rowCount = writableSheet.getRows();
      driver.navigate().to("https://www.express.com");
      SoftAssert softAssert = new SoftAssert();
      softAssert.assertEquals(driver.getTitle(),"Men's and Women's Clothing");
      Thread.sleep(2000);
// Create for loop
      for (int i = 1; i < rowCount; i++) {
          //Get the cell contents
          //column is hard coded, row is not
          String size = writableSheet.getCell(0,i).getContents();
          String quantity = writableSheet.getCell(1,i).getContents();
          String firstName = writableSheet.getCell(2,i).getContents();
          String lastName = writableSheet.getCell(3,i).getContents();
          String email = writableSheet.getCell(4,i).getContents();
          String phone = writableSheet.getCell(5,i).getContents();
          String address = writableSheet.getCell(6,i).getContents();
          String zipCode = writableSheet.getCell(7,i).getContents();
          String city = writableSheet.getCell(8,i).getContents();
          String state = writableSheet.getCell(9,i).getContents();
          String cardNum = writableSheet.getCell(10,i).getContents();
          String expMnth = writableSheet.getCell(12,i).getContents();
          String expYr = writableSheet.getCell(13,i).getContents();
          String cvv = writableSheet.getCell(14,i).getContents();

          JavascriptExecutor js = (JavascriptExecutor) driver;
          driver.manage().deleteAllCookies();
  //navigate to Express home page
  driver.navigate().to("https://www.express.com");
  Thread.sleep(2000);

  //Click on shirts
    ReusableMethod_Loggers.mouseHover(driver,"//*[@href = '/mens-clothing']", logger, "Mens");
    Thread.sleep(1500);
    ReusableMethod_Loggers.mouseClick(driver,"//*[contains(@href, '/mens-clothing/shirts/cat410008')]", logger, "Shirts" );
    Thread.sleep(2000);
          js.executeScript("window.scrollBy(0,300)");
   //Click on third link
    ReusableMethod_Loggers.clickByIndex(driver,"//*[@class='_1ddDj _136PD']",2, logger, "Third link");
    Thread.sleep(3000);
   //Click on sizes
    ReusableMethod_Loggers.click(driver,"//*[@value='"+size+"']",logger,"Size");
    Thread.sleep(1500);
          js.executeScript("window.scrollBy(0,500)");
    //Click on Add to bag
    ReusableMethod_Loggers.mouseClick(driver,"//*[text()='Add to Bag']", logger, "Add to bag");
    Thread.sleep(1500);
    ReusableMethod_Loggers.mouseClick(driver,"//*[@aria-label='view bag']", logger, "View Bag");
    Thread.sleep(1500);
    //Select Quantity
    ReusableMethod_Loggers.dropDownMenu(driver,"//*[@id='qdd-0-quantity']",quantity,logger,"Quantity");
    Thread.sleep(3500);
    //Click on Checkout
    ReusableMethod_Loggers.mouseClick(driver,"//*[@alt='Close Button']", logger,"CLICK X");
    Thread.sleep(1500);
          js.executeScript("window.scrollBy(0,500)");
          Thread.sleep(1500);
          ReusableMethod_Loggers.mouseClick(driver,"//*[@id='continue-to-checkout']",logger,"Checkout");
    Thread.sleep(1500);
    ReusableMethod_Loggers.mouseClick(driver,"//*[text()='Checkout as Guest']",logger,"As Guest");
Thread.sleep(2000);
//Fill in all customer information
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='firstname']",firstName,logger,"First name");
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='lastname']",lastName,logger,"Last Name");
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='email']",email,logger,"Email address");
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='confirmEmail']",email,logger,"Reenter Email");
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='phone']",phone,logger,"Phone number");
     ReusableMethod_Loggers.mouseClick(driver,"//*[text()='Continue']",logger,"Click Continue");
     Thread.sleep(2000);
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='shipping.line1']",address,logger,"Address");
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='shipping.postalCode']",zipCode,logger,"Zip");
     ReusableMethod_Loggers.sendKeys(driver,"//*[@name='shipping.city']",city,logger,"City");
     ReusableMethod_Loggers.dropDownMenu(driver,"//*[@name='shipping.state']",state,logger,"State");
     ReusableMethod_Loggers.mouseClick(driver,"//*[text()='Continue']",logger,"Click Continue");
     Thread.sleep(2000);
          ReusableMethod_Loggers.mouseClick(driver,"//*[text()='Continue']",logger,"Click Continue");
          Thread.sleep(1500);
    ReusableMethod_Loggers.sendKeys(driver,"//*[@id='creditCardNumberInput']",cardNum,logger,"Enter card");
    ReusableMethod_Loggers.dropDownMenu(driver,"//*[@name='expMonth']",expMnth,logger,"Exp Month");
    ReusableMethod_Loggers.dropDownMenu(driver,"//*[@name='expYear']",expYr,logger,"Exp Year");
    ReusableMethod_Loggers.sendKeys(driver,"//*[@name='cvv']",cvv,logger,"CVV");
    ReusableMethod_Loggers.mouseClick(driver,"//*[text()='Place Order']",logger,"Place Order");
    Thread.sleep(2000);
    String result = ReusableMethod_Loggers.captureResult(driver,"//*[@id='rvn-note-NaN']",logger,"Capture error");
    Label label = new Label(11,i,result);
          writableSheet.addCell(label);
      }//end of loop
      writableFile.write();
      writableFile.close();
      softAssert.assertAll();

  } //end of test
  }// end of class
