package AutomationTest.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import AutomationTest.TestComponents.BaseTest;
import automation.framework.pageobjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorValidationStepDefinitionImp extends BaseTest {
   
    public LandingPage lopage;
    
    @Given("I open Ecommerce Page")
    public void openEcommercePage() throws IOException {
        lopage = launchApplication();
    }

    @When("^Logged in with name (.+) and password (.+)$")
    public void loggedInWithNameAndPassword(String name, String password) {
    	lopage.LoginApplication(name,password);
    }

    @Then("\"Incorrect email or password.\" message is displayed")
    public void incorrectEmailOrPasswordMessageIsDisplayed() {
        // Your assertion logic here to verify the error message
        // For example:
        String actualErrorMessage = lopage.getErrorMessage();
        String expectedErrorMessage = "Incorrect email or password.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match");
        driver.quit();
    }
}
