package utils;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserManager {
	RemoteWebDriver  driver;


	public  RemoteWebDriver getDriver(String browser) throws MalformedURLException {
		final String USERNAME = "omkartaralekar_exYuMj";
		final String AUTOMATE_KEY = "8chzwMYzg8eHf8LWQUdF";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Inside Chrome");
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Users\\OTARALE\\eclipse-workspace\\temp\\src\\main\\resources\\chromedriver.exe"
			 * ); driver = new ChromeDriver();
			 */
			System.out.println("Driver is setup");
			
			  DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability("os", "Windows");
			  caps.setCapability("os_version", "10");
			  caps.setCapability("browser", "Chrome");
			  caps.setCapability("browser_version", "latest");
			  caps.setCapability("browserstack.local", "false");
			  caps.setCapability("browserstack.selenium_version", "3.14.0"); 
			  driver= new RemoteWebDriver(new java.net.URL(URL),caps);
			 
		} else if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Firefox");
			caps.setCapability("browser_version", "latest");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.selenium_version", "3.14.0");
			driver= new RemoteWebDriver(new java.net.URL(URL),caps);
		} else if (browser.equalsIgnoreCase("IE")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "IE");
			caps.setCapability("browser_version", "11.0");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.selenium_version", "3.5.2");
			driver= new RemoteWebDriver(new java.net.URL(URL),caps);
		}else if (browser.equalsIgnoreCase("Safari")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Big Sur");
			caps.setCapability("browser", "Safari");
			caps.setCapability("browser_version", "14.1");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.selenium_version", "3.14.0");
			driver= new RemoteWebDriver(new java.net.URL(URL),caps);
		}
		else {
			Assert.assertTrue(false);
		}
		return driver;
	}
}
