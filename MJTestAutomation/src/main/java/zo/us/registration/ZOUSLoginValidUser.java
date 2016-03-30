/**
 *
 */
package zo.us.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tools.PageObjects.LoginRegistration;


/**
 *
 */
public class ZOUSLoginValidUser
{
	//LoginValidUser Test Data
	private static final String CUST_PASS = "Testing@1";
	private static final String CUST_EMAIL = "kamaljeet@pragiti.com";
	private static final String COUNTRY_SELECTOR = "UNITED STATES (English)";

	/**
	 * @param driver
	 * @param baseUrl
	 * @throws Exception
	 */
	public void testZOUSLoginValidUser(final WebDriver driver, final String baseUrl) throws Exception
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
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}
}
