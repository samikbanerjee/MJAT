package mauijim.MJOrderAutomation;

import java.io.IOException;

import mauijim.tools.ReadTestData;
import mauijim.tools.PageObjects.Cart;
import mauijim.tools.PageObjects.CheckoutLoginIntercept;
import mauijim.tools.PageObjects.CheckoutOrderReview;
import mauijim.tools.PageObjects.CheckoutPayment;
import mauijim.tools.PageObjects.CheckoutShipping;
import mauijim.tools.PageObjects.PDP;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Samik
 *
 */
public class PlaceOrder
{
	private static String CUST_CVVAL;
	private static String CUST_EXPDATEYEAR;
	private static String CUST_EXPDATEMONTH;
	private static String CUST_CCNUM;
	private static String CUST_CCNAME;
	private static String CUST_CCINS;
	private static String CUST_PHONE;
	private static String CUST_ZIP;
	private static String CUST_REGIONISO;
	private static String CUST_TOWN;
	private static String CUST_ADDRESSLINE1;
	private static String CUST_LASTNAME;
	private static String CUST_FIRSTNAME;

	//For Guest
	private static String CUST_EMAIL;

	//For Logged in User
	private static String CUST_PASSWORD;
	private static String CUST_USERNAME;

	private static String PDP_URL;
	private static String baseUrl;



	/**
	 * Constructor
	 *
	 * @param testDataProperies
	 * @throws IOException
	 */
	public PlaceOrder(final String testDataProperies) throws IOException
	{
		final ReadTestData td = new ReadTestData(testDataProperies);
		CUST_CVVAL = td.getValue("CUST_CVVAL", "null");
		CUST_EXPDATEYEAR = td.getValue("CUST_EXPDATEYEAR", "null");
		CUST_EXPDATEMONTH = td.getValue("CUST_EXPDATEMONTH", "null");
		CUST_CCNUM = td.getValue("CUST_CCNUM", "null");
		CUST_CCNAME = td.getValue("CUST_CCNAME", "null");
		CUST_CCINS = td.getValue("CUST_CCINS", "null");
		CUST_PHONE = td.getValue("CUST_PHONE", "null");
		CUST_ZIP = td.getValue("CUST_ZIP", "null");
		CUST_REGIONISO = td.getValue("CUST_REGIONISO", "null");
		CUST_TOWN = td.getValue("CUST_TOWN", "null");
		CUST_ADDRESSLINE1 = td.getValue("CUST_ADDRESSLINE1", "null");
		CUST_LASTNAME = td.getValue("CUST_LASTNAME", "null");
		CUST_FIRSTNAME = td.getValue("CUST_FIRSTNAME", "null");

		//For Guest
		CUST_EMAIL = td.getValue("CUST_EMAIL", "null");

		//For Logged in User
		CUST_PASSWORD = td.getValue("CUST_PASSWORD", "null");
		CUST_USERNAME = td.getValue("CUST_USERNAME", "null");

		PDP_URL = td.getValue("PDP_URL", "null");
		baseUrl = td.getValue("baseUrl", "null");

	}

	/**
	 * <p>
	 * places order as a guest
	 * </p>
	 *
	 * @param driver
	 * @return Order Number
	 */
	public String guestCheckout(final WebDriver driver)
	{
		try
		{
			driver.get(baseUrl);

			//GO TO PDP
			driver.get(baseUrl + PDP_URL);
			final WebDriverWait wait = new WebDriverWait(driver, 30);

			//ATC
			PDP.addToCartAction(driver);
			PDP.cart_Icon(driver).click();

			// CART PAGE
			Cart.beginCheckout_Btn(driver).sendKeys(Keys.RETURN);

			// CHECKOUT INTERCEPT PAGE
			CheckoutLoginIntercept.guestEmail_TextBox(driver).clear();
			CheckoutLoginIntercept.guestEmail_TextBox(driver).sendKeys(CUST_EMAIL);
			CheckoutLoginIntercept.guestCheckout_Btn(driver).click();
			Thread.sleep(3000);

			// CHECKOUT SHIPPING - ADDRESS
			CheckoutShipping.fName(driver).clear();
			CheckoutShipping.fName(driver).sendKeys(CUST_FIRSTNAME);
			CheckoutShipping.lName(driver).clear();
			CheckoutShipping.lName(driver).sendKeys(CUST_LASTNAME);
			CheckoutShipping.addrLine1(driver).clear();
			CheckoutShipping.addrLine1(driver).sendKeys(CUST_ADDRESSLINE1);
			CheckoutShipping.city(driver).clear();
			CheckoutShipping.city(driver).sendKeys(CUST_TOWN);
			new Select(CheckoutShipping.state(driver)).selectByVisibleText(CUST_REGIONISO);
			CheckoutShipping.zip(driver).clear();
			CheckoutShipping.zip(driver).sendKeys(CUST_ZIP);
			CheckoutShipping.phone(driver).clear();
			CheckoutShipping.phone(driver).sendKeys(CUST_PHONE);
			wait.until(ExpectedConditions.elementToBeClickable(CheckoutShipping.submitAddress(driver)));
			CheckoutShipping.submitAddress(driver).sendKeys(Keys.RETURN);

			//CHECKOUT- SHIPPING SUGGESTED ADDRESS
			wait.until(ExpectedConditions.visibilityOf(CheckoutShipping.suggestAddressModalSubmit(driver)));
			CheckoutShipping.suggestAddressModalSubmit(driver).click();

			//CHECKOUT - SHIPPING METHOD
			wait.until(ExpectedConditions.visibilityOf(CheckoutShipping.shippingMethodHeader(driver)));
			CheckoutShipping.shippingMethodDivSelection(driver).click();
			CheckoutShipping.shippingMethodSelection(driver, 1).click();
			wait.until(ExpectedConditions.elementToBeClickable(CheckoutShipping.shippingMethodSubmit(driver)));
			Thread.sleep(3000);
			CheckoutShipping.shippingMethodSubmit(driver).click();

			//Payment
			Thread.sleep(10000);
			final WebElement delFrame = CheckoutPayment.delegoFrame(driver);
			driver.switchTo().frame(delFrame);
			new Select(CheckoutPayment.cardType(driver)).selectByVisibleText(CUST_CCINS);
			CheckoutPayment.cardName(driver).clear();
			CheckoutPayment.cardName(driver).sendKeys(CUST_CCNAME);
			CheckoutPayment.cardNum(driver).sendKeys(CUST_CCNUM);
			CheckoutPayment.cardExpDtMnth(driver).clear();
			CheckoutPayment.cardExpDtMnth(driver).sendKeys(CUST_EXPDATEMONTH);
			CheckoutPayment.cardExpDtYr(driver).clear();
			CheckoutPayment.cardExpDtYr(driver).sendKeys(CUST_EXPDATEYEAR);
			CheckoutPayment.cardCvv(driver).clear();
			CheckoutPayment.cardCvv(driver).sendKeys(CUST_CVVAL);
			CheckoutPayment.cardSubmit(driver).click();
			driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.elementToBeClickable(CheckoutPayment.copyShippingAddressOption(driver)));
			CheckoutPayment.copyShippingAddressOption(driver).click();
			Thread.sleep(2000);

			CheckoutPayment.submitPaymentAddress(driver).sendKeys(Keys.RETURN);
			Thread.sleep(2000);

			//REVIEW
			CheckoutOrderReview.reviewAcceptTerms(driver).click();
			wait.until(ExpectedConditions.elementToBeClickable(CheckoutOrderReview.reviewAcceptTerms(driver)));
			CheckoutOrderReview.reviewSubmit(driver).sendKeys(Keys.RETURN);
			Thread.sleep(3000);

			//Order confirmation
			return driver.findElement(By.className("order-num")).getText();
		}
		catch (final Exception e)
		{
			return e.getMessage();
		}

	}

	/**
	 * <p>
	 * places order as a logged in user
	 * </p>
	 *
	 * @param driver
	 * @return Order Number
	 */
	public String loginCheckout(final WebDriver driver)
	{
		try
		{
			driver.get(baseUrl);

			//GO TO PDP
			driver.get(baseUrl + PDP_URL);
			final WebDriverWait wait = new WebDriverWait(driver, 30);

			//ATC
			PDP.addToCartAction(driver);
			PDP.cart_Icon(driver).click();

			// CART PAGE
			Cart.beginCheckout_Btn(driver).sendKeys(Keys.RETURN);

			// CHECKOUT INTERCEPT PAGE
			CheckoutLoginIntercept.loginEmail_TextBox(driver).clear();
			CheckoutLoginIntercept.loginEmail_TextBox(driver).sendKeys(CUST_USERNAME);
			CheckoutLoginIntercept.loginPassword_TextBox(driver).clear();
			CheckoutLoginIntercept.loginPassword_TextBox(driver).sendKeys(CUST_PASSWORD);
			CheckoutLoginIntercept.loginCheckout_Btn(driver).click();

			// CHECKOUT SHIPPING - ADDRESS
			new Select(CheckoutShipping.addressId(driver)).selectByVisibleText("Add New Address");
			CheckoutShipping.shippingAddNewAddress(driver).click();
			CheckoutShipping.fName(driver).clear();
			CheckoutShipping.fName(driver).sendKeys(CUST_FIRSTNAME);
			CheckoutShipping.lName(driver).clear();
			CheckoutShipping.lName(driver).sendKeys(CUST_LASTNAME);
			CheckoutShipping.addrLine1(driver).clear();
			CheckoutShipping.addrLine1(driver).sendKeys(CUST_ADDRESSLINE1);
			CheckoutShipping.city(driver).clear();
			CheckoutShipping.city(driver).sendKeys(CUST_TOWN);
			new Select(CheckoutShipping.state(driver)).selectByVisibleText(CUST_REGIONISO);
			CheckoutShipping.zip(driver).clear();
			CheckoutShipping.zip(driver).sendKeys(CUST_ZIP);
			CheckoutShipping.phone(driver).clear();
			CheckoutShipping.phone(driver).sendKeys(CUST_PHONE);
			wait.until(ExpectedConditions.elementToBeClickable(CheckoutShipping.submitAddress(driver)));
			CheckoutShipping.submitAddress(driver).sendKeys(Keys.RETURN);

			//CHECKOUT- SHIPPING SUGGESTED ADDRESS
			wait.until(ExpectedConditions.visibilityOf(CheckoutShipping.suggestAddressModalSubmit(driver)));
			CheckoutShipping.suggestAddressModalSubmit(driver).click();

			//CHECKOUT - SHIPPING METHOD
			wait.until(ExpectedConditions.visibilityOf(CheckoutShipping.shippingMethodHeader(driver)));
			CheckoutShipping.shippingMethodDivSelection(driver).click();
			CheckoutShipping.shippingMethodSelection(driver, 1).click();
			wait.until(ExpectedConditions.elementToBeClickable(CheckoutShipping.shippingMethodSubmit(driver)));
			Thread.sleep(3000);
			CheckoutShipping.shippingMethodSubmit(driver).click();

			//Payment
			Thread.sleep(10000);
			final WebElement delFrame = CheckoutPayment.delegoFrame(driver);
			driver.switchTo().frame(delFrame);
			new Select(CheckoutPayment.cardType(driver)).selectByVisibleText(CUST_CCINS);
			CheckoutPayment.cardName(driver).clear();
			CheckoutPayment.cardName(driver).sendKeys(CUST_CCNAME);
			CheckoutPayment.cardNum(driver).sendKeys(CUST_CCNUM);
			CheckoutPayment.cardExpDtMnth(driver).clear();
			CheckoutPayment.cardExpDtMnth(driver).sendKeys(CUST_EXPDATEMONTH);
			CheckoutPayment.cardExpDtYr(driver).clear();
			CheckoutPayment.cardExpDtYr(driver).sendKeys(CUST_EXPDATEYEAR);
			CheckoutPayment.cardCvv(driver).clear();
			CheckoutPayment.cardCvv(driver).sendKeys(CUST_CVVAL);
			CheckoutPayment.cardSubmit(driver).click();
			driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.elementToBeClickable(CheckoutPayment.copyShippingAddressOption(driver)));
			CheckoutPayment.copyShippingAddressOption(driver).click();
			Thread.sleep(2000);

			//TODO: Phone number coded in - to bypass a bug on Staging as on 3/28
			CheckoutShipping.phone(driver).clear();
			CheckoutShipping.phone(driver).sendKeys(CUST_PHONE);
			// TODO: END - remove section

			CheckoutPayment.submitPaymentAddress(driver).sendKeys(Keys.RETURN);
			Thread.sleep(2000);


			//REVIEW
			CheckoutOrderReview.reviewAcceptTerms(driver).click();
			wait.until(ExpectedConditions.elementToBeClickable(CheckoutOrderReview.reviewAcceptTerms(driver)));
			CheckoutOrderReview.reviewSubmit(driver).sendKeys(Keys.RETURN);
			Thread.sleep(3000);

			//Order confirmation
			return driver.findElement(By.className("order-num")).getText();
		}
		catch (final Exception e)
		{
			return "Unable to place Order due to - " + e.getMessage();
		}

	}
}
