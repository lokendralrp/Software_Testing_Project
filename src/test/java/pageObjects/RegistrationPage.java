package pageObjects;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.HandleMultipleDrp;

public class RegistrationPage extends BasePage
{
	HandleMultipleDrp hmd= new HandleMultipleDrp();
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement rdmale;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstname;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;

//select date of birth
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement drpdate;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement drpmonth;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement drpyear;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement txtConfPassword;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement btnRegister;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement msgConfirmation;	
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//img[@alt='nopCommerce demo store']")
	WebElement logoElement;
	
	public void setGender() 
	{
		rdmale.click();
	}
	
	public void setFirstName(String fname) 
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setDate(String date) 
	{
		hmd.selectOptionsFromDrp(drpdate, date);		
	}
	
	public void setMonth(String month) 
	{
		hmd.selectOptionsFromDrp(drpmonth, month);	
	}
	
	public void setYear(String year) 
	{
		hmd.selectOptionsFromDrp(drpyear, year);	
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pw) 
	{
		txtPassword.sendKeys(pw);
	}
	
	public void setConfPassword(String pw) 
	{
		txtConfPassword.sendKeys(pw);
	}

	public void clickRegister() 
	{
		btnRegister.click();
		//js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnRegister);
	}
	
	public String getConfirmationMsg () 
	{
		try 
		{
			return (msgConfirmation.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
	}
	
	public boolean test_logo()
	{
		return logoElement.isDisplayed();
	}
	
}
