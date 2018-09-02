package selenium.web.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	@Test
	public void launchCNB() {

		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cnb.com");

		System.out.println(driver.getTitle());
		String ttl = driver.getTitle();
		Assert.assertEquals("CityNational Bank", ttl);
		Assert.assertNotEquals("NEWSROOM", "NEWS ROOM");

		driver.close();
	}

	@Test
	public void assertTrue() {
		Assert.assertTrue(3 < 5);
		System.out.println(
				"This line will be executed as assertTrue will" + " pass because the 3<5(which will return true)");
	}

	@Test
	public void assertFalse() {
		Assert.assertFalse(3 > 5);
		System.out.println("This line is executed because assertFalse"
				+ "assertion passes as the given condition will return false");
	}

	@Test
	public void assertNull() {
		Assert.assertNull(null);
		System.out.println("Since we we set null in the condition, the assertion " + "assertNull will pass");
	}

	@Test
	public void assertNotNull() {
		Assert.assertNotNull("This assertion will pass because this " + "string don't returns a null value");
		System.out.println("This line is executed because assertNotNull have have passed");
	}
}