package selenium.web.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CnbHome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\July2018\\src\\Driver\\chromedriver.exe");

		ChromeOptions winMax = new ChromeOptions();
		winMax.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(winMax);

		driver.get("http://www.cnb.com");

	}
}