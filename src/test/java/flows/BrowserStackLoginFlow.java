package flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.BrowserStackSignInPage;

public class BrowserStackLoginFlow {

    WebDriver driver;
    BrowserStackSignInPage browserStackSignInPage;
    public BrowserStackLoginFlow(WebDriver driver){
        this.driver=driver;
        this.browserStackSignInPage=new BrowserStackSignInPage(driver);
    }

    public void signIn(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(browserStackSignInPage.SignInText()));
        browserStackSignInPage.SignInText().sendKeys("omkartaralekar1991@gmail.com");
        browserStackSignInPage.PasswordInputText().sendKeys("Viscait@2k21");
        browserStackSignInPage.SignInButton().click();
    }

}
