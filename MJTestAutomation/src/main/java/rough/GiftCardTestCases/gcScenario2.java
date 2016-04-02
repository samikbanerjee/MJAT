package rough.GiftCardTestCases;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import tools.PageObjects.Cart;
import tools.PageObjects.GiftCardPDP;
//import tools.PageObjects.LoginRegistration;
import tools.PageObjects.PDP;


public class gcScenario2
{
	private static final double GC_PERCENT = 75;
	private static final String GC_PIN = "YSL9";
	private static final String GC_NUM = "1101174626950504";
	private static final String Giftcard_Amount = "$75.00";
	private static final String Giftcard_Quantity = "2";
	private static final String PDP1_URL = "/en/shop/sunglasses/aviators/freight-trains";
	private static final double PDP1_PRICE = 329.00;
	private static final String base_URL = "http://usmauijim.stg/";

	public static void main(final String[] args) throws InterruptedException
	{
		final WebDriver driver = new FirefoxDriver();
		driver.get(base_URL);
		driver.manage().window().maximize();
		//		Login 
		//		LoginRegistration.regPage_Link(driver).click();
		//		LoginRegistration.regPage_Login_User(driver).clear();
		//		LoginRegistration.regPage_Login_User(driver).sendKeys("kamaljeet@pragiti.com");
		//		LoginRegistration.regPage_Login_Pass(driver).clear();
		//		LoginRegistration.regPage_Login_Pass(driver).sendKeys("Testing@1");
		//		LoginRegistration.regPage_Login_Submit(driver).click();


		//      PDP1 (higher Priced)
		driver.get(base_URL + PDP1_URL);

		//		ATC
		PDP.atc_Btn(driver).click();

		//      Gift Card PDP - specify quantity , value
		GiftCardPDP.footerGiftcard_link(driver).click();
		new Select(GiftCardPDP.buyGiftcard_Quantity_Select(driver)).selectByVisibleText(Giftcard_Quantity);
		new Select(GiftCardPDP.buyGiftcard_Amount_Select(driver)).selectByVisibleText(Giftcard_Amount);


		//		ATC
		GiftCardPDP.addToCartAction(driver);

		//		Cart Page
		GiftCardPDP.cart_Icon(driver).click();


		//	    Enter GC number , Pin
		Cart.gcNum_Text(driver).clear();
		Cart.gcNum_Text(driver).sendKeys(GC_NUM);
		Cart.gcPin_Text(driver).clear();
		Cart.gcPin_Text(driver).sendKeys(GC_PIN);

		//		Submit GC button

		Thread.sleep(1000);
		Cart.gcApply_Btn(driver).sendKeys(Keys.RETURN);
		Thread.sleep(10000);

		//		Expected order total - PDP1 Price + Gift Card PDP Price - X% of PDP1 Price = Y]
		final double GiftCardPDP = 150;
		final double PriceTotal = (PDP1_PRICE + GiftCardPDP);
		final double discount = (GC_PERCENT / 100) * PDP1_PRICE;
		final double orderTotal = PriceTotal - discount;

		//	    Order Total
		assertEquals("$" + Double.toString(orderTotal), Cart.orderSummary_Total_Label(driver).getText());
		Thread.sleep(1000);
		driver.quit();
	}
}
