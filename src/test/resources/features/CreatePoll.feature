Feature: Create Poll Functionality

  Scenario Outline: User should be able to create a poll
    Given user is logged in as "<userType>"
    And user is on the homepage
    When user clicks on the "Poll" tab
    And user enters poll question and answers
    And user clicks the send button
    Then poll should be successfully created

    Examples:
      | userType  |
      | HR        |
      | HelpDesk  |
      | Marketing |
