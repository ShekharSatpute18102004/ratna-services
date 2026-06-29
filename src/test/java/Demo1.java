import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.CDPSession;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo1 {

	public static void main(String[] args) {
		 
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.facebook.com/");
		System.out.println(page.title());
		page.locator("[name='email']").fill("sneha");

		page.locator("[name='pass']").fill("2005");
		
		page.locator("[aria-label='Log in']").click();
		/*to check browser is connected or not
		boolean connected = browser.isConnected();
		System.out.println(connected);*/
		
		CDPSession cdp = browser.newBrowserCDPSession();
		System.out.println(cdp);
		
		browser.close();
		
		
		
		

	}

}
