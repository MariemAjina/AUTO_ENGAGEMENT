Feature: [EMEE-11483]User access to the anatomy bare bones module
  @ANATOMY
  Scenario: Displaying anatomy card on the home page
    Given the welcome screen dispayed
    When the user clicks on "Use Without Account"
    And the user accepts "Terms and Conditions"
    Then the anatomy card should be displayed on the home page
    And Acess to the anatomy card
    @Content-Check
  Scenario: Displaying list of sub-contents for anatomy
    Given the user is on the anatomy module page
    When a list of sub-contents for the anatomy module should be displayed
    Then the user selects one of the sub-content

