/**
 *
 */
package mauijim.MJOrderAutomation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 *
 */
public class MJB2CUSOrderAutomation
{
	private static WebDriver driver;
	private static final String USERNAME = "samikbanerjee1";
	private static final String AUTOMATE_KEY = "176d0ad6-8028-4068-bf7a-8617758ed99b";
	private static final String URL = "@ondemand.saucelabs.com:80/wd/hub";


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final DateFormat dateFormat = new SimpleDateFormat("MMddyyHHmmss");
		final String dtStamp = dateFormat.format(new Date());

		final DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "44.0");
		caps.setCapability("screenResolution", "1280x1024");
		caps.setCapability("name", "Placing Order - " + dtStamp);
		caps.setCapability("build", "MJB2CUSOrderAutomation");
		caps.setCapability("acceptSslCerts", true);
		caps.setCapability("tunnel-identifier", "MJConnection");
		driver = new RemoteWebDriver(new java.net.URL("http://" + USERNAME + ":" + AUTOMATE_KEY + URL), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		final PlaceOrder po = new PlaceOrder("MJB2CUSTestData.properties");
		final String order_num = po.loginCheckout(driver);
		System.out.println(order_num);
		driver.quit();
	}



}
