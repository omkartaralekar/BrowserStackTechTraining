package flows;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageObject.GoogleHomePage;
import pageObject.JenkinHomePage;
import pageObject.JenkinsAfterLoginPage;

public class JenkinsBuildRunFlow {
    WebDriver driver;
    JenkinHomePage jenkinHomePage;
    JenkinsAfterLoginPage jenkinsAfterLoginPage;
    SoftAssert softAssert=new SoftAssert();
    public JenkinsBuildRunFlow(WebDriver driver){
        this.driver=driver;
        this.jenkinHomePage=new JenkinHomePage(driver);
        this.jenkinsAfterLoginPage=new JenkinsAfterLoginPage(driver);
    }

    public void loginToJenkins(){
        jenkinHomePage.loginTextfield().sendKeys("otaralekar");
        jenkinHomePage.passwordTextfield().sendKeys("Viscait@2k21");
        jenkinHomePage.signInButton().click();
        softAssert.assertEquals(true,jenkinsAfterLoginPage.demoProjectText().isDisplayed());
    }
    public void runBuild(){
        jenkinsAfterLoginPage.demoProjectText().click();
        jenkinsAfterLoginPage.buildNowButton().click();
    }
}
