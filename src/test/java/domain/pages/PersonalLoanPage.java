package domain.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.BasePage;

import static utilities.GlobalConstants.personalLoanPageURL;


public class PersonalLoanPage extends BasePage<PersonalLoanPage>
{
	@FindBy(name = "desiredAmount")
	WebElement desiredAmount;

	@FindBy(name = "loan-purpose")
	WebElement loanPurpose;

	@FindBy(xpath = "//*[text()='Check your rate']")
	WebElement checkYourRate;

	public PersonalLoanPage()
	{
		this.driver = driver;
	}

	public static PersonalLoanPage open()
	{
		new PersonalLoanPage().get(personalLoanPageURL);
		return PageFactory.initElements(driver, PersonalLoanPage.class);
	}

	public void enterAmount(String amount)
	{
		desiredAmount.sendKeys(amount);
	}

	public void enterPurpose(String purpose)
	{
		Select selectPurpose = new Select(loanPurpose);
			selectPurpose.selectByValue("CREDIT_CARD");
	}

	public void checkYourRate()
	{
		checkYourRate.click();
	}
}
