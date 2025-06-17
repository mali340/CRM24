Feature: Send message functionality

  As a user, I should be able to send messages
  So that my messages can be displayed on top of the feed

  @wip1
  Scenario Outline: User sends a simple text message
    Given I am logged into Activity Stream Page with "<userName>" and "<password>"
    When I click on the message tab
    And I type "Message Test"
    And I click the send button
    Then the message should be visible on the top of the feed with the text "Message Test"

    Examples:
      | userName             | password |
      | hr8@cydeo.com        | UserUser |
      | helpdesk8@cydeo.com  | UserUser |
      | marketing8@cydeo.com | UserUser |

    @wip1
    Scenario Outline: User should be able to cancel sending message before sending
      Given I am logged into Activity Stream Page with "<userName>" and "<password>"
      When I click on the message tab
      And I type "Message Test"
      Then I am able to cancel the message before sending

      Examples:
        | userName             | password |
        | hr8@cydeo.com        | UserUser |
        | helpdesk8@cydeo.com  | UserUser |
        | marketing8@cydeo.com | UserUser |


