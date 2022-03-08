package service;

import java.util.Map;
import java.util.Random;

import domain.pages.CreateNewAccountPage;
import domain.pages.LogInPage;
import domain.pages.OfferPage;
import domain.pages.PersonalIncomePage;
import domain.pages.PersonalLoanBasicInformationPage;
import domain.pages.PersonalLoanPage;
import utilities.BaseTest;
import utilities.Session;


public class NavigationService {
    private static PersonalLoanPage personalLoanLandingPage;
    private static PersonalLoanBasicInformationPage personalLoanBasicInformationPage;
    private static PersonalIncomePage personalIncomePage;
    private static CreateNewAccountPage createNewAccountPage;
    private static OfferPage offerPage;
    private static LogInPage logInPage;
    private static BaseTest baseTest;



    public void openPersonalLoanPage() {
        personalLoanLandingPage = PersonalLoanPage.open();
    }

    public void openLogInPage()
    {
        logInPage = LogInPage.open();
    }

    public void openPersonalLoanBasicInformationPage() {
        personalLoanBasicInformationPage = PersonalLoanBasicInformationPage.open();

    }
    public void openCreateNewAccountPage()
    {
        createNewAccountPage = CreateNewAccountPage.open();
    }

    public void openPersonalIncomePage()
    {
        personalIncomePage = PersonalIncomePage.open();
    }

    public void openOfferPage()
    {
        offerPage = OfferPage.open();
    }


    public void enterPurpose(String purpose) {
        personalLoanLandingPage.enterPurpose(purpose);
    }

    public void enterAmount(String amount) {
        personalLoanLandingPage.enterAmount(amount);
    }

    public void checkYourRate()
    {
        personalLoanLandingPage.checkYourRate();
    }

    public void borrowerFirstName( String firstName)
    {
        personalLoanBasicInformationPage.enterFirstName(firstName);
    }

    public void borrowerBirthday(String birthday)
    {
        personalLoanBasicInformationPage.enterBirthday(birthday);
    }

    public void borrowerHomeAddress(String homeAddress)
    {
        personalLoanBasicInformationPage.enterHomeAddress(homeAddress);
    }

    public void borrowerLastName(String lastName)
    {
        personalLoanBasicInformationPage.enterLastName(lastName);
    }

    public void borrowerZipcode(String zipcode)
    {
        personalLoanBasicInformationPage.enterZipCodeElement(zipcode);
    }

    public void borrowerState(String state)
    {
        personalLoanBasicInformationPage.enterState(state);
    }

    public void borrowerCity(String city)
    {
        personalLoanBasicInformationPage.enterCity(city);
    }

    public void submitBasicInformation()
    {
        personalLoanBasicInformationPage.clickContinue();
    }



    public void borrowerAdditionalAmount(String additionalAmount)
    {
        personalIncomePage.enterAdditionalAmount(additionalAmount);
    }

    public void borrowerAnnualAmount(String annualAmount)
    {
        personalIncomePage.enterAnnualAmount(annualAmount);
    }

    public void submitIncome()
    {
        personalIncomePage.submit();
    }



    public String borrowerNewEmail(String firstName)
    {
        String email = createEmailWithRandomNumber(firstName);
         createNewAccountPage.enterNewEmail(email);
         return email;
    }

    public void borrowerEnterNewPassword(String password)
    {
        createNewAccountPage.enterPassworkd(password);
    }

    public void borrowerAgree()
    {
        createNewAccountPage.checkAgreebox();
    }

    public String createEmailWithRandomNumber(String name){
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;
        return name+String.valueOf(randomNumber)+"@upgrade-challenge.com";
    }


    public void submitNewEmail()
    {
        createNewAccountPage.submit();
    }

    public Session saveOffer(Session session)
    {
        return offerPage.saveOffer(session);
    }


    public void login(String email, String password)
    {
        logInPage.login(email,password);
    }


    public Map<String,String> viewOffer()
    {
        return offerPage.viewOffer();

    }
}
