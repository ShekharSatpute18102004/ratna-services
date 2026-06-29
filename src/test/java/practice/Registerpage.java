package practice;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Registerpage {

	public static void main(String[] args) {
		
	Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	page.getByText("New user? Signup").click();

	PlaywrightAssertions.assertThat(page.getByText("Sign up").last()).isDisabled();
	page.locator("#name").fill(new Faker().name().fullName());
	page.locator("#email").fill(new Faker().name().firstName()+"_"+new Faker().name().lastName()+"_"+"@gmail.com");
	page.locator("#password").fill("snehagholap");
	page.locator("xpath=//label[text()='Selenium']//preceding::input[1]").click();
	PlaywrightAssertions.assertThat(page.locator("xpath=//label[text()='Selenium']//preceding::input[1]")).isChecked();
	page.locator("xpath=//input[@value='Female']").click();
	page.locator("#state").selectOption("Goa");
	String hobbies[]= {"Playing","Swimming"};
	page.locator("#hobbies").selectOption(hobbies);
	page.locator(".submit-btn").click();
	PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();
	
	
	page.close();
	browser.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
