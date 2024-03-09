package samplebaseclasstestscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import baseclass.SampleBaseClass;

public class UpdateAddressTest extends SampleBaseClass
{
     @Test
     public void updateAddress()
     {
         driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-892d40']")).click();
         driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[1]")).click();
         driver.findElement(By.xpath("//div[text()='My Addresses']")).click();
         driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textSuccess MuiButton-sizeSmall MuiButton-textSizeSmall  css-n3v15g']")).click();
         driver.findElement(By.id("Home")).click();
         
         driver.findElement(By.id("Name")).clear();
         driver.findElement(By.id("Name")).sendKeys("Joker");
         driver.findElement(By.id("House/Office Info")).clear();
         driver.findElement(By.id("House/Office Info")).sendKeys("169");
         driver.findElement(By.id("Street Info")).clear();
         driver.findElement(By.id("Street Info")).sendKeys("Alagiri Nagar");
         driver.findElement(By.id("Landmark")).clear();
         driver.findElement(By.id("Landmark")).sendKeys("Vadapalani");
         
         WebElement countryDropdown=driver.findElement(By.id("Country"));
         Select country=new Select(countryDropdown);
         country.selectByVisibleText("USA");
         WebElement stateDropdown=driver.findElement(By.id("State"));
         Select state=new Select(stateDropdown);
         state.selectByVisibleText("Punjab");
         WebElement cityDropdown=driver.findElement(By.id("City"));
         Select city=new Select(cityDropdown);
         city.selectByVisibleText("Madurai");
         
         driver.findElement(By.id("Pincode")).clear();
         driver.findElement(By.id("Pincode")).sendKeys("432101");
         driver.findElement(By.id("Phone Number")).clear();
         driver.findElement(By.id("Phone Number")).sendKeys("9943420538");
         driver.findElement(By.id("Update Address")).click();
         Reporter.log("Address Added Successfully",true); 
     }
}
