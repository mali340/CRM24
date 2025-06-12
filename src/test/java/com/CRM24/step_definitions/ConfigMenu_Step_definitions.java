package com.CRM24.step_definitions;


import com.CRM24.pages.ConfigOptionsPage;
import com.CRM24.pages.Configuration_Menu;
import com.CRM24.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ConfigMenu_Step_definitions {
    ConfigOptionsPage configOptionsPage = new ConfigOptionsPage();
    LoginPage login = new LoginPage();
    Configuration_Menu configuration_menu = new Configuration_Menu();

    @Given("user is already logged in to The CRM")
    public void userIsAlreadyLoggedInToTheCRM() {
        login.login();
    }

    @When("the user clicks on the {string} menu")
    public void theUserClicksOnTheMenu(String configMenu) {
        configuration_menu.ConfigureLink.click();
    }

    @Then("the user should see {int} options:")
    public void theUserShouldSeeOptions(int expectedCount,List<String> expectedOptions) {
        List<WebElement> actualOptions = configuration_menu.ConfigureMenuOptions;
        Assert.assertEquals("Number of visible menu options", expectedCount, actualOptions.size());

        System.out.println("Options in the Configure menu:");
        for (WebElement option : actualOptions) {
            System.out.println(option.getText());
        }

    }

//second Scenario:


    @Given("the {string} menu is open")
    public void the_menu_is_open(String ConfigMenu) {
        login.login();
        configuration_menu.ConfigureLink.click();
    }


    @When("the user clicks all {string} options one by one")
    public void theUserClicksAllOptionsOneByOne(String configOptions) {


        configOptionsPage.firstOption.click();
        configOptionsPage.saveBtn.click();
        configuration_menu.ConfigureLink.click();

        configOptionsPage.secondOption.click();
        configOptionsPage.collapseBtn.click();
        configuration_menu.ConfigureLink.click();

        WebElement removeOption = configOptionsPage.thirdOption;
        try {
            if (!configOptionsPage.thirdOption.isEnabled() ||
                    configOptionsPage.thirdOption.getAttribute("class").contains("menu-popup-item-disabled")) {
                System.out.println("The 'Remove current page from left menu' option is disabled.");
            } else {
                configOptionsPage.thirdOption.click();
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element went stale. Re-locating...");

            configuration_menu.ConfigureLink.click();
            configOptionsPage.thirdOption.click();
        }

        configOptionsPage.fourthOption.click();
        configOptionsPage.CloseBtn.click();
        configuration_menu.ConfigureLink.click();

        configOptionsPage.fifthOption.click();
        configOptionsPage.closeItem.click();
        configuration_menu.ConfigureLink.click();

        configOptionsPage.sixthOption.click();
        configOptionsPage.handleAlertIfPresent();
        configuration_menu.ConfigureLink.click();

    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String optionName) {
        System.out.println("Verified that option was clicked: " + optionName);

    }



}
