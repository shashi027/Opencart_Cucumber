package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import PageObjects.MyAccountPage;
import PageObjects.homepage;
import PageObjects.registerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class registration_steps {
	
	
	WebDriver d;
	homepage hp;
	MyAccountPage map;
	registerPage regpage;
	
	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() 
	{
	    BaseClass.getlogger().info("Goto to my account and click on register");
	    hp=new homepage(BaseClass.getdriver());
	    hp.clickMyaccount();
	    hp.clickRegister();
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);
		
		regpage= new registerPage(BaseClass.getdriver());
		regpage.setFirstname(datamap.get("firstName"));
		regpage.setLastname(datamap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		regpage.setTelephone(datamap.get("telephone"));
		regpage.setPassword(datamap.get("password"));
		regpage.setConfirmPassword(datamap.get("password"));
		
		
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() 
	{
	   regpage=new registerPage(BaseClass.getdriver());
	   regpage.checkpolicy();
	   
	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() 
	{
	    regpage=new registerPage(BaseClass.getdriver());
	    regpage.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() 
	{
		map=new MyAccountPage(BaseClass.getdriver());
		boolean msg = map.is_my_Acc_created();
		System.out.println(msg);
		Assert.assertEquals(msg, true);
		
	}

}
