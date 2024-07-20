#Author: your.email@your.domain.com
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
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@ApplyFilter
Feature: Validate to select all the minister which are provided and check corresponding checkbox
         I want to use this template for my feature file

  
  Scenario: Check minister checkbox, Apply Filter and then Clear Filter
    Given I navigate to url
    And   I expand the Minister List
    And   I select the following ministers:
     
     | Treasurer |
     #| Minister for Water |
     #| Minister for Agriculture|
     #| Minister for Better Regulation and Fair Trading|
     #|Minister for Aboriginal Affairs and Treaty|
 
    When  apply filter on the seleceted Minister List
    Then  I validate all the minsters selected
    And   lastly click on Clear All and validate it
    And   Finally close the browser
    
    
   
    
     

  
