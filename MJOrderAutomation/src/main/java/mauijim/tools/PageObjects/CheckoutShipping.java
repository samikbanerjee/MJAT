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

public class CheckoutShipping
{
	public static WebElement shippingAddNewAddress(final WebDriver driver)
	{
		return driver.findElement(By.id("ShippingAddNewAddress"));
	}

	public static WebElement addressId(final WebDriver driver)
	{
		return driver.findElement(By.id("address-id"));
	}

	public static WebElement fName(final WebDriver driver)
	{
		return driver.findElement(By.id("address-firstName"));
	}

	public static WebElement lName(final WebDriver driver)
	{
		return driver.findElement(By.id("address-lastName"));
	}

	public static WebElement addrLine1(final WebDriver driver)
	{
		return driver.findElement(By.id("address-line1"));
	}

	public static WebElement addrLine2(final WebDriver driver)
	{
		return driver.findElement(By.id("address-line2"));
	}

	public static WebElement city(final WebDriver driver)
	{
		return driver.findElement(By.id("address-town"));
	}

	public static WebElement state(final WebDriver driver)
	{
		return driver.findElement(By.id("regionIso"));
	}

	public static WebElement country(final WebDriver driver)
	{
		
		return null;
	}

	public static WebElement zip(final WebDriver driver)
	{
		return driver.findElement(By.id("address-zip"));
	}

	public static WebElement phone(final WebDriver driver)
	{
		return driver.findElement(By.id("address-phone"));
	}

	public static WebElement submitAddress(final WebDriver driver)
	{
		return driver.findElement(By.id("continue-address-btn"));
	}

	public static WebElement suggestAddressModalFirstHeader(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='addressSuggestion']/h3[1]"));
	}

	public static WebElement suggestAddressModalSecondHeader(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='addressSuggestion']/h3[2]"));
	}

	public static WebElement suggestAddressModalSubmit(final WebDriver driver)
	{
		return driver.findElement(By.id("suggest-address-btn"));
	}

	public static WebElement shippingMethodHeader(final WebDriver driver)
	{
		return driver.findElement(By.cssSelector("div.shipping-method > h2.checkout-sub-title"));
	}

	public static WebElement shippingMethodInfo(final WebDriver driver)
	{
		return driver.findElement(By.cssSelector("a.view-shipp-info-a > p"));
	}

	public static WebElement shippingMethodDivSelection(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='shippingMethods']/div"));
	}

	public static WebElement shippingMethodSelection(final WebDriver driver, final int i)
	{
		return driver.findElement(By.xpath(".//*[@id='shippingMethods']/div/div[1]/div[" + i + "]/div/a"));
	}

	public static WebElement shippingMethodSubmit(final WebDriver driver)
	{
		return driver.findElement(By.id("shipping-button"));
	}

}
