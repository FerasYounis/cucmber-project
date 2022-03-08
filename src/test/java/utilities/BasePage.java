package utilities;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;


public class BasePage<T extends BasePage<T>> {

	protected static WebDriver driver;

	protected static FluentWait<WebDriver> wait;

	public BasePage(){
		driver = BaseTest.getDriver();
	}

	public T get(String url){
		driver.get(url);
		return(T) this;
	}

}
