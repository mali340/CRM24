package com.CRM24.step_definitions;


import com.CRM24.pages.CreatePollPage;
import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.ConfigurationReader;
import com.CRM24.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class CreatePollStepDefs {

    CreatePollPage pollPage = new CreatePollPage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user logs in as {string} with {string} and {string}")
    public void user_logs_in_as_with_and(String userType, String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(username, password);
        System.out.println("Logging in as " + userType);

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
            WebElement popupClose = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector(".popup-window-close-icon")));
            popupClose.click();
        } catch (Exception e) {
            System.out.println("Pop-up not seen, continuing.");
        }

    }


    @When("user clicks on the {string} tab")
    public void user_clicks_on_the_tab(String tabName) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        BrowserUtils.sleep(2);
        wait.until(ExpectedConditions.visibilityOf(pollPage.pollTab));
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.pollTab));

        pollPage.pollTab.click();
    }

    @When("user writes a poll question")
    public void user_writes_a_poll_question() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement questionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("question_0")));
        questionInput.sendKeys("What is your favorite test tool?");


        Driver.getDriver().switchTo().frame(pollPage.iframe);
        pollPage.messageBody.sendKeys("This poll is for testing toolss.");
        Driver.getDriver().switchTo().defaultContent();
    }



    @When("user enters poll options")
    public void user_enters_poll_options() {
        pollPage.answer1Input.sendKeys("Seleniumm");
        pollPage.answer2Input.sendKeys("Cypresss");
    }

    @When("user sends the poll")
    public void user_sends_the_poll() {
        pollPage.sendButton.click();
    }

    @Then("poll should be visible on the homepage")
    public void poll_should_be_visible_on_the_homepage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'What is your favorite test tool?')]")));
        Assert.assertTrue("Poll not found!", confirmation.isDisplayed());
    }
}



