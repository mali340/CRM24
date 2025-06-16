package com.CRM24.step_definitions;

import com.CRM24.pages.HomePage;
import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.ConfigurationReader;
import com.CRM24.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class CreatingTask_StepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(Driver.getDriver());


    @Given("I am logged into homePage as {string}")
    public void iAmLoggedIntoHomePageAsWithAsUsernameAndAndISeeTheHomePage(String userType) {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(userType);
        BrowserUtils.sleep(3);
        //Assert.assertTrue(homePage.userAccount.isDisplayed());

    }

    @When("I click TASK button in menu under the search box")
    public void i_should_click_task_in_menu_under_the_search_box() {
        homePage.taskButton.click();
        BrowserUtils.sleep(2);
    }


    @When("I click SEND button to create Task")
    public void i_should_click_send_button_to_create_task() {
        homePage.sendButton.click();
        BrowserUtils.sleep(2);

    }


    @Then("Task should be displayed in the feed or popup Task has been created will appear")
    public void task_should_be_displayed_in_the_feed() {

        if (homePage.popupExit.isDisplayed()) {

            Assert.assertTrue(homePage.popupExit.isDisplayed());

            homePage.popupExit.click();

        } else
            Assert.assertTrue(homePage.newTaskInFeed.isDisplayed());

    }


    @And("I click CANCEL button")
    public void iClickCANCELButton() {
        homePage.cancelButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("Task message area should collapse")
    public void taskMessageAreaShouldCollapse() {
        Assert.assertTrue(homePage.sendMessageArea.isDisplayed());

    }

    @When("I click Tasks link in left menu")
    public void iClickTasksLinkInLeftMenu() {
        homePage.tasksLink.click();
    }

    @And("I click NEW TASK in tasks menu on the right side of the page")
    public void iClickNEWTASKInTasksMenuOnTheRightSideOfThePage() {
        homePage.newTaskButton.click();

    }


    @And("I create {string} New Task title and New Task body in the New Task window")
    public void iCreateANewTaskTitleAndNewTaskBodyInTheTaskWindow(String TaskTitleY, String taskBodyY) {


        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(homePage.newTaskIframe);
        homePage.newTaskTitle.sendKeys(TaskTitleY);
        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(homePage.newTaskBodyIframe);
        BrowserUtils.sleep(2);
        homePage.newTaskBodyElement.sendKeys(taskBodyY);

        BrowserUtils.sleep(2);
        Driver.getDriver().switchTo().parentFrame();

    }

    @And("I click ADD TASK button to create a Task")
    public void iClickADDTASKButtonToCreateATask() {
        homePage.addTaskButton.click();
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);
    }

    @Then("Task should be displayed in the My Tasks feed")
    public void taskShouldBeDisplayedInTheMyTasksFeed() {

        homePage.tasksLink.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(homePage.newTaskInMyTasksFeed.isDisplayed());

    }

    @When("I click + sign besides the Task link in left menu")
    public void iClickSignBesidesTheTaskLinkInLeftMenu() {

        actions.moveToElement(homePage.tasksLink).perform();
        homePage.additionSign.click();
        BrowserUtils.sleep(2);
    }

    @And("I create {string} Task title and Task body with the following details")
    public void iCreateATaskTitleAndTaskBodyInTheTaskWindowWithTheFollowingDetails(String taskTitleX, String taskBodyX) {


        homePage.tasksTitle.sendKeys(taskTitleX);
        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(homePage.tasksBodyIframe);
        homePage.taskBodyElement.sendKeys(taskBodyX);
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);

    }


}
