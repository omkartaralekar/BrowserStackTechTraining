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

public class BrowserManager {
	public static WebDriver getDriver(String type, String url2) throws MalformedURLException {
		WebDriver driver = null;
		final String USERNAME = "omkartaralekar_exYuMj";
		final String AUTOMATE_KEY = "8chzwMYzg8eHf8LWQUdF";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		String url = "https://www.amazon.com/";
		if (type.equalsIgnoreCase("chrome")) {
			System.out.println("Inside Chrome");
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Users\\OTARALE\\eclipse-workspace\\temp\\src\\main\\resources\\chromedriver.exe"
			 * ); driver = new ChromeDriver();
			 */
			System.out.println("Driver is setup");
			
			  DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability("os", "Windows"); caps.setCapability("os_version", "10");
			  caps.setCapability("browser", "Chrome");
			  caps.setCapability("browser_version", "latest");
			  caps.setCapability("browserstack.local", "false");
			  caps.setCapability("browserstack.selenium_version", "3.14.0"); 
			  driver= new RemoteWebDriver(new java.net.URL(URL),caps);
			 
		} else if (type.equalsIgnoreCase("firefox ")) {
			driver = new FirefoxDriver();
		} else if (type.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else {
			Assert.assertTrue(false);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
