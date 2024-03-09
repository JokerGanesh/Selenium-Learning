package demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class DemoTest 
{
@Test(retryAnalyzer = listnerimplementation.RetryListner.class)
public void loginTest()
{
	Assert.fail();
	Reporter.log("Login Test is Executing",true);
}
}
