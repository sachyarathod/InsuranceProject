package neoStoxPomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class Neostoxpassword 
{
    @FindBy(id = "txt_accesspin")private WebElement passwordfield;
	
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitbutton;
	
	public Neostoxpassword(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterpassword(WebDriver driver,String password)
	{
		Utilityproperties.wait(driver, 1000);
		passwordfield.sendKeys(password);
		Reporter.log("Entering passwird ",true);
	}
	
	public void clickonsubmitbutton(WebDriver driver)
	{
		Utilityproperties.wait(driver, 1000);
		submitbutton.click();
		Reporter.log("click on submit button",true);
	}
	
	
	
	

}
