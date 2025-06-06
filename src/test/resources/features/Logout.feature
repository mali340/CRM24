Feature: Different User Logout
  As an authenticated user
  I want to log out of the system

  Background:
    Given I am on the login page
    When I enter "hr10@cydeo.com" as username, enter "UserUser" as password
    And I click on the "Login" button


  Scenario: Successful logout from dashboard as different user
    When I click the logout button
    Then I should be redirected to the login page

