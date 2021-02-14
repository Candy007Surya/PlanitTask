package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksAddCart {
	

	WebDriver driver;
	
	
	
	
	By selectbook = By.xpath("//div[@class='product-item']//div[@class='details']//a[text()='Computing and Internet']");
	
	By BooksTaps = By.xpath("//div[@class='header-menu']//child::ul[@class='top-menu']//child::a[contains(text(),'Books')]");
	
	By getprice =  By.xpath("//label[contains(text(),'Price:')]//following::span[@class='price-value-13']");
	
	By quantity  = By.xpath("//input[@id='addtocart_13_EnteredQuantity']");
	
	By addtocart  = By.xpath("//input[@id='add-to-cart-button-13']");
	
	By productvalidate = By.xpath("//div[@id='bar-notification']//child::p[@class='content']");
	
	
	
	
	public BooksAddCart(WebDriver driver)
	{
		this.driver=driver;
	}

	
	
	
	public void ClickonBooks()
	{
		driver.findElement(BooksTaps).click();
	}
	
	public void SelectBook()
	{
		driver.findElement(selectbook).click();
	}
	
	public String  GetPriceOfBook()
	{
		return driver.findElement(getprice).getText();
	}
	
	public void EnterQunaity()
	{
		driver.findElement(quantity).sendKeys("7");
	}
	
	
	public void AddToCart()
	{
		driver.findElement(addtocart).click();
	}
	
	public String ProductValidateMessage()
	{
		return driver.findElement(productvalidate).getText();
		
	}

}
