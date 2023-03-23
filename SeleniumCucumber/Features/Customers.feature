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
@tag
Feature: Cutomers
Background: Common steps for every scenario
	 Given launch chrome browser
		When User open URL 
		And user enter email ID as "admin@yourstore.com" and password as "admin"
		And User click login
		Then User can view the Dashboard
	
  @tag1
  Scenario: Add a new cutomer
 		When user clicks on customers menu
		And click on customers menu item
		And Click on Add New button
		Then user can view Add new customer Page
		When User enter customer info
		And click on Save button
		Then user can view confirmation message "The new customer has been added sucessfully."
		And close the browser
		
 @tag2
  Scenario: Search cutomer by email Id
 		When user clicks on customers menu
		And click on customers menu item
		When enter the email id
		And click on Search button
		Then The customer record related to the email id will be displayed
		And close the browser
		
 @tag3
  Scenario: Search cutomer by name
 		When user clicks on customers menu
		And click on customers menu item
		And enter the firstname
		And enter the lastname
		And click on Search button
		Then The customer record related to the name will be displayed
		And close the browser

  