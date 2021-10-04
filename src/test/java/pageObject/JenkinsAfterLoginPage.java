package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JenkinsAfterLoginPage {
    WebDriver driver;

    public JenkinsAfterLoginPage (WebDriver driver){
        this.driver=driver;
    }

    public WebElement demoProjectText(){
        return driver.findElement(By.xpath("//a[text()='DemoProject']"));
    }

    public WebElement buildNowButton(){
        return driver.findElement(By.xpath("//span[text()='Build Now']"));
    }

}
