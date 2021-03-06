package test;

import flows.WikipediaSearchFlow;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserManager;
import utils.DriverManager;
import utils.Uttilities;

import javax.swing.text.Utilities;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class WikipediaTest {
    private static AppiumDriver driver;

    @BeforeTest
    @Parameters("deviceName")
    public void driverCreation(String deviceName) throws Exception {
        DriverManager driverManager = new DriverManager();
        driver = driverManager.initializeDriver(deviceName);
    }

    @Test
    public void wikipediaFirstTest() {
        WikipediaSearchFlow wikipediaSearchFlow = new WikipediaSearchFlow(driver);
        wikipediaSearchFlow.searchText();

    }

    @AfterTest
    public void statusMark() throws URISyntaxException, IOException {
        Uttilities uttilities = new Uttilities();
        uttilities.statusUpdateJS(true, driver);
        driver.quit();
    }
}
