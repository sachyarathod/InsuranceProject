package amazonTestNg;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazonBase.AmazonBaseClass;
import amazonPomclass.AmazonIphonePage;
import amazonPomclass.AmazonPhoneDetailsPage;
import amazonPomclass.AmazonPomCLass;
import amazonPomclass.UtilityClassAmazon;
import mishoPomClass.MishoUtilityClass;

public class AmazonTestNG extends AmazonBaseClass
{

	AmazonPomCLass home;
	AmazonIphonePage iphone;
	AmazonPhoneDetailsPage detail;
  @BeforeClass
  public void launchbrowser()
  {
	  launchBrowsermisho(); // from base class
	  home = new AmazonPomCLass(driver);
	  iphone = new AmazonIphonePage(driver);
	  detail = new AmazonPhoneDetailsPage(driver);
	  
  }
  @BeforeMethod
  public void login() throws InterruptedException
  {
	  home.searchProducts();
	  Thread.sleep(1500);
	  home.clickoniphone14pro();
	  iphone.clickonIphone128gb(driver);
	  Thread.sleep(1000);
	  
  }


  @Test
  public void validateNameandStorage() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  Thread.sleep(1000);
	  Assert.assertEquals(detail.validateNameStorage(driver), MishoUtilityClass.readDataFromPropertyFIle("text"));
	  UtilityClassAmazon.screenshot(driver, detail.validateNameStorage(driver));
	  Reporter.log("Validating actual and expected result ",true);
  }
  
  @AfterMethod
  public void signout() throws InterruptedException
  {
	  Thread.sleep(3000);
	  detail.clickonBuyNow(driver);
	  
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException
  {
	  Thread.sleep(2000);
	  driver.close();
	  Reporter.log("Closing browser",true);
  }
}
