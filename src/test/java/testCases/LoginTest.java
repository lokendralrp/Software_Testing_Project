package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass
{
	@Test(groups= {"Sanity", "Master"})
	public void test_login() throws InterruptedException, IOException  
	{
		try 
		{
			logger.info(" ***Starting Login test*** ");
			HomePage hp = new HomePage(driver);
			Thread.sleep(1000);
			hp.clickLogin();
			Thread.sleep(1000);
			logger.info("Clicked on login link");

			LoginPage lp = new LoginPage(driver);
			logger.info("Providing login details");

			lp.setEmail(rb.getString("email"));
			Thread.sleep(1000);
			logger.info("Entered Email");
			lp.setpassword(rb.getString("password"));
			Thread.sleep(1000);
			logger.info("Entered Password");
			lp.clicklogin();
			Thread.sleep(1000);
			logger.info("Clicked login button");
			boolean acclink = lp.MyAcclink();
			Thread.sleep(1000);
			Assert.assertEquals(acclink, true, "test failed");

		} 
		catch (Exception e) 
		{
			captureScreen("LoginTest");
			logger.info("test failed");
			Assert.fail();
		}
		logger.info(" *** Login test finished *** ");
	}
}	
