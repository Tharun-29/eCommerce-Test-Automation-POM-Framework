
@tag
Feature: Error Validation
  I want to use this template for my feature file
 

  @ErrorValidation
  Scenario Outline: Error Validation for Incorect Login
    Given I open Ecommerce Page
    When Logged in with name <name> and password <password>
    Then "Incorrect email or password." message is displayed

   Examples: 
      | name                          | password     | 
      | DavidMDiaz@rhyta.com          | David@5321   | 
      | zalepraddili-9737@yopmail.com | Cillin@54321 | 
