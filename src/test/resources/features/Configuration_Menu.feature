Feature: Configuration functionality
  As a user, I should be able to configure the menu.

  Scenario:   User logs in and sees 6 options under the Configure menu
    Given user is already logged in to The CRM
    When  the user clicks on the "Configure" menu
    Then  the user should see 6 options:
      | Configure menu items               |
      | Collapse menu                      |
      | Remove current page from left menu |
      | Add custom menu item               |
      | Change primary tool                |
      | Reset menu                         |

@wip
Scenario Outline: User clicks all options under Configure menu and sees the corresponding results
  When the user logs in as "<user type>"
  When the user clicks the configure menu
  And the user clicks the "<menu option>"
  Then the "<menu option>" should be displayed
  Examples:
    | user type | menu option                        |
    | helpdesk  | Configure menu items               |
    | marketing | Collapse menu                      |
    | hr        | Remove current page from left menu |
    | helpdesk  | Add custom menu item               |
    | marketing | Change primary tool                |
    | hr        | Reset menu                         |

