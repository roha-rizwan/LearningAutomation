Feature: Sample API tests

  Scenario: To test GET request
    When I issue a GET request
    Then I validate a successful response
    And response body is not empty

  Scenario: To test unsuccessful response
    When I issue an invalid GET request
    Then I validate a unsuccessful response

  Scenario: To test email detail is not null
    When I issue a GET request
    Then I validate email detail is not null

  Scenario: To test username and password detail is not null
    When I issue a GET request
    Then I validate username and password detail is not null

  Scenario: To test username and password detail is not null
    When I issue a GET request
    Then I validate username and password detail is not null

  Scenario: To test header in get request
    When I issue a GET request
    Then I validate content type
