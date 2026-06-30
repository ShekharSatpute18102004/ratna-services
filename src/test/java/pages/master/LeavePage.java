package pages.master;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestData;

public class LeavePage {
	
	
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
	
	@Given("user is on the Master page")
	public void Master()
	{
		SetUp();
		page.locator("xpath=//a[text()='Master']").click();
		
	}
	@When("user clicks on Leave Master")
	public void LeaveMaster()
	{
		page.getByText(" Leave  Master").first().click();
	}
	@And("user clicks on Add leave type and click on Add Leave type")
	public void LeaveMasterDetail1()
	{
		page.locator("xpath=//a[text()='Add Leave Type']").first().click();
		page.locator("xpath=//a[@class='li_master_Leave_LT_AddLeaveType']").click();
		
	}
	@Then("Leave Type page is visible")
	public void LeaveMasterDetail2()
	{
		page.locator("xpath= //p[@class='text-center text-uppercase h3 head']").isVisible();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
