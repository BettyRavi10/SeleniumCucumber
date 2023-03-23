Feature: Login

Scenario: Successful login with valid login credentials
Given launch chrome browser
When User open URL 
And user enter email ID as "admin@yourstore.com" and password as "admin"
And User click login
Then Page title should be displayed as "Dashboard / nopCommerce administration"
When user click logout
Then Page title should be "Your Store.Login"
And close the browser

Scenario Outline: Login Data Driven
Given launch chrome browser
When User open URL 
And user enter email ID as "<email>" and password as "<password>"
And User click login
Then Page title should be displayed as "Dashboard / nopCommerce administration"
When user click logout
Then Page title should be "Your Store.Login"
And close the browser

		Examples:
		
				| email | password |
				| admin@yourstore.com |admin |
				| admin1@yourstore.com |admin1 |
				
		