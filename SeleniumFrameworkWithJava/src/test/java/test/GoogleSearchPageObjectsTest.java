package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageObjectsTest {

	public static void main(String[] args) {

		googleSearchBoxTest();

	}

	private static void googleSearchBoxTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		GoogleSearchPageObjects searchObj = new GoogleSearchPageObjects(driver);
		
		
		searchObj.setTextInSearch("A B C D");
//		lets give it some time to load button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		searchObj.clickSearchButton();
		
		driver.quit();
		
	}

}
