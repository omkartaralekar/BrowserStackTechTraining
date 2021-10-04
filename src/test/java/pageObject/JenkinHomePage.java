package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JenkinHomePage {

    WebDriver driver;

    public JenkinHomePage (WebDriver driver){
        this.driver=driver;
    }

    public WebElement loginTextfield(){
         return driver.findElement(By.id("j_username"));
    }

    public WebElement passwordTextfield(){
        return driver.findElement(By.name("j_password"));
    }

    public WebElement signInButton(){
        return driver.findElement(By.name("Submit"));
    }
}
