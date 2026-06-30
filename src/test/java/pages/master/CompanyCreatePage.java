package pages.master;

import org.testng.Assert;

//import java.nio.file.Paths;

//import java.nio.file.Paths;

//import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.WebSocket.WaitForFrameReceivedOptions;
//import com.microsoft.playwright.assertions.PlaywrightAssertions;

//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestData;

public class CompanyCreatePage 
{

	Browser browser;
	Page page;
	
	public void SetUp()
	{
	
	browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
	page=browser.newPage();
	page.navigate(TestData.LoginUrl);
	page.locator("#CompanyUserId").fill(TestData.UserID);
	page.locator("#CompanyPassword").fill(TestData.Password);
	page.locator("#btnLogin").click();
	}
	/*
	@Given("user on Master drop down list")
	public void MasterDropList()
	{
		SetUp();
		page.locator("xpath=//a[text()='Master']").click();
		
	}
	@When("User clicks on Company Master")
	public void CompanyMaster()
	{
		page.getByText(" Company Master").click();
	}
	@And("user clicks on Create Company")
	public void CreateCompany()
	{
		page.locator(".li_master_company_create").click();
	}
	@Then("Create company is visible")
	public void VerifyCreate()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Company/Create");
	}
	
	/*@Given("user is on the Create company page")
	public void CreatePage()
	{
		page.locator("http://192.168.1.1:8001/Company/Create");
	}
	/*
	@When("user enters company name and company short code and Establishment code")
	public void CompanyDetail()
	{
		page.locator("#CompanyName").fill("Tata Consultancy Services");
		page.locator("#CompanyShortCode").fill("TCS1");
		page.locator("#EstablishCode").fill("1967");
	}
	@And("clicks on Select ownership Drop down and enters company url")
	public void CompanyDetail2()
   {
		page.locator("#OwnershipType").selectOption("Public Sector Undertaking");
		page.locator("#CompanyWebsite").fill("https://www.tcs.com/");
	}
	
	@And("clicks on choose file and clicks on next")
	public void LogoFile()
	{
		
		page.locator("#companyIcon").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		page.locator(".Company-next").first().click();
	}
	@Then("user should navigate to Company address page")
	public void VerifyCompanyaddress()
	{
		PlaywrightAssertions.assertThat(page.getByText("Company Address"));
	}
	@Given("user is on Company Address")
	public void CompanyAdress()
	{
		page.getByTestId("Company Address").isVisible();
	}
	
	@When("user enters a Pincode")
	public void Pincode1()
	{
		page.locator("#CompanyAddress_Pincode").fill("412105");
	}
	@Then("all address fields should be autofill")
	public void VerifyAddress()
	{
		PlaywrightAssertions.assertThat(page.locator("#CompanyAddress_AddressLine1")).isEmpty();
		page.locator(".Company-next").nth(1).click();
		
	}
	
	@Given("user is on contact details page")
	public void ContactDetails()
	{
		page.locator("xpath=//p[text()='Contact Details ']").isVisible();
		
	}
	@When("user enters contact person name,std code,number,landline1 code,number,landline2, number,landline3,number")
	public void ContactPersonDetails()
	{
		page.locator("#CompanyContact_ContactPerson").fill("sneha gholap");
		page.locator("#CompanyContact_MobileOfficial_std_code").fill("+91");
		page.locator("#CompanyContact_MobileOfficial").fill("9766350459");
		page.locator("#CompanyContact_LandLine_No_1_std_code").fill("020");
		page.locator("#CompanyContact_LandLine_No_1").fill("12345678");
		page.locator("#CompanyContact_LandLine_No_2_std_code").fill("080");
		page.locator("#CompanyContact_LandLine_No_2").fill("41257896");
		page.locator("#CompanyContact_LandLine_No_3_std_code").fill("040");
		page.locator("#CompanyContact_LandLine_No_3").fill("38965412");
		
	}
	@And("enters email id and clicks on next button")
	public void ContactPersonDetails2()
	{
		page.locator("#CompanyContact_EmailIdOfficial").fill("snehagholap@gmail.com");
		page.locator(".Company-next").nth(2).click();
	}
	@Then("user should succesfully add contact details")
	public void VerifyNextPage()
	{
		page.locator("xpath=//p[text()='Owner Details ']").isVisible();
	}
	
	@Given("user is on owner details page")
	public void OwnerDetail()
	{
		page.locator("xpath=//p[text()='Owner Details ']").isVisible();
	}
	@When("user enters first name,Status-Designation,mobile number,date from posistion,Father-husband name,Pan Card no")
	public void OwnerDetailPage()
	{
		page.locator("xpath=//input[@placeholder='First name']").fill("sneha");
		page.locator("xpath=//select[@data-bind='value:OwnerStatus ,uniqueName: true']").selectOption("Director");
		page.locator("xpath=//input[@data-bind='value:OwnerMobileNo ,uniqueName: true']").fill("9876456379");
		page.locator("xpath=//input[@data-bind='value:OwnerDateInPosition ,uniqueName: true']").fill("12/04/2020");
		page.locator("xpath=//input[@placeholder='Father/Husband name']").fill("sharad");
		
		page.locator("xpath=//select[@data-bind='value:OwnerResponsibleType ,uniqueName: true']").selectOption("Manager");
		page.locator("xpath=//input[@placeholder='Last name']").fill("gholap");
		page.locator("xpath=//input[@placeholder='Director Identification Number']").fill("12345678");
		page.locator("xpath=//textarea[@placeholder='Residential Address']").fill("pune");
		page.locator("xpath=//input[@placeholder='PTEC Number']").fill("27ABCDE1234FPT001");
		page.locator("xpath=//select[@data-bind='value:OwnerGender,uniqueName: true']").selectOption("Female");
		page.locator("xpath=//input[@data-bind='value:OwnerDOB ,uniqueName: true']").fill("19/03/2005");
		
		
	}
	
	@And("Email Id,Responsible type")
	public void OwnerDetailsPage2()
	{
		page.locator("xpath=//input[@data-bind='value:OwnerPAN ,uniqueName: true']").fill("EQGCP6231E");
		page.locator("xpath=//input[@data-bind='value:OwnerEmailId ,uniqueName: true']").fill("snehagholap@gmail.com");
	}
	@And("Last Name,DIN,Residential Address,PTEC code no,Gender,Date of Birth,Is Primary")
	public void OwnerDetailsPage3()
	{
		page.locator("xpath=//select[@data-bind='value:OwnerResponsibleType ,uniqueName: true']").selectOption("Manager");
		page.locator("xpath=//input[@placeholder='Last name']").fill("gholap");
		page.locator("xpath=//input[@placeholder='Director Identification Number']").fill("12345678");
		page.locator("xpath=//textarea[@placeholder='Residential Address']").fill("pune");
		page.locator("xpath=//input[@placeholder='PTEC Number']").fill("27ABCDE1234FPT001");
		page.locator("xpath=//select[@data-bind='value:OwnerGender,uniqueName: true']").selectOption("Female");
		page.locator("xpath=//input[@data-bind='value:OwnerDOB ,uniqueName: true']").fill("19/03/2005");
		page.locator("xpath=//select[@data-bind='value: OwnerIsPrimary ,uniqueName: true']").selectOption("Yes");
		PlaywrightAssertions.assertThat(page.locator("#btnOwnerAdd")).isEnabled();
	}
	
	@And("click on row button to create row and delete row")
	public void RowClick() throws InterruptedException
	{
		page.locator("xpath=//button[@data-bind='click: addOwnerDetails']").click();
		page.locator("#btnOwnerDelete").nth(1);
		Thread.sleep(2000);
	}
	

	@And("click on next button")
	public void ClickNext()
	{
		page.locator(".Company-next").nth(3).click();
	}
	
	@Then("succesfully registeration detail1 page should display")
	public void RegisterationDetail1()
	{
		page.locator("xpath=//p[text()='Registration Details 1']").isVisible();
	}
	
	//Registeration detail 1
	
	@Given("user is on registeration detail 1 page")
	public void RegistrationDetail1()
	{
		page.locator("xpath=//p[text()='Registration Details 1']").isVisible();;
	}
	
	@When("user click on shop Act no checkbox and enters shop act no and date and clicks on choose file")
	public void DetailsRegisteration()
	{
		page.locator("xpath=//input[@name='cbShopActNo']").check();
		page.locator("#Doc_0__DocNumber").fill("SA/2026/458721");
		page.locator("#Doc_0__DocDate").fill("02/10/2003");
		page.locator("#fuShopActNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
	}
	
	@And("user click on Shop Act Copy No checkbox and enters Shop Act Copy No and date and clicks on choose file")
	public void DetailsRegisteration2()
	{
		page.locator("#cbShopActCopyNo").check();
		page.locator("#Doc_1__DocNumber").fill("SAC/MH/2026/458721");
		page.locator("#Doc_1__DocDate").fill("02/10/2003");
		page.locator("#fuShopActCopyNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	
	@And("user click on ESIC Code No checkbox and enters ESIC Code No and date and clicks on choose file")
	public void DetailsRegisteration3()
	{
		page.locator("#cbESICNo").check();
		page.locator("#Doc_2__DocNumber").fill("12345678901234567");
		page.locator("#Doc_2__DocDate").fill("02/10/2003");
		page.locator("#fuESICNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	
	@And("user click on PF Code No checkbox and enters PF Code No and date and clicks on choose file")
	public void DetailsRegisteration5()
	{
		page.locator("#cbPFNo").check();
		page.locator("#Doc_3__DocNumber").fill("MHBAN1234567000");
		page.locator("#Doc_3__DocDate").fill("02/10/2003");
		page.locator("#fuPFNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	@And("user click on PT Code No checkbox and enters PT Code No and date and clicks on choose file")
	public void DetailsRegisteration6()
	{
		page.locator("#cbPTNo").check();
		page.locator("#Doc_4__DocNumber").fill("27ABCDE1234FPT001");
		page.locator("#Doc_4__DocDate").fill("02/10/2003");
		page.locator("#fuPTNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	@And("user click on Welfare Fund No checkbox and enters Welfare Fund No and date and clicks on choose file")
	public void DetailsRegisteration7()
	{
		page.locator("#cbWelfareFundNo").check();
		page.locator("#Doc_5__DocNumber").fill("WF2026458721");
		page.locator("#Doc_5__DocDate").fill("02/10/2003");
		page.locator("#fuWelfareFundNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	@And("user click on Service Tax No checkbox and enters Service Tax No and date and clicks on choose file")
	public void DetailsRegisteration8()
	{
		page.locator("#cbServiceTaxNo").check();
		page.locator("#Doc_6__DocNumber").fill("ABCDE1234FST001");
		page.locator("#Doc_6__DocDate").fill("02/10/2003");
		page.locator("#fuServiceTaxNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	@And("user click on TIN No checkbox and enters TIN No and date and clicks on choose file")
	public void DetailsRegisteration9()
	{
		page.locator("#cbTinNo").check();
		page.locator("#Doc_7__DocNumber").fill("27123456789");
		page.locator("#Doc_7__DocDate").fill("02/10/2003");
		page.locator("#fucbTinNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	@And("user click on PAN Card No checkbox and enters PAN Card No and date and clicks on choose file")
	public void DetailsRegisteration10()
	{
		page.locator("#cbPanNo").check();
		page.locator("#Doc_8__DocNumber").fill("ABCDE1234F");
		page.locator("#Doc_8__DocDate").fill("02/10/2003");
		page.locator("#fuPanNoDate").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	@And("user click on LIN No checkbox and enters LIN No and date and clicks on choose file")
	public void DetailsRegisteration4()
	{
		page.locator("#cbLINNo").check();
		page.locator("#Doc_9__DocNumber").fill("1000001234567");
		page.locator("#Doc_9__DocDate").fill("02/10/2003");
		page.locator("#fucbLINNo").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		
	}
	
	@And("click on next button for regesiteration detail 2 page")
	public void ClickNext1()
	{
		page.locator(".Company-next").nth(4).click();
	}
	
	@Then("succesfully registeration detail2 page should display")
	public void VerifyNextPage2()
	{
		page.locator("xpath=//p[text()='Registration Details 2']").isVisible();
	}
	
	//registration2
	
	@Given("user is on Registration detail2 page")
	public void Registrationpage23()
	{
		page.locator("xpath=//p[text()='Registration Details 2']").isVisible();
	}
	
	@When("user enters document no,date of registration,upload a document")
	public void Registrationdetail2()
	{
		PlaywrightAssertions.assertThat(page.locator("xpath=//input[@placeholder='Document Name']")).not().isEmpty();
		page.locator("xpath=//input[@placeholder='Document No.']").fill("1");
		page.locator("xpath=//input[@name='ko_uniqued_0']").fill("24/06/2026");
		page.locator("xpath=//input[@name='ko_uniques_0']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
	}
	
	@And("user click on gst row and fill the details")
		public void Registrationdetails()
		{
			page.locator("xpath=//button[@data-bind='click: addGSTDocs']").click();
			page.locator("xpath=//input[@name='ko_uniqueo_1']").fill("2");
			page.locator("xpath=//input[@name='ko_uniqued_1']").fill("12/02/2025");
			page.locator("xpath=//input[@name='ko_uniques_1']").setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\google-logo.png"));
		}
	@And("user click on row button and delete row")
		public void AddRow()
		{
			page.locator("xpath=//button[@data-bind='click: addDocs']").click();
			page.locator("xpath=//a[@data-bind='click: $root.removeDocs']").click();
		}
	
	@And("click on the next button")
	public void ClickNext3()
	{
			page.locator(".Company-next").nth(5).click();
	}
		
	@Then("successfully login detail page should displayed")
	public void VerifyLoginDetail()
	{
		page.locator("xpath=//p[text()='Login Details ']").isVisible();
	}
	
	//Login details
	
	@Given("user is on login details page")
	public void LoginDetails()
	{
		page.locator("xpath=//p[text()='Login Details ']").isVisible();
	}
	@When("user clicks on allow uniqueness check box")
	public void Detaillogin()
	{
		page.locator("#CheckForUniqueness").check();
	}
	@And("enters UserId,Password,Re comfirs enters password and clicks on submit button")
	public void DetailLogin()
	{
		page.locator("#CompanyUserId").fill("Sneha2005");
		page.locator("#CompanyPassword").fill("sneha@2005");
		page.locator("#ConfirmPassword").fill("sneha@2005");
		page.locator("#btnSaveData").click();
	}
	*/
	
	
	// negative scenarios
	/*
	@Given("user is on Create company page")
	public void CreatePage()
	{
		page.locator("http://192.168.1.1:8001/Company/Create");
	}
		/*passed
	@When("user enters invalid company name")
	public void CName()
	{
		page.locator("xpath=//input[@id='CompanyName']").fill("1234");
	}
	@Then("user should get error message as'Enter correct input'")
	public void CNameError1()
	{
		String expectedResult = "Enter correct input";
		Assert.assertEquals(expectedResult, "Enter correct input");
	}
	
	@When("user does not enter any CName and click on last button and click on submit button of login detail page")
	public void CNameError2()
	{
		page.locator("xpath=//input[@id='CompanyName']").fill("");
		page.locator("xpath=//a[@class='Company-last']").first().click();
		page.locator("#btnSaveData").click();
	}
	
	@Then("user should navigate to company create page and Cname field show error message as'This feild is required'")
	public void CNameError3()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Company/Create");
		if(page.locator("#CompanyName-error").isVisible())
		{
			System.out.println("error is visible");
		}
		else
		{
			System.out.println("error not visible");
		}
	}
	*/
	/* passed
	@When("user enters more than 15 numbers")
	public void CSCode()
	{
		page.locator("#CompanyShortCode").fill("1234567891012345");
	}
	
	@Then("user should not be able to enter more than that")
	public void CSCodeError1()
	{
		String expectedResult = "123456789123456";
		Assert.assertEquals(expectedResult, "1234567891012345");
	}
	
	@When("user does not enter any Short Code and click on last button and click on submit button of login detail page")
	public void CSCodeError2()
	{
		page.locator("#CompanyShortCode").fill("");
		page.locator("xpath=//a[@class='Company-last']").nth(1).click();
		page.locator("#btnSaveData").click();
	}
	
	@Then("user should navigate to company create page and short code field show error message as'This feild is required'")
	public void CSCodeError3()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Company/Create");
		if(page.locator("#CompanyShortCode-error").isVisible())
		{
			System.out.println("error is visible");
		}
		else
		{
			System.out.println("error not visible");
		}
	
	}
	*/
	
	/*passed
	@When("user enters Establishment code more than 15 numbers")
	public void ECode()
	{
		page.locator("#EstablishCode").fill("1234567891012345");
	}
	@Then("user should not be able to enter more 15 numbers")
	public void ECodeError1()
	{
		String expectedResult = "123456789123456";
		Assert.assertEquals(expectedResult, "1234567891012345");
	}
	
	@When("user does not enter any eCode and click on last button and click on submit button of login detail page")
	public void ECodeError2()
	{
		page.locator("#EstablishCode").fill("");
		page.locator("xpath=//a[@class='Company-last']").first().click();
		page.locator("#btnSaveData").click();
	}
	
	@Then("user should navigate to company create page and ECode field show error message as'This feild is required'")
	public void ECodeError3()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Company/Create");
		if(page.locator("#EstablishCode-error").isVisible())
		{
			System.out.println("error is visible");
		}
		else
		{
			System.out.println("error not visible");
		}
	
	}
	*/
	/*passed
	@When("clicks multiple Select ownership Drop down")
	public void Ownership()
	{
		String Ownershiptype[]= {"Central Govt. Controlled","Central Public Sector Undertakings"};
		page.locator("#OwnershipType").selectOption(Ownershiptype);
	}
	@Then("user should not be able to select multiple options")
	public void OwnershipError()
	{
		String ExpectedResult="Central Public Sector Undertakings";
		Assert.assertEquals(ExpectedResult,"Central Govt. Controlled","Central Public Sector Undertakings" );
	}
	@When("user does not choose any options and click on last button and click on submit button of login detail page")
	public void OwnershiptypeError2()
	{
		page.locator("#OwnershipType").fill("");
		page.locator("xpath=//a[@class='Company-last']").first().click();
		page.locator("#btnSaveData").click();
	}
	
	@Then("user should navigate to company create page and show error message as'This feild is required'")
	public void OwnershiptypeError3()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Company/Create");
		if(page.locator("#OwnershipType-error").isVisible())
		{
			System.out.println("error is visible");
		}
		else
		{
			System.out.println("error not visible");
		}
	
	}
	*/
	/*passed
	@When("user enters invalid company url")
	public void CUrl()
	{
		page.locator("#CompanyWebsite").fill("google");
	}
	@Then("user should get error message as'Please enter a valid URL'")
	public void CUrlError1()
	{
		String ExpectedResult="Enter correct url";
		Assert.assertEquals(ExpectedResult,"Enter correct url" );
	}
	*/
	/*passed
	@When("user choose file of inavlid type")
	public void File()
	{
		page.locator("#companyIcon").setInputFiles(Paths.get("C:/Users/Lenovo-3/Pictures/download.pdf"));
	}
	@Then("user should get error message as 'Only image formate are allowed'")
	public void FileError1()
	{
		String ExcpectedResult = "Only image formats are allowed";
		Assert.assertEquals(ExcpectedResult,"Only image formats are allowed");
	}
	
	@When("user does not choose any file and click on last button and click on submit button of login detail page")
	public void FileError2()
	{
		page.locator("#companyIcon");
		page.locator("xpath=//a[@class='Company-last']").first().click();
		page.locator("#btnSaveData").click();
	}
	
	@Then("user should navigate to company create page and CLogo field show error message as'This feild is required'")
	public void FileError3()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Company/Create");
		if(page.locator("#companyIcon-error").isVisible())
		{
			System.out.println("error is visible");
		}
		else
		{
			System.out.println("error not visible");
		}
	
	}
	*/
	/*
	
	@Given("user is on Company Address page")
	public void CAddr()
	{
		page.locator("xpath=//a[text()='Company Address']").click();
	}
	@When("user enters a invalid Pincode")
	public void CAddr1()
	{
		page.locator("#CompanyAddress_Pincode").fill("Abcd");
	}
	@Then("it should not accept it")
	public void CAddrError1()
	{
		PlaywrightAssertions.assertThat(page.locator("#CompanyAddress_Pincode")).isEmpty();
	}
	@When("user does not enters pincode and click on last button and click on submit button of login detail page")
	public void CAddrError2()
	{
		page.locator("#CompanyAddress_Pincode").fill("");
		page.locator("xpath=//a[@class='Company-last']").nth(1).click();
		page.locator("#btnSaveData").click();
	}
	@Then("user should navigate to company address page and pincode field show error message as'This feild is required'")
	public void CAddrError3()
	{
		String ExcpectedResult = "This field is required.";
		Assert.assertEquals(ExcpectedResult,"This field is required.");
	}
	*/
	
	@Given("user is on contact details page")
	public void ContactDetailspage()
	{
		page.locator("xpath=//a[text()='Contact Details']").click();
		
	}
	
	@When("user enters invalid contact name")
	public void ContactDetails() throws InterruptedException
	{
		page.locator("#CompanyContact_ContactPerson").fill("1234");
		

	    // Click outside the field to trigger validation
	    page.locator("body").click();
	    
	}
	@Then("user should get error message {string}")
	public void userShouldGetErrorMessage(String expectedMessage) {

	    Locator errorMsg = page.locator("//h2[text()='Enter correct input']");

	    String actualMessage = errorMsg.textContent().trim();

	    Assert.assertEquals(actualMessage, expectedMessage);
	}

	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
