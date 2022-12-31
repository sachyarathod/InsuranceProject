package amazonPomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AmazonPomCLass 
{
	
	@FindBy(id = "twotabsearchtextbox")private WebElement searchbar;
	
	@FindBy(xpath = "(//div[text()='iphone'])[1]")private WebElement iphone14pro;
	
	public AmazonPomCLass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void searchProducts()
	{
		searchbar.sendKeys("iphone");
		Reporter.log("searching iphone",true);
	}
	public void clickoniphone14pro()
	{
		iphone14pro.click();
		Reporter.log("clicking on iphone 14 pro",true);
	}
}
