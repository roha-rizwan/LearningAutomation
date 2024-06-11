Feature: Sample tests for E-commerce website

  Scenario: Add items to cart
    When user searches for item "strong money australia"
    Then he sees the item is listed on top
    And he adds the top result to the cart

  Scenario: Verify recently viewed items
    When user searches for item "strong money australia"
    And he sees the item is listed on top
    And he views the top result
    Then he navigates to the home page
    And he verifies that the item is listed under Your Recently Viewed Items

  Scenario: Add multiple items to cart and review
    When user adds the below list to the cart
      |Item|Quantity|
      |Australia Sunscreen SPF 50+|1|
      |Bluey: Little Library: Four Books in One |1                                     |
    Then the user reviews the cart with below list
      |Item|Qty|
      |Sunscreen|1|
      |Bluey|1                                     |


