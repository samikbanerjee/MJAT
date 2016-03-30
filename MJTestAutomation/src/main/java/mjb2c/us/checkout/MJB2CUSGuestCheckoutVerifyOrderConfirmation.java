package mjb2c.us.checkout;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.PageObjects.Cart;
import tools.PageObjects.CheckoutLoginIntercept;
import tools.PageObjects.CheckoutOrderConfirmation;
import tools.PageObjects.CheckoutOrderReview;
import tools.PageObjects.CheckoutPayment;
import tools.PageObjects.CheckoutShipping;
import tools.PageObjects.PDP;




/**
 *
 */
public class MJB2CUSGuestCheckoutVerifyOrderConfirmation
{
	private static final String CUST_CVVAL = "123";
	private static final String CUST_EXPDATEYEAR = "2022";
	private static final String CUST_EXPDATEMONTH = "01";
	private static final String CUST_CCNUM = "5555555555554444";
	private static final String CUST_CCNAME = "Sunny";
	private static final String CUST_CCINS = "MasterCard";
	private static final String CUST_PHONE = "+16514685841";
	private static final String CUST_ZIP = "95117";
	private static final String CUST_REGIONISO = "CALIFORNIA";
	private static final String CUST_TOWN = "San Jose";
	private static final String CUST_ADDRESSLINE1 = "4010 Moorpark Ave";
	private static final String CUST_LASTNAME = "Singh";
	private static final String CUST_FIRSTNAME = "Kamaljeet";
	private static final String CUST_EMAIL = "kamaljeet@pragiti.com";
	private static final String PDP_URL = "/en/shop/sunglasses/active-collection/insomnia";

	/**
	 * @param driver
	 * @param baseUrl
	 * @throws Exception
	 */
	public void testMJB2CUSGuestCheckoutVerifyOrderConfirmation(final WebDriver driver, final String baseUrl) throws Exception
	{
		{
			//GO TO PDP
			driver.get(baseUrl + PDP_URL);
			final WebDriverWait wait = new WebDriverWait(driver, 30);

			//ATC
			PDP.addToCartAction(driver);
			PDP.cart_Icon(driver).click();

			// CART PAGE
			Cart.addGiftBagAction(driver);
			Thread.sleep(3000);
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
			CheckoutShipping.shippingMethodSelection(driver, 2).click();
			wait.until(ExpectedConditions.elementToBeClickable(CheckoutShipping.shippingMethodSubmit(driver)));
			Thread.sleep(3000);
			CheckoutShipping.shippingMethodSubmit(driver).click();

			//Payment
			assertEquals("PAYMENT METHOD", CheckoutPayment.paymentMethodHeader(driver).getText());
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
			assertEquals("Copy Shipping Address", CheckoutPayment.copyShippingAddressLabel(driver).getText());

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
			assertEquals("YOUR RECEIPT", CheckoutOrderConfirmation.confirmationReceipt_Hdr(driver).getText());
			assertEquals("SHIPPING INFORMATION", CheckoutOrderConfirmation.confirmationShippingInfo_Hdr(driver).getText());
			assertEquals("BILLING INFORMATION", CheckoutOrderConfirmation.confirmationBillingInfo_Hdr(driver).getText());
			assertEquals("Sign up to receive email updates and information.", CheckoutOrderConfirmation.confirmationMktg_Hdr(driver)
					.getText());
			assertEquals("CREATE AN ACCOUNT", CheckoutOrderConfirmation.confirmationCreateAcct_Hdr(driver).getAttribute("value"));

		}
	}
}
