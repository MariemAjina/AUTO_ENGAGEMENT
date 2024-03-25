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
   @Check-Zoom&closeImage
   Scenario:Zoom in/out functionality of anatomy figure
     Given Title & content & image displyed
     When user click on the loop button to zooms in on the figure
     Then the figure should be enlarged for detailes exmination
     And the user should be able to zoom out to the original size0
@check-second-topic
Scenario: Second topic
  Given the user is on the anatomy module page
  When the user selects the second sub-content
  Then Title & content & image displyed
  And user click on the loop button to zooms in on the figure
  And the user should be able to zoom out to the original size0

  @check-THIRD-topic
  Scenario: Second topic
    Given the user is on the anatomy module page
    When the user selects the Third sub-content
    Then Title & content & image displyed
    And user click on the loop button to zooms in on the figure
    And the user should be able to zoom out to the original size0
  @check-Fourth-topic
  Scenario: Fourth topic
    Given the user is on the anatomy module page
    When the user selects the fourth sub-content
    Then Title & content & image displyed
    And user click on the loop button to zooms in on the figure
    And the user should be able to zoom out to the original size0