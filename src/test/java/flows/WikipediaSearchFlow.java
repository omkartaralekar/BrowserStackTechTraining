package flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pageObject.WikipediaHomePage;

public class WikipediaSearchFlow {
    WikipediaHomePage wikipediaHomePage;
    public WikipediaSearchFlow(AppiumDriver driver){
        this.wikipediaHomePage=new WikipediaHomePage(driver);
    }

    public void searchText(){
        wikipediaHomePage.searchField().sendKeys("Solo man");
    }
}
