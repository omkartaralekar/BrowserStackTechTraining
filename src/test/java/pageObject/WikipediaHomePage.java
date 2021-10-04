package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class WikipediaHomePage {
    AppiumDriver driver;

    public WikipediaHomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public MobileElement searchField(){
        return (MobileElement) driver.findElements(By.xpath("//android.widget.TextView[@text='Search Wikipedia']"));
    }

}
