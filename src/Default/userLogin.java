package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class userLogin {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// navigate to loginPage
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		
		// Login user with valid credentials
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Validate that you’re logged in successfully
		driver.findElement(By.xpath("//span[contains(.,'Products')]"));
		System.out.println("user logged in succesfully");
		
		//Validate the “locked_out_user” user
		driver.findElement(By.xpath("//*[@id=\'react-burger-menu-btn\']")).click();
		driver.findElement(By.xpath("//*[@id=\'logout_sidebar_link']")).click();
		System.out.println("User was logged out succesfully");
		
		//verify user is back on the login page again
		if (driver.getPageSource().contains("Login")) {
		System.out.println("User was redirected back to Login page");	
		}
		
		//Verify that locked out user is unable to Login
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.getPageSource().contains("Epic sadface: Sorry, this user has been locked out.");
        System.out.println("Error message for locked-out user is displayed correctly");
		
		driver.quit();
	}

 }
