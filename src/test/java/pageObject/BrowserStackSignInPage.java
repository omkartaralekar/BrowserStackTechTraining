package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserStackSignInPage {

    WebDriver driver;

    public BrowserStackSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement SignInText() {
        return driver.findElement(By.xpath("//input[@id='user_email_login']"));
    }

    public WebElement PasswordInputText() {
        return driver.findElement(By.id("user_password"));
    }

    public WebElement SignInButton() {
        return driver.findElement(By.id("user_submit"));
    }


}
