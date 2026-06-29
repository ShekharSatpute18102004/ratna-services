package demowebshop;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Books {

	public static void main(String args[])
	
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		Page page = browser.newPage();
		page.navigate("https://demowebshop.tricentis.com");
		page.getByText("Log in").click();
		page.locator("#Email").fill("gholap@gmail.com");
		page.locator("#Password").fill("123456");
		page.locator("xpath=//input[@value='Log in']").click();
		page.locator("xpath=//a[@href='/books']").first().click();
		page.locator("#products-orderby").selectOption("Price: Low to High");
		page.locator("#products-pagesize").selectOption("12");
		page.locator("#products-viewmode").selectOption("List");
		//page.getByText("25.00").nth(1).click();
		page.locator("xpath=//input[@value='Add to cart']").nth(1).click();
		page.locator("xpath=//span[text()='Shopping cart']").hover();
		page.locator("xpath=//input[@value='Go to cart']").click();
		page.locator("xpath=//input[@name='removefromcart']").check();
		page.locator("xpath=//input[@name='updatecart']").click();
		
		}

}
