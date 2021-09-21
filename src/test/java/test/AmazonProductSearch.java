package test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import flows.AmazonPrductSearchDetailsFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BrowserManager;

public class AmazonProductSearch {
	private static WebDriver driver;
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
		driver.quit();
	}
}
