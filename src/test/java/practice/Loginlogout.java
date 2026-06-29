package practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Loginlogout {

	public static void main(String[] args) {
		Browser browser = null;
		Page page = null;
		try {
		 browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		 page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator("#email1").fill("snehagholap2005@gmail.com");
		page.locator("#password1").fill("sneha2005");
		page.getByText("Sign in").last().click();
		PlaywrightAssertions.assertThat(page.locator("//h4[@class='welcomeMessage']")).containsText("Welcome");
		page.getByAltText("menu").click();
		page.getByText("Sign out").click();
		PlaywrightAssertions.assertThat(page).hasURL("https://freelance-learn-automation.vercel.app/login");
		}
		finally {
			page.close();
			browser.close();
		
		}

	}

}
