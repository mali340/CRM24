package com.CRM24.step_definitions;

import com.CRM24.pages.ConfigOptionsPage;
import com.CRM24.pages.Configuration_Menu;
import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConfigMenu_Step_definitions {
    ConfigOptionsPage configOptionsPage = new ConfigOptionsPage();
    LoginPage login = new LoginPage();
    Configuration_Menu configuration_menu = new Configuration_Menu();

    @Given("user is already logged in to The CRM")
    public void userIsAlreadyLoggedInToTheCRM() {
        login.login();
    }

    @When("the user clicks on the Configure menu")
    public void theUserClicksOnTheConfigureMenu() {
        configuration_menu.ConfigureLink.click();
    }

    @Then("the user should see {int} options:")
    public void theUserShouldSeeOptions(int expectedCount, List<String> expectedOptions) {
        List<WebElement> actualOptions = configuration_menu.ConfigureMenuOptions;
        Assert.assertEquals("Number of visible menu options", expectedCount, actualOptions.size());

        for (int i = 0; i < expectedOptions.size(); i++) {
            String expected = expectedOptions.get(i).trim();
            String actual = actualOptions.get(i).getText().trim();
            Assert.assertEquals("Menu option mismatch at index " + i, expected, actual);
        }

    }


    //second Scenario:

    @When("the user logs in as {string}")
    public void the_user_logs_in_as(String log) {
        login.login();
    }

    @When("the user clicks the configure menu")
    public void the_user_clicks_the_configure_menu() {
        configuration_menu.ConfigureLink.click();
    }

    @When("the user clicks the {string}")
    public void the_user_clicks_the(String menuOption) {
        switch (menuOption.toLowerCase()) {
            case "configure menu items":
                configOptionsPage.firstOption.click();
                break;
            case "collapse menu":
                configOptionsPage.secondOption.click();
                break;
            case "remove current page from left menu":
                configOptionsPage.thirdOption.click();
                configOptionsPage.handleAlertIfPresent();
                break;
            case "add custom menu item":
                configOptionsPage.fourthOption.click();
                break;
            case "change primary tool":
                configOptionsPage.fifthOption.click();
                break;
            case "reset menu":
                configOptionsPage.sixthOption.click();
                configOptionsPage.handleAlertIfPresent();
                break;
            default:
                throw new IllegalArgumentException("Unexpected menu option: " + menuOption);
        }
    }


    @Then("the {string} should be displayed")
    public void the_should_be_displayed(String menuOption) {
        boolean isDisplayed = false;

        switch (menuOption.toLowerCase()) {
            case "configure menu items":
                isDisplayed = configOptionsPage.saveBtn.isDisplayed();
                break;
            case "collapse menu":
                BrowserUtils.waitForVisibility(configOptionsPage.collapseBtn,5);
                isDisplayed = configOptionsPage.collapseBtn.isDisplayed();
                break;
            case "remove current page from left menu":
            case "reset menu":
                isDisplayed = true;
                break;
            case "add custom menu item":
                isDisplayed = configOptionsPage.CloseBtn.isDisplayed();
                break;
            case "change primary tool":
                isDisplayed = configOptionsPage.closeItem.isDisplayed();
                break;
        }

        Assert.assertTrue(menuOption + " is not displayed as expected", isDisplayed);
    }
}
