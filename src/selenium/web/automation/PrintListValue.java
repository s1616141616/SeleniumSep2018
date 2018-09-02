package selenium.web.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintListValue {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		
		WebDriver fxDriver = new FirefoxDriver();
		
		fxDriver.get("https://www.wikipedia.org/");
		
		//printing default value
		String defaultValue = fxDriver.findElement(By.xpath("//*[starts-with(@id,'searchLan')]")).getText();
		System.out.println(defaultValue);
		
		
		/*Select select =new Select (fxDriver.findElement(By.xpath("//*[starts-with(@id,'searchLan')]")));
				
				//((WebElement) fxDriver.findElements(By.xpath("//*[starts-with(@id,'searchLan')]")));
		select.getOptions();
		*/
		
		Thread.sleep(3000);
		fxDriver.close();
		
	}

}

/*
WebElement dropdown = driver.findElement(By.xpath("//select[@id='ddladult1']")); 
Select select = new Select(dropdown); 
java.util.List<WebElement> options = select.getOptions(); 
for(WebElement item:options) 
{ 

     System.out.println("Dropdown values are "+ item.getText());           
   }*/

/*
// Clicking on each service provider link
serviceProviderLinks.get(i).click();
// Navigating back to the previous page that stores link to service providers
driver.navigate().back();
*/