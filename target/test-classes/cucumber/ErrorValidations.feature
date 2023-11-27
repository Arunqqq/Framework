
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
 
  @Errorvalidation
  Scenario Outline: Positive Test of Sumitting the order
    Given I landed on Ecommerce Page
    When Logged in with username <username> and password <password> 
    Then "Incorrect email or password." message is displayed 

    Examples: 
      | username             | password     | 
      | arunkumar1@gmail.com | Framework$47 | 

