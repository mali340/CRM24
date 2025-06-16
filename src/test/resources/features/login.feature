Feature: Login Functionality

  As a user, I should be able to login

  Acceptance Criteria:
  1-Users should be able to login with valid credentials and should land on the home page after successful login.
  (We have 3 types of users such as HR user, Marketing user, and Helpdesk user).
  2-"Incorrect login or password" should be displayed for invalid (valid username-invalid password and invalid
  username-valid password) credentials
  3- "Please fill out this field" message should be displayed if the password or username is empty
  4-User can see "Remember Me" link exists and is clickable on the login page
  5-User should see the password in bullet signs by default

  Background:
    Given I am on the login page

  Scenario Template: Verify login with valid credentials
    When I log in as "<userType>"
    Then I should land on the home page and the "<title>" should be displayed
    Examples:
      | userType  | title  |
      | hr        | Portal |
      | helpdesk  | Portal |
      | marketing | Portal |


  Scenario Template: Verify login with valid user name and invalid password
    When I enter a valid "<username>" and an invalid "<password>"
    Then the "<error message>" should be displayed
    Examples:
      | username              | password  | error message               |
      | hr10@cydeo.com        | Useruser  | Incorrect login or password |
      | helpdesk10@cydeo.com  | userUser  | Incorrect login or password |
      | marketing10@cydeo.com | UserUsers | Incorrect login or password |


  Scenario Template: Verify login with invalid user name and valid password
    When I enter an invalid "<username>" and a valid "<password>"
    Then the "<error message>" should be displayed
    Examples:
      | username              | password | error message               |
      | hr888@cydeo.com       | UserUser | Incorrect login or password |
      | helpdesk88@ cydeo.com | UserUser | Incorrect login or password |
      | marketing88cydeo.com  | UserUser | Incorrect login or password |


  Scenario Template: Verify login attempt with missing credentials
    When I log in with missing "<username>" and or "<password>" fields
    Then the "<error message>" should be displayed
    Examples:
      | username | password         | error message              |
      | hrUser   |                  | Please fill out this field |
      |          | helpdeskPassword | Please fill out this field |
      |          |                  | Please fill out this field |


  Scenario: Verify "Remember me" option is visible and clickable
    Then the "Remember me on this computer" text should be visible
    When I click the Remember me checkbox
    Then the Remember me checkbox should be selected


  Scenario: Verify password is hidden by default
    When I enter a "anypassword" as password
    Then the password should be masked with bullets by default