package flows;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.AmazonProductDetailsSearchPage;

public class AmazonPrductSearchDetailsFlow {
WebDriver driver=null;
AmazonProductDetailsSearchPage amazonProductDetails_SearchPage =null;
	public AmazonPrductSearchDetailsFlow(WebDriver driver) {
		this.driver = driver;
		this.amazonProductDetails_SearchPage =new AmazonProductDetailsSearchPage(driver);
	}
	
	public void setSearchBox(String arg) {
		amazonProductDetails_SearchPage.txtbox_search().sendKeys(arg);
	}

	public void clickSearchButton() {
		amazonProductDetails_SearchPage.btn_search().click();
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void searchProdut(String arg) {
		String actual = driver.getTitle();
		String expected = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actual, expected);
		setSearchBox(arg);
		clickSearchButton();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(amazonProductDetails_SearchPage.iosCheckBox()));
		WebElement element = driver.findElement(By.xpath("//span[text()='iOS']/..//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 wait.until(ExpectedConditions.visibilityOf(amazonProductDetails_SearchPage.iosCheckBox()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.elementToBeClickable(amazonProductDetails_SearchPage.sortButton()));
		try {Thread.sleep(6000);} catch (InterruptedException e) {e.printStackTrace();}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", amazonProductDetails_SearchPage.sortButton());
//		po_Search.sortButton().click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", po_Search.sortButton());
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		amazonProductDetails_SearchPage.priceHighToLow().click();
	}


	public void productDetailFlow() {
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		Iterator<WebElement> iterator = amazonProductDetails_SearchPage.productNameList().iterator();
		for (Iterator<WebElement> it = iterator; it.hasNext();) {
            WebElement webElement = it.next();
		System.out.println(webElement.getText());
		}
		iterator = amazonProductDetails_SearchPage.productLink().iterator();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		for (Iterator<WebElement> it = iterator; it.hasNext();) {
            WebElement webElement = it.next();
		System.out.println(webElement.getAttribute("href"));
		}
		iterator = amazonProductDetails_SearchPage.productPrice().iterator();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		for (Iterator<WebElement> it = iterator; it.hasNext();) {
            WebElement webElement = it.next();
		System.out.println(webElement.getText());
		}
	}
}
