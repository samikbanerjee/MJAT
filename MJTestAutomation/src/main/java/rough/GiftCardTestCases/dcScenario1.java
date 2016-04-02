package rough.GiftCardTestCases;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tools.PageObjects.Cart;
import tools.PageObjects.PDP;


public class dcScenario1
{

	private static final double Discount = 120;
	private static final String GC_PIN = "YSL9";
	private static final String GC_NUM = "1101174626950504";
	private static final String PDP2 = "/en/shop/sunglasses/aviators/freight-trains";
	private static final double PDP2_PRICE = 329.00;
	private static final String PDP1 = "/en/shop/readers/makaha-reader-universal-fit";
	private static final double PDP1_PRICE = 229.00;
	private static final String baseURL = "http://usmauijim.stg/";

	public static void main(final String[] args) throws InterruptedException
	{
		final WebDriver driver = new FirefoxDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();

		//		 Login 

		//		 PDP1
		driver.get(baseURL + PDP1);

		//		 ATC
		PDP.atc_Btn(driver).click();

		//		 PDP2 (higher Priced)
		driver.get(baseURL + PDP2);

		//		 ATC
		PDP.atc_Btn(driver).click();

		//		 Cart Page
		PDP.cart_Icon(driver).click();

		//		 Enter GC number , Pin
		Cart.gcNum_Text(driver).sendKeys(GC_NUM);
		Cart.gcPin_Text(driver).sendKeys(GC_PIN);

		//		 Submit GC button
		Thread.sleep(1000);
		Cart.gcApply_Btn(driver).sendKeys(Keys.RETURN);
		Thread.sleep(10000);

		//		 Expected order total - PDP1 Price + PDP 2 Price - X dollars = Y]
		final double productPriceTotal = PDP1_PRICE + PDP2_PRICE;
		final double orderTotal = productPriceTotal - Discount;


		//		 OrderTotal
		assertEquals("$" + orderTotal, Cart.orderSummary_Total_Label(driver).getText());


	}

}
