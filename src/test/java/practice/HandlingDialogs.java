package practice;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class HandlingDialogs {

	public static void main(String[] args) {
		
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		Page page=browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.onDialog(dialog -> {
			String msg = dialog.message();
			System.out.println(msg);
			Assert.assertTrue(msg.contains("I am a JS Confirm"));
			dialog.accept();
		});
		page.locator("xpath=//button[text()='Click for JS Confirm']").click();
		
	
	}

}
