package rough.GiftCardTestCases;

//import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.PageObjects.Cart;
//import tools.PageObjects.LoginRegistration;
import tools.PageObjects.PDP;


public class gcScenario1
{
	private static final String GC_PIN = "YSL9";
	private static final String GC_NUM = "1101174626950504";
	private static final double GC_PERCENT_DISCOUNT = 75;
	//private static final String CUST_PASSWORD = "Testing@1";
	//private static final String CUST_USER = "kamaljeet@pragiti.com";
	private static final String PDP2_URL = "/en/shop/sunglasses/aviators/freight-trains";
	private static final double PDP2_PRICE = 329.00;
	private static final String PDP1_URL = "/en/shop/readers/makaha-reader-universal-fit";
	private static final double PDP1_PRICE = 229.00;
	private static final String baseUrl = "http://usmauijim.stg";

	public static void main(final String[] args) throws InterruptedException
	{
		final WebDriver dr = new FirefoxDriver();
		dr.get(baseUrl);
		dr.manage().window().maximize();
		final WebDriverWait wait = new WebDriverWait(dr, 20);

		//		Login 
		//		LoginRegistration.regPage_Link(dr).click();
		//		LoginRegistration.regPage_Login_User(dr).clear();
		//		LoginRegistration.regPage_Login_User(dr).sendKeys(CUST_USER);
		//		LoginRegistration.regPage_Login_Pass(dr).clear();
		//		LoginRegistration.regPage_Login_Pass(dr).sendKeys(CUST_PASSWORD);
		//		LoginRegistration.regPage_Login_Submit(dr).click();
		//		Thread.sleep(3000);

		//		 PDP1
		dr.get(baseUrl + PDP1_URL);

		//		 ATC
		PDP.atc_Btn(dr).click();

		//		 PDP2 (higher Priced)
		dr.get(baseUrl + PDP2_URL);

		//		 ATC
		PDP.atc_Btn(dr).click();

		//		 Cart Page
		PDP.cart_Icon(dr).click();

		//		 Enter GC number , Pin
		Cart.gcNum_Text(dr).sendKeys(GC_NUM);
		Cart.gcPin_Text(dr).sendKeys(GC_PIN);


		//		 Submit GC button
		wait.until(ExpectedConditions.elementToBeClickable(Cart.gcApply_Btn(dr)));
		Thread.sleep(1000);
		Cart.gcApply_Btn(dr).sendKeys(Keys.RETURN);
		;
		Thread.sleep(10000);


		//		 Expected order total - PDP1 Price + PDP 2 Price - X% of PDP2 Price = Y]
		final double productPriceTotal = PDP1_PRICE + PDP2_PRICE;
		final double discount = (GC_PERCENT_DISCOUNT / 100) * PDP2_PRICE;
		final double orderTotal = productPriceTotal - discount;


		//		 Check The Order Total
		assertEquals("$" + Double.toString(orderTotal), Cart.orderSummary_Total_Label(dr).getText());

		Thread.sleep(10000);

		dr.quit();

	}
}
