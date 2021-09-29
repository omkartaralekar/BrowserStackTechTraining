package test;

import flows.AmazonPrductSearchDetailsFlow;
import flows.BrowserStackAfterLoginFlow;
import flows.BrowserStackLoginFlow;
import flows.BrowserStackSearchFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserManager;
import utils.Uttilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BrowserStackInceptionTest {
    private static RemoteWebDriver driver;
    String url = "https://www.google.com/";

    @BeforeTest
    @Parameters("browser")
    public void driverCreation(String browser) throws MalformedURLException {
        BrowserManager browserManager = new BrowserManager();
        driver = browserManager.getDriver(browser);
    }

    @Test
    public void t01search() throws MalformedURLException {
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        BrowserStackSearchFlow browserStackSearchFlow = new BrowserStackSearchFlow(driver);
        browserStackSearchFlow.serachBrowserStack();
        BrowserStackLoginFlow browserStackLoginFlow = new BrowserStackLoginFlow(driver);
        browserStackLoginFlow.signIn();
        BrowserStackAfterLoginFlow browserStackAfterLoginFlow = new BrowserStackAfterLoginFlow(driver);
        browserStackAfterLoginFlow.liveInteraction();
        Uttilities uttilities=new Uttilities();
        uttilities.statusUpdateJS(true,driver);
        driver.quit();
    }
}
