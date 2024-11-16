package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class createOrder {

	public static void main(String[] args) {
		//Navigate to URL
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		
		//User Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//User navigate to Products page
		driver.findElement(By.xpath("//span[contains(.,'Products')]"));
		System.out.println("User was logged in succesfully");
		System.out.println("User was redirected to Products page succesfully");
		
		
		//Sort Products on price highest to lowest
		driver.findElement(By.xpath("//select[@data-test='product-sort-container']")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();
		System.out.println("Products are now ordered based on prices high to low");
		
		// Add items to shopping cart
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		System.out.println("products are selected by user");
		
		// Navigate to Shopping card page
		driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
		
		// Verify user is redirected to shopping card page
		driver.findElement(By.xpath("//span[contains(.,'Your Cart')]"));
		System.out.println("User was redirected to Shopping card page succesfully");
		
		//Verify that shopping card contains correct products and description
		
		if (driver.getPageSource().contains("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.")) {
			System.out.println("Sauce Labs bolt T-shirt was added to cart succesfully");
			}
		
		if (driver.getPageSource().contains("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.")) {
			System.out.println("classic Sauce Labs t-shirt was added to cart succesfully");
			}
	
		// Navigate to checkout page
		driver.findElement(By.xpath("//*[@id='checkout']")).click();
		if (driver.getPageSource().contains("Checkout: Your Information")) {
			System.out.println("user was redirected to Checkout page succesfully");
		}
		
		//Enter user data
		driver.findElement(By.id("first-name")).sendKeys("testuser_first-name");
		driver.findElement(By.id("last-name")).sendKeys("testuser_last-name");
		driver.findElement(By.id("postal-code")).sendKeys("64912");
		
		//navigate to Overview page
		driver.findElement(By.id("continue")).click();
		if (driver.getPageSource().contains("Checkout: Overview")) {
			System.out.println("user was redirected to Overview page succesfully succesfully");
			}
		
		//Verify overview page elements
		if (driver.getPageSource().contains("Item total: $31.98" + "Tax: $2.56" + "Total: $34.54" + "Payment Information:"
				+ "SauceCard #31337" + "Shipping Information:" + "Free Pony Express Delivery" + "Price Total" + "Item total: $31.98" + "Tax: $2.56" +
				"Total: $34.54")); 
			System.out.println("The page elements are displayed correctly on the Overview page");
		
		//Verify total price
		if (driver.getPageSource().contains("Total: $34.54")) {
			System.out.println("Total price was calculated correctly");
			}
		
		//Navigate to Checkout: Complete! page
		driver.findElement(By.id("finish")).click();
		if (driver.getPageSource().contains("Checkout: Complete!")) {
			System.out.println("User was redirected to Checkout: Complete! page succesfully");
			}
		
		//Verify order confirmation
		if (driver.getPageSource().contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!")) {
			System.out.println("Order confirmation is displayed correctly");
			}
		
		//Navigate back to products page
		driver.findElement(By.id("back-to-products")).click();
		driver.findElement(By.xpath("//span[contains(.,'Products')]"));
		System.out.println("User can navigate back to products page by using back home button");	
		
		driver.quit();	
		
		}
}
		
	
