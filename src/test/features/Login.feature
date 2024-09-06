Feature: Login
  As a valid user, I should able to login successfully.

  Scenario: As a valid user, I should able to login successfully.
    Given I navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I enter user as "Admin" and password as "admin123"
    And I click on login
    Then I navigated to the dashboard page where title is "OrangeHRM"
    When I click on logout
    Then I navigated to the login page where title is "OrangeHRM"
