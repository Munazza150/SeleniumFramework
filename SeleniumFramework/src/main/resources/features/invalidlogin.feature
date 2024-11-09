Feature: Login with Invalid Credentials on SauceDemo
  To ensure that users cannot access the system with incorrect credentials

  @Smoketest
  Scenario: Login with invalid password
    Given user is on the login page
    When I enter valid username and invalid password
    Then I should see an error message