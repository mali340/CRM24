Feature: Employee Directory Access
  As an authorized company user
  I need to access the Employees page

@wip
  Scenario Outline: Access Employees page from main dashboard
    Given I am logged in "<username>" as username, enter "<password>" as password
    And I select Employees from the menu
    When I see the 14 modules in the Employees page shown
    Then I add a department on the “Employees” page and department should diplayed

    Examples:
      | username              | password |
      | hr10@cydeo.com        | UserUser |
      #| helpdesk10@cydeo.com  | UserUser |
      #| marketing10@cydeo.com | UserUser |