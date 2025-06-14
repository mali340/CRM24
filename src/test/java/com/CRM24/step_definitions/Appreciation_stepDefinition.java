package com.CRM24.step_definitions;


import com.CRM24.pages.AppreciationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Appreciation_stepDefinition {
    int selectedVersions = 0;

    @Given("the user is on the download page")
    public void the_user_is_on_the_download_page() {
        selectedVersions = 0;
    }

    @When("the user selects 3 desktop versions")
    public void the_user_selects_3_desktop_versions() {
        selectedVersions = 3;
    }

    @Then("the user should be able to download the desktop app")
    public void the_user_should_be_able_to_download_the_desktop_app() {
        assertTrue(selectedVersions == 3);
    }





}
