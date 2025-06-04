Feature: Different User Logout
  As an authenticated user
  I want to log out of the system

  Scenario Outline: Successful logout from dashboard as different user
    Given I am logged in "<username>" as username, enter "<password>" as password
    When I click the logout button
    Then I should be redirected to the login page

    Examples:
      | username              | password |
      | hr10@cydeo.com        | UserUser |
      | helpdesk10@cydeo.com  | UserUser |
      | marketing10@cydeo.com | UserUser |