package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//		driver.manage().timeouts().implicitlyWait(4,  TimeUnit.SECONDS);
		
	}
	
	public void test() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(4));
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("button"))); //id not there, so going to throw exception
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Test
	public void fluentWaitDemo() {
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Abcd" + Keys.RETURN);
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
		
		//fluent wait on an element
		WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement ele = driver.findElement(By.xpath("//*[@id=\"arc-srp_110\"]/div/div[9]/div/div/div[1]/div/div/span/a/h3"));
		       if (ele.isEnabled()) {
					System.out.println("Element found");
					System.out.println(ele.getText());
				}
		       return ele;
		     }
		});
		
		element.click();
	}
	
	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
