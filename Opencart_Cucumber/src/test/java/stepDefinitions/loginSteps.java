package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import PageObjects.MyAccountPage;
import PageObjects.homepage;
import PageObjects.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utilities.DataReader;

@SuppressWarnings("deprecation")
public class loginSteps {
	
	WebDriver d;
	homepage hp;
	loginPage lp;
	MyAccountPage map;
	
	List<HashMap<String,String>>datamap;

	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() 
	{
	    BaseClass.getlogger().info("goto my Account-- Click on login");
	    hp=new homepage(BaseClass.getdriver());
	    hp.clickMyaccount();
	    hp.clickLogin();
	    		
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String usename, String pwd)
	{
	   lp=new loginPage(BaseClass.getdriver());
	   lp.setEmail(usename);
	   lp.setPassword(pwd);
	   
	   
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() 
	{
	    lp=new loginPage(BaseClass.getdriver());
	    lp.clickLogin();
	    BaseClass.getlogger().info("Clicked on login");
	    
	}

	@Then("the user should be redirected to the MyAccount Page")
	public void the_user_should_be_redirected_to_the_my_account_page() 
	{
	    map=new MyAccountPage(BaseClass.getdriver());
	    boolean actualresult = map.isMyAccPageExist();
	    Assert.assertEquals(actualresult, true);
	    
	    		
	}
	
	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows) 
	{
		try
		{
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		int index=Integer.parseInt(rows)-1;
		String email=datamap.get(index).get("username");
		String pwd=datamap.get(index).get("password");
		String exp_res=datamap.get(index).get("res");
		
		lp=new loginPage(BaseClass.getdriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
		
		lp.clickLogin();
		
		map=new MyAccountPage(BaseClass.getdriver());
		
		try 
		{
		boolean tarpage = map.isMyAccPageExist();
		
		if(exp_res.equals("valid"))
		{
			if(tarpage==true)
			{
				map.clicklogout();
				Assert.assertTrue(true);
				
			}
			else if(tarpage==false)
			{
				Assert.assertTrue(false);
			}
		}
		
		 if(exp_res.equals("Invalid"))
         {
             if(tarpage==true)
             {
            	 map.clicklogout();
                 Assert.assertTrue(false);
             }
             else if(tarpage==false)
             {
                 Assert.assertTrue(true);
             }
         }
		 
		}
		
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}
		
	}
	
	
}
