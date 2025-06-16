package com.CRM24.step_definitions;

import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.ConfigurationReader;
import com.CRM24.utilities.Driver;
import com.sun.source.tree.BreakTree;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class LoginPage_StepDefinitions {

    LoginPage loginPage = new LoginPage();


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("I log in as {string}")
    public void iAmLogInAs(String userType) {
        loginPage.login(userType);
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("I should land on the home page and the {string} should be displayed")
    public void iShouldLandOnTheHomePageAndTheShouldBeDisplayed(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));

    }

    @When("I enter a valid {string} and an invalid {string}")
    public void iEnterAValidAndAnInvalid(String username, String password) {
        loginPage.invalidLogin(username, password);
    }

    @Then("the {string} should be displayed")
    public void theShouldBeDisplayed(String errorMessage) {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @When("I enter an invalid {string} and a valid {string}")
    public void iEnterAnInvalidAndAValid(String username, String password) {
        loginPage.invalidLogin(username, password);

    }

    @When("I log in with missing {string} and or {string} fields")
    public void iLogInWithMissingAndOrFields(String username, String password) {
        loginPage.invalidLogin(username, password);
    }

    @Then("the {string} text should be visible")
    public void theTextShouldBeVisible(String message) {
        Assert.assertTrue(loginPage.rememberMeMessage.isDisplayed());

    }

    @When("I click the Remember me checkbox")
    public void iClickTheRememberMeCheckbox() {
        loginPage.rememberMeCheckBox.click();

    }

    @Then("the Remember me checkbox should be selected")
    public void theRememberMeCheckboxShouldBeSelected() {
        Assert.assertTrue(loginPage.rememberMeCheckBox.isSelected());
    }

    @When("I enter a {string} as password")
    public void iEnterAPassword(String anypassword) {
        loginPage.password.sendKeys(anypassword);
    }

    @Then("the password should be masked with bullets by default")
    public void thePasswordShouldBeMaskedWithBulletsByDefault() {
        Assert.assertEquals(loginPage.password.getAttribute("type"),"password");

    }
/*
    @When("I enter {string} as username, enter {string} as password")
    public void i_enter_as_username_enter_as_password(String userName, String password) {
        loginPage.userName.sendKeys(userName);
        loginPage.password.sendKeys(password);
    }
    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        loginPage.submit.click();
        // actions.moveToElement(loginPage.loginButton).click().perform();
    }
    @Then("I should be able to login and see the dashboard")
    public void i_should_be_able_to_login_and_see_the_dashboard() {
        BrowserUtils.sleep(2);
        String currentURL = Driver.getDriver().getCurrentUrl();
        String expectedInURL = "stream";
        Assert.assertTrue(currentURL.contains(expectedInURL));
    }
 */


}
