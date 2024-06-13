package testNgWorking;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkingWithTestNg 
{
	@Test(priority = 1)
	public void testScript1()
	{
		Reporter.log("Test script 1 executed succesfully",true);
	}
	
	@Test(priority = 2)
	public void testScript2()
	{
		Reporter.log("Test script 2 executed succesfully",true);
	}
	
	@Test(priority = 3)
	public void testScript3()
	{
		Reporter.log("Test script 3 executed succesfully",true);
	}
	
}
