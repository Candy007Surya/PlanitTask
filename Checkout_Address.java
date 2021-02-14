package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Checkout_Address 
{


	WebDriver driver;
	
	By checkout   =By.xpath("//div[@class='checkout-buttons']/child::button[@id='checkout']");
	By terms      = By.xpath("//div[@class='terms-of-service']/child::input[@id='termsofservice']");
	By billdropdwon = By.xpath("//select[@id='billing-address-select']");
	
	By continu      = By.xpath("//div[@id='billing-buttons-container']//child::input[@value='Continue']");
	
	By shippingaddress  = By.xpath("//select[@id='shipping-address-select']");
	
	By shipcontinuebutton  = By.xpath("//div[@id='shipping-buttons-container']//child::input[@value='Continue']");
	
	By nextdayair  = By.xpath("//div[@class='method-name']//child::input[@id='shippingoption_1']");
	
	By airContinue = By.xpath("//div[@id='shipping-method-buttons-container']//input[@value='Continue']");
	
	By COD          = By.xpath("//div[@class='payment-details']//input[@id='paymentmethod_0']");
	
	By codContinue  = By.xpath("//div[@id='payment-method-buttons-container']//input[@value='Continue']");
	
	By validateCodtext  = By.xpath("//p[contains(text(),'You will pay by COD')]");
	
	By Paycontinue  = By.xpath("//div[@id='payment-info-buttons-container']/child::input[@value='Continue']");
	
	By orderconforim  = By.xpath("//div[@id='confirm-order-buttons-container']/child::input[@value='Confirm']");
	
	By validateconfrim  = By.xpath("//div[@class='title']//strong[contains(text(),'Your order has been successfully processed!')]");
	
	By logout          = By.xpath("//a[contains(text(),'Log out')]");
	
	
	public Checkout_Address(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void ClickonCheckOut()
	{
		driver.findElement(checkout).click();
	}
	
	
	public void TermsConditions()
	{
		driver.findElement(terms).click();
	}
	
	public WebElement BillDropdwon()
	{
		  return driver.findElement(billdropdwon);
	}
	
	
	public void ClickOnContinue()
	{
		driver.findElement(continu).click();
	}
	
	
	public WebElement ShippingAddress()
	{
		return driver.findElement(shippingaddress);
	}
	
	public void ClickonShipContinue()
	{
		driver.findElement(shipcontinuebutton).click();
	}
	
	
	public void NextDayAir()
	{
		driver.findElement(nextdayair).click();
	}
	
	public void NextDayContinue()
	{
		driver.findElement(airContinue).click();
	}
	
	
	public void ClickonCOD()
	{
		driver.findElement(COD).click();
	}
	
	public void CODContinueClick()
	{
		driver.findElement(codContinue).click();
	}
	
	public String ValidatePayText()
	{
		return driver.findElement(validateCodtext).getText();
	}
	
	public void PayinfoContinue()
	{
		driver.findElement(Paycontinue).click();
	}
	
	public void OrderConfirm()
	{
		driver.findElement(orderconforim).click();
	}
	
	public String ValidateOrderConfrim()
	{
		return driver.findElement(validateconfrim).getText();
	}
	
	public void Logout()
	{
		driver.findElement(logout).click();
	}
}
