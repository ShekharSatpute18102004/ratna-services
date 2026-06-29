Feature:Employee page

Scenario: verify employee master page

Given user is on the Master 
When User clicks on Employee Master
And user clicks create employee
Then Enter Employee Information page is visible 

Given user is on Enter employee information page 
When user select company code,client code
And user verify Employee Id and enters First Name
And user enters Father,Husband Name and select option from drop down list,surname
And user enters Date of Birth
Then Age should autogenrate
When user selects Marital Status and selects Gender
And clicks on submit
Then user should navigate to Enter General Information page


#Residential address page

Given user is on the Residential Address page
When user is enters email ID1,email id2,mobile no1 std,number,mobile no2 std,number,Landineno1 std,number
And enters addr1,addr2,village,city,district,state,country,pincode and clicks on permenant adress check box ,clicks on submit button
Then user should succesfully navigate to general info page


#qualification page
Given user is qualification details
When user enter qualification, passing year,percentage,qualification type,addes row and delete one row and click on submit
Then user should get navigated to general detail page

#General detail page
Given user is on General detail page
When user enters joining dates,designation,releaving date,releaving reason,reffered by,pan card no,date of birth
And user enters adharno,name as per addr,father name adharr,click on blacklist by check box and enter blacklist by and blacklist reason
Then user should get navigate to Salary heads page

#policy detail page
Given user is on Policy detail page
When user clicks on medical policy check box enters policy no,amount,policy premium,main uhid,start date,end date,insurance agency name
And user clicks on row button and click on delete button
And user clicks on WC policy chek box enters policy no,amount,policy premium,man uhd,start date,end date,insurance agency name
And user clicks on WC row button and click on delete button and click on submit buton
Then user should navigate to salary heads page

#Provient Fund page

#Given user is on Provient fund page
#When user enters UAN no and clicks on ESICno check box and enters ESICno and date
#And click on Emp category type and select worker type,nationality
#sAnd enters Passport no,Valid from,valid till and chooses is Handicap check box and click on submit

Given user is on the Salary Heads page
When user selects Salary Type and select template
And clicks on applicable check box and enters fix amount and click on submit button


Given user enter is on the Document or login page
When user selects photo,sign,CV,Aadhaar,PAN,Cancel Cheque,driving license file
And enters Pasword,Re-confirm password and click on the submit button


