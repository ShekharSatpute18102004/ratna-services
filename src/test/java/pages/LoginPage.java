package pages;


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

public class LoginPage
{	
	Browser browser;
	Page page;
	@Given("user is on login page")
	public void setUp() 
	{
		browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		page=browser.newPage();
		page.navigate("http://192.168.1.1:8001/account/login");
	}
	
	@When("user enters userId")
	public void Login()
	{
		page.locator("#CompanyUserId").fill(TestData.UserID);
	}
	
	@And("password and clicks on login button")
	public void Login2()
	{
		page.locator("#CompanyPassword").fill(TestData.Password);
		page.locator("#btnLogin").click();
	}
	
	@Then("user should navigate to home page")
	public void DisplayhomePage()
	{
		PlaywrightAssertions.assertThat(page).hasURL("http://192.168.1.1:8001/Home/IndexPage");
		System.out.println("successfully login");
	}
	
	
	
	
	
	


}
