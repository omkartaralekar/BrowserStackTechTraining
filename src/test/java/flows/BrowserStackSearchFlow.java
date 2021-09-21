package flows;

import org.openqa.selenium.WebDriver;
import pageObject.GoogleHomePage;

public class BrowserStackSearchFlow {
    WebDriver driver;
    GoogleHomePage googleHomePage;
    public BrowserStackSearchFlow(WebDriver driver){
        this.driver=driver;
        this.googleHomePage=new GoogleHomePage(driver);
    }

    public void serachBrowserStack(){
        googleHomePage.googleSearchBox().sendKeys("Browserstack");
        googleHomePage.googleSearchButton().click();
        googleHomePage.browserstackSignLink().click();
    }

}
