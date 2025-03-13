package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

	WebDriver d;
	Properties p;
	
	@Before
	public void setup() throws IOException
	{
		d=BaseClass.initialisebrowser();
		p=BaseClass.getproperties();
		d.get(p.getProperty("appURL"));
		d.manage().window().maximize();
		
	}
	
	@After
	public void teardown()
	{
		d.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario Scenario)
	{
		if(Scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)d;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			Scenario.attach(screenshot, "image/png", Scenario.getName());
		}
		
		
		
	}
	
	
}
