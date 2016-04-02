package rough.GiftCardTestCases;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import tools.PageObjects.Cart;
import tools.PageObjects.GiftCardPDP;
import tools.PageObjects.PDP;

 public class dcScenario2 {
	 
 private static final String GC_PIN = "";
private static final String GC_NUM = " ";
private static final double Discount = 120;	 
 private static final String Giftcard_Amount = "$125.00";
 private static final String Giftcard_Quantity = "2";
 private static final String PDP1 = "/en/shop/sunglasses/aviators/freight-trains";
 private static final double PDP1_PRICE = 329.00;
 private static final String BaseURL = "http://usmauijim.stg/";
private static final double GiftCardTotal = 150.00;

public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
	driver.get(BaseURL);
	driver.manage().window().maximize();
//	  Login
	
	
//	  PDP1 (higher Priced)
	  driver.get(BaseURL+PDP1);
	  
//	  ATC
	  PDP.atc_Btn(driver).click();
	  
//	  Gift Card PDP - specify quantity , value
	  GiftCardPDP.footerGiftcard_link(driver).click();
	  new Select(GiftCardPDP.buyGiftcard_Quantity_Select(driver)).selectByVisibleText(Giftcard_Quantity);
	  new Select(GiftCardPDP.buyGiftcard_Amount_Select(driver)).selectByVisibleText(Giftcard_Amount);
	  
//	  ATC
	  GiftCardPDP.addToCartAction(driver);
	  
//	  Cart Page
	  GiftCardPDP.cart_Icon(driver).click();

//	  Enter GC number , Pin
	  Cart.gcNum_Text(driver).clear();
	  Cart.gcNum_Text(driver).sendKeys(GC_NUM);
	  Cart.gcPin_Text(driver).clear();
	  Cart.gcPin_Text(driver).sendKeys(GC_PIN);
	  
//	  Submit GC button
	  Thread.sleep(1000);
	  Cart.gcApply_Btn(driver).sendKeys(Keys.RETURN);
	  Thread.sleep(1000);
	  
//	  Expected order total- PDP1 Price + Gift Card PDP Price - X dollars = Y]

	  double PriceTotal  =  (PDP1_PRICE + GiftCardTotal); 
	  double orderTotal  =  PriceTotal - Discount;
	  
//	  Order Total
	  assertEquals("$"+orderTotal, Cart.orderSummary_Total_Label(driver).getText());
 }
	
}
