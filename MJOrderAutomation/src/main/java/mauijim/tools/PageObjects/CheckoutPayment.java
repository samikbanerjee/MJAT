package mauijim.tools.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 *
 */

public class CheckoutPayment
{

	public static WebElement submitPaymentAddress(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='paymentDetailsForm']//*[@class='orange-bt']"));
	}


	public static WebElement copyShippingAddressLabel(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='copyShippingAddress']/../label"));
	}

	public static WebElement copyShippingAddressOption(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='copyShippingAddress']/../a"));
	}


	public static WebElement delegoFrame(final WebDriver driver)
	{
		return driver.findElement(By.id("partner-frame"));
	}


	public static WebElement paymentMethodHeader(final WebDriver driver)
	{
		return driver.findElement(By.cssSelector("h2.checkout-sub-title"));
	}


	public static WebElement cardSubmit(final WebDriver driver)
	{
		return driver.findElement(By.id("submitButton"));
	}


	public static WebElement cardCvv(final WebDriver driver)
	{
		return driver.findElement(By.id("cvval_display"));
	}


	public static WebElement cardExpDtYr(final WebDriver driver)
	{
		return driver.findElement(By.id("expDateYear"));
	}


	public static WebElement cardExpDtMnth(final WebDriver driver)
	{
		return driver.findElement(By.id("expDateMonth"));
	}


	public static WebElement cardNum(final WebDriver driver)
	{
		return driver.findElement(By.id("ccnum_display"));
	}


	public static WebElement cardName(final WebDriver driver)
	{
		return driver.findElement(By.id("ccname"));
	}


	public static WebElement cardType(final WebDriver driver)
	{
		return driver.findElement(By.id("ccins"));
	}



}
