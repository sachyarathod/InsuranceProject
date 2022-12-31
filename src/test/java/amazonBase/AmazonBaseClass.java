package amazonBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonBaseClass
{
	
    protected static WebDriver driver;
	public void launchBrowsermisho()
	{
	    System.setProperty("webdriver.chrome.driver", "D:\\Selenium velocity\\chromedriver.exe");
	
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.amazon.in");

	    driver.get("https://www.amazon.in");
	    driver.get("https://www.amazon.in");
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   
	    
	}
}
