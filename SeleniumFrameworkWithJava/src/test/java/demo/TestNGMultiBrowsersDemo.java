package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGMultiBrowsersDemo {
	
	WebDriver driver = null;
	
	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) {
		
		System.out.println("browser name : " + browserName);
		System.out.println(Thread.currentThread().getName());
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(browserName + " Started");
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(browserName + " Started");
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println(browserName + " Started");
		}
	}
	
	@Test
	public void setupTest() {
		driver.get("https://google.com");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
