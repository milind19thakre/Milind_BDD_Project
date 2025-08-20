Feature: Logout


  Background:
    Given user launch chrome browser
    When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters userid as "Admin" and password as "admin123"
    And click on login
    Then page title should be "OrangeHRM"

  Scenario: Logout user successfully
    And click on userdropdown icon
    And click on logout
    Then the ex_logout_url should be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"