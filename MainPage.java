package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
	
	

	WebDriver driver;
	
	  By Login = By.xpath("//a[contains(text(),'Log in')]");
	  
	  By Validate  = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
	
	  By EmailID = By.xpath("//input[@id='Email']");
	  
	  By PWD = By.xpath("//input[@id='Password']");
	  
	  By MAinLogin  = By.xpath("//input[@value='Log in']");
      	
	
	
	public MainPage(WebDriver driver)
	{

        this.driver = driver;

    }
	
	//Click onLogin
    public void clickLogin()
    {

            driver.findElement(Login).click();

    }
    
    //Validate the welcomeSigin 
   public String ValidateWelcom()
   {
	return  driver.findElement(Validate).getText();
	   
   }

   public  void   EmailId(String username)
   {
	    driver.findElement(EmailID).sendKeys(username);;
   }
   
   public  void Password(String password)
   {
	   driver.findElement(PWD).sendKeys(password);
   }
   
   public void MainLogin()
   {

           driver.findElement(MAinLogin).click();

   }

}
