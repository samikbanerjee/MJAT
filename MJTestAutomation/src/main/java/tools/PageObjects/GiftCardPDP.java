package tools.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * <p>
 * Page Objects on GiftCard Page and actions
 * </p>
 */

public class GiftCardPDP
{
	/**
	 * @param driver
	 * @return Link to gift card page
	 */
	public static WebElement footerGiftcard_link(final WebDriver driver)
	{
		return driver.findElement(By.linkText("GIFT CARDS"));
	}

	/**
	 * @param driver
	 * @return Gift Card Qty selector
	 */
	public static WebElement buyGiftcard_Quantity_Select(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@name='qty']"));
	}

	/**
	 * @param driver
	 * @return Gift Card Amount Selector
	 */
	public static WebElement buyGiftcard_Amount_Select(final WebDriver driver)
	{
		return driver.findElement(By.id("selectid"));
	}

	/**
	 * @param driver
	 * @return ATC button
	 */
	public static WebElement buyGiftcard_ATC_Btn(final WebDriver driver)
	{
		return driver.findElement(By.id("addToCartButton"));
	}

	/**
	 * @param driver
	 */
	public static void addToCartAction(final WebDriver driver)
	{
		final WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(GiftCardPDP.buyGiftcard_ATC_Btn(driver)));
		GiftCardPDP.buyGiftcard_ATC_Btn(driver).click();
		wait.until(new ExpectedCondition<Boolean>()
		{
			public Boolean apply(final WebDriver driver)
			{
				final int elementCount = Integer.parseInt(PDP.miniCart_Count(driver).getText());
				if (elementCount > 0)
				{
					return true;
				}
				else
				{
					return false;

				}
			}
		});

	}

	/**
	 * @param driver
	 * @return cart icon
	 */
	public static WebElement cart_Icon(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='holderMiniCart']/a/span[2]"));
	}
}
