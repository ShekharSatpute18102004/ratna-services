package pages.master;

import java.nio.file.Paths;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import Locators.BranchPageLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestData;

public class BranchPage {
	
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
	
	@Given("user on the Master page")
	public void Master()
	{
		SetUp();
		page.locator("xpath=//a[text()='Master']").click();
		
	}
	@When("User clicks on Branch Master")
	public void BranchtMaster()
	{
		page.locator(BranchPageLocators.BranchMaster).click();
	}
	
	@And("user clicks create Branch")
	public void CreateBrancDetail1()
	{
		page.locator(BranchPageLocators.CreateBranch).click();
	}
	@Then("create branch page is visible")
	public void CreateBrancDetail2()
	{
		page.getByText(BranchPageLocators.CreateBranchPage).isVisible();
	}
	
	@Given("user is on create branch page")
	public void CreateBrancDetail3()
	{
		page.getByText(BranchPageLocators.CreateBranchPage).isVisible();
	}
	
	@When("user enters company code")
	public void CreateBrancDetail4()
	{
		page.locator(BranchPageLocators.Companycode).selectOption("2000 TATA MOTORS LTD");
	}
	@Then("company name should autofill")
	public void CreateBrancDetail5()
	{
		PlaywrightAssertions.assertThat(page.locator(BranchPageLocators.CompanyName)).not().isEmpty();
	}
	
	@When("user selects client code")
	public void CreateBrancDetail6()
	{
		page.locator(BranchPageLocators.ClientCode).selectOption("2001-TATA MOTORS LTD CVBU");
	}
	
	@Then("client name,branch code should autofill")
	public void CreateBrancDetail7()
	{
		PlaywrightAssertions.assertThat(page.locator(BranchPageLocators.ClientName)).not().isEmpty();
		PlaywrightAssertions.assertThat(page.locator(BranchPageLocators.BranchCode)).not().isEmpty();
		
	}
	@When("user enters branch name,selects ownership type and branch logo and clicks next")
	public void CreateBrancDetail8()
	{
		page.locator(BranchPageLocators.BranchName).fill("pune");
		page.locator(BranchPageLocators.OwnershipType).selectOption("Central Public Sector Undertakings");
		page.locator(BranchPageLocators.BranchLogo).setInputFiles(Paths.get("D:\\prachi\\Analysis\\logo\\branchpage.jpg"));
		page.locator(BranchPageLocators.Next).first().click();
	}
	
	
	//branch address
	@Given("user is on the branch address page")
	
	public void BrancAddressDetail1()
	{
		page.locator(BranchPageLocators.BranchAddress).isVisible();
	}
	
	@When("user enters pincode,addr1village,district,addr2,city,state,click on next")
	public void BrancAddressDetail2() throws InterruptedException
	{
		Faker faker=new Faker();
		String pincode=faker.numerify("######");
		page.locator(BranchPageLocators.pincode).fill(pincode);
		page.locator(BranchPageLocators.Village_Taluka).fill("alandi");
		page.locator(BranchPageLocators.District).fill(new Faker().address().cityName());
		page.locator(BranchPageLocators.Addressline2).fill(new Faker().address().fullAddress());
		page.locator(BranchPageLocators.City).fill(new Faker().address().city());
		page.locator(BranchPageLocators.State).selectOption("Maharashtra");
		page.locator(BranchPageLocators.Next).nth(1).click();
	}
	
	
	@Then("usre is on the contact details page")
	public void BranchContactDetail1()
	{
		page.locator(BranchPageLocators.ContactDetail).isVisible();
	}
	
	@Given("user is on Branch contact deatils")
	public void BranchContactDetail2()
	{
		page.locator(BranchPageLocators.ContactDetail).isVisible();
	}
	
	@When("user enters contact person,mobile std,number,landlinestd1,number,landlinestd2,number,landinestd3.number,email,click on next")
	public void BranchContactDetail3()
	{
		page.locator(BranchPageLocators.ContactPerson).fill(new Faker().name().fullName());
		page.locator(BranchPageLocators.MobileStd).fill("+91");
		Faker faker=new Faker();
		page.locator(BranchPageLocators.MobileNumber).fill("9766350448");
		page.locator(BranchPageLocators.Landlinestd1).fill("200");
		String Landline=faker.numerify("########");
		page.locator(BranchPageLocators.LandlineNumber1).fill(Landline);
		page.locator(BranchPageLocators.Landlinestd2).fill("202");
		page.locator(BranchPageLocators.LandlineNumber2).fill(Landline);
		page.locator(BranchPageLocators.Landlinestd3).fill("211");
		page.locator(BranchPageLocators.LandlineNumber3).fill(Landline);
		page.locator(BranchPageLocators.EmailId).fill(new Faker().name().firstName()+"@gmail.com");
		page.locator(BranchPageLocators.Next).nth(2).click();
	}
		//owner detail
		
		@Then("user is on owner detail page")
		public void BranchContactDetail4()
		{
			page.locator(BranchPageLocators.OwnerDetail).isVisible();

		}
		
		
		@Given("user is on the Ownerdetail page")
		public void OwnerDetail()
		{
			page.locator(BranchPageLocators.OwnerDetail).isVisible();
		}
		
		@When("user enters all the feilds and click on next button")
		public void OwnerDetails2()
		{
			page.locator(BranchPageLocators.FirstName).fill(new Faker().name().firstName());
			page.locator(BranchPageLocators.Father_husband).fill(new Faker().name().firstName());
			page.locator(BranchPageLocators.LastName).fill(new Faker().name().lastName());
			page.locator(BranchPageLocators.Gender).selectOption("Female");
			page.locator(BranchPageLocators.Status_Designation).selectOption("Managing Director");
			Faker faker=new Faker();
			String PanCardno=faker.numerify("EQCDF####Q");
			page.locator(BranchPageLocators.PanCardno).fill(PanCardno);
			String Dinno=faker.numerify("########");
			page.locator(BranchPageLocators.DIN).fill(Dinno);
			page.locator(BranchPageLocators.DateOfBirth).fill("19/03/2005");
			String phoneno=faker.numerify("##########");
			page.locator(BranchPageLocators.Mobile_no).fill(phoneno);
			page.locator(BranchPageLocators.Email_Id).fill(new Faker().name().firstName()+"@gmail.com");
			page.locator(BranchPageLocators.ResidentialAddress).fill(new Faker().address().fullAddress());
			page.locator(BranchPageLocators.DateFromPosition).fill("12/02/2020");
			page.locator(BranchPageLocators.ResponibileType).selectOption("Manager");
			page.locator(BranchPageLocators.PTECCodeNo).fill("27123456789P");
			page.locator(BranchPageLocators.IsPrimary).selectOption("Yes");
			page.locator(BranchPageLocators.Next).nth(3).click();
			
			
		}
		
		@Then("user succesfully navigate to Regiestration detail1 page")
		public void RegisterationDetail()
		{
			page.locator(BranchPageLocators.Registrationdetail1).isVisible();
			
		}
		@Given("user is on the LoginDetailPage")
		public void LogindetailPage()
		
		{
			page.locator("xpath=//a[text()='Login Details']").click();
		}
		
		@When("user enters login details and click on submit button  and click on last button")
		public void LogindetailPage2() throws InterruptedException
		{
			page.locator(BranchPageLocators.ServiceActiveDate).fill("20/04/2026");
			page.locator(BranchPageLocators.EmployeeIdMode).first().click();
			page.locator(BranchPageLocators.Handledby).selectOption("Company");
			page.locator(BranchPageLocators.UserId).fill(new Faker().name().username());
			page.locator(BranchPageLocators.passowrd).fill("12345678");
			page.locator(BranchPageLocators.Re_confirmPassword).fill("12345678");
			page.locator("xpath=//a[text()='Branch Address']").click();
			page.locator(BranchPageLocators.Addressline1).fill("pimpri-chinchwad");
			page.locator("xpath=//a[text()='Login Details']").click();
			page.locator(BranchPageLocators.submitButton).first().click();
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

