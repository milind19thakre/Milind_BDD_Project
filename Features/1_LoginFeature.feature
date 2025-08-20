Feature: Login


Scenario: Successful Login with valid credentials

  Given user launch chrome browser
  When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  And user enters userid as "Admin" and password as "admin123"
  And click on login
  Then page title should be "OrangeHRM"
  And close browser
