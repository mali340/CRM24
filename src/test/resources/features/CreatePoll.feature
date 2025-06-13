Feature: Create Poll Functionality

  @wip
  Scenario Outline: User creates a poll with two options
    Given user is on the login page
    When user logs in as "<userType>" with "<username>" and "<password>"
    And user clicks on the "Poll" tab
    And user writes a poll question
    And user enters poll options
    And user sends the poll
    Then poll should be visible on the homepage

    Examples:
      | userType   | username                | password  |
      | hr         | hr10@cydeo.com           | UserUser  |
      | help_desk  | helpdesk10@cydeo.com     | UserUser  |
      | marketing  | marketing10@cydeo.com    | UserUser  |




