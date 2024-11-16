package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginFeature {
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
    
    @When("user enters valid credentials and clicks on the Login button")
    public void userEntersValidCredentials() {
        
        
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
      
    }
    
    @Then("User is logged in and redirected to the Products page")
    public void validateUserIsOnProductspage() {
		driver.findElement(By.xpath("//span[contains(.,'Products')]"));

    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}