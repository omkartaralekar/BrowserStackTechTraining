package test;

import flows.JenkinsBuildRunFlow;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserManager;
import utils.Uttilities;

import java.util.concurrent.TimeUnit;

public class JenkinsRunBuildTest {
    private static RemoteWebDriver driver;
    String url = "http://localhost:8080/";
    boolean status;
    Uttilities uttilities=new Uttilities();
    @BeforeTest
    @Parameters("browser")
    public void driverCreation(String browser) throws Exception {
        uttilities.bsLocalStart();
        BrowserManager browserManager = new BrowserManager();
        driver = browserManager.getDriver(browser,true);
    }
//    @BeforeMethod(alwaysRun = true)
//    public  void localRun() throws Exception {
//
//    }

    @Test
    public void t01LocalJenkinsJobRunTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        JenkinsBuildRunFlow jenkinsBuildRunFlow=new JenkinsBuildRunFlow(driver);
        jenkinsBuildRunFlow.loginToJenkins();
        jenkinsBuildRunFlow.runBuild();
    }

    @AfterMethod(alwaysRun = true)
    public void writeResult(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                System.out.println("status="+status);
                status = true;
            } else if (result.getStatus() == ITestResult.FAILURE) {
                System.out.println("status="+status);
                status = true;
            } else if (result.getStatus() == ITestResult.SKIP) {
                System.out.println("status="+status);
                status = true;
            }
        } catch (Exception e) {
            System.out.println("\nLog Message::@AfterMethod: Exception caught");
            e.printStackTrace();
        }
    }

    @AfterTest(alwaysRun = true)
    public void statusMark() throws Exception {
        Uttilities uttilities = new Uttilities();
        uttilities.statusUpdateJS(status, driver);
        uttilities.bsLocalStop();
        driver.quit();
    }
}
