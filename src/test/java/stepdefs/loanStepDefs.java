package stepdefs;

import java.util.Map;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import service.NavigationService;
import service.ValidationService;
import utilities.BaseTest;
import utilities.Session;




public class loanStepDefs
{

	private static NavigationService navigationService;
	private static ValidationService validationService;
	private static BaseTest baseTest = new BaseTest();
	private static Session session= new Session();

	public loanStepDefs(NavigationService navigationService, ValidationService validationService) {
		this.navigationService = navigationService;
		this.validationService=validationService;
	}

	@Before
	@Test
	public void setUP(){
		MutablePicoContainer pico = new DefaultPicoContainer();
		pico.addComponent(navigationService);
		pico.addComponent(validationService);
	}

//	@After
	@Test
	public void cleanUp(){
		baseTest.closeDriver();
	}



	@Given("^Data setup loan offers$")
	public void data_setup_loan_offers() {
	}

	@When("^loan borrower enter loan amount as (.*) and select (.*)$")
	public void loan_borrower_enter_loan_amount_as_and_select(String amount, String purpose) {
		navigationService.openPersonalLoanPage();
		navigationService.enterAmount(amount);
		navigationService.enterPurpose(purpose);
	}

	@When("^Check your Rate$")
	public void check_your_Rate() {
		navigationService.checkYourRate();
	}

	@When("^They fill out personal information (.*) (.*), (.*) (.*) (.*) (.*), and (.*)$")
	public void theyFillOutPersonal(final String firstName, String lastName, String homeAddress, String city, String state, String zipcode, String birthday) {
		navigationService.openPersonalLoanBasicInformationPage();
		session.setFirstName(firstName);
		navigationService.borrowerFirstName(firstName);
		navigationService.borrowerLastName(lastName);
		navigationService.borrowerHomeAddress(homeAddress);
		navigationService.borrowerCity(city);
		navigationService.borrowerState(state);
		navigationService.borrowerZipcode(zipcode);
		navigationService.borrowerBirthday(birthday);
		navigationService.submitBasicInformation();
	}

	@When("^They fill out financial situation (.*) and (.*)$")
	public void fillOutFinancialIncome(String annualAmount, String additionalAmount) {
		navigationService.openPersonalIncomePage();
		navigationService.borrowerAnnualAmount(annualAmount);
		navigationService.borrowerAdditionalAmount(additionalAmount);
		navigationService.submitIncome();

	}

	@Then("^Create user account with (.*)$")
	public void createNewAccount(String password) {
		navigationService.openCreateNewAccountPage();
		session.setEmail(navigationService.borrowerNewEmail(session.getFirstName()));
		session.setPassword(password);
		navigationService.borrowerEnterNewPassword(password);
	}

	@Then("^They accept the Terms of Use and Check their Rate and sign out$")
	public void acceptTermsOfUseAndCheckRate() {
		navigationService.borrowerAgree();
		navigationService.submitNewEmail();
		try
		{
			Thread.sleep(8000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		navigationService.openOfferPage();
		session = navigationService.saveOffer(session);

	}


	@Then("^They Sign In with the new USERNAME to their account$")
	public void signInToTheirAccount() {
		try
		{
			Thread.sleep(8000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		navigationService.openLogInPage();
		System.out.println(session.getEmail());
		System.out.println(session.getPassword());
		System.out.println(session.getAmountApproved());
		navigationService.login(session.getEmail(), session.getPassword());
	}

	@Then("^Check your offer$")
	public void checkYourOffer() {
		try
		{
			Thread.sleep(8000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		navigationService.openOfferPage();
		Map<String,String> offerItemsMap = navigationService.viewOffer();
		Assert.assertEquals(session.getAmountApproved(),offerItemsMap.get("amountApproved"));
		Assert.assertEquals(session.getMonthlyPayment(),offerItemsMap.get("monthlyPayment"));
		Assert.assertEquals(session.getAPR(),offerItemsMap.get("APR"));
		Assert.assertEquals(session.getRate(),offerItemsMap.get("rate"));
		Assert.assertEquals(session.getTerms(),offerItemsMap.get("terms"));
	}

	@When("Check loan exist by id (.*) and Side Effects is set to (.*)$")
	public void checkLoanExistById(String id, boolean skipSideEffects){
		validationService.GetLoanDetailsById(id,skipSideEffects);
	}
}
