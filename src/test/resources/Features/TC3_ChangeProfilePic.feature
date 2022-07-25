@change
Feature: ChangeProfilePic Module API Automation

  Scenario: Verify the changeprofilepic to the application through API
    Given User should add headers and beared authorization and multipart/form-data for accessing changeprofilepic endpoint
    When User send "POST" request address for ChangeProfilePic
    Then User should verify the statuscode is 200
    And User verify the changeprofilepic response message matches with "Profile Updated Successfully"
