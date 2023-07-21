package module1_home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomBrokerPage
{

	@FindBy(tagName = "h4")	private WebElement signedInMail;
	@FindBy(xpath = "//input[@value='Log out']") private WebElement logoutBtn;
	
	
	public PomBrokerPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	public String getSignedInMail()
	{
		String lgogedInMail = signedInMail.getText();
		return lgogedInMail;
	}
	
	public void clickOnLogoutBtn()
	{
		logoutBtn.click();
	}
}
