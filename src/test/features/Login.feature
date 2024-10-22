Feature: Login
  As a valid user, I should able to login successfully orange hrm application.

  Scenario Outline: As a valid user, I should able to login successfully.
    Given I navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I enter user as "<user>" and password as "<password>"
    And I click on login
    Then I navigated to the dashboard page where title is "OrangeHRM"
    When I click on logout
    Then I navigated to the login page where title is "OrangeHRM"
    Examples:
    |   user  |    password    |
    |  Admin  |   admin123     |