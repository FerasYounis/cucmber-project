package domain.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;


public class CreateNewAccountPage extends BasePage<CreateNewAccountPage>
{
	@FindBy(name ="username")
	WebElement usernameElement;

	@FindBy(name = "password")
	WebElement passwordElement;

	@FindBy(name = "agreements")
	WebElement agreeElement;

	@FindBy(css = ("div[class='sc-kTCsyW sc-dvUynV dXWGfZ joRTNm']"))
	WebElement agreeElement2;

	@FindBy(css =("button[class='sc-Arkif ebrFvu section']") )
	WebElement submitElement;

	public static CreateNewAccountPage open()
	{
		return PageFactory.initElements(driver, CreateNewAccountPage.class);
	}

	public CreateNewAccountPage()
	{
		this.driver = driver;
	}

	public void enterNewEmail(String emailWithRandomNumber)
	{
		usernameElement.sendKeys(emailWithRandomNumber);
	}

	public void enterPassworkd(String password)
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		passwordElement.sendKeys(password);
	}


	public void checkAgreebox()
	{
		agreeElement2.click();
	}

	public void submit()
	{
		submitElement.click();
	}
}
