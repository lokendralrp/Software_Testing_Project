package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		try 
		{
			logger.info("Starting LoginDataDrivenTest");
			
			HomePage hp=new HomePage(driver);
			hp.clickLogin();
			logger.info("Clicked on login link");
			
			LoginPage lp= new LoginPage(driver);
			logger.info("Providing login details");
			
			lp.setEmail(email);Thread.sleep(1000);
			logger.info("Entered Email");
			lp.setpassword(pwd);Thread.sleep(1000);
			logger.info("Entered Password");
			lp.clicklogin();Thread.sleep(1000);
			logger.info("Clicked login button");
			
			boolean acclink= lp.MyAcclink();   Thread.sleep(1000);
			
			if (exp.equals("Valid")) 
			{
				if (acclink == true) 
				{
					lp.clicklogout();
					Assert.assertTrue(true);
				} 
				else 
				{
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) 
			{
				if (acclink == true) 
				{
					
					lp.clicklogout();
					Assert.assertTrue(false);
				} 
				else 
				{
					Assert.assertTrue(true);
				}
			}
		} 
		catch (Exception e) 
		{
			Assert.fail();
		}
		logger.info(" Finished Login data driven Test");

		
		
		
		
	}

}
