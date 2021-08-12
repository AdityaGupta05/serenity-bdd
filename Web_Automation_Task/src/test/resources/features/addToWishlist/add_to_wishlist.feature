Feature: Add and validate the item in cart

  @ui=addwishlist
  Scenario: Cart items should be updated with my current purchase
    Given  I add four different products to my wish list
    When  I view my wishlist table
    Then  I find total 4 selected items in my Wishlist
    When  I search for lowest price product
    And  I am able to add the lowest price item to my cart        
    Then  I am able to verify the item in my cart