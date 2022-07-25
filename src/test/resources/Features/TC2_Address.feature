@address
Feature: Address Module API automation

  Scenario Outline: Verify add new address to the aplication through API
    Given User add headers and bearer authorization for accessing address endpoints
    When user add request body for Add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>"and "<address_type>"
    When User send "POST" request for add new address
    Then User should verify the statuscode is 200
    And User verify the create address response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Vini       | Tha       | 8428502914 | apartment |    33 | 3378 |     101 |  202020 |      52 | home         |

  Scenario Outline: Verify Upadate the existing address to the aplication through API
    Given User add headers and bearer authorization for accessing address endpoints
    When user add request body for  update address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    When User send "PUT" request for  update address
    Then User should verify the statuscode is 200
    And User verify the update address response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Vini       | Tha       | 8428502914 | apartment |    33 | 3378 |     101 |  202020 |      52 | home         |

  Scenario: Verify Get the existing address to the aplication through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User send "GET" request for get existing address
    Then User should verify the statuscode is 200
    And User verify the get existing address response message matches "OK"

  Scenario: Verify Delete the existing address to the aplication through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User send "DELETE" request for delete address
    Then User should verify the statuscode is 200
    And User verify the delete address response message matches "Address deleted successfully"
