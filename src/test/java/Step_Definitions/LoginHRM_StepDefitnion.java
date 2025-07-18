package Step_Definitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.LoginHRM_POM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginHRM_StepDefitnion
{
	public static String Browser = "Chrome";
	public static WebDriver driver;
	
    LoginHRM_POM loginPage;
	
	@Given("User opened the Browser")
	public void user_opened_the_browser() 
	{
		if (Browser.equals("Chrome"))
		{
			 driver= new ChromeDriver();
		}
		else if (Browser.equals("Firefox"))
		{
			 driver= new FirefoxDriver();	
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("Navigate to URL and open the login page")
	public void navigate_to_url_and_open_the_login_page() {
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginHRM_POM(driver); 
		driver.manage().window().maximize();
	}

	
	@When("User enter {string} and {string}")
	public void user_enter_and(String Username, String Password) 
	{
		loginPage.HRM_enterUsername(Username);
		loginPage.HRM_enterPassword(Password);
	}

	@And("Click on login button")
	public void click_on_login_button()
	{
		loginPage.HRM_clickLoginButton();
	}
	
	@Then("Message Should display {string}")
	
	public void message_should_display(String Message) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		    if (Message.equalsIgnoreCase("success"))
		    {
		        Assert.assertTrue(driver.findElements(By.xpath("//h6[text()='Dashboard']")).size() > 0, "Dashboard not displayed after login.");
		    }
		    
		    else if (Message.equalsIgnoreCase("Invalid Credentials"))
		    {
		    	Assert.assertTrue(driver.findElements(By.xpath("//p[contains(@class, 'oxd-alert-content-text')]")).size() > 0, 
			            "Error message not displayed on invalid login.");
		    }
		    
		    else if (Message.equalsIgnoreCase("Username and password should not be empty")) 
		    {
		    	Assert.assertTrue(driver.findElements(By.xpath("(//span[text()='Required'])[1]")).size() > 0, 
			            "Error message not displayed on invalid login.");
		    } 
		    
		    
		    else
		    {
		        throw new IllegalArgumentException("Unexpected message text: " + Message);
		    }
		}

	
	@And("Close the Browser")
	public void close_the_browser() 
	{
	       driver.quit();
	}


}
