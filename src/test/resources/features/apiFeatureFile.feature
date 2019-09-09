Feature: To verify API Functions

Scenario: Get weather details in Hyderabad
Given I set URI to get weather info
When I submit a request with city "Hyderabad"
Then Verify the weather response


#Scenario: Complete registration process
#Given I set URI for registration
#When I register with all required information
#Then Verify the response after registration



 