package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass 
{
	public static WebDriver driver;
	public Logger logger;
	ChromeOptions chromeOptions;
	EdgeOptions edgeOptions;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master", "Sanity", "Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");
		logger= LogManager.getLogger(this.getClass());
		
//to remove sentence "chrome is being controlled by automated software"	while automation-- use below code	
	//setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		if(br.equals("chrome"))
		{	
			WebDriverManager.chromedriver().setup();
			chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			//chromeOptions.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
			driver= new ChromeDriver(chromeOptions);
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			edgeOptions=new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			//edgeOptions.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
			driver= new EdgeDriver(edgeOptions);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master", "Sanity", "Regression"})
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumString=RandomStringUtils.randomNumeric(10);
		return generatedNumString;
	}
	
	public String randomAlphaNumeric1()//FOR PASSWORD
	{
		String st=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(3);
		return (st+"@"+num);
	}
	
	public String randomAlphaNumeric2()//FOR EMAIL
	{
		String generatedAlphanumString= RandomStringUtils.randomAlphanumeric(7);
		return generatedAlphanumString;
	}
	
	public String captureScreen(String testname) throws IOException
	{
		/*SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt=new Date();
		String timeStamp= 	df.format(dt);*/
		
							//OR (IN PLACE OF ABOVE 3 LINES WE CAN WRITE BELOW 1 LINE)
		
		String timeStamp=new SimpleDateFormat("yyyy/MM/dd_hh:mm:ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//String timeStamp=new SimpleDateFormat("yyyy/MM/dd_hh:mm:ss").format(new Date());
		String destination= System.getProperty("user.dir") + "\\screenshots\\" + testname + "_" + timeStamp + ".png";
		//String destination="./screenshots\\testname_"+ timestamp +".png" 
		try 
		{
			FileUtils.copyFile(source, new File(destination));	
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return destination;	
	}
	
	
	
	
	
	
}
