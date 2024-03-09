package samplebaseclasstestscripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import baseclass.SampleBaseClass;

public class DeleteAddressTest extends SampleBaseClass
{
    @Test
    public void deleteAddress()
    {
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-892d40']")).click();
        driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[1]")).click();
        driver.findElement(By.xpath("//div[text()='My Addresses']")).click();
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium  css-1hw9j7s']")).click();
    	Reporter.log("Address Deleted Successfully",true);
    }
}
