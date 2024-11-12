Feature: Validating place APIs
  Scenario: Verify if place is being successfully added using AddPlaceAPI
    Given Add place payload
    When User call's "AddPlaceAPI" with post http request
    Then API call is success with 200 status code
    And "status" in response body is "OK"
    And "scope" in response body is "APP"