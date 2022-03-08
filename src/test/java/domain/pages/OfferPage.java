package domain.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;
import utilities.Session;


public class OfferPage extends BasePage<OfferPage>
{
	private static Session session;

	@FindBy(css =("span[class='sc-lmgQwP hpRDUw']") )
	WebElement amountApprovedElement;

	@FindBy(css =("span[data-auto='defaultMonthlyPayment']"))
	WebElement monthlyPaymentElement;

	@FindBy(css =("div[data-auto='defaultLoanTerm']"))
	WebElement termsElement;

	@FindBy(css =("div[data-auto='defaultLoanInterestRate']"))
	WebElement rateElement;

	@FindBy(css =("div[data-auto='defaultAPR']"))
	WebElement APRElement;

	@FindBy(css =("label[aria-label='Open Site Menu']"))
	WebElement menuElement;

	@FindBy(css =("a[class='header-nav-menu__link']"))
	WebElement signOutElement;

	public static OfferPage open()
	{
		return PageFactory.initElements(driver, OfferPage.class);
	}

	public OfferPage()
	{
		this.driver = driver;
	}


	public Session saveOffer(Session session)
	{
		this.session = session;
		System.out.println(amountApprovedElement.getText());
		System.out.println(monthlyPaymentElement.getText());
		System.out.println(termsElement.getText());
		System.out.println(rateElement.getText());
		System.out.println(APRElement.getText());
		OfferPage.session.setAmountApproved(amountApprovedElement.getText());
		OfferPage.session.setMonthlyPayment(monthlyPaymentElement.getText());
		OfferPage.session.setTerms(termsElement.getText());
		OfferPage.session.setRate(rateElement.getText());
		OfferPage.session.setAPR(APRElement.getText());
		menuElement.click();
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		signOutElement.click();
		return session;

	}

	public Map<String,String> viewOffer()
	{
		Map<String,String> offerItemsMap = new HashMap<String, String>();
		offerItemsMap.put("amountApproved",amountApprovedElement.getText());
		offerItemsMap.put("monthlyPayment",monthlyPaymentElement.getText());
		offerItemsMap.put("terms",termsElement.getText());
		offerItemsMap.put("rate",rateElement.getText());
		offerItemsMap.put("APR",APRElement.getText());
		return offerItemsMap;
	}
}
