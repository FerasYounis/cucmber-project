package utilities;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest
{
	private static WebDriver driver;

	private static WebDriver startDriver()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver getDriver()
	{
		if (driver != null)
		{
			return driver;
		}
		return startDriver();
	}

	public static void closeDriver()
	{

		if (driver != null)
		{
			driver.close();
		}
	}




}
