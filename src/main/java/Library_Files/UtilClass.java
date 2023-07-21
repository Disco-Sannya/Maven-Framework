package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilClass
{

	public static String getDataFromPF(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Sunny\\eclipse-workspace\\MavenProjectFinal\\PropertyFile.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}

	public static void captureScreenshot(WebDriver d, String testcaseName) throws IOException
	{
		File Source = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\Sunny\\eclipse-workspace\\MavenProjectFinal\\screenshot\\"+testcaseName+".jpg");
		FileHandler.copy(Source, Dest);
	}

}
