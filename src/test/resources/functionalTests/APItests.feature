Feature: Sample API tests

  Scenario: To test GET request
    When I issue a GET request
    Then I validate a successful response
    And response body is not empty

  Scenario: To test GET request
    When I issue an invalid GET request
    Then I validate a unsuccessful response

  Scenario: To test email detail is not null
    When I issue a GET request
    Then Then i validate email detail is not null