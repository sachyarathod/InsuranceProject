package neoStoxTestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase.BaseclassNew;
import neoStoxPomclass.NeostoxHomepage;
import neoStoxPomclass.NeostoxLoginpage;
import neoStoxPomclass.Neostoxpassword;
import neoStoxPomclass.Utilityproperties;

@Listeners(neoStoxBase.Listener.class)
public class ValidatingAccountBalance extends BaseclassNew 
{
	NeostoxLoginpage login;
	Neostoxpassword passowrd;
	NeostoxHomepage home;

	@BeforeClass
	public void launchbr() throws IOException
	{
		launchbrowser(); // from base class
		Reporter.log("lanching browser", true);
		login = new NeostoxLoginpage(driver);
		passowrd = new Neostoxpassword(driver);
		home = new NeostoxHomepage(driver);	
	}
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.clicKonsigninbutton(driver);
		login.EnterMobilenumber(driver, Utilityproperties.readDataFromPropertyFile("mobileNumber"));
		login.clickonsigninbutton2(driver);
		Utilityproperties.wait(driver, 1000);
		
		passowrd.enterpassword(driver, Utilityproperties.readDataFromPropertyFile("password"));
		Thread.sleep(3000);
		passowrd.clickonsubmitbutton(driver);
		Thread.sleep(5000);
		
		home.cliclonOkButton(driver);
		Utilityproperties.wait(driver, 1000);		
	}
	@Test
	 public void validateuserid() throws IOException 
	  {
		Utilityproperties.wait(driver, 1000);
		  
		 Assert.assertEquals(home.getuserid(driver), Utilityproperties.readDataFromPropertyFile("userName"),"if acutal and expected both are not equal TC failed");
		 Utilityproperties.screenshot(driver, home.getuserid(driver));
	  }
   @Test(priority = -1)
    public void validateAccBalance() throws IOException 
     {
	   Utilityproperties.wait(driver, 1000);
	  
	   Assert.assertNotNull(home.getaccountbalance(driver),"if account balance is null TC faled");
	   Assert.fail();
 
      }
    @AfterMethod
    public void logout()
     {
    	Utilityproperties.wait(driver, 1000);
	   home.clickonUserid(driver);
	   Utilityproperties.wait(driver, 1000);
	   home.clickonLogout(driver);
     }
    @AfterClass
    public void closeBrowser()
      {
    	Utilityproperties.wait(driver, 1000);
	   driver.close();
     }
  
}
