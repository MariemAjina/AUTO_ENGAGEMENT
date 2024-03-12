Feature: User Login
  @Login
  Scenario: User logs in with unknown email
    Given User is on the login page
    When User enters an unknown email "example@example.com"
