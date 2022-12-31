package amazonPomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AmazonPhoneDetailsPage
{
	
	
	@FindBy(xpath = "//span[text()='        Apple iPhone 12 (128GB) - Blue       ']")private WebElement iphoedetail;

	@FindBy(xpath = "((//div[@class='a-accordion-inner accordion-row-content'])[2]//div)[130]")private WebElement buynow;
	public AmazonPhoneDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String  validateNameStorage(WebDriver driver)
	{
		UtilityClassAmazon.Wait(driver, 1000);
		String actualResult = iphoedetail.getText();
		Reporter.log("actual name and storage of iphone is "+actualResult,true);
		return actualResult;
		
	}
	public void clickonBuyNow(WebDriver driver)
	{
		UtilityClassAmazon.Wait(driver, 1000);
		buynow.click();
		Reporter.log("Clicking on your account button",true);
	}
	
}
