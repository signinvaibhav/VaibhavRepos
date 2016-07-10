package com.test.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumUtils {

	WebDriver driver;
	List<WebElement> allLinks;
	Actions actions;
	Robot robot;
	JavascriptExecutor jse;
	Select dropdown;

	// Assignment:
	// https://drive.google.com/open?id=18gl9z7EEvjqCkCClKV2ITGq-eISE6I2HEov-BlOT-po

	public void setBrowser(String browser) {

		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
		case "googlechrome":
			System.setProperty("webdriver.chrome.driver", "Resources//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "ie":
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", "Resources//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("No Browser Found");
		}
	}

	public void setImplicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void navigateBrowser(String value) {

		if (value == "back") {
			driver.navigate().back();
		} else if (value == "forward") {
			driver.navigate().forward();
		} else {
			System.out.println("Enter correct navigation value");
		}
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void launchURL(String url) {
		driver.get(url);
	}

	public WebElement createWebElement(String type, String value) {
		By by = null;
		switch (type) {
		case "id":
			by = by.id(value);
			break;
		case "css":
			by = by.cssSelector(value);
			break;
		case "xpath":
			by = by.xpath(value);
			break;
		case "linktext":
			by = by.linkText(value);
			break;
		case "partiallinktext":
			by = by.partialLinkText(value);
			break;
		case "classname":
			by = by.className(value);
			break;
		case "name":
			by = by.name(value);
			break;
		default:
			System.out.println("Provide Correct Type/Value");
		}
		return driver.findElement(by);
	}

	public void clickElement(String type, String value) {
		createWebElement(type, value).click();
	}

	public void sendText(String type, String value, String textToBeEntered) {
		createWebElement(type, value).clear();
		createWebElement(type, value).sendKeys(textToBeEntered);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getLinkTextValue(String type, String value) {
		return createWebElement(type, value).getText();
	}

	public void matchCompleteText(String actual, String expected) {
		Assert.assertTrue(actual.equals(expected), "Content do not match");
	}

	public void matchPartialText(String actual, String expected) {
		Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()), "Content do not match");
	}

	public String handleAlert() {
		String alertMessage;
		Alert alert = driver.switchTo().alert();
		alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}

	public List<WebElement> getMultipleElements(String value) {
		return driver.findElements(By.tagName(value));
	}

	public void hardWait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void mouseHoverEvent(String type, String value) {
		actions = new Actions(driver);
		actions.moveToElement(createWebElement(type, value)).build().perform();
	}

	public void keyboardPress(int keycode) throws AWTException {
		robot = new Robot();
		robot.keyPress(keycode);
	}

	public void keyboardRelease(int keycode) throws AWTException {
		robot = new Robot();
		robot.keyRelease(keycode);
	}

	public String getCurrentWindow() {
		return driver.getWindowHandle();
	}

	public void goToPopupWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void switchToSpecificWindow(String getWindow) {
		driver.switchTo().window(getWindow);
	}

	public String executeJavaScript(String js) {
		jse = (JavascriptExecutor) driver;
		return (String) jse.executeScript(js);
	}

	public List<WebElement> createMultipleWebElement(String type, String value) {
		By by = null;
		switch (type) {
		case "id":
			by = by.id(value);
			break;
		case "css":
			by = by.cssSelector(value);
			break;
		case "xpath":
			by = by.xpath(value);
			break;
		case "linktext":
			by = by.linkText(value);
			break;
		case "partiallinktext":
			by = by.partialLinkText(value);
			break;
		case "classname":
			by = by.className(value);
			break;
		case "name":
			by = by.name(value);
			break;
		default:
			System.out.println("Provide Correct Type/Value");
		}
		return driver.findElements(by);
	}

	public WebElement explicitWait(String type, String value, int seconds) {
		By by = null;
		switch (type) {
		case "id":
			by = by.id(value);
			break;
		case "css":
			by = by.cssSelector(value);
			break;
		case "xpath":
			by = by.xpath(value);
			break;
		case "linktext":
			by = by.linkText(value);
			break;
		case "partiallinktext":
			by = by.partialLinkText(value);
			break;
		case "classname":
			by = by.className(value);
			break;
		case "name":
			by = by.name(value);
			break;
		default:
			System.out.println("Provide Correct Type/Value");
		}

		WebElement myDynamicElement = (new WebDriverWait(driver, seconds))
				.until(ExpectedConditions.presenceOfElementLocated(by));
		return myDynamicElement;
	}

	public void actionKeyPress(Keys theKey, String value) {
		actions = new Actions(driver);
		actions.keyDown(theKey).sendKeys(value).perform();
	}

	public void actionKeyRelease(Keys theKey) {
		actions = new Actions(driver);
		actions.keyUp(theKey).perform();
	}

	public void chooseDropDown(String type, String value, String selectType, Object selectValue) {
		dropdown = new Select(createWebElement(type, value));
		switch (selectType) {
		case "index":
			dropdown.selectByIndex((int) selectValue);
			break;
		case "value":
			dropdown.selectByValue((String) selectValue);
			break;
		case "visibletext":
			dropdown.selectByVisibleText((String) selectValue);
			break;
		default:
			System.out.println("Enter correct Value");
			break;
		}
	}

	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}
}
