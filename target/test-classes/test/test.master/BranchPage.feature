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

#registration deatil1

Given user is on registeration detail 1 page
When user click on shop Act no checkbox and enters shop act no and date and clicks on choose file
And user click on Shop Act Copy No checkbox and enters Shop Act Copy No and date and clicks on choose file
And user click on ESIC Code No checkbox and enters ESIC Code No and date and clicks on choose file
And user click on PF Code No checkbox and enters PF Code No and date and clicks on choose file
And user click on PT Code No checkbox and enters PT Code No and date and clicks on choose file
And user click on Welfare Fund No checkbox and enters Welfare Fund No and date and clicks on choose file
And user click on Service Tax No checkbox and enters Service Tax No and date and clicks on choose file
And user click on TIN No checkbox and enters TIN No and date and clicks on choose file
And user click on PAN Card No checkbox and enters PAN Card No and date and clicks on choose file
And user click on LIN No checkbox and enters LIN No and date and clicks on choose file
And click on next button for regesiteration detail 2 page
Then succesfully registeration detail2 page should display

Given user is on Registration detail2 page
When user enters document no,date of registration,upload a document 
And click on the next button
Then successfully login detail page should displayed

Given user is on the LoginDetailPage
When user enters login details and click on submit button  and click on last button