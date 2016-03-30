/**
 *
 */
package zo.testRunner;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import tools.BaseTestCase;
import zo.ca.checkout.ZLCAGuestCheckoutVerifyOrderConfirmation;
import zo.ca.checkout.ZLCALoggedInUserCheckoutVerifyOrderConfirmation;
import zo.ca.registration.ZOCALoginValidUser;
import zo.ca.registration.ZOCARegistration;


/**
 *
 */
public class ZOCASmokeTestCases extends BaseTestCase
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
		caps.setCapability("build", "ZOCASmokeTestCases 03-30-2016 v0.1");
		caps.setCapability("acceptSslCerts", true);
		caps.setCapability("tunnel-identifier", "MJConnection");


		driver = new RemoteWebDriver(new java.net.URL("http://" + authentication.getUsername() + ":"
				+ authentication.getAccessKey() + URL), caps);
		this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();

		baseUrl = "http://cazealoptics.stg/";
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
	 * Site : ZO CA; Scenario - Registration
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testZOCARegistration() throws Exception
	{
		new ZOCARegistration().testZOCARegistration(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site : ZO CA; Scenario - Logged in valid user
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testZOCALoginValidUser() throws Exception
	{
		new ZOCALoginValidUser().testZOCALoginValidUser(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site : ZO CA; Scenario - Checkout(Guest)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testZLCAGuestCheckoutVerifyOrderConfirmation() throws Exception
	{
		new ZLCAGuestCheckoutVerifyOrderConfirmation().testZLCAGuestCheckoutVerifyOrderConfirmation(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site : ZO CA; Scenario - Checkout(Login)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testZLCALoggedInUserCheckoutVerifyOrderConfirmation() throws Exception
	{
		new ZLCALoggedInUserCheckoutVerifyOrderConfirmation().testZLCALoggedInUserCheckoutVerifyOrderConfirmation(driver, baseUrl);

	}
}
