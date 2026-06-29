package practice;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class CaptureText {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page=browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator(".submit-btn").click();
		String expected = "Email and Password is required";
		//capturing text by textContent()
		String msg = page.locator(".errorMessage").textContent();
		System.out.println("error msg is:"+msg);
		//with testng 
		//assertEquals(expected, msg);
		//using playwright assertion
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(expected);
		//if we want capture partially
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Password is required");
		//capturing text by innerText()
		String msg2 = page.locator(".errorMessage").innerText();
		System.out.println("error msg with inner text"+msg2);
		
		page.close();
		browser.close();
	}

}
