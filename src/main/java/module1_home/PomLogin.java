package module1_home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLogin
{

	@FindBy(id = "email")	private WebElement username;
	@FindBy(id = "password")	private WebElement password;
	@FindBy(xpath = "//input[@name='submit']")	private WebElement signInBtn;
	
	public PomLogin(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	public void enterUsername(String un)
	{
		username.sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		password.sendKeys(pw);
	}
	
	public void clickOnSignInBtn()
	{
		signInBtn.click();
	}
	
	
}
