package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_GoogleSearch2 {

	static WebDriver driver;
	
	@BeforeTest
	private void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	private static void googleSearch() {
		
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
	}

	@AfterTest
	public void tearDownTest() {

		driver.quit();
	}
}
