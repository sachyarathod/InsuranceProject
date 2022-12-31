package mishoPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MishoPaymentPage
{
	@FindBy(xpath = "//div[@class='sc-bdvvaa iAFOqX PriceDetailsstyled__PriceRow-sc-1slp7ke-1 ZQgzT PriceDetailsstyled__PriceRow-sc-1slp7ke-1 ZQgzT']")private WebElement totalprice;

	@FindBy(xpath = "//span[text()='No']") private WebElement Nobutton;
	public MishoPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String validateprice()
	{
		String actualPrice = totalprice.getText();
		Reporter.log("Actual price is"+actualPrice,true);
		return actualPrice;
		
	}
	public void clickOnNo()
	{
		Nobutton.click();
	}
}
