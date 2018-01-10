package mauijim.tools.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 *
 */

public class LoginRegistration
{


	public static WebElement regPage_Login_Submit(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='loginFormButton']/input"));
	}

	public static WebElement regPage_Login_Pass(final WebDriver driver)
	{
		return driver.findElement(By.id("j_password"));
	}

	public static WebElement regPage_Login_User(final WebDriver driver)
	{
		return driver.findElement(By.id("j_username"));
	}


	public static WebElement regPage_Form_Submit(final WebDriver driver)
	{
		return driver.findElement(By.xpath(".//*[@id='registerSubmitButton']/input"));
	}



	public static WebElement regPage_Form_confPass(final WebDriver driver)
	{
		return driver.findElement(By.id("register.checkPwd"));
	}



	public static WebElement regPage_Form_pass(final WebDriver driver)
	{
		return driver.findElement(By.id("password"));
	}



	public static WebElement regPage_Form_confEmail(final WebDriver driver)
	{
		return driver.findElement(By.id("confEmail"));
	}



	public static WebElement regPage_Form_email(final WebDriver driver)
	{
		return driver.findElement(By.id("register_email"));
	}



	public static WebElement regPage_Form_lname(final WebDriver driver)
	{
		return driver.findElement(By.id("register.lastName"));
	}



	public static WebElement regPage_Form_fname(final WebDriver driver)
	{
		return driver.findElement(By.id("register.firstName"));
	}



	public static WebElement regPage_Link(final WebDriver driver)
	{
		return driver.findElement(By.linkText("User"));
	}

}
