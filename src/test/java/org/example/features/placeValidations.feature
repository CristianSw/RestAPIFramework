Feature: Validating place APIs
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When User call's "AddPlaceAPI" with post http request
    Then API call is success with 200 status code
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
    |name|language|address|
    |WW  |English |Balti  |
    |AA  |German  |Berlin |
    |BB  |French  |Paris  |