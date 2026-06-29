package pages.master;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestData;

public class EmployeePage {
	
	Browser browser;
	Page page;
	
	public void SetUp()
	{
	
	browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
	page=browser.newPage();
	page.navigate(TestData.LoginUrl);
	page.locator("#CompanyUserId").fill(TestData.UserID);
	page.locator("#CompanyPassword").fill(TestData.Password);
	page.locator("#btnLogin").click();
	}
	
	@Given("user is on the Master")
	public void Master()
	{
		SetUp();
		page.locator("xpath=//a[text()='Master']").click();
		
	}
	@When("User clicks on Employee Master")
	public void CompanyMaster()
	{
		page.getByText(" Employee  Master").click();
	}
	@And("user clicks create employee")
	public void CreateCompany()
	{
		page.locator(".li_master_Employee_Create").click();
	}
	@Then("Enter Employee Information page is visible")
	public void VerifyCreate()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Employee/CreateEmp");
	}
	
	@Given("user is on Enter employee information page")
	public void EmployeeInfoPage()
	{
		page.locator("http://192.168.1.1:8001/Employee/CreateEmp");
	}
	
	@When("user select company code,client code")
	public void CompanyInfo()
	{
		page.locator("#s2id_CompanyCode").click();
	    page.locator("#s2id_autogen1_search").fill("2000 TATA MOTORS LTD");
	    page.locator("#select2-results-1").click();
		 
		page.locator("#s2id_ClientCode").click();
		page.locator("#s2id_autogen2_search").fill("2001-TATA MOTORS LTD CVBU");
		page.locator("#select2-results-2").click();
		
	}
	
	@And("user verify Employee Id and enters First Name")
	public void EmployeeDetails1()
	{
		PlaywrightAssertions.assertThat(page.locator("#EmployeeCode")).not().isEmpty();
		page.locator("#FirstName").fill(new Faker().name().firstName());
		
	}
	@And("user enters Father,Husband Name and select option from drop down list,surname")
	public void EmployeeDetails2()
	{
		page.locator("#MiddleName").fill(new Faker().name().nameWithMiddle());
		page.locator("#Relation").selectOption("Father");
		page.locator("#SurName").fill(new Faker().name().lastName());
	}
	
	@And("user enters Date of Birth")
	public void EmployeeDetails3()
	{
		page.locator("#DateOfBirth").fill(
			    new SimpleDateFormat("dd/MM/yyyy")
			        .format(new Faker().date().birthday(18, 60))
			);
	}
	@Then("Age should autogenrate")
	public void EmployeeDetails4()
	{
		PlaywrightAssertions.assertThat(page.locator("#Age")).isVisible();
	}
	@When("user selects Marital Status and selects Gender")
	public void EmployeeDetails5()
	{
		page.locator("#MaritalStatus").selectOption("Un-Married");
		page.locator("xpath=//input[@value='Female']").click();
	}
	@And("clicks on submit")
	public void EmployeeDetails6()
	{
		page.locator("#btnSubmit").first().click();
	}
	@Then("user should navigate to Enter General Information page")
	public void EmployeeDetails7()
	{
		page.locator("xpath=//p[text()='Enter General Information ']").isVisible();
	}
	
	@Given("user is on the Residential Address page")
	public void RAddr()
	{
		page.locator("xpath=//a[text()='Residential Address']").click();
	}
	@When("user is enters email ID1,email id2,mobile no1 std,number,mobile no2 std,number,Landineno1 std,number")
	public void RAddrDetail1()
	{
		page.locator("#Contact_EmailIdOfficial").fill(new Faker().name().firstName()+"@gmail.com");
		page.locator("#Contact_EmailIdPersonal").fill(new Faker().name().firstName()+"@gmail.com");
		page.locator("#Contact_MobileOfficial_std_code").fill("91");
		Faker faker = new Faker();
		String number = faker.numerify("##########");
		page.locator("#Contact_MobileOfficial").fill(number);
		page.locator("#Contact_MobilePersonal_std_code").fill("91");
		page.locator("#Contact_MobilePersonal").fill(number);
		page.locator("#Contact_LandLine_No_1_std_code").fill("201");
		page.locator("#Contact_LandLine_No_1").fill(number);
	}
	
	@And("enters addr1,addr2,village,city,district,state,country,pincode and clicks on permenant adress check box ,clicks on submit button")
	public void RAddrdetail2()
	{
		page.locator("#CurrentAddress_AddressLine1").fill(new Faker().address().cityName());
		page.locator("#CurrentAddress_AddressLine2").fill(new Faker().address().cityName());
		page.locator("#CurrentAddress_Village_Taluka").fill(new Faker().address().cityName());
		page.locator("#CurrentAddress_City").fill(new Faker().address().city());
		page.locator("#CurrentAddress_District").fill("haveli");
		page.locator("#CurrentAddress_State").selectOption("Maharashtra");
		page.locator("#CurrentAddress_Country").fill(new Faker().address().country());
		Faker faker=new Faker();
		String pincode = faker.numerify("######");
		page.locator("#CurrentAddress_Pincode").fill(pincode);
		page.locator("#cb").check();
		page.locator("#btnSubmit").nth(1).click();
	}
	
	@Then("user should succesfully navigate to general info page")
	
	public void VerifyPage()
	{
		page.locator("xpath=//p[text()='Enter General Information ']").isVisible();
	}
	
	@Given("user is qualification details")
	public void QualificationDetail()
	{
		page.locator("xpath=//a[text()='Qualifications Details']").click();
		
	}
	
	@When("user enter qualification, passing year,percentage,qualification type,addes row and delete one row and click on submit")
	public void Qualificationdeatail1()
	{
		page.locator("xpath=//input[@data-bind='value: Course, uniqueName: true']").fill("Graduated");
		page.getByPlaceholder("Passing Year").fill("02/2025");
		page.locator("xpath=//input[@data-bind='value: Percentage, uniqueName: true']").fill("80");
		page.getByPlaceholder("Qualification Type").fill("bba");
		page.locator("xpath=//button[@data-bind='click: addCourse']").click();
		page.locator("xpath=//span[@class='glyphicon glyphicon-trash']").first().click();
		
		page.locator("#btnSubmit").nth(2).click();
		
	}
	@Then("user should get navigated to general detail page")
	public void VerifyPage2()
	{
		page.locator("xpath=//p[text()='Enter General Information ']").isVisible();
	}
	
	@Given("user is on General detail page")
	public void Generaldetail()
	{
		page.locator("xpath=//a[text()='General Details']").click();

	}
	@When("user enters joining dates,designation,releaving date,releaving reason,reffered by,pan card no,date of birth")
	public void GeneralDetail1()
	{
		page.locator("#GeneralInfo_JoiningDate").fill("12/02/2025");
		page.locator("#GeneralInfo_Designation").fill("softwaretesting");
		page.locator("#GeneralInfo_ReleavingDate").fill("16/05/2026");
		page.locator("#GeneralInfo_ReasonCode").selectOption("Left Service");
		page.locator("#GeneralInfo_ReleavingReason").fill("none");
		page.locator("#ReferredBy").fill(new Faker().name().firstName());
		page.locator("#chkPANCard").check();
		//Faker faker=new Faker();
		//String pannumber=faker.numerify("")
		page.locator("#GeneralInfo_PanCardNo").fill("EQASD1234Q");
		page.locator("#GeneralInfo_PanCardDate").fill("23/03/2005");
		
	}
	@And("user enters adharno,name as per addr,father name adharr,click on blacklist by check box and enter blacklist by and blacklist reason")
	public void GeneralDetail2()
	{
		page.locator("#GeneralInfo_AdharId").fill("234545676789");
		page.locator("#GeneralInfo_AdharName").fill(new Faker().name().fullName());
		page.locator("#GeneralInfo_AdharFatherName").fill(new Faker().name().fullName());
		page.locator("#chkBlackList").check();
		page.locator("#GeneralInfo_BlackListBy").fill(new Faker().name().fullName());
		page.locator("#GeneralInfo_BlackListDate").fill("13/11/2012");
		page.locator("#GeneralInfo_BlackListReason").fill("nothing");
		page.locator("#btnSubmit").nth(3).click();
		
	}
	
	@Then("user should get navigate to Salary heads page")
	public void VerifySalaryHeads()
	{
	page.locator("xpath=//a[text()='Salary Heads']").isVisible();
	}
	@Given("user is on Policy detail page")
	public void PolicyDetail1()
	{
		page.getByText("Policy's Details").click();
	}
	@When("user clicks on medical policy check box enters policy no,amount,policy premium,main uhid,start date,end date,insurance agency name")
	public void PolicyDetail2()
	{
		page.locator("#cbIfApplicable").check();
		Faker faker=new Faker();
		String policyno=faker.numerify("POL######");
		page.locator("xpath=//input[@name='ko_unique_13']").first().fill(policyno);
		page.locator("xpath=//input[@name='ko_unique_14']").fill("500000");
		page.locator("xpath=//input[@name='ko_unique_15']").fill("1500");
		page.locator("xpath=//input[@name='ko_unique_16']").fill("UHID00012345");
		page.locator("xpath=//input[@name='ko_unique_17']").fill("12/03/2005");
		page.locator("xpath=//input[@name='ko_unique_18']").fill("01/12/2022");
		page.locator("xpath=//input[@name='ko_unique_19']").fill(new Faker().name().firstName());
		
	}
	@And("user clicks on row button and click on delete button")
	public void PolicyDetail3()
	{
		page.locator("#btnAddMedicine").click();
		page.locator("xpath=//a[@data-bind='click: $root.removeMedical']").first().click();
	}
	
	@When("user clicks on WC policy chek box enters policy no,amount,policy premium,man uhd,start date,end date,insurance agency name")
	public void PolicyDetail4()
	{
		page.locator("#cbIfApplicable_WCPolicy").check();
		Faker faker=new Faker();
		String policyno=faker.numerify("POL######");
		page.locator("xpath=//input[@name='ko_unique_20']").first().fill(policyno);
		page.locator("xpath=//input[@name='ko_unique_21']").fill("500000");
		page.locator("xpath=//input[@name='ko_unique_22']").fill("1500");
		page.locator("xpath=//input[@name='ko_unique_23']").fill("UHID00012345");
		page.locator("xpath=//input[@name='ko_unique_24']").fill("12/03/2005");
		page.locator("xpath=//input[@name='ko_unique_25']").fill("01/12/2022");
		page.locator("xpath=//input[@name='ko_unique_26']").fill(new Faker().name().firstName());
		
	}
	
	@And("user clicks on WC row button and click on delete button and click on submit buton")
	public void PolicyDetail5()
	{

		page.locator("#btnAdd_WCPolicy").click();
		page.locator("xpath=//a[@data-bind='click: $root.removeWCPolicy']").first().click();
	}
	@Then("user should navigate to salary heads page")
	public void VerifyPolicyDEtail()
	{
		page.locator("xpath=//p[text()='Enter Salary Heads']").isVisible();
	}
	
	
	/*Provient fund
	
	@Given("user is on Provient fund page")
	public void PFpage()
	{
		page.locator("xpath=//a[text()='Provident Fund']").click();
	}
	
	@When("user enters UAN no and clicks on ESICno check box and enters ESICno and date")
	public void PFdetail()
	{
		Faker faker=new Faker();
		String Uan_no=faker.numerify("############");
		page.locator("#PF_Info_0__UANNo").fill(Uan_no);
		
		page.locator("xpath=//input[@id='cbESICNo']").check();
		String Esicno=faker.numerify()
		page.locator("#PF_Info_0__ESICNo").
	}
	*/
	
	@Given("user is on the Salary Heads page")
	public void SalaryPage()
	{
		page.locator("xpath=//a[text()='Salary Heads']").click();
	}
	
	@When("user selects Salary Type and select template")
	public void SalaryDetails1()
	{
		page.locator("#SalaryType").selectOption("Monthly(M)");
		page.locator("#ApplyTemplate").click();
	}
	@And("clicks on applicable check box and enters fix amount and click on submit button")
	public void SalaryDetails2()
	{
		page.locator("#cbApp").check();
		page.locator("xpath=//input[@data-bind='value: FixAmount, uniqueName:true']").first().fill("1500");
		page.locator("#btnSubmit").nth(8).click();
	}
	
	@Given("user enter is on the Document or login page")
	public void DocumentPage()
	{
		page.locator("xpath=//a[text()='Document / Login']").click();
	}
	@When("user selects photo,sign,CV,Aadhaar,PAN,Cancel Cheque,driving license file")
	public void DocumentPageDetail1()
	{
		page.locator("xpath=//input[@name='Photo']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		page.locator("xpath=//input[@name='Sign']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		page.locator("xpath=//input[@name='CV']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\dummy.pdf"));
		page.locator("xpath=//input[@name='Adhar']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		page.locator("xpath=//input[@name='PAN']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		page.locator("xpath=//input[@name='CancelCheque']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		page.locator("xpath=//input[@name='DrivingLicence']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	
	@And("enters Pasword,Re-confirm password and click on the submit button")
	public void DocumentPageDetail2()
	{
		page.locator("#Password").fill("12345678");
		page.locator("#ConfirmPassword").fill("12345678");
		page.locator("#btnSubmit").nth(9).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
