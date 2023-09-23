package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChrome {

	public static void main(String[] args) {

		headlessChrome();

	}

	private static void headlessChrome() {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");	//(--"headless") also works
//		options.addArguments("window-size=200,200");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");
		System.out.println("visited google");
		
		driver.findElement(By.name("q")).sendKeys("Headless Chrome");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		System.out.println("Entered Headless Chrome");
		
		driver.close();
		driver.quit();
		System.out.println("Completed");
	}

}
