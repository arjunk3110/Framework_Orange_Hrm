package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRM_POM 
{
	private WebDriver driver;
	
	//Constructor
	 public LoginHRM_POM(WebDriver driver)
	    {
	        this.driver = driver;
	    }
	 
	
	By Txt_Username = By.name("username");
	By Txt_Password = By.name("password");
	By Button_Login = By.xpath("//button[@type ='submit']");
	

			
    public void HRM_enterUsername(String Username)
    {
        driver.findElement(Txt_Username).clear();
        driver.findElement(Txt_Username).sendKeys(Username);
    }

    public void HRM_enterPassword(String Password) 
    {
        driver.findElement(Txt_Password).clear();
        driver.findElement(Txt_Password).sendKeys(Password);
    }

    public void HRM_clickLoginButton()
    {
        driver.findElement(Button_Login).click();
    }
	   
}
