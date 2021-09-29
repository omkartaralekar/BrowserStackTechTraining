package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AmazonProductDetailsSearchPage {
    WebDriver driver;

    public AmazonProductDetailsSearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement txtbox_search() {
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    public WebElement btn_search() {
        return driver.findElement(By.id("nav-search-submit-button"));
    }

    public WebElement mobilesCategory() {
        return driver.findElement(By.linkText("Mobiles"));
    }

    public WebElement iosCheckBox() {
        return driver.findElement(By.xpath("//span[text()='iOS']/..//input"));
    }

    public WebElement loginText() {
        return driver.findElement(By.xpath("//form[@autocomplete='on']//input[@type='text']"));
    }

    public WebElement sortButton() {
        return driver.findElement(By.xpath("//span[@data-action='a-dropdown-button']"));
    }


    public WebElement passwordText() {
        return driver.findElement(By.xpath("//input[@type='password']"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']/span"));
    }

    public WebElement usernameDisplay() {
        return driver.findElement(By.xpath("//div[text()='Omkar']"));
    }

    public WebElement priceHighToLow() {
        return driver.findElement(By.xpath("//a[text()='Price: High to Low']"));
    }


    public List<WebElement> productNameList() {
        return driver.findElements(By.xpath("//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16']//span[@class='a-size-medium a-color-base a-text-normal']"));
    }

    public List<WebElement> productLink() {
        return driver.findElements(By.xpath("//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16']//a[@class='a-link-normal a-text-normal']"));
    }

    public List<WebElement> productPrice() {
        return driver.findElements(By.xpath("//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16']//span[@class='a-price']/span"));
    }




    /*
     * @FindBy(how = How.NAME, using = "q") private WebElement txtbox_search;
     *
     * @FindBy(how = How.CLASS_NAME, using = "L0Z3Pu") private WebElement
     * btn_search;
     *
     * @FindBy(how = How.LINK_TEXT, using = "Mobiles") private WebElement
     * mobilesCategory;
     *
     * @FindBy(how = How.XPATH, using = "//div[@class='_3U-Vxu']") private
     * WebElement fassudeCheckbox;
     *
     * @FindBy(how = How.XPATH, using =
     * "//form[@autocomplete='on']//input[@type='text']") private WebElement
     * loginText;
     *
     * @FindBy(how = How.XPATH, using = "//input[@type='password']") private
     * WebElement passwordText;
     *
     * @FindBy(how = How.XPATH, using = "//button[@type='submit']/span") private
     * WebElement loginButton;
     *
     * @FindBy(how = How.LINK_TEXT, using = "Omkar") private WebElement
     * usernameDisplay;
     */

}
