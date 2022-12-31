package mishoPomClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class MishoUtilityClass 
{
	
	
	public static void waitmethod(WebDriver driver,int waittime)
	{
	   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	   Reporter.log("waiting for" +waittime+"ms",true);
	}
	public static String  readDataFromPropertyFIle(String key) throws IOException
	{
	    // create object of property class
		Properties p = new Properties();
		
		// create object of fileInputstream and pass parameter as properties file
		FileInputStream myfile = new FileInputStream("D:\\eclipse-workspace\\practicehomework\\Neostox.properties");

		p.load(myfile);
		
		 String value = p.getProperty("search");
		Reporter.log("Reading "+key+ "from property file",true);
		return value;

	}
	public static void screenshot(WebDriver driver,String screenshot ) throws IOException
	{
		waitmethod(driver, 500);
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	    File dest = new File("D:\\\\Document\\\\Selenium\\\\Screenshot"+screenshot+".png");
	    FileHandler.copy(src, dest);
	    Reporter.log("tacking screenshot ",true);
	        
	}
	public static void scrollIntoView(WebDriver driver,String element)
	{
		waitmethod(driver, 500);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrolling into view ",true);
	}
	
	
	
	

}
