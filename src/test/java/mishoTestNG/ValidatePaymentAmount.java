package mishoTestNG;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mishoBase.MishoBaseClass;
import mishoPomClass.MishoAdressPage;
import mishoPomClass.MishoHomepage;
import mishoPomClass.MishoPaymentPage;
import mishoPomClass.MishoUtilityClass;
import mishoPomClass.MishoshoesDetailpage;


public class ValidatePaymentAmount extends MishoBaseClass
{
	
	MishoHomepage home;
	MishoshoesDetailpage detail;
	MishoAdressPage adress;
	MishoPaymentPage payment;
	
	@BeforeClass
	public void launchBrowser()
	{
		launchBrowsermisho();  // from base class
		Reporter.log("launching browser",true);
		MishoUtilityClass.waitmethod(driver, 1000);
		home = new MishoHomepage(driver);
		detail = new MishoshoesDetailpage(driver);
		adress = new MishoAdressPage(driver);
		payment = new MishoPaymentPage(driver);
	
	}
	@BeforeMethod
	public void searchProducts() throws IOException, InterruptedException
	{
		MishoUtilityClass.waitmethod(driver, 1000);
		home.searchProducts();
		Thread.sleep(1000);
		MishoUtilityClass.waitmethod(driver, 1000);
		detail.clickOnSize(driver);
		detail.clickonBuynow(driver);
		MishoUtilityClass.waitmethod(driver, 1000);
		adress.clickonAdressButton(driver);
		
	}
  @Test
  public void validatePayment() throws IOException 
  {
	  
	  Assert.assertEquals(payment.validateprice(), MishoUtilityClass.readDataFromPropertyFIle("totalprice"),"if actual and expected price not matching TC failed");
	  
  }
  @AfterMethod
  public void closePayment()
  {
	  payment.clickOnNo();
  }
  @AfterClass
  public void closebrowser()
  {
	  driver.close();
	  Reporter.log("closing browser",true);
  }
}
