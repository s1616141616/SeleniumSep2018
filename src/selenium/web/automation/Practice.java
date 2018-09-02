package selenium.web.automation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice {

	@Test
	public void VerifyPageTitle() {

		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		WebDriver fxDriver = new FirefoxDriver();

		fxDriver.get("https://www.google.com");
		System.out.println(fxDriver.getTitle());
		Assert.assertEquals(fxDriver.getTitle(), "Google");

		fxDriver.quit();

	}

	@Test
	public void DoubleClick() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		WebDriver fxDriver = new FirefoxDriver();

		fxDriver.get("https://www.cnb.com");

		Actions action = new Actions(fxDriver);

		// action.doubleClick(); action.doubleClick(fxDriver.findElement(By.
		action.contextClick(fxDriver.findElement(By.xpath("//input[contains(@type, 'text')]"))).perform();
		Thread.sleep(2000);

		fxDriver.quit();
	}

	@Test
	public void RinghtClick() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		WebDriver fxDriver = new FirefoxDriver();

		fxDriver.get("https://www.cnb.com");

		Actions action = new Actions(fxDriver);

		// action.contextClick(); action.contextClick(fxDriver.findElement(By.
		action.contextClick(fxDriver.findElement(By.xpath("//input[contains(@type, 'text')]"))).perform();
		fxDriver.navigate().refresh();
		Thread.sleep(2000);

		fxDriver.quit();

	}

	@Test(priority = 0)
	public void WordCount() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any sentence.");
		String input = scan.nextLine();
		System.out.println("You entered " + input);
		scan.close();
		int count = 1;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == ' ' && input.charAt(i + 1) != ' ') {
				count++;
			}
		}

		System.out.println("Total " + count + " words!");

	}

}