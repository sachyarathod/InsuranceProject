package amazonPomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AmazonIphonePage 
{
	// declare and find element present on web-page 
	@FindBy(xpath = "(//img[@class='_bXVsd_image_1pfbQ'])[2]")private WebElement iphone128gb;
	
	// use constructor for initialization of variable
	public AmazonIphonePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// perform operation on variable
	public void clickonIphone128gb(WebDriver driver)
	{
		UtilityClassAmazon.Wait(driver, 1000);
		iphone128gb.click();
		Reporter.log("clicking on iphone128gb ",true);
	}

}
