package com.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageFactory.Test1_po;
import com.utils.WebdriverUtil;

public class Test1 {

	private WebDriver driver = WebdriverUtil.getInstance();
	Test1_po testPage1 = PageFactory.initElements(driver, Test1_po.class);

	@BeforeMethod
	public void beforeClass() {
		WebdriverUtil.navigateTo("https://jqueryui.com/");
	}

	@AfterMethod
	public void afterClass() {
		WebdriverUtil.exit();
	}

	@Test
	public void scenario1(){

		testPage1.clickOnDraggable();
		
		String get1=testPage1.getAttribute();
		System.err.println(testPage1.getAttribute());
		
		testPage1.dragAndDropToElement();
		
		String get2=testPage1.getAttribute();
		System.err.println(testPage1.getAttribute());
		
		if (get1.equals(get2)) {
			assertTrue(false);
		}
	}
}
