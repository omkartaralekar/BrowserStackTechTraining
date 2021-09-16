package test;

import java.net.MalformedURLException;

import flows.SiteFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utils.BrowserManager;

public class TC_Health_Check {
	String url="";
	@Test
	public void t01_cscart_search() throws MalformedURLException {
		System.out.println("Test 11111111");
		WebDriver driver = BrowserManager.getDriver("chrome",url);
		SiteFlow siteFlow=new SiteFlow(driver);
//		siteFlow.login();
		siteFlow.searchProdut("iphone X");
		siteFlow.productDetailFlow();
	}
}
