/**
 *
 */
package rough.GiftCardTestCases;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tools.PageObjects.Cart;
import tools.PageObjects.PDP;


/**
 * @author Sai
 *
 */
public class GCErrorScenarioSameCard
{

	private static final String baseUrl = "http://usmauijim.stg";
	private static final String PDP_URL = "/en/shop/sunglasses/aviators/freight-trains";
	private static final String GC_NUM = "1101174626950504";
	private static final String GC_PIN = "YSL9";
	private static final String errorMessage = "Your shopping bag already has a Promo/VIP card applied. If you would like to apply a different card, please remove a previously applied card.";

	public void testGCErrorScenarioSameCard(final WebDriver driver) throws InterruptedException
	{
		// Navigate to PDP
		driver.get(baseUrl + PDP_URL);

		// ATC
		PDP.addToCartAction(driver);
		PDP.cart_Icon(driver).click();

		// Enter 1 GC Number + Pin + Submit
		Cart.gcNum_Text(driver).clear();
		Cart.gcNum_Text(driver).sendKeys(GC_NUM);
		Cart.gcPin_Text(driver).clear();
		Cart.gcPin_Text(driver).sendKeys(GC_PIN);
		Thread.sleep(1000);
		Cart.gcApply_Btn(driver).sendKeys(Keys.RETURN);
		Thread.sleep(1000);

		// Enter same GC Number + Pin + Submit
		Cart.gcNum_Text(driver).clear();
		Cart.gcNum_Text(driver).sendKeys(GC_NUM);
		Cart.gcPin_Text(driver).clear();
		Cart.gcPin_Text(driver).sendKeys(GC_PIN);
		Thread.sleep(1000);
		Cart.gcApply_Btn(driver).sendKeys(Keys.RETURN);
		Thread.sleep(1000);

		//Verify The error message comes up
		assertEquals(errorMessage, Cart.gcApply_Error_label(driver).getText());
	}

	public static void main(final String[] args) throws InterruptedException
	{
		final WebDriver abc = new FirefoxDriver();
		new GCErrorScenarioSameCard().testGCErrorScenarioSameCard(abc);
		abc.quit();
	}
}
