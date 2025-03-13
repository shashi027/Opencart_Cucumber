package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver d) 
	
	{
		super(d);
		
	}

	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MsgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[normalize-space()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//div[@id='content']//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement reg_Suc_mes;
	
	
	public boolean isMyAccPageExist()
	{
		try
		{
		return MsgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public boolean is_my_Acc_created()
	{
		try 
		{
			return reg_Suc_mes.isDisplayed();
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public void clicklogout()
	{
		lnkLogout.click();
	}
	
}
