package zo.ca.registration;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tools.Utilities;
import tools.PageObjects.LoginRegistration;


/**
 *
 */
public class ZOCARegistration
{

	// Registration Test Data
	private static final String COUNTRY_SELECTOR = "CANADA (English)";
	private static final String CUST_PASS = "Qwerty@123";
	private static final String CUST_EMAIL = "zoqatest" + Utilities.dateTimeStamp() + "@pragiti.com";
	private static final String CUST_LNAME = "zo";
	private static final String CUST_FNAME = "zoqatest";

	/**
	 * @param driver
	 * @param baseUrl
	 * @throws Exception
	 */
	public void testZOCARegistration(final WebDriver driver, final String baseUrl) throws Exception
	{
		driver.get(baseUrl + "/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/div[2]/div[1]/ul[1]/li[2]/a")).click();
		driver.findElement(By.linkText(COUNTRY_SELECTOR)).click();
		LoginRegistration.regPage_Link(driver).click();
		LoginRegistration.regPage_Form_fname(driver).clear();
		LoginRegistration.regPage_Form_fname(driver).sendKeys(CUST_FNAME);
		LoginRegistration.regPage_Form_lname(driver).clear();
		LoginRegistration.regPage_Form_lname(driver).sendKeys(CUST_LNAME);
		LoginRegistration.regPage_Form_email(driver).clear();
		LoginRegistration.regPage_Form_email(driver).sendKeys(CUST_EMAIL);
		LoginRegistration.regPage_Form_confEmail(driver).click();
		LoginRegistration.regPage_Form_confEmail(driver).clear();
		LoginRegistration.regPage_Form_confEmail(driver).sendKeys(CUST_EMAIL);
		LoginRegistration.regPage_Form_pass(driver).clear();
		LoginRegistration.regPage_Form_pass(driver).sendKeys(CUST_PASS);
		LoginRegistration.regPage_Form_confPass(driver).clear();
		LoginRegistration.regPage_Form_confPass(driver).sendKeys(CUST_PASS);
		LoginRegistration.regPage_Form_Submit(driver).click();
		assertEquals("Thank you for registering.", driver.findElement(By.cssSelector("div.alert-checkbalance")).getText());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();

	}

}
