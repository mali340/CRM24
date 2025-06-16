Feature: Creating Task
  User Story: User should be able to create a simple task with the task title and task body.
  - Successfully created task should be displayed in the feed or popup Alert "Task has been created" will appear.



  Scenario Outline: User should be able to create a Task
  task should be displayed in the feed or popup Alert "Task has been created" will appear

    Given I log in as "<userType>"
    When I click TASK button in menu under the search box
    And I create "Project X Practice" Task title and Task body with the following details
    """
        Project X
        1. Preparation
        2. Assign the project
        3. Monitor
      """
    And I click SEND button to create Task
    Then Task should be displayed in the feed or popup Task has been created will appear

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |



  Scenario Outline: User should be able to create a Task through the "Tasks" link
  task should be displayed in the feed or popup Alert "Task has been created" will appear.

    Given I log in as "<userType>"
    When I click Tasks link in left menu
    And I click NEW TASK in tasks menu on the right side of the page
    And I create "Project Y Practice" New Task title and New Task body in the New Task window
    """
        Project Y
        1. Preparation
        2. Assign the project
        3. Monitor
      """
    And I click ADD TASK button to create a Task
    Then Task should be displayed in the My Tasks feed

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |



  Scenario Outline: User should be able to create a Task through the "+" sign besides the "Tasks" link
  task should be displayed in the feed or popup Alert "Task has been created" will appear.

    Given I log in as "<userType>"
    When I click + sign besides the Task link in left menu
    And I create "Project Y Practice" New Task title and New Task body in the New Task window
    """
        Project Y
        1. Preparation
        2. Assign the project
        3. Monitor
      """
    And I click ADD TASK button to create a Task
    Then Task should be displayed in the My Tasks feed

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |



  Scenario Outline: User should be able to cancel a task.Task message area should collapse after clicking the “Cancel” button

    Given I log in as "<userType>"
    When I click TASK button in menu under the search box
    And I create "Project X Practice" Task title and Task body with the following details
    """
        Project X
        1. Preparation
        2. Assign the project
        3. Monitor
      """
    And I click CANCEL button
    Then Task message area should collapse

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |




