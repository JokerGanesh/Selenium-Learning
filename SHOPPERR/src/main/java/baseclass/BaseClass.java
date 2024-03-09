package baseclass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import fileutility.ReadProperty;
import genericutility.WebDriverUtility;
import objectrepository.LoginPage;
public class BaseClass 
{
	 public WebDriver driver;
	 public static WebDriver sdriver;
	 @BeforeClass
	 public void openBrowser()
	 {
		driver =new ChromeDriver();
	    sdriver=driver;
		driver.manage().window().maximize();
		
		ReadProperty properties =new ReadProperty();
		String url=properties.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));	
		Reporter.log("Browser opened Successfully ",true);
	 }
	@BeforeMethod
	public void login()
	{
		//object creation
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		ReadProperty properties =new ReadProperty();
		//Getting properties
		String username =properties.fetchProperty("username");
		String password=properties.fetchProperty("password");
		//driver.findElement(By.id("Email")).sendKeys(username);
		//driver.findElement(By.id("Password")).sendKeys(password);
		//driver.findElement(By.xpath("//span[text()='Login']")).click();
		//POM Code
		LoginPage loginpage=new LoginPage(driver);
		//loginpage.getEmailTextField().sendKeys(username);
		//loginpage.getPasswordTextField().sendKeys(password);
		//loginpage.getLoginButton().click();
		
		//Logging in
		webDriverUtility.sendText(loginpage.getEmailTextField(), username);
		webDriverUtility.sendText(loginpage.getPasswordTextField(), password);
		webDriverUtility.clickOnElement(loginpage.getLoginButton());	
	}
	@AfterMethod
	public void logout()
	{
			driver.findElement(By.xpath("//div[text()='I']")).click();
			driver.findElement(By.xpath("//*[name()='svg' and @data-testid='LogoutIcon']")).click();
			Reporter.log("Logged out Successfully",true);
	}
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("Browser Closed Successfully",true);
		driver.quit();	
	}
}