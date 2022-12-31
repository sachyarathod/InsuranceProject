package mishoBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MishoBaseClass 
{
	protected WebDriver driver;
	public void launchBrowsermisho()
	{
	    System.setProperty("webdriver.chrome.driver", "D:\\Selenium velocity\\chromedriver.exe");
	
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.meesho.com/");
	}
}
