package Day10;

import Reusable_Library.ReusableMethod;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class DataDriven {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        WebDriver driver = ReusableMethod.getDriver();

        //Step 1 = locate excel workbook
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Mortgage_Calc.xls"));
        //Step 2:Locate the excel sheet for this readable workbook
        Sheet readableSheet = readableFile.getSheet(0);
        //Step 3:Make a copy of the readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Mortgage_Calc1.xls"),readableFile);
        //Step 4: define writable sheet for the writable file
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Step 5: Get row count
        int rowCount = writableSheet.getRows();
        //write test steps in for loop
        for (int i = 1; i < rowCount; i++) {
            //Get the cell contents
            //column is hard coded, row is not
            String homeVal = writableSheet.getCell(0,i).getContents();
            String downPay = writableSheet.getCell(1,i).getContents();
            String loanAmt = writableSheet.getCell(2,i).getContents();
            String startMt = writableSheet.getCell(3,i).getContents();
            String startYr = writableSheet.getCell(4,i).getContents();
            //navigate to mortgage calc website
            driver.navigate().to("https://www.mortgagecalculator.org");
            Thread.sleep(1500);
            //Enter home value
            ReusableMethod.sendKeys(driver, "//*[@id='homeval']", homeVal, "Home Value");
            //Enter down payment
            ReusableMethod.sendKeys(driver,"//*[@id='downpayment']",downPay,"Down Payment");
            //Enter Loan amount
            ReusableMethod.sendKeys(driver,"//*[@id='loanamt']",loanAmt,"Loan Amount");
            Thread.sleep(1500);
            //Enter Start Month
            ReusableMethod.dropdown(driver,"//*[@name='param[start_month]']",startMt,"Start Month");
            //Enter Year
            ReusableMethod.sendKeys(driver,"//*[@id='start_year']",startYr,"Start Year");
            //Click Calc
            ReusableMethod.click(driver,"//*[@value='Calculate']","Calculate");
            Thread.sleep(2000);
            String result = ReusableMethod.getText(driver,"//*[@class='left-cell']/following::h3","Monthly payment");
            System.out.println("Monthly payment is " +result);
//store and send it to empty cell
            Label label = new Label(5,i,result);
            //add it to writable sheet
            writableSheet.addCell(label);
        }// end of loop

writableFile.write();
        writableFile.close();
    } // end of method
} // end of class
