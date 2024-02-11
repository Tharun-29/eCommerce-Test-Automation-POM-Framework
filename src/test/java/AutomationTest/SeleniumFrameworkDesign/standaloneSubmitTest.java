package AutomationTest.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.framework.pageobjects.LandingPage;
import automation.framework.pageobjects.OrderConfirmationPage;
import automation.framework.pageobjects.ProductCatalogue;
import automation.framework.pageobjects.cartPage;
import automation.framework.pageobjects.checkoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standaloneSubmitTest {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String item = "ADIDAS ORIGINAL";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Login Page
		LandingPage lpage = new LandingPage(driver);
		lpage.goTo();

		ProductCatalogue productCatalogue = lpage.LoginApplication("DavidMDiaz@rhyta.com", "David@54321");
		List<WebElement> products = productCatalogue.getProductList();

		cartPage cp = productCatalogue.addProductToCart(item);
		cp.goToCartPage();

		Boolean match = cp.VerifyProductDisplay(item);
		Assert.assertTrue(match);

		checkoutPage chkPg = cp.goToCheckout(); 
		chkPg.selectCountry();
        chkPg.selectCountryFromList();

		
		chkPg.scrollToPlaceOrder();

		OrderConfirmationPage confirmation = chkPg.checkTheOrder();
		
    
		// Order Confirmation Page Section
		confirmation.getOrderId();
	}
}
