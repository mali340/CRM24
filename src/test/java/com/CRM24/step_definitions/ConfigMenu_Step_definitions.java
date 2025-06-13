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

    @Given("the Configure menu is open")
    public void theConfigureMenuIsOpen() {
        login.login();
        configuration_menu.ConfigureLink.click();
    }


    List<String> clickedItems = new ArrayList<>();

    @When("the user clicks all MenuItem options one by one and then MenuItem should be displayed")
    public void theUserClicksAllMenuItemOptionsOneByOneAndThenMenuItemShouldBeDisplayed(DataTable menuItemsTable) {
        List<String> menuItems = menuItemsTable.asList().subList(1, menuItemsTable.asList().size());

        for (String each : menuItems) {
            try {
                configuration_menu.ConfigureLink.click();


                String xpath = "//span[@class='menu-popup-item-text' and normalize-space()='" + each + "']";
                BrowserUtils.waitForPresenceOfElement(By.xpath(xpath), 5);
                WebElement optionElement = Driver.getDriver().findElement(By.xpath(xpath));
                BrowserUtils.waitForClickablility(optionElement, 5);
                optionElement.click();


                switch (each) {
                    case "Configure menu items":

                        BrowserUtils.waitForClickablility(configOptionsPage.saveBtn, 5);
                        configOptionsPage.saveBtn.click();
                        break;

                    case "Collapse menu":
                        BrowserUtils.waitForClickablility(configOptionsPage.collapseBtn, 5);
                        configOptionsPage.collapseBtn.click();
                        break;

                    case "Remove current page from left menu":
                        WebElement thirdOption = Driver.getDriver().findElement(By.xpath(xpath));
                        if (!thirdOption.getAttribute("class").contains("menu-popup-item-disabled")) {
                            thirdOption.click();
                        } else {
                            System.out.println("Option disabled: " + each);
                        }
                        break;

                    case "Add custom menu item":
                        BrowserUtils.waitForClickablility(configOptionsPage.CloseBtn, 5);
                        configOptionsPage.CloseBtn.click();
                        break;

                    case "Change primary tool":
                        BrowserUtils.waitForClickablility(configOptionsPage.closeItem, 5);
                        configOptionsPage.closeItem.click();
                        break;

                    case "Reset menu":
                        configOptionsPage.handleAlertIfPresent();
                        break;

                    default:
                        System.out.println("Unknown option: " + each);
                }

                System.out.println("✅ Option handled: " + each);

            } catch (Exception e) {
                System.out.println("❌ Error with option: " + each);
                e.printStackTrace();
            }


        }
    }


    @Then("each menu option should respond correctly")
    public void eachMenuOptionShouldRespondCorrectly() {
        List<String> expectedItems = Arrays.asList(
                "Configure menu items",
                "Collapse menu",
                "Remove current page from left menu",
                "Add custom menu item",
                "Change primary tool",
                "Reset menu"
        );

        for (String each : expectedItems) {
            Assert.assertTrue("Menu option did not respond correctly: " + each, clickedItems.contains(each));
        }


    }
}