#Author: srideep.deepti@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#
@ApplyFilter
Feature: This Feature is to validate the functionality of Apply Filter and Clear All filter button
         available in https://www.nsw.gov.au/media-releases page

  
  Scenario: Check minister checkbox, Apply Filter and then Clear Filter
    Given I navigate to specified URL
    And   I expand the Minister List available on page
    And   I select the following ministers given below:
     
     | Treasurer |
     #| Minister for Water |
     | Minister for Agriculture|
     | Minister for Better Regulation and Fair Trading|
     #|Minister for Aboriginal Affairs and Treaty|
 
    When  I click on Apply Filter after selection
    Then  I validate filters are applied correctly and corresponding Minister Media Release cards are visible
    
    
    
    
   Scenario: Click on Clear All button to remove the already applied filters
    Given I am on the page with Filters applied on Ministers
    When  I click on CLear All to remove the applied filters
    Then  I validate that Filters are removed correcly
    And   then I close the browser
     
    
    
   
    
     

  
