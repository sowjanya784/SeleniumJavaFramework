package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {

	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(TestNG_Demo.class);
	public static String browserName = null;
	
	@BeforeTest
	private void setupTest() {
		
		//we need the browser name
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		logger.info("Browser Started");
	}

	@Test
	private static void googleSearch() {
		
		driver.get("https://google.com");
		logger.info("Navigated to google");
		
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
	}

	@AfterTest
	public void tearDownTest() {

		driver.quit();
		PropertiesFile.setProperties();
		logger.info("Quit the browser");
	}
}
