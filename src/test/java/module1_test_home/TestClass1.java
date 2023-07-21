package module1_test_home;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilClass;
import module1_home.PomBrokerPage;
import module1_home.PomLogin;

public class TestClass1 extends BaseClass
{

	PomLogin login;
	PomBrokerPage broker;
	
	String TestCaseName;
	
	@BeforeClass
	public void initializeBrowser()
	{
		launchBrowser();
		login = new PomLogin(driver);
		broker = new PomBrokerPage(driver);
		
	}

	@BeforeMethod
	public void loginToApp() throws IOException
	{
		login.enterUsername(UtilClass.getDataFromPF("Username"));
		login.enterPassword(UtilClass.getDataFromPF("Pass"));
		login.clickOnSignInBtn();
	}

	@Test
	public void verifySignedInAsMail() throws IOException
	{
		TestCaseName = "verifySignedInAsMail";
		String actualMail = broker.getSignedInMail();
		String expectedMail = UtilClass.getDataFromPF("expectedsignedInMail");

		Assert.assertEquals(actualMail, expectedMail);
	}

	@Test
	public void VerifyTitle() throws IOException
	{
		TestCaseName = "VerifyTitle";
		String actualTitle = driver.getTitle();
		String expectedTitle = UtilClass.getDataFromPF("expectedBrokerPageTitle");
	
		Assert.assertTrue(actualTitle.equals(expectedTitle));
	}
	
	
	@AfterMethod
	public void logoutFromApp(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			UtilClass.captureScreenshot(driver, TestCaseName);
		}	
		
		broker.clickOnLogoutBtn();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
}
