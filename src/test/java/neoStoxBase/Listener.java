package neoStoxBase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import neoStoxPomclass.Utilityproperties;

public class Listener extends BaseclassNew implements ITestListener
{

	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC"+result.getTestName()+" sucess...",true);
	}

	public void onTestFailure(ITestResult result)
	{
		Reporter.log("TC"+result.getTestName()+" failed please try again",true);
		try {
			Utilityproperties.screenshot(driver, result.getTestName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("Tc"+result.getTestName()+" skipped plese cheek");
	}
	 
    
	
}
