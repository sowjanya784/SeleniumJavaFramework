package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchtest {

	public static void main(String[] args) {

		googleSearch();

	}

	private static void googleSearch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		GoogleSearchPage.textBoxSearch(driver).sendKeys("Selenium");
		
		//waiting implicitly for not getting element not found error
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		GoogleSearchPage.buttonSearch(driver).sendKeys(Keys.RETURN);
		
		System.out.println("pressed return on button");
		
		driver.quit();
	}

}
