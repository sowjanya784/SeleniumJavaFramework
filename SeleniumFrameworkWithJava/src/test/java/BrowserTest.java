import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		
		/*
		//path until the current project
		String projectPath = System.getProperty("user.dir");
		
		//firefox
//		System.setProperty("webdriver.gecko.driver", projectPath + "path to gecko  driver in project");
//		System.setProperty("webdriver.firefox.marionette", “path to gecko driver exe”);

		//chrome
//		System.setProperty("webdriver.chrome.driver", projectPath + "path to chrome driver");
		
//		IE System.setProperty("webdriver.ie.driver",”location of iedriver”);
		System.setProperty("webdriver.ie.driver", projectPath + "location of ie driver in project");
		
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		
		
		
		//web driver manager
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.operadriver().setup();
		WebDriverManager.phantomjs().setup();
		WebDriverManager.edgedriver().setup();
		*/
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https:seleniumhq.org");
		
		driver.quit();
	}
}
