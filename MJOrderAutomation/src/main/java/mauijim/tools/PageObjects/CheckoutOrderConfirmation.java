/**
 *
 */
package mauijim.tools.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 *
 */

public class CheckoutOrderConfirmation
{
	public static WebElement confirmationCreateAcct_Hdr(final WebDriver driver)
	{
		return driver.findElement(By.id("guestRegisterFormButton"));
	}

	public static WebElement confirmationMktg_Hdr(final WebDriver driver)
	{
		return driver.findElement(By.xpath("//form[@id='guestRegisterForm']/div/div[7]/div/label"));
	}

	public static WebElement confirmationBillingInfo_Hdr(final WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[@id='pageContent']/div[2]/div/div[2]/div[2]/h1"));
	}

	public static WebElement confirmationShippingInfo_Hdr(final WebDriver driver)
	{
		return driver.findElement(By.cssSelector("h2.checkout-sub-title"));
	}

	public static WebElement confirmationReceipt_Hdr(final WebDriver driver)
	{
		return driver.findElement(By.cssSelector("h1.checkout-sub-title"));
	}
}
