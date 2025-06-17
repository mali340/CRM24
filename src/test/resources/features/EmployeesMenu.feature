Feature: Employee Directory Access
  As an authorized company user
  I need to access the Employees page

  Background:
    Given I am on the login page as HR user

  Scenario: Access Employees page from main dashboard
    And I select Employees from the menu
    Then I see the 14 modules in the Employees page shown
    When I add a "QA department" on the “Employees” page
    And department should displayed

