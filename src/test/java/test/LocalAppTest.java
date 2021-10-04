package test;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DriverManager;
import utils.Uttilities;

import java.io.IOException;
import java.net.URISyntaxException;

public class LocalAppTest {
    private static AppiumDriver driver;
    Uttilities uttilities=new Uttilities();
    @BeforeTest
    @Parameters("deviceName")
    public void driverCreation(String deviceName) throws Exception {
        uttilities.bsLocalStart();
        DriverManager driverManager = new DriverManager();
        driver = driverManager.initializeDriver(deviceName);
    }

    @Test
    public void wikipediaFirstTest() {
        driver.get("http://localhost:8080/");
    }

    @AfterTest
    public void statusMark() throws URISyntaxException, IOException {
        /*System.out.println("Inside after");
        DriverManager driverManager=new DriverManager();
        String sessionId= String.valueOf(driver.getSessionId());
        driverManager.statusMarkMethod(sessionId);*/
        Uttilities uttilities = new Uttilities();
        uttilities.statusUpdateJS(true, driver);
        driver.quit();
    }
}
