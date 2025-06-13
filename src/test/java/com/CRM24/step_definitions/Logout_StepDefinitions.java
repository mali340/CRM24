package com.CRM24.step_definitions;

import com.CRM24.pages.LoginPage;
import com.CRM24.pages.LogoutPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_StepDefinitions {

    LogoutPage logoutPage = new LogoutPage();



    @When("I click the logout button")
    public void i_click_the_logout_button() {
        logoutPage.userMenu.click();
        logoutPage.logOutBtn.click();


    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {

        BrowserUtils.verifyTitle("Authorization");

    }
}
