package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleMultipleDrp 
{
	public void selectOptionsFromDrp(WebElement ele, String value)
	{
		Select drp= new Select(ele);
		
		List<WebElement> allOptions= drp.getOptions();
		
		for(WebElement option:allOptions)
		{
			if (option.getText().equals(value)) 
			{
				option.click();
			}
		}
		
	}

}
