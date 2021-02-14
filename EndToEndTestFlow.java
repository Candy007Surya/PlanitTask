package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.BooksAddCart;
import PageObjects.Checkout_Address;
import PageObjects.MainPage;
import PageObjects.Shopping;
public class EndToEndTestFlow extends Base
{

	public static   WebDriver  driver;
	public static Properties prop;
	static MainPage  mpg ; 
	static Shopping shp;
	static BooksAddCart  bks ;
	static Checkout_Address cad;
	
	
	
	@BeforeTest
	public void openBrowser() throws FileNotFoundException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromelatest\\chromedriver.exe");
		driver = new ChromeDriver();
        prop = new Properties();	
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\data.properties")));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	

	
	
	//Intial Checling
	@Test(priority=1)
	
	public void InitialCheck()
	{
		mpg = new MainPage(driver);
		mpg.clickLogin();
		String ValidateWelcon = "Welcome, Please Sign In!";
		Assert.assertEquals(mpg.ValidateWelcom(), ValidateWelcon);
	}
	
	
	//Enteting username and password
	@Test(priority=2)
	public void LogIn() {

		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		mpg.EmailId(username);
		mpg.Password(password);
		mpg.MainLogin();
		
	}
	
	//AftertLogin Clear the cart
	@Test(priority=3)
	public void ClearTheShopCart()
	{
		shp = new Shopping(driver);
		String UsernameValidation = "atest@gmail.com";
		Assert.assertEquals(shp.ValidateUsername(),UsernameValidation);
		//click on shoping cart
		shp.ClickOnShoppingCart();
		shp.checkbox();
		shp.ClearField();
		shp.ClearShoppingCart();
		
	}
	
	
	//selecting the book and add cart
	@Test(priority=4)
	public void BookAddCart()
	{
		bks = new BooksAddCart(driver);
		bks.ClickonBooks();
		bks.SelectBook();
		System.out.println(" The price of the Selected book is--->"+bks.GetPriceOfBook());
		bks.EnterQunaity();
		bks.AddToCart();
		System.out.println("Validattion Message of producrt-->"+ bks.ProductValidateMessage());
	}
	
	//validating the sub total
	@Test(priority=5)
	public void ValidateSubTotal()
	{
		
		WebElement shiping = shp.ShopcartHover();
		MouseHoverAndHoldCtrlMethod(shiping);
		//String subtotal =  shp.ValidateSubtotal();
		System.out.println("Validate the sub total --->"+shp.ValidateSubtotal()); 
		shp.GoToCartClick();
	}
	
	
	//AddtoCartAndAddressFilling
	@Test(priority=6)
	public void AddressFilling() throws InterruptedException
	{
		cad = new Checkout_Address(driver);
		cad.TermsConditions();
		cad.ClickonCheckOut();
		System.out.println("this step si done ");
		//selecting new bill from drop down
		WebElement dropdown = cad.BillDropdwon();
		String value = "atest dummy, et5y56iytk, frhtrjt 345666, American Samoa";
		SelectDropdwon(dropdown,value);
		cad.ClickOnContinue();
		System.out.println("bill is done about to ship");
		WebElement shipdropdown = cad.ShippingAddress();
		String Value2 = "atest dummy, et5y56iytk, frhtrjt 345666, American Samoa";
		SelectDropdwon(shipdropdown,Value2);
		System.out.println("bill is done about to cod");
		  cad.ClickonShipContinue();
		  cad.NextDayAir();
		  cad.NextDayContinue();
		  cad.ClickonCOD();
		  
		  cad.CODContinueClick();
		  Thread.sleep(3000);
		 // cad.ValidatePayText()
		  String PaymentCod = "You will pay by COD";
		  Assert.assertEquals( cad.ValidatePayText(), PaymentCod);
		  cad.PayinfoContinue();
		  cad.OrderConfirm();
		  Thread.sleep(3000);
		  String ValidateOrder = "Your order has been successfully processed!";
		  Assert.assertEquals( cad.ValidateOrderConfrim(), ValidateOrder);
	}
	
	@Test(priority=7)
	public void Logout()
	{
		cad.Logout();
		System.out.println("End to End flow is done");
	}
	
	
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	
	
	public static void MouseHoverAndHoldCtrlMethod(WebElement we){

		
		Actions a1 = new Actions(driver);
		a1.moveToElement(we).build().perform();
	}
	
	
 	public static void SelectDropdwon(WebElement ele ,String sc)
  	{
  		Select  sw = new Select(ele);
  		
  		sw.selectByVisibleText(sc);
  	}
}


