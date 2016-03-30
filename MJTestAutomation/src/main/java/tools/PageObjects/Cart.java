/**
 *
 */
package tools.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * <p>
 * Page Objects on Cart Page and actions
 * </p>
 */
public class Cart
{
	/**
	 * @param driver
	 * @return start checkout button
	 */
	public static WebElement beginCheckout_Btn(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='pageContent']/div/div[4]/div[1]/div[3]/div[2]/div/div/div[2]/a"));
	}

	/**
	 * @param driver
	 * @return start checkout button for ZO
	 */
	public static WebElement beginCheckoutZO_Btn(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='pageContent']/div[1]/div[4]/div[1]/div[2]/div[2]/div/div/div[2]/a"));
	}


	/**
	 * @param driver
	 */
	public static void addGiftBagAction(final WebDriver driver)
	{
		final WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//form[@id='addToGiftCartForm']//a")));
		driver.findElement(By.xpath(".//form[@id='addToGiftCartForm']//a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//form[@id='addToGiftCartForm']//button")));
		driver.findElement(By.xpath(".//form[@id='addToGiftCartForm']//button")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.elementToBeClickable(Cart.beginCheckout_Btn(driver)));
	}
}
