Feature:Company Master

Scenario: to verify Company Master is clickable 

#Given user on Master drop down list
#When User clicks on Company Master 
#And user clicks on Create Company
#Then Create company is visible

#When user enters company name and company short code and Establishment code
#And clicks on Select ownership Drop down and enters company url
#And clicks on choose file and clicks on next
#Then user should navigate to Company address page

#Given user is on Company Address
#When user enters a Pincode
#Then all address fields should be autofill

#Given user is on contact details page
#When user enters contact person name,std code,number,landline1 code,number,landline2, number,landline3,number
#And enters email id and clicks on next button
#Then user should succesfully add contact details

#Given user is on owner details page
#When user enters first name,Status-Designation,mobile number,date from posistion,Father-husband name,Pan Card no
#And Email Id,Responsible type
#And Last Name,DIN,Residential Address,PTEC code no,Gender,Date of Birth,Is Primary
#And click on row button to create row and delete row 
#And click on next button
#Then succesfully registeration detail1 page should display

#Given user is on registeration detail 1 page
#When user click on shop Act no checkbox and enters shop act no and date and clicks on choose file
#And user click on Shop Act Copy No checkbox and enters Shop Act Copy No and date and clicks on choose file
#And user click on ESIC Code No checkbox and enters ESIC Code No and date and clicks on choose file
#And user click on PF Code No checkbox and enters PF Code No and date and clicks on choose file
#And user click on PT Code No checkbox and enters PT Code No and date and clicks on choose file
#And user click on Welfare Fund No checkbox and enters Welfare Fund No and date and clicks on choose file
#And user click on Service Tax No checkbox and enters Service Tax No and date and clicks on choose file
#And user click on TIN No checkbox and enters TIN No and date and clicks on choose file
#And user click on PAN Card No checkbox and enters PAN Card No and date and clicks on choose file
#And user click on LIN No checkbox and enters LIN No and date and clicks on choose file
#And click on next button for regesiteration detail 2 page
#Then succesfully registeration detail2 page should display

#Given user is on Registration detail2 page
#When user enters document no,date of registration,upload a document 
#And user click on gst row and fill the details
#And user click on row button and delete row And click on the next button
#Then successfully login detail page should displayed

#Given user is on login details page
#When user clicks on allow uniqueness check box
#And enters UserId,Password,Re comfirs enters password and clicks on submit button






#negative test scenarios for company create

#For company name
#Given user is on Create company page
#When user enters invalid company name
#Then user should get error message as'Enter correct input'
#When user does not enter any CName and click on last button and click on submit button of login detail page
#Then user should navigate to company create page and Cname field show error message as'This feild is required'

#for company short code
#When user enters more than 15 numbers 
#Then user should not be able to enter more than that
#When user does not enter any Short Code and click on last button and click on submit button of login detail page
#Then user should navigate to company create page and short code field show error message as'This feild is required'

#for Establishment code
#When user enters Establishment code more than 15 numbers
#Then user should not be able to enter more 15 numbers
#When user does not enter any eCode and click on last button and click on submit button of login detail page
#Then user should navigate to company create page and ECode field show error message as'This feild is required'

#Ownership drop down
#When clicks multiple Select ownership Drop down
#Then user should not be able to select multiple options
#When user does not choose any options and click on last button and click on submit button of login detail page
#Then user should navigate to company create page and show error message as'This feild is required'

#for company url
#When user enters invalid company url
#Then user should get error message as'Please enter a valid URL'

#for choosing company logo file
#When user choose file of inavlid type
#Then user should get error message as 'Only image formate are allowed'
#When user does not choose any file and click on last button and click on submit button of login detail page
#Then user should navigate to company create page and CLogo field show error message as'This feild is required'

#For Company address pincode
#Given user is on Company Address page
#When user enters a invalid Pincode
#Then it should not accept it
#When user does not enters pincode and click on last button and click on submit button of login detail page
#Then user should navigate to company address page and pincode field show error message as'This feild is required'

#For contact details
#Given user is on contact details page
#When user enters invalid contact name
#Then user should get error message "Enter correct input"





