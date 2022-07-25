@login
Feature: Login Module API Automation

  Scenario: Get User logtoken from login endpoint
    Given User should add header
    And User should add basic authentication for login
    When User should send "POST" request for login endpoint
    Then User should verify the statuscode is 200
    And User should verify the login response body firstName present as "vini" and get the logtoken saved
