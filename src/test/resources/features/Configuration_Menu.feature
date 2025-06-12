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
    Given the "Configure" menu is open
    When the user clicks all "<MenuItem>" options one by one
    Then "<MenuItem>" should be displayed

    Examples:
      | MenuItem                           |
      | Configure menu items               |
      | Collapse menu                      |
      | Remove current page from left menu |
      | Add custom menu item               |
      | Change primary tool                |
      | Reset menu                         |
