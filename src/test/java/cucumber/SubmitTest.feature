@tag
Feature: Purchase the Order from eCommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I Landed on Ecommerce Page 

  @tag2
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with name <name> and password <password>
    When add item <item> to cart
    And Checkout item <item> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

    Examples: 
      | name                          | password      | item       |
      | DavidMDiaz@rhyta.com          | David@54321   | ZARA COAT 3 |
      | zalepraddili-9737@yopmail.com | Cillian@54321 | ADIDAS ORIGINAL |
