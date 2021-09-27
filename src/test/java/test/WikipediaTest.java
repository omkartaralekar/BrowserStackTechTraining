package test;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserManager;
import utils.DriverManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class WikipediaTest {
    private static AppiumDriver driver;
    @BeforeTest
    @Parameters("deviceName")
    public void driverCreation(String deviceName) throws Exception {
        DriverManager driverManager=new DriverManager();
        driver=driverManager.initializeDriver(deviceName);
    }

    @Test
    public void wikipediaFirstTest(){

    }
    @AfterTest
    public void statusMark() throws URISyntaxException, IOException {
        /*System.out.println("Inside after");
        DriverManager driverManager=new DriverManager();
        String sessionId= String.valueOf(driver.getSessionId());
        driverManager.statusMarkMethod(sessionId);*/
        driver.quit();
    }

}
