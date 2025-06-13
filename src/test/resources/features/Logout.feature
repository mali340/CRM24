Feature: Different User Logout
  As an authenticated user
  I want to log out of the system

  Background:
    Given I am on the login page as HR user

  Scenario: Successful logout from dashboard as different user
    When I click the logout button
    Then I should be redirected to the login page

