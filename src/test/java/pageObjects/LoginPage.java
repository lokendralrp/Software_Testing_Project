package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement lnklogout;
//----------------------------------------------------
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setpassword(String pw)
	{
		txtPassword.sendKeys(pw);
	}
	
	public void clicklogin() 
	{
		loginbutton.click();
	}

	public boolean MyAcclink() 
	{
		try 
		{
			return lnkMyAccount.isDisplayed();			
		} catch (Exception e) 
		{
			return(false);
		}
	}
	
	public void clicklogout()
	{
		lnklogout.click();
	}
}








