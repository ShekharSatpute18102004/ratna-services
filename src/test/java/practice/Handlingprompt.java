package practice;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handlingprompt {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
		BrowserContext context=browser.newContext();
		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator("#email1").fill("admin@email.com");
		page.locator("#password1").fill("admin@123");
		page.locator(".submit-btn").click();
		page.locator("xpath=//span[text()='Manage']").hover();
		
		page.locator("xpath=//*[@id=\"root\"]/div/nav/div/div[2]/div[1]/div/a[2]").click();
		
		page.onDialog(dialog -> {
			String msg = dialog.message();
			System.out.println(msg);
			Assert.assertTrue(msg.contains("Enter a Category Name"));
			dialog.accept("java");
			
		});	
		
	Page newPage=context.waitForPage(()-> 
	{
		page.locator(".nav-menu-item active").click();
		page.locator("xpath=//button[text()='Add New Category ']").click();
	});
	
		


		

		
		

	}

}
