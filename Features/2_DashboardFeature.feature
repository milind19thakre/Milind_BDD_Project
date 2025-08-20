Feature: Dashboard Validation

  Background:
    Given user launch chrome browser
    When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters userid as "Admin" and password as "admin123"
    And click on login
    Then page title should be "OrangeHRM"




  Scenario Outline: Validate the elements present on dashboard
    Then validate <elements> on dashboard
    Examples:
      | elements |
      | Time at Work                      |
      | My Actions                        |
      | Quick Launch                      |
      | Buzz Latest Posts                 |
      | Employees on Leave Today          |
      | Employee Distribution by Sub Unit |
      | Employee Distribution by Location |


