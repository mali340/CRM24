Feature: Employee Directory Access
  As an authorized company user
  I need to access the Employees page

  Background:
    Given I am on the login page
    When I enter "hr10@cydeo.com" as username, enter "UserUser" as password
    And I click on the "Login" button


  Scenario: Access Employees page from main dashboard
    And I select Employees from the menu
    When I see the 14 modules in the Employees page shown
    Then I add a department on the “Employees” page and department should diplayed

