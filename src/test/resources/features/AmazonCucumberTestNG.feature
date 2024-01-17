Feature: Adding Item in Cart and verifying sub total

  Scenario: Adding a “Monitor”” Item in Cart and verifying sub total
    Given open Amazon.com
    And in the Search field type “Monitor”
    Then press “Enter”
    And select the 1st item in the List
    And add the item to cart by clicking on "Add to Cart”
    Then open “Cart” from the top-left
    And verify that the price is identical to the product page
    Then verify that the sub total is identical to the product page

  Scenario: Adding a “Laptop” Item in Cart and verifying sub total
    Given open Amazon.com
    And in the Search field type “Laptop”
    Then press “Enter”
    And select the 2nd item in the List
    And add the item to cart by clicking on "Add to Cart”
    Then open “Cart” from the top-left
    And verify that the price is identical to the product page
    Then verify that the sub total is identical to the product page
