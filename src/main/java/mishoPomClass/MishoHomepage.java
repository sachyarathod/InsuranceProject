package mishoPomClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MishoHomepage 
{
	
	@FindBy(xpath = "//p[text()='Unique Attractive Men Sports Shoes']")private WebElement searchBar;
	@FindBy(xpath = "(//div[@class='sc-bdvvaa iAawii autosuggest autosuggest__desk autosuggest autosuggest__desk']//div)[1]")private WebElement adidasshoes;
	
	public MishoHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void searchProducts() throws IOException
	{
		searchBar.click();
		Reporter.log("clicking on shoes",true);
	}
	
}
