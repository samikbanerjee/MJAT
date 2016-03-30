package mjb2c.us.registration;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tools.PageObjects.LoginRegistration;


/**
 *
 */
public class MJB2CUSLoginValidUser
{
	//LoginValidUser Test Data
	private static final String CUST_PASS = "Qwerty@1234";
	private static final String CUST_EMAIL = "mjaqatest@pragiti.com";
	private static final String COUNTRY_SELECTOR = "UNITED STATES (English)";

	/**
	 * @param driver
	 * @param baseUrl
	 * @throws Exception
	 */
	public void testMJB2CUSLoginValidUser(final WebDriver driver, final String baseUrl) throws Exception
	{
		driver.get(baseUrl + "/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/div[2]/div[1]/ul[1]/li[2]/a")).click();
		driver.findElement(By.linkText(COUNTRY_SELECTOR)).click();
		LoginRegistration.regPage_Link(driver).click();
		LoginRegistration.regPage_Login_User(driver).clear();
		LoginRegistration.regPage_Login_User(driver).sendKeys(CUST_EMAIL);
		LoginRegistration.regPage_Login_Pass(driver).clear();
		LoginRegistration.regPage_Login_Pass(driver).sendKeys(CUST_PASS);
		LoginRegistration.regPage_Login_Submit(driver).click();
		assertEquals("Sunglasses designed to change the way you see the world..", driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}


}
