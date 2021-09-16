package flows;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import pageObject.PO_Search;

public class SiteFlow {
WebDriver driver=null;
PO_Search po_Search=null;
	public SiteFlow(WebDriver driver) {
		this.driver = driver;
		this.po_Search=new PO_Search(driver);
	}
	
	public void setSearchBox(String arg) {
		po_Search.txtbox_search().sendKeys(arg);
	}

	public void clickSearchButton() {
		po_Search.btn_search().click();
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void searchProdut(String arg) {
		String actual = driver.getTitle();
		String expected = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actual, expected);
		setSearchBox(arg);
		clickSearchButton();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(po_Search.iosCheckBox()));
		WebElement element = driver.findElement(By.xpath("//span[text()='iOS']/..//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 wait.until(ExpectedConditions.visibilityOf(po_Search.iosCheckBox()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		po_Search.iosCheckBox().click();
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		po_Search.sortButton().click();
		po_Search.priceHowToLow().click();
	}

	public void login() {
		po_Search.loginText().sendKeys("8108866906");
		po_Search.passwordText().sendKeys("Viscait@2k20");
		po_Search.loginButton().click();
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOf(po_Search.usernameDisplay()));
		 * Assert.assertEquals(true,po_Search.usernameDisplay());
		 */
	}
	public void productDetailFlow() {
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		Iterator<WebElement> iterator = po_Search.productNameList().iterator();
		for (Iterator<WebElement> it = iterator; it.hasNext();) {
            WebElement webElement = it.next();
		System.out.println(webElement.getText());
		}
		iterator = po_Search.productLink().iterator();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		for (Iterator<WebElement> it = iterator; it.hasNext();) {
            WebElement webElement = it.next();
		System.out.println(webElement.getAttribute("href"));
		}
		iterator = po_Search.productPrice().iterator();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		for (Iterator<WebElement> it = iterator; it.hasNext();) {
            WebElement webElement = it.next();
		System.out.println(webElement.getText());
		}
	}
}
