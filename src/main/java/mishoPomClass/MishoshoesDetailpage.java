package mishoPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MishoshoesDetailpage
{
	
	@FindBy(xpath = "//span[text()='IND-7']")private WebElement shoessize;
	
	@FindBy(xpath = "//span[text()='Buy Now']")private WebElement buyNowButton;
	
	public MishoshoesDetailpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSize(WebDriver driver)
	{
		MishoUtilityClass.waitmethod(driver, 1000);
		shoessize.click();
		Reporter.log("Clicking on sixe ",true);
		
		
	}
	public void clickonBuynow(WebDriver driver)
	{
	    MishoUtilityClass.waitmethod(driver, 1000);
		buyNowButton.click();
		Reporter.log("Clicking on buy now button",true);
	}
}
