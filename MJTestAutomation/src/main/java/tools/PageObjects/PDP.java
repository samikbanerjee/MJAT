package tools.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * <p>
 * Page Objects on PDP and actions
 * </p>
 */
public class PDP
{

	/**
	 * @param driver
	 * @return ATC button On PDP
	 */
	public static WebElement atc_Btn(final WebDriver driver)
	{
		return driver.findElement(By.id("addToCartButton"));
	}

	/**
	 * @param driver
	 * @return mini cart item count
	 */
	public static WebElement miniCart_Count(final WebDriver driver)
	{
		return driver.findElement(By.className("item-count"));
	}


	/**
	 * @param driver
	 * @return cart icon
	 */
	public static WebElement cart_Icon(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='holderMiniCart']/a/span[2]"));
	}

	/**
	 * @param driver
	 */
	public static void addToCartAction(final WebDriver driver)
	{
		final WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(PDP.atc_Btn(driver)));
		PDP.atc_Btn(driver).click();
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
}
