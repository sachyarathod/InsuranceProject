package neoStoxPomclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeostoxHomepage 
{
	
    @FindBy(xpath = "(//a[text()='OK'])[2]")private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement closebutton;
	@FindBy(xpath = "(//span[text()='Hi Sachin Rathod'])[1]")private WebElement userid;
	@FindBy(xpath = "//span[text()='Rs.5,00,000.00']")private WebElement accbalance;
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logout;
	@FindBy(xpath = "(//span[@style='display: inline-block; text-align: center;'])[2]")private WebElement analyzersButton;
	@FindBy(xpath = "//span[text()='Index Analyzer - Segment View']")private WebElement segmentbutton;
	@FindBy(xpath = "//span[text()='6.00%']")private WebElement weightagePer;
	public NeostoxHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void cliclonOkButton(WebDriver driver) throws InterruptedException
	{
		if(okButton.isDisplayed())
		{
		Utilityproperties.wait(driver, 500);
		okButton.click();
		Reporter.log("Handaling pop up", true);
		Reporter.log("clicking on ok button popup", true);
		Utilityproperties.wait(driver, 1000);
		closebutton.click();
		Reporter.log("clicking on close button poup",true);
		}
		else
		{
			Reporter.log("there is no pop up ",true);
			Thread.sleep(500);
		}
	}
	public String getuserid(WebDriver driver) throws IOException
	{
		Utilityproperties.wait(driver, 500);
		String Actualuserid = userid.getText();
		Reporter.log("getting actual userid ",true);
		String realUserName = Actualuserid.substring(3);
		Reporter.log("actual user id is  "+realUserName,true);
		return Actualuserid;
	}
	public String getaccountbalance(WebDriver driver)
	{
		Utilityproperties.wait(driver, 500);
		String AccountBalance = accbalance.getText();
		Reporter.log(" account balance is "+AccountBalance,true);
		
		
		
		
		
		
		
		return AccountBalance;
	}
	
	public void clickonUserid(WebDriver driver)
	{
		Utilityproperties.wait(driver, 1000);
		userid.click();
		Reporter.log(" clicking on userid", true);
	}
	public void clickonLogout(WebDriver driver)
	{
		Utilityproperties.wait(driver, 1000);
		logout.click();
		Reporter.log(" clicking on logout button", true);
	}
	public void clickonAnalyzerbutton(WebDriver driver)
	{
		Utilityproperties.wait(driver, 1000);
		analyzersButton.click();
		Reporter.log("clicking on analyzers  button",true);
	}
	public void clickonSegmentButton(WebDriver driver)
	{
		Utilityproperties.wait(driver, 1000);
		segmentbutton.click();
		Reporter.log("clicking on segment button ",true);
		
	}
	public String getActAutomobileWeightage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String actualWeightage = weightagePer.getText();
		Thread.sleep(1000);
		Reporter.log("getting actual automobile weightage "+actualWeightage,true);
		return actualWeightage;
	}

}
