package tools.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 *
 */

public class CheckoutOrderReview
{


	public static WebElement reviewAcceptTerms(final WebDriver driver)
	{
		return driver.findElement(By.id("termChkBoxLarge"));
	}

	public static WebElement reviewSubmit(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='review']/button"));
	}
}
