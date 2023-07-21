package Library_Files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import module1_home.PomLogin;

public class BaseClass
{

	public WebDriver driver;
	
	/*
		public void launchBrowser()
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
	
			driver = new ChromeDriver();
		
			driver.get("https://demo.guru99.com/insurance/v1/index.php");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	*/
	
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--headless");
//		options.setHeadless(true);
		DesiredCapabilities cp=new DesiredCapabilities();

		cp.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(cp);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
