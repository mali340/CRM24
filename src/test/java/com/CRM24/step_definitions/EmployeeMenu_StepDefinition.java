package com.CRM24.step_definitions;

import com.CRM24.pages.AddDepartmen_page;
import com.CRM24.pages.EmployeeMenuPage;
import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class EmployeeMenu_StepDefinition {

    LoginPage loginPage = new LoginPage();
    EmployeeMenuPage employeeMenuPage = new EmployeeMenuPage();
AddDepartmen_page addDepartmenPage = new AddDepartmen_page();


    @Then("I see the {int} modules in the Employees page shown")
    public void iSeeTheModulesInTheEmployeesPageShown(int expectedModuleNumber) {

        //I am testing it with 14 modules on dashboard as in the AC it requires 8 but we have 14.
        Assert.assertEquals(expectedModuleNumber, employeeMenuPage.getModuleNumber());

    }


    @And("I select Employees from the menu")
    public void iSelectEmployeesFromTheMenu() {
        employeeMenuPage.employeesMenu.click();
        BrowserUtils.waitForPageToLoad(5);
    }

   

    @And("department should displayed")
    public void departmentShouldDisplayed() {

        BrowserUtils.waitForVisibility(addDepartmenPage.displayedDepartment, 10);
        BrowserUtils.verifyElementDisplayed(addDepartmenPage.displayedDepartment);
    }

    @Given("I am on the login page as HR user")
    public void iAmOnTheLoginPageAsHRUser() {

       loginPage.login( ConfigurationReader.getProperty("HR_username"),
               ConfigurationReader.getProperty("HR_password")
       );
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I add a {string} on the “Employees” page")
    public void iAddAOnTheEmployeesPage(String departmentName) {

        BrowserUtils.waitForClickablility(addDepartmenPage.addDepartment, 5);
        addDepartmenPage.addDepartment.click();

        BrowserUtils.waitForVisibility(addDepartmenPage.deparmentName, 5);
        addDepartmenPage.deparmentName.sendKeys(departmentName);

        Select dropdown = new Select(addDepartmenPage.parentDepartment_Dropdown);
        dropdown.selectByVisibleText(" .  . Department");

        BrowserUtils.waitForClickablility(addDepartmenPage.addButton, 5);
        addDepartmenPage.addButton.click();

        BrowserUtils.waitForPageToLoad(5);

    }
}
