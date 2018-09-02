package selenium.web.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void launchCNB() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cnb.com");

		System.out.println(driver.getTitle());
		String ttl = driver.getTitle();
		softAssert.assertEquals("CityNational Bank", ttl);

		// Assert.assertNotEquals("NEWSROOM", "NEWS ROOM");

		System.out.println("Successfull");
		driver.quit();
		softAssert.assertAll();

	}
}