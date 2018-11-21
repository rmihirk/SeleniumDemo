package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtil {

	protected static final long SECOND = 120;
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;
	protected static Actions build;

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Make\\Documents\\Selenium\\chromedriver.exe");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	public static WebDriver getInstance() {

		if (driver == null) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, SECOND);
			js = (JavascriptExecutor) driver;
			build = new Actions(driver);
		}
		return driver;
	}

	public static void navigateTo(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void exit() {
		driver.quit();
	}

	public void waitForVisibility(WebElement element) {
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	}

	public void gotoDefault() {
		driver.switchTo().defaultContent();
	}

}
