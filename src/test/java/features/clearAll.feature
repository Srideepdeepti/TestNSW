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
@ClearAllFilter
Feature: Validate Clear All filter
  
 
  Scenario: Verify if clear all filter is working as expected
     Given I navigate to url
     And   show all  ministers
     And  check few of the ministers
     When I click on Clear All Filter
     Then I validate whether checkbox got unchecked

 