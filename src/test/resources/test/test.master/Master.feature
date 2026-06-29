Feature: Master drop down

Scenario: verify master
Given user is on home page
When user clicks on Master drop down list


#When user enters invalid std code
#Then user should get error  message
#When user enters invalid number of 11 numbers
Then user should not be able to enter 11 numbers
When user enters invalid landline1 code
Then user should get error message
When user enters invalid email id 
Then user should get error message
When user doesnot fill any contact deatils and clicks on last next button and click on submit button
Then user should naviagte to contact details page and this is required page message should displayed

