package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import flows.AmazonPrductSearchDetailsFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BrowserManager;
import utils.DriverManager;

public class AmazonProductSearch {
	private static RemoteWebDriver driver;
	String url = "https://www.amazon.com/";
	@BeforeTest
	@Parameters("browser")
	public void driverCreation(String browser) throws MalformedURLException {
		BrowserManager browserManager=new BrowserManager();
		driver=browserManager.getDriver(browser);
	}

	@Test
	public void t01search() throws MalformedURLException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		AmazonPrductSearchDetailsFlow amazonPrductSearchDetailsFlow =new AmazonPrductSearchDetailsFlow(driver);
		amazonPrductSearchDetailsFlow.searchProdut("iphone X");
		amazonPrductSearchDetailsFlow.productDetailFlow();
	}
	@AfterTest
	public void statusMark() throws URISyntaxException, IOException {
		System.out.println("Inside after");
		System.out.println("Inside Status");
		String sessionId= String.valueOf(driver.getSessionId());
		System.out.println(sessionId);
		DriverManager driverManager=new DriverManager();
		driverManager.statusMarkMethod(sessionId);
		driver.quit();

	}
}
