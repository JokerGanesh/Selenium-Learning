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

public class SampleBaseClass
{
    public WebDriver driver;
    
    @BeforeClass
    public void openBrowser()
    {
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    ReadProperty read=new ReadProperty();
	    String url=read.fetchProperty("url");
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	    Reporter.log("Navigated To Application Successfully",true);
    }
    @BeforeMethod
    public void login()
    {
    	ReadProperty read=new ReadProperty();
    	String username=read.fetchProperty("username");
    	String password=read.fetchProperty("password");
    	driver.findElement(By.id("loginBtn")).click();
    	driver.findElement(By.id("Email")).sendKeys(username);
    	driver.findElement(By.id("Password")).sendKeys(password);
    	driver.findElement(By.xpath("//span[text()='Login']")).click();
    	Reporter.log("Logged in Successfully",true);
    }
    @AfterMethod
    public void logout()
    {
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-892d40']")).click();
    	driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[6]")).click();
    	Reporter.log("Logged Out Successfully",true);
    }
    @AfterClass
    public void closeBrowser()
    {
    	driver.quit();
    	Reporter.log("Browser Closed Successfully",true);
    }
}