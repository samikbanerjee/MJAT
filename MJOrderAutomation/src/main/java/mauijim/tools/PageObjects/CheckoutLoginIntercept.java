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
public class CheckoutLoginIntercept
{
	/**
	 * @param driver
	 * @return Username
	 */
	public static WebElement loginEmail_TextBox(final WebDriver driver)
	{
		return driver.findElement(By.id("j_username"));
	}

	/**
	 * @param driver
	 * @return Password
	 */
	public static WebElement loginPassword_TextBox(final WebDriver driver)
	{
		return driver.findElement(By.id("j_password"));
	}

	/**
	 * @param driver
	 * @return Checkout Button
	 */
	public static WebElement loginCheckout_Btn(final WebDriver driver)
	{
		return driver.findElement(By.id("loginUserSubmitButton"));
	}

	/**
	 * @param driver
	 * @return guest Email
	 */
	public static WebElement guestEmail_TextBox(final WebDriver driver)
	{
		return driver.findElement(By.id("email"));
	}

	/**
	 * @param driver
	 * @return guest Checkout Button
	 */
	public static WebElement guestCheckout_Btn(final WebDriver driver)
	{
		return driver.findElement(By.id("registerInterceptSubmitButton"));
	}
}
