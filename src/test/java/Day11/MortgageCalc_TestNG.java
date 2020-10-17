package Day11;

import Reusable_Library.ReusableMethod;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MortgageCalc_TestNG {
//Set global variables so that they can be used in all tests
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;
//Start before suite with preconditions
@BeforeSuite
public void setPreConditions() throws IOException, BiffException {
    driver = ReusableMethod.getDriver();

    //Step 1 = locate excel workbook
    readableFile = Workbook.getWorkbook(new File("src/main/resources/Mortgage_Calc.xls"));
    //Step 2:Locate the excel sheet for this readable workbook
    readableSheet = readableFile.getSheet(0);
    //Step 3:Make a copy of the readable file
    writableFile = Workbook.createWorkbook(new File("src/main/resources/Mortgage_Calc1.xls"),readableFile);
    //Step 4: define writable sheet for the writable file
    writableSheet = writableFile.getSheet(0);
    //Step 5: Get row count
    rowCount = writableSheet.getRows();
} // end of Before Suite
@Test
    public void getMonthlyPayment() {
    //start of for loop
    for (int i = 1; i <rowCount; i++) {
        String homeVal = writableSheet.getCell(0,i).getContents();
        String downPay = writableSheet.getCell(1,i).getContents();
        String loanAmt = writableSheet.getCell(2,i).getContents();
        String startMnth = writableSheet.getCell(3,i).getContents();
        String StartYr = writableSheet.getCell(4,i).getContents();
    }//end of for loop



}//end of test
} // end of class
