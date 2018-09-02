package selenium.web.automation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ManualTesting {

	@Test
	public void test() throws Exception {
			
			System.out.println("test");
			System.setProperty("webdriver.gecko.driver", "D:\\eclipse-workspace\\FrameWork\\src\\Drivers\\geckodriver.exe");

			WebDriver driver = new FirefoxDriver();

			driver.get("https://www.bloomingdales.com/");
			Thread.sleep(3000);

			driver.quit();

	}

}
