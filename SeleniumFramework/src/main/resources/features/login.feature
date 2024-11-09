Feature: Login with Valid Credentials on SauceDemo
  To verify that users can access the system with correct credentials

  @Smoketest
  Scenario: Login with valid credentials
    Given I am on the SauceDemo login page
    When I enter valid username and valid password
    Then I should land on the dashboard
    