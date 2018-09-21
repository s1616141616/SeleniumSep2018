package selenium.web.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import com.google.inject.Key;

public class Google_Search {

	@Test
	public void CheckSearchResult() {

		String search = "Bangladesh Bank";

		System.setProperty("webdriver.gecko.driver", "D:/eclipse-workspace/SeleniumPractice/Driver/geckodriver.exe");

		WebDriver fxDriver = new FirefoxDriver();

		fxDriver.manage().deleteAllCookies();
		fxDriver.get("https://www.google.com");
		fxDriver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys(search, Keys.TAB, Keys.ENTER);
		//fxDriver.findElement(By.xpath("//input[@name='btnK']")).click();

		java.util.List<WebElement> results = fxDriver.findElements(By.cssSelector(".r"));
		java.util.List<WebElement> results1 = fxDriver.findElements(By.tagName("a"));

		System.out.println(results.size());
		System.out.println(results1.size());

		System.out.println("===========================");

		WebElement element = fxDriver.findElement(By.tagName("a"));

		if (results.contains(element) == equals(search)) {
			System.out.println("Search Result Displayed Bangladesh Bank Related Inforamtion");
		} else {
			System.out.println("Surch Result is not matching with search entered :(");
		}

		for (WebElement el : results1) {
			System.out.println(el.getAttribute("href"));
			System.out.println(el.getText());
		}
		fxDriver.quit();
	}

}