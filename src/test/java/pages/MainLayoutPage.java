package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;



import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import utils.TestData;

public class MainLayoutPage {
	
	Browser browser;
	Page page;
	
	public void setUp()
	{
		browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page=browser.newPage();
		page.navigate(TestData.LoginUrl);
		page.locator("#CompanyUserId").fill(TestData.UserID);
		page.locator("#CompanyPassword").fill(TestData.Password);
		page.locator("#btnLogin").click();
		
	}
	@Given("user is on home page")
	public void HomePage()
	{
		setUp();
		page.navigate(TestData.HomeUrl);
	}
	
	@When("user clicks on Master drop down list")
	public void MasterDropDown()
	{
		page.locator("xpath=//a[text()='Master']").click();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
