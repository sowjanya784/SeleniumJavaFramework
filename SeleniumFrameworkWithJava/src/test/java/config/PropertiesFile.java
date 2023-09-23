package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_Demo;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {

		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {

		try {

			InputStream input = new FileInputStream(projectPath + "/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println("browser : " + browser);

			TestNG_Demo.browserName = browser;

		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public static void setProperties() {
		
		try {
			OutputStream output = new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
//			prop.setProperty("browser", "chrome");
			prop.setProperty("result","Pass");
			prop.store(output, null);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
