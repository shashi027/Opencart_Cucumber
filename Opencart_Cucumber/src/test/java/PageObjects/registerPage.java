package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage extends BasePage {

	public registerPage(WebDriver d) {
		super(d);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLasttname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name=\"agree\"]")
	WebElement chckbpolicy;

	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstname(String fname) 
	{
		txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) 
	{
		txtLasttname.sendKeys(lname);
	}

	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String Telephone) 
	{
		txtTelephone.sendKeys(Telephone);
	}

	public void setPassword(String Password) 
	{
		txtPassword.sendKeys(Password);
	}

	public void setConfirmPassword(String CPassword) 
	{
		txtConfirmPassword.sendKeys(CPassword);
	}

	public void checkpolicy() 
	{
		chckbpolicy.click();
	}

	public void clickContinue() 
	{
		btnContinue.click();
	}

	public String getConfirmationMsg() 
	{
		try 
		{
			return msgConfirmation.getText();
		} 
		catch (Exception e) 
		{
        return (e.getMessage());
		}
	}

}
