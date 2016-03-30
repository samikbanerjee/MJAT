/**
 *
 */
package zo.testRunner;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import tools.BaseTestCase;
import zo.us.checkout.ZLUSGuestCheckoutVerifyOrderConfirmation;
import zo.us.checkout.ZLUSLoggedInUserCheckOutConfirmation;
import zo.us.registration.ZOUSLoginValidUser;
import zo.us.registration.ZOUSRegistration;


/**
 *
 */
public class ZOUSSmokeTestCases extends BaseTestCase
{
	private WebDriver driver;
	private String baseUrl;


	/**
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception
	{
		//driver = new FirefoxDriver();
		final DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "44.0");
		caps.setCapability("screenResolution", "1280x1024");
		caps.setCapability("name", name.getMethodName());
		caps.setCapability("build", "ZOUSSmokeTestCases 03-30-2016 v0.1");
		caps.setCapability("acceptSslCerts", true);
		caps.setCapability("tunnel-identifier", "MJConnection");


		driver = new RemoteWebDriver(new java.net.URL("http://" + authentication.getUsername() + ":"
				+ authentication.getAccessKey() + URL), caps);
		this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();

		baseUrl = "http://uszealoptics.stg/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		driver.quit();
	}

	/**
	 * <p>
	 * Site : ZO US; Scenario - Registration
	 * </p>
	 * *
	 *
	 * @throws Exception
	 */
	@Test
	public void testZOUSRegistration() throws Exception
	{
		new ZOUSRegistration().testZOUSRegistration(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site : ZO US; Scenario - Login Valid User
	 * </p>
	 * *
	 *
	 * @throws Exception
	 */
	@Test
	public void testZOUSLoginValidUser() throws Exception
	{
		new ZOUSLoginValidUser().testZOUSLoginValidUser(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site : ZO US; Scenario - Checkout(Guest)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testZLUSGuestCheckoutVerifyOrderConfirmation() throws Exception
	{
		new ZLUSGuestCheckoutVerifyOrderConfirmation().testZLUSGuestCheckoutVerifyOrderConfirmation(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site : ZO US; Scenario - Checkout(Login)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testZLUSLoggedInUserCheckOutConfirmation() throws Exception
	{
		new ZLUSLoggedInUserCheckOutConfirmation().testZLUSLoggedInUserCheckOutConfirmation(driver, baseUrl);
	}
}
