package atest;

import java.util.concurrent.TimeUnit;

import mjb2c.us.checkout.MJB2CUSGuestCheckoutVerifyOrderConfirmation;

import org.openqa.selenium.firefox.FirefoxDriver;


/**
 *
 */
public class Atest
{
	private static final String CUST_PASS = "Qwerty@1234";
	private static final String CUST_EMAIL = "mjaqatest@pragiti.com";
	private static final String baseURL = "http://usmauijim.stg";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception
	{
		final FirefoxDriver dr = new FirefoxDriver();

		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new MJB2CUSGuestCheckoutVerifyOrderConfirmation().testMJB2CUSGuestCheckoutVerifyOrderConfirmation(dr, baseURL);
		System.out.println("Done");

	}
}
