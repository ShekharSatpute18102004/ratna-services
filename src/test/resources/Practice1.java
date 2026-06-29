import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Practice1 {

	public static void main(String[] args) {
		
		 Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 Page page=browser.newPage();
		 page.navigate("https://www.facebook.com/");
		 page.locator(".x10d0gm4 ").fill("snehagholap");
		 page.locator("#_R_1hmkqsqppb6amH1_").fill("12344");
		 page.getByText("Log in").click();

	}

}
