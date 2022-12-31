package mishoPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MishoAdressPage 
{
	@FindBy(xpath = "//span[text()='Deliver to this Address']")private WebElement adressButton;
	
	public MishoAdressPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickonAdressButton(WebDriver driver)
	{
		MishoUtilityClass.waitmethod(driver, 1000);
		adressButton.click();
		Reporter.log("clicking on delivery here button",true);
		Reporter.log("clicking on delivery here button",true);
		Reporter.log("clicking on delivery here button",true);
		Reporter.log("clicking on delivery here button",true);
		Reporter.log("clicking on delivery here button",true);
	}

}
