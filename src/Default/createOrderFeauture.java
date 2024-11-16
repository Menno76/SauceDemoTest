package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class createOrderFeauture {
    private WebDriver driver;
	
	 @Before
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }
	    
	    @Given("user is on the loginPage")
	    public void userIsOnLoginPage() {
	    	driver.get("https://www.saucedemo.com");
			driver.manage().window().maximize();;
	    }
	    
	    @Given("user enters valid credentials and clicks on the Login button")
	    public void userEntersValidCredentials() {
	    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
	      
	    }
	    
	    @Given("User is logged in and redirected to the Products page")
	    public void validateUserIsOnProductspage() {
			driver.findElement(By.xpath("//span[contains(.,'Products')]"));
	    }
			
		@When("User Adds items to shopping card")
		public void userAddsitemsToShoppingCart() {
			driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
			driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
			
		}
		
		@When("User navigates to Shopping card page")
		public void userNavigatesToShoppingCard () {
			driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
			driver.findElement(By.xpath("//span[contains(.,'Your Cart')]"));
			System.out.println("User was redirected to Shopping card page succesfully");

	    }
		
		@When("User continues to the Checkout page")
		public void userNavigatesToCheckoutPage () {
			driver.findElement(By.xpath("//*[@id='checkout']")).click();
			driver.getPageSource().contains("Checkout: Your Information"); {
			System.out.println("user was redirected to Checkout page succesfully");
			}
		}
		
		@When("User enters data")		
		public void enterUserData() {
			driver.findElement(By.id("first-name")).sendKeys("testuser_first-name");
			driver.findElement(By.id("last-name")).sendKeys("testuser_last-name");
			driver.findElement(By.id("postal-code")).sendKeys("64912");
		}
		
		@When("User navigates to Overview page")
		public void userNavigatesToOverviewPage() {
			driver.findElement(By.id("continue")).click();
			driver.getPageSource().contains("Checkout: Overview");
			System.out.println("user was redirected to Overview page succesfully succesfully");
				}

		@Then("Verify overview page elements") 
		public void verifyOverviewPageElements() {
			driver.getPageSource().contains("Item total: $31.98" + "Tax: $2.56" + "Total: $34.54" + "Payment Information:"
					+ "SauceCard #31337" + "Shipping Information:" + "Free Pony Express Delivery" + "Price Total" + "Item total: $31.98" + "Tax: $2.56" +
					"Total: $34.54");
				System.out.println("The page elements are displayed correctly on the Overview page");
				}
		
		@Then("Verify total price")
		public void verifyTotalPrice() {
			driver.getPageSource().contains("Total: $34.54"); {
			System.out.println("Total price was calculated correctly");
			}
			}
		
		@When("Navigate to Checkout: Complete! page")
		public void navigateToCheckoutPage() {
			driver.findElement(By.id("finish")).click();
			driver.getPageSource().contains("Checkout: Complete!");
			System.out.println("User was redirected to Checkout: Complete! page succesfully");
		}
		
		@Then("Order confirmation is displayed correctly")
		public void verifyOrderConfirmation() {
			driver.getPageSource().contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
			System.out.println("Order confirmation is displayed correctly");
				}

		@Then("User can navigate back to products page")
		public void NavigateBackToProductspage() {
			driver.findElement(By.id("back-to-products")).click();
			driver.findElement(By.xpath("//span[contains(.,'Products')]"));
			System.out.println("User was able to navigate back to products page by using back home button succesfully");	
		
			driver.quit();	
		}
}

	   
