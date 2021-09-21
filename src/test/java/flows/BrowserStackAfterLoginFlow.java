package flows;

import org.openqa.selenium.WebDriver;
import pageObject.BrowserStackAfterLoginPage;

public class BrowserStackAfterLoginFlow {
    WebDriver driver;
    BrowserStackAfterLoginPage browserStackAfterLoginPage;
    public BrowserStackAfterLoginFlow(WebDriver driver){
        this.driver=driver;
        this.browserStackAfterLoginPage=new BrowserStackAfterLoginPage(driver);
    }

    public void liveInteraction(){
        browserStackAfterLoginPage.windowsButton().click();
        browserStackAfterLoginPage.chromeLatestButton().click();
    }
}
