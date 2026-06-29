package demowebshop;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class computers {

	public static void main(String[] args) {
		
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		Page page = browser.newPage();
		page.navigate("https://demowebshop.tricentis.com");
		page.getByText("Log in").click();
		page.locator("#Email").fill("gholap@gmail.com");
		page.locator("#Password").fill("123456");
		page.locator("xpath=//input[@value='Log in']").click();
		page.locator("xpath=//a[@href='/computers']").nth(2).click();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
