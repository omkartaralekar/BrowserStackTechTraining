package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserStackAfterLoginPage {

    WebDriver driver;

    public BrowserStackAfterLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement windowsButton() {
        return driver.findElement(By.xpath("//div[@data-test-ositem='win10']"));
    }

    public WebElement chromeLatestButton() {
        return driver.findElement(By.xpath("//div[@data-browser-type='chrome']/span[text()='latest']"));
    }

}
