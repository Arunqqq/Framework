
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

   Background: 
   Given I landed on Ecommerce Page
 
  @Regression
  Scenario Outline: Positive Test of Sumitting the order
    Given Logged in with username <username> and password <password>
    When I add product <productname> to cart
    And  Checkout <produtname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username             | password       | productname     |
      | arunkumar1@gmail.com | Framework$1247 | ADIDAS ORIGINAL |

