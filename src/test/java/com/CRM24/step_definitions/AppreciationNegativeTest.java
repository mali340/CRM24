package com.CRM24.step_definitions;

import com.CRM24.pages.AppreciationPage;
import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AppreciationNegativeTest {

    AppreciationPage appreciationPage = new AppreciationPage();
    LoginPage loginPage = new LoginPage();

    @When("User  navigates to the Appreciation tab")
    public void userNavigatesToTheAppreciationTab() {
        loginPage.inputUsername.sendKeys("hr10@cydeo.com");
        loginPage.inputPassword.sendKeys("UserUser");
        loginPage.loginButton.click();

        appreciationPage.moreButton.click();
        appreciationPage.appreciation.click();

    }

    @And("User leaves the message content empty")
    public void userLeavesTheMessageContentEmpty() {
    //   driver.findElement(By.tagName("body")).clear(); Ensure it's empty

       // appreciationPage.messageBox.clear();
       // Driver.getDriver().switchTo().defaultContent();
    }

    @And("User clicks the Send button")
    public void userClicksTheSendButton() {
        BrowserUtils.waitFor(3);
       appreciationPage.sendButton.click();

    }

    @Then("The invalid message should be displayed")
    public void theInvalidMessageShouldBeDisplayed() {
        BrowserUtils.sleep(2);
         String expectedMessage= appreciationPage.errorMessage.getText();
         String actualMessage = " The message title is not specified";

         Assert.assertTrue(expectedMessage.equals(actualMessage));
    }


}
