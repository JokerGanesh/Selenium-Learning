package listnerimplementation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseclass.BaseClass;

public class ListnerClass extends BaseClass implements ISuiteListener,ITestListener
{
@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub	
	Reporter.log(suite.getName()+" has finished",true);
    }
@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log(suite.getName()+" has Started",true);
    }
@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName()+" is started",true);
	}
@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	Reporter.log(result.getName()+" is successfully executed",true);

    }
@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	Reporter.log(result.getName()+" is skipped",true);

    }
@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		File path=new File("./FailedScreenshots/"+result.getName()+".png");
		TakesScreenshot ts=(TakesScreenshot) sdriver;
		File ss=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(ss, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log(result.getName()+"is failed and successfully captured the screenshot",true);
}
}