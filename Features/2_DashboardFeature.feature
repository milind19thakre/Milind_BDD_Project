Feature: Dashboard Validation

  Background:
    Given user launch chrome browser
    When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters userid as "Admin" and password as "admin123"
    And click on login
    Then page title should be "OrangeHRM"



  @Regression
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


    #Amministrazione
  @Smoke
  Scenario Outline: Validate the elements present on left pane on dashboard
    Then validate <elements> left pane
    Examples:
    |elements|
    |Admin|
    |PIM|
    |Leave|
    |Time|
    |Recruitment|
    |My Info|
    |Performance|
    |Dashboard|
    |Directory|
    |Maintenance|
    |Claim|
    |Buzz|

  @Mvt
  Scenario Outline: Validate the element page is loading
    Then click on <elements1> from left pane
    Then check <elements1> is present
    Examples:
      |elements1|
      |Admin|
      |PIM|
      |Leave|
      |Time|
      |Recruitment|
      |Performance|
      |Dashboard|
      |Directory|
      |Claim|
      |Buzz|

    Scenario:
