package amazonPomclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityClassAmazon 
{
	
	
	// read test data from excel sheet
	public static String readDataFromExcel(WebDriver driver, int row,int cell) throws EncryptedDocumentException, IOException
	{
		Wait(driver, 1000);
		File myfile = new File("D:\\Selenium velocity\\poi\\Myfiles.xlsx");

	    String value = WorkbookFactory.create(myfile).getSheet("Sheet2").getRow(row).getCell(cell).getStringCellValue();
	    
	    Reporter.log("Reading test data from cxcel sheet ",true);
	    return value;
	}
	
	// common method for screenshot
	public static void screenshot(WebDriver driver,String screenshot) throws IOException
	{
		 Wait(driver, 500);
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 File dest = new File("D:\\Document\\Selenium\\Screenshot"+screenshot+".png");
		 
		 FileHandler.copy(src, dest);
		 Reporter.log("Tacking screenshot ",true);
	}
	
	//  for ScrollIntoView to the particular element
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		Wait(driver, 500);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		Reporter.log("Scrolling into view",true);
	}
	
	// for wait 
	public static void Wait(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		Reporter.log("Wait for "+waitTime+" MS",true);
	}

}
