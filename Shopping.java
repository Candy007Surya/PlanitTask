package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shopping {

	
	WebDriver driver;
	

	 By ValidateUsername  = By.xpath("//a[contains(text(),'atest@gmail.com')]");
	 
	 By ShoppingCart =  By.xpath("//span[contains(text(),'Shopping cart')]");
	 
	 By CheckBox          = By.xpath("//input[@type='checkbox']//parent::td[@class='remove-from-cart']");
	 
	 By ClearValue        = By.xpath("//input[@class='qty-input']");
	 
	 By updateshoopingcart  = By.xpath("//input[@value='Update shopping cart']");
	 
	 By validateSubtotal   = By.xpath("//div[@id='flyout-cart']//child::div[@class='totals']//child::strong");
	 
	 By gotocart        = By.xpath("//div[@class='buttons']/input[@value='Go to cart']");
	
	public Shopping(WebDriver driver)
	{
		this.driver= driver;
	}
	 
	 
	 public String ValidateUsername()
	 {
		 
		 return  driver.findElement(ValidateUsername).getText();
	 }
	 
	 public void ClickOnShoppingCart()
	 {
		  driver.findElement(ShoppingCart).click();
	 }
	 
	 
	 public WebElement ShopcartHover()
	 {
		 return driver.findElement(ShoppingCart);
	 }
	 
	 public void checkbox()
	 {
		 driver.findElement(CheckBox).click();
	 }
	 
	 public void ClearField()
	 {
		 driver.findElement(ClearValue).clear();
	 }
	 
	 public void ClearShoppingCart()
	 {
		 driver.findElement(updateshoopingcart).click();
	 }
	 
	 
	 public void ClickonUsername()
	 {
		 
		 driver.findElement(ValidateUsername).click();
	 }
	 
	 public String ValidateSubtotal()
	 {
		 return driver.findElement(validateSubtotal).getText();
		 
	 }
	 
	 public void GoToCartClick()
	 {
		 driver.findElement(gotocart).click();
	 }
	
}



