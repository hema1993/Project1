package org.test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static String parentId;

	public static WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kalam-2020\\eclipse-workspace\\Employee\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void fillTextBox(WebElement e, String text) {
		e.sendKeys(text);
	}

	public static void btnClick(WebElement e) {
		e.click();
	}

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static String getAttribute(WebElement e, String value) {
		String s = e.getAttribute("value");
		return s;
	}

	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public static void draganddrop(WebElement e, WebElement element) {
		Actions a = new Actions(driver);
		a.dragAndDrop(e, element).perform();
	}

	public static void contextclick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	public static void doubleclick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	public static void scrollup(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", e);
	}

	public static void scrollDown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", e);
	}

	public static void jsclick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);
	}

	public static void switchFrame1(String id) {
		driver.switchTo().frame(id);
	}

	public static void switchFrame(String name) {
		driver.switchTo().frame(name);
	}

	public static void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	public static void switchFrame(WebElement e) {
		driver.switchTo().frame(e);
	}

	public static void comebackToFrame() {
		driver.switchTo().parentFrame();
	}

	public static void comeoutToFrame() {
		driver.switchTo().defaultContent();
	}

	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	public static void selectByvalue(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByVisibleText(value);
	}

	public static void deselectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.deselectByIndex(index);
	}

	public static void deselectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);
	}

	public static void deselectByVisibleText(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByVisibleText(value);
	}

	public static boolean isMultiple(WebElement e) {
		Select s = new Select(e);
		boolean bn = s.isMultiple();
		return bn;
	}

	public static String getFristSelectedOptions(WebElement e) {
		Select s = new Select(e);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption.getText();
	}

	public static void takeScreenShot()
	{
	TakesScreenshot tk=(TakesScreenshot)driver;
	tk.getScreenshotAs(OutputType.FILE);
	}

	public static void acceptsimplealert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void dismisssimplealert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void acceptConfirmalert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void dismissConfirmalert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void acceptpromptalert(String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		a.accept();
	}

	public static void dismisspromptalert(String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		a.dismiss();
	}

	public static String getAlertText() {
		Alert a = driver.switchTo().alert();
		String t = a.getText();
		return t;
	}

	public static String getParentWindowId() {
		String parentId = driver.getWindowHandle();
		return parentId;
	}

	public static Set<String> getallWindowId() {
		Set<String> allId = driver.getWindowHandles();
		return allId;
	}

	public static void switchToWindow() {
		Set<String> allId = driver.getWindowHandles();
		for (String eachId : allId) {
			if (!eachId.equals(allId)) {
				driver.switchTo().window(eachId);

			}

		}
	}
}