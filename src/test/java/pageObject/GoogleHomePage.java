package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {

    WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement googleSearchBox(){
        return driver.findElement(By.xpath("//input[@title='Search']"));
    }


    public WebElement googleSearchButton(){
        return driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
    }
    public WebElement browserstackSignLink(){
        return driver.findElement(By.xpath("//a[contains(@href,'https://www.browserstack.com/users/sign_in')]"));
    }
}
