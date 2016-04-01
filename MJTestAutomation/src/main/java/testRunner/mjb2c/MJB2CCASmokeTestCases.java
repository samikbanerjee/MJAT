/**
 *
 */
package testRunner.mjb2c;

import java.util.concurrent.TimeUnit;

import mjb2c.ca.checkout.MJB2CCAGuestCheckoutVerifyOrderConfirmation;
import mjb2c.ca.checkout.MJB2CCALoginCheckoutVerifyOrderConfirmation;
import mjb2c.ca.registration.MJB2CCALoginValidUser;
import mjb2c.ca.registration.MJB2CCAReg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import tools.BaseTestCase;


/**
 *
 */
public class MJB2CCASmokeTestCases extends BaseTestCase
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
		caps.setCapability("build", "MJB2CCASmokeTestCases 04-01-2016 v0.1");
		caps.setCapability("acceptSslCerts", true);
		caps.setCapability("tunnel-identifier", "MJConnection");


		driver = new RemoteWebDriver(new java.net.URL("http://" + authentication.getUsername() + ":"
				+ authentication.getAccessKey() + URL), caps);
		this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();

		baseUrl = "http://camauijim.stg/";
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
	 * Site : MJ B2C CA; Scenario - Registration
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCAReg() throws Exception
	{
		new MJB2CCAReg().testMJB2CCAReg(driver, baseUrl);
	}


	/**
	 * <p>
	 * Site: MJ B2C CA; Scenario -Registration (ForgotPasswordEmailSend)
	 * </p>
	 *
	 * @throws Exception
	 */
	//	@Test
	//	public void testMJB2CCAForgotPasswordEmailSend() throws Exception
	//	{
	//		new MJB2CCAForgotPasswordEmailSend().testMJB2CCAForgotPasswordEmailSend(driver, baseUrl);
	//	}

	/**
	 * <p>
	 * Site: MJ B2C CA; Scenario - Registration(LoginValidUser)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCALoginValidUser() throws Exception
	{
		new MJB2CCALoginValidUser().testMJB2CCALoginValidUser(driver, baseUrl);
	}



	/**
	 * <p>
	 * Site: Site: MJ B2C CA; Scenario - OpenForgotPasswordPage
	 * </p>
	 *
	 * @throws Exception
	 */
	//	@Test
	//	public void testMJB2CCAOpenForgotPasswordPage() throws Exception
	//	{
	//		new MJB2CCAOpenForgotPasswordPage().testMJB2CCAOpenForgotPasswordPage(driver, baseUrl);
	//	}

	/**
	 * <p>
	 * Site: Site: MJ B2C CA; Scenario - Checkout(Guest)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCAGuestCheckoutVerifyOrderConfirmation() throws Exception
	{
		new MJB2CCAGuestCheckoutVerifyOrderConfirmation().testMJB2CCAGuestCheckoutVerifyOrderConfirmation(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site: Site: MJ B2C CA; Scenario - Checkout(Login)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCALoginCheckoutVerifyOrderConfirmation() throws Exception
	{
		new MJB2CCALoginCheckoutVerifyOrderConfirmation().testMJB2CCALoginCheckoutVerifyOrderConfirmation(driver, baseUrl);

	}
}
