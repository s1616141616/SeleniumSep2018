package selenium.web.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLoader {

	public static void loadChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("");
	}
}