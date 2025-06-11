
Feature: User should be able to download the desktop app


  Scenario Outline: Users can download the desktop app
    Given the <role> user is logged in
    And the user is on the download page
    When the user selects 3 desktop versions
    Then the user should be able to download the desktop app for each version

    Examples:
      | role      |
      | HR        |
      | Helpdesk  |
      | Marketing |