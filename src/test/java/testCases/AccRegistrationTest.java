package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccRegistrationTest extends BaseClass 
{
	@Test(groups= {"Regression", "Master"})
	public void test_acc_reg() throws InterruptedException, IOException 
	{
		logger.debug("application logs......");
		logger.info("***  Starting AccountRegistrationTest ***");
		try 
		{
			HomePage hp = new HomePage(driver);
			Thread.sleep(2000);
			hp.clickReg();
			logger.info("clicked on register link");

			RegistrationPage rp = new RegistrationPage(driver);
			Thread.sleep(2000);
			rp.setGender();
			logger.info("selected gender");

			rp.setFirstName(randomString().toUpperCase());
			Thread.sleep(2000);
			logger.info("Enter first name");
			rp.setLastName(randomString().toUpperCase());
			Thread.sleep(2000);
			logger.info("Enter last name");

			rp.setDate("1");
			Thread.sleep(2000);
			logger.info("Set date");
			rp.setMonth("1");
			Thread.sleep(2000);
			logger.info("Set month");
			rp.setYear("2001");
			Thread.sleep(2000);
			logger.info("Set Year");

			rp.setEmail(randomString() + "@gmail.com");
			Thread.sleep(2000);
			logger.info("Set eamil");

			String password = randomAlphaNumeric1();
			rp.setPassword(password);
			Thread.sleep(2000);
			logger.info("Enter password");
			rp.setConfPassword(password);
			Thread.sleep(2000);
			logger.info("Confirm password");

			rp.clickRegister();
			Thread.sleep(2000);
			logger.info("Clicked on register button");

			String confmsg = rp.getConfirmationMsg();
			Thread.sleep(2000);
			logger.info("validating Expected msg");
			Assert.assertEquals(confmsg, "Your registration completed", "Registration Failed");
			Thread.sleep(2000);

			rp.clickContinue();
			Thread.sleep(2000);
			logger.info("Clicked continue button");

			boolean logo = rp.test_logo();
			Thread.sleep(2000);
			Assert.assertEquals(logo, true, "test failed");
			logger.info("validated logo");

			System.out.println(driver.getTitle());
			logger.info("captured title");
		} 
		catch (Exception e) 
		{
			//captureScreen("AccRegistrationTest");
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished AccountRegistrationTest ***");
	}

}
