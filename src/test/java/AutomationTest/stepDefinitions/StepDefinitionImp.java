package AutomationTest.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AutomationTest.TestComponents.BaseTest;
import automation.framework.pageobjects.LandingPage;
import automation.framework.pageobjects.OrderConfirmationPage;
import automation.framework.pageobjects.ProductCatalogue;
import automation.framework.pageobjects.cartPage;
import automation.framework.pageobjects.checkoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImp extends BaseTest {

    public LandingPage lpage;
    public ProductCatalogue productCatalogue;
    public cartPage cp;
    public OrderConfirmationPage confirmation;

    @Given("I Landed on Ecommerce Page")
    public void iLandedOnEcommercePage() throws IOException {
        lpage = launchApplication();
    }

    @Given("^Logged in with name (.+) and password (.+)$")
    public void iLoggedInWithNameAndPassword(String name, String password) {
        productCatalogue = lpage.LoginApplication(name, password);
    }

    @When("^add item (.+) to cart$")
    public void iAddItemToCart(String item) {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(item);
    }

    @And("^Checkout item (.+) and submit the order$")
    public void checkoutItemAndSubmitTheOrder(String item) {
        cp.goToCartPage();

        Boolean match = cp.VerifyProductDisplay(item);
        Assert.assertTrue(match);

        checkoutPage chkPg = cp.goToCheckout();
        chkPg.selectCountry();
        chkPg.selectCountryFromList();

        chkPg.scrollToPlaceOrder();

        confirmation = chkPg.checkTheOrder();
    }

    @Then("{string} message is displayed on Confirmation Page")
    public void messageIsDisplayedOnConfirmationPage(String orderMessage) {
        String orderConfirmationMessage = confirmation.getOrderConfirmationMessage();
        Assert.assertEquals(orderMessage, orderConfirmationMessage);
        driver.close();
    }
}
