package neoStoxPomclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utilityproperties 
{
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		// create object of property class --- java 
		Properties pop = new Properties();
		
		// create object of fileInputstream  and pass property path as a parameter
		FileInputStream myfile = new FileInputStream("D:\\eclipse-workspace\\practicehomework\\Neostox.properties");
	
		// load file 
		pop.load(myfile);
		
		String value = pop.getProperty(key);
		Reporter.log("Reading "+key+" from property file",true);
		return value;
	}
	public static void scrolllintoview(WebDriver driver,WebElement element)
	{
		wait(driver, 500);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrolling in to view", true);
	
	
	
	
	
	
	
	}
	
	public static void screenshot(WebDriver driver,String screenshot) throws IOException
	{
		 wait(driver, 500);
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File("D:\\Document\\Selenium\\Screenshot"+screenshot+".png");
		 FileHandler.copy(src, dest);
		 Reporter.log("tacking screenshot ", true);
	}
	
	public static void wait(WebDriver driver,int waitTime)
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		 Reporter.log("waiting for"+waitTime+"ms" , true);
	}
	
	
	
	
	

}
