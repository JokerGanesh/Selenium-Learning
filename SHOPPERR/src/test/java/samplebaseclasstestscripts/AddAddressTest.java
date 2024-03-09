package samplebaseclasstestscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import baseclass.SampleBaseClass;

public class AddAddressTest extends SampleBaseClass
{
     @Test
     public void addAddress()
     {
       driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-892d40']")).click();
       driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[1]")).click();
       driver.findElement(By.xpath("//div[text()='My Addresses']")).click();
       driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium  css-1hw9j7s']")).click();
       driver.findElement(By.id("Home")).click();
       
       driver.findElement(By.id("Name")).sendKeys("Ganesh C");
       driver.findElement(By.id("House/Office Info")).sendKeys("199");
       driver.findElement(By.id("Street Info")).sendKeys("Labour Colony");
       driver.findElement(By.id("Landmark")).sendKeys("Sathanur Dam");
       
       WebElement countryDropdown=driver.findElement(By.id("Country"));
       Select country=new Select(countryDropdown);
       country.selectByVisibleText("India");
       WebElement stateDropdown=driver.findElement(By.id("State"));
       Select state=new Select(stateDropdown);
       state.selectByVisibleText("Tamil Nadu");
       WebElement cityDropdown=driver.findElement(By.id("City"));
       Select city=new Select(cityDropdown);
       city.selectByVisibleText("Chennai");
       
       driver.findElement(By.id("Pincode")).sendKeys("5600010");
       driver.findElement(By.id("Phone Number")).sendKeys("9384499531");
       driver.findElement(By.id("addAddress")).click();
       Reporter.log("Address Added Successfully",true); 
     }
}
