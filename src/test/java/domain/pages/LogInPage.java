package domain.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;

import static utilities.GlobalConstants.uriLoginPage;


public class LogInPage extends BasePage<LogInPage>
{
	@FindBy( name= "username")
	WebElement usernameElement;

	@FindBy( name= "password")
	WebElement passwordElement;

	@FindBy(css =("button[data-auto='login']"))
	WebElement loginElement;

	public LogInPage()
	{
		this.driver = driver;
	}

	public static LogInPage open()
	{
		new LogInPage().get(uriLoginPage);
		return PageFactory.initElements(driver, LogInPage.class);
	}

	public void login(String email, String password)
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		usernameElement.sendKeys(email);
		passwordElement.sendKeys(password);
		loginElement.click();
	}
}
