package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class AddDetailsTest extends BaseClass
{
  @Test
  public void enterDetails()
  {
	  Reporter.log("successfully added",true);
  }
}
