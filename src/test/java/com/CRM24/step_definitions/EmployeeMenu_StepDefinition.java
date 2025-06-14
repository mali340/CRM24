package com.CRM24.step_definitions;

import com.CRM24.pages.AddDepartmen_page;
import com.CRM24.pages.EmployeeMenuPage;
import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class EmployeeMenu_StepDefinition {

    LoginPage loginPage = new LoginPage();
    EmployeeMenuPage employeeMenuPage = new EmployeeMenuPage();
AddDepartmen_page addDepartmenPage = new AddDepartmen_page();

    @Given("I am logged in {string} as username enter {string} as password")
    public void iAmLoggedInAsUsernameEnterAsPassword(String username, String password) {

        //used login method from LoginPage
        loginPage.login(username, password);

    }
    @And("I see the {int} modules in the Employees page shown")
    public void iSeeTheModulesInTheEmployeesPageShown(int expectedModuleNumber) {

        //I am testing it with 14 modules on dashboard as in the AC it requires 8 but we have 14.
        Assert.assertEquals(expectedModuleNumber, employeeMenuPage.getModuleNumber());

    }


    @And("I select Employees from the menu")
    public void iSelectEmployeesFromTheMenu() {
        employeeMenuPage.employeesMenu.click();
       BrowserUtils.sleep(2);
    }

    @Then("I add a department on the “Employees” page and department should diplayed")
    public void iAddADepartmentOnTheEmployeesPageAndDepartmentShouldDiplayed() {

        addDepartmenPage.addDepartment.click();
        addDepartmenPage.deparmentName.sendKeys("Whatever");

        Select dropdown = new Select(addDepartmenPage.parentDepartment_Dropdown);
        dropdown.selectByContainsVisibleText("Department");

        addDepartmenPage.addButton.click();

        BrowserUtils.verifyElementDisplayed(addDepartmenPage.displayedDepartment);






    }
}
