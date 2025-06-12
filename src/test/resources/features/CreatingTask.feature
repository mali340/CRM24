Feature: Creating Task
  User Story: User should be able to create a simple task with the task title and task body.
  - Successfully created task should be displayed in the feed or popup Alert "Task has been created" will appear.

@wip
  Scenario Outline: User should be able to create a Task ,
  task should be displayed in the feed or popup Alert "Task has been created" will appear

    Given I am logged into homePage as "<userType>" with "<userName>" as username and "<password>" and i see the homePage
    And I click TASK button in menu under the search box
    And I create a Task title and Task body in the Task window
    And I click SEND button to create Task
    Then Task should be displayed in the feed or popup "Task has been created" will appear

    Examples:
      | userType  | userName              | password |
      | hr        | hr10@cydeo.com        | UserUser |
      | help_desk | helpdesk10@cydeo.com  | UserUser |
      | marketing | marketing10@cydeo.com | UserUser |



  Scenario Outline: User should be able to create a Task through the "Tasks" link,
  task should be displayed in the feed or popup Alert "Task has been created" will appear.

    Given I am logged into homePage as "<userType>" with "<userName>" as username and "<password>" and i see the homePage
    When I click Tasks link in left menu
    And I click NEW TASK in tasks menu on the right side of the page
    And I create a New Task title and New Task body in the New Task window
    And I click ADD TASK button to create a Task
    Then Task should be displayed in the My Tasks feed

    Examples:
      | userType  | userName              | password |
      | hr        | hr10@cydeo.com        | UserUser |
      | help_desk | helpdesk10@cydeo.com  | UserUser |
      | marketing | marketing10@cydeo.com | UserUser |



  Scenario Outline: User should be able to create a Task through the "+" sign besides the "Tasks" link,
  task should be displayed in the feed or popup Alert "Task has been created" will appear.

    Given I am logged into homePage as "<userType>" with "<userName>" as username and "<password>" and i see the homePage
    When I click + sign besides the Task link in left menu
    And I create a New Task title and New Task body in the New Task window
    And I click ADD TASK button to create a Task
    Then Task should be displayed in the My Tasks feed

    Examples:
      | userType  | userName              | password |
      | hr        | hr10@cydeo.com        | UserUser |
      | help_desk | helpdesk10@cydeo.com  | UserUser |
      | marketing | marketing10@cydeo.com | UserUser |



  Scenario Outline: User should be able to cancel a task.Task message area should collapse after clicking the “Cancel” button.

    Given I am logged into homePage as "<userType>" with "<userName>" as username and "<password>" and i see the homePage
    And I click TASK button in menu under the search box
    And I create a Task title and Task body in the Task window
    And I click CANCEL button
    Then Task message area should collapse

    Examples:
      | userType  | userName              | password |
      | hr        | hr10@cydeo.com        | UserUser |
      | help_desk | helpdesk10@cydeo.com  | UserUser |
      | marketing | marketing10@cydeo.com | UserUser |

