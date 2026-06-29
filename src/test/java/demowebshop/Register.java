package demowebshop;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Register {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		Page page = browser.newPage();
		page.navigate("https://demowebshop.tricentis.com/");
		page.locator("xpath=//a[text()='Register']").click();
		page.locator("#gender-female").click();
		page.locator("#FirstName").fill("sneha");
		page.locator("#LastName").fill("gholap");
		page.locator("#Email").fill("gholap@gmail.com");
		page.locator("#Password").fill("123456");
		page.locator("#ConfirmPassword").fill("123456");
		page.locator("#register-button").click();
		page.locator("xpath=//input[@value='Continue']").click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//page.close();
		//browser.close();
		
		
		
		
		
	}

}
