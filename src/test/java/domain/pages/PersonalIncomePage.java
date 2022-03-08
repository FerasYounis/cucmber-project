package domain.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;


public class PersonalIncomePage extends BasePage<PersonalIncomePage>
{
	@FindBy(name = "borrowerIncome")
	WebElement incomeElement;

	@FindBy(name = "borrowerAdditionalIncome")
	WebElement additionalIncomeElement;

	@FindBy(xpath = "//*[text()='Continue']")
	WebElement continueElement;

	public static PersonalIncomePage open()
	{
		return PageFactory.initElements(driver, PersonalIncomePage.class);
	}

	public PersonalIncomePage()
	{
		this.driver = driver;
	}

	public void enterAnnualAmount(String annualAmount)
	{
		incomeElement.sendKeys(annualAmount);
	}

	public void enterAdditionalAmount(String additionalAmount)
	{
		additionalIncomeElement.sendKeys(additionalAmount);
	}

	public void submit()
	{
		continueElement.click();
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		continueElement.click();
	}
}
