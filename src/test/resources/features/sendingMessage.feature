Feature: Send Message on Activity Stream

  As a user, I should be able to send messages
  So that my messages can be displayed on top of the feed

@wip
  Scenario Outline: User sends a simple text message
    Given I am on the login page
    When  I enter "<username>" as username, enter "<password>" as password
    And   I click on the "Login" button
    And I am on the Activity Stream page
    And user click on the message tab
    When I type "Hello, this is a test message!"
    And I click the send button
    Then the message should be visible on the top of the feed with the text "Hello, this is a test message!"

    Examples:
      | username              | password |
      | hr2@cydeo.com        | UserUser |
      | helpdesk2@cydeo.com  | UserUser |
      | marketing2@cydeo.com | UserUser |