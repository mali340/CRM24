Feature:Login functionality

  As a user
  I want to log in to the application
  So that I can access my dashboard

  @wip
  Scenario Outline: Login with different users
    Given I am on the login page
    When  I enter "<username>" as username, enter "<password>" as password
    And   I click on the "Login" button
    Then  I should be able to login and see the dashboard

    Examples:
      | username              | password |
      | hr10@cydeo.com        | UserUser |
      | helpdesk10@cydeo.com  | UserUser |
      | marketing10@cydeo.com | UserUser |