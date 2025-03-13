package Factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BaseClass {
	
	static WebDriver d;
	static Properties p;
	static Logger logger;

	public static Properties getproperties() throws IOException
	{
		//FileReader file= new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		return p;
	}
	
	@SuppressWarnings("deprecation")
	public static WebDriver initialisebrowser() throws IOException
	{
		
		//Remote
		if(getproperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//OS
			
			if(getproperties().getProperty("os").equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			
			else if(getproperties().getProperty("os").equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			
			else if(getproperties().getProperty("os").equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
		
			else
			{
				System.out.println("Invalid OS type");
			}
			
			
			//Browser
			
			if(getproperties().getProperty("browser").equalsIgnoreCase("chrome"))
			{
				capabilities.setBrowserName("chrome");
			}
			else if(getproperties().getProperty("browser").equalsIgnoreCase("edge"))
			{
				capabilities.setBrowserName("MicrosoftEdge");
			}
			else 
			{
				System.out.println("Invalid Browser type");
			}
			
			d=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
		
		
		//Local
		
		else if(getproperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//browser
			if(getproperties().getProperty("browser").equalsIgnoreCase("chrome"))
			{
				d=new ChromeDriver();
			}
			else if(getproperties().getProperty("browser").equalsIgnoreCase("edge"))
			{
				d=new EdgeDriver();
			}
			else
			{
				System.out.println("Invalid browser");
			}
		}
		
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		//d.manage().window().maximize();
		return d;
		
		
	}
	
	
	
	public static WebDriver getdriver()
	{
		return d;
	}
	
	public static Logger getlogger()
	{
		logger=LogManager.getLogger();
		return logger;
	}
	
	public static String randomeString()
	{
		
		@SuppressWarnings("deprecation")
		String GenString=RandomStringUtils.randomAlphabetic(5);
		return GenString;
	}
	
	public static  String randomeNumber()
	{
		
		@SuppressWarnings("deprecation")
		String GenString=RandomStringUtils.randomNumeric(10);
		return GenString;
		
	}
	public static  String randomAlphaNumeric()
	{
		
		@SuppressWarnings("deprecation")
		String alp=RandomStringUtils.randomAlphabetic(5);
		@SuppressWarnings("deprecation")
		String num=RandomStringUtils.randomNumeric(10);
		return alp+num;
		
	}
	
}
