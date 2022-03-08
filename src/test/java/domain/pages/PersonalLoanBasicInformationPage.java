package domain.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;


public class PersonalLoanBasicInformationPage extends BasePage<PersonalLoanBasicInformationPage>
{
	@FindBy(name = "borrowerFirstName")
	WebElement firstNameElement;

	@FindBy(name = "borrowerLastName")
	WebElement lastNameElement;

	@FindBy(name = "borrowerStreet")
	WebElement addressElement;

	@FindBy(id = "/geosuggest__input--borrowerStreet")
	WebElement addressElement2;

	@FindBy(name = "borrowerZipCode")
	WebElement zipCodeElement;

	@FindBy(name = "borrowerDateOfBirth")
	WebElement birthdayElement;

	@FindBy(name = "borrowerCity")
	WebElement cityElement;

	@FindBy(name = "borrowerState")
	WebElement stateElement;

	@FindBy(xpath = "//*[text()='Continue']")
	WebElement continueElement;

	public PersonalLoanBasicInformationPage()
	{
		this.driver = driver;
	}

	public static PersonalLoanBasicInformationPage open()
	{
		return PageFactory.initElements(driver, PersonalLoanBasicInformationPage.class);
	}

	public void enterFirstName(String firstName)
	{
		firstNameElement.sendKeys(firstName);
	}

	public void enterLastName(String lastName)
	{
		lastNameElement.sendKeys(lastName);
	}

	public void enterHomeAddress(String homeAddress)
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		addressElement.sendKeys(homeAddress);


		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		lastNameElement.click();
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void enterBirthday(String birthday)
	{
		birthdayElement.sendKeys(birthday);
	}
	public void enterCity(String city){
		cityElement.sendKeys(city);
	}

	public void enterState(String state){
		stateElement.sendKeys(state);
	}

	public void enterZipCodeElement(String zipcode){
		zipCodeElement.sendKeys(zipcode);
	}

	public void clickContinue(){
		continueElement.click();
	}
}
