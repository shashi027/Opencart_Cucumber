package PageObjects;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver d;
	
	
	
	public BasePage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d, this);
	}
	

	
	
}
