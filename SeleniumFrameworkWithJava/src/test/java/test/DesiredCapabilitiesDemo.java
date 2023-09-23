package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) {
		
		/*
		 //IE only runs on windows, so not going to execute
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("ignoreProtectedModeSetting", true);
		
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(capabilities);
		*/
		
		//for chrome, chrome options in Java
		ChromeOptions options = new ChromeOptions();
		
		// Add the WebDriver proxy capability.
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("myhttpproxy:3337");
		options.setCapability("proxy", proxy);

		// Add a ChromeDriver-specific capability.
		//have to have the extension .crx in path
		options.addExtensions(new File("/path/to/extension.crx"));
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD" + Keys.ENTER);
		
		driver.quit();

	}

}
