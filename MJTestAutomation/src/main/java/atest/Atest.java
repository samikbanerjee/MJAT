package atest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



/**
 *
 */
public class Atest
{
	//private static final String CUST_PASS = "Qwerty@1234";
	//private static final String CUST_EMAIL = "mjaqatest@pragiti.com";
	private static final String baseURL = "http://www.amway.com.br/";
	private static final String headerNavigation = "Nutrição;Suplementos";
	private static final String targetPage = "Suplementos e Nutrição | AMWAY DO BRASIL";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception
	{
		final FirefoxDriver dr = new FirefoxDriver();

		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.get(baseURL);
		Thread.sleep(1000);

		System.out.println("Done navigation");

		final String[] headerNavigationElements = headerNavigation.split(";");

		final int navigationItems = headerNavigationElements.length - 1;

		final Actions act = new Actions(dr);
		
		for (int i = 0; i < navigationItems; i++)
		{
			final String linkText = headerNavigationElements[i];
			final WebElement link = dr.findElementByLinkText(linkText);
			act.moveToElement(link).build().perform();
			Thread.sleep(1000);
			System.out.println("Moved to : " + linkText);
		}

		dr.findElementByLinkText(headerNavigationElements[navigationItems]).click();
		
		System.out.println("click on  - " + headerNavigationElements[navigationItems]);
		Thread.sleep(1000);
		System.out.println(dr.getTitle());
		System.out.println("abc-" + targetPage);


		dr.quit();
	}
}
