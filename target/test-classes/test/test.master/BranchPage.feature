Feature:Branch page

Scenario: to verify Branch page

Given user on the Master page 
When User clicks on Branch Master
And user clicks create Branch
Then create branch page is visible 


Given user is on create branch page
When user enters company code
Then company name should autofill
When user selects client code
Then client name,branch code should autofill
When user enters branch name,selects ownership type and branch logo and clicks next


Given user is on the branch address page
When user enters pincode,addr1village,district,addr2,city,state,click on next

Given user is on Branch contact deatils
When user enters contact person,mobile std,number,landlinestd1,number,landlinestd2,number,landinestd3.number,email,click on next
Then user is on owner detail page


Given user is on the Ownerdetail page
When user enters all the feilds and click on next button
Then user succesfully navigate to Regiestration detail1 page

Given user is on the LoginDetailPage
When user enters login details and click on submit button  and click on last button