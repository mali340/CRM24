Feature: Employee Directory Access
  As an authorized company user
  I need to access the Employees page


  Scenario Outline: Access Employees page from main dashboard
    Given I am logged in "<username>" as username, enter "<password>" as password
    And I select "Employees" from the menu
    Then I should see the Employee Structure title
    And the page should the strcuture of the company