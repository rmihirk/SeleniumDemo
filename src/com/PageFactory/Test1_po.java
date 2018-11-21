package com.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WebdriverUtil;

public class Test1_po extends WebdriverUtil {

	@FindBy(linkText = "Draggable")
	private WebElement draggable;

	@FindBy(className = "demo-frame")
	private WebElement iframe;

	@FindBy(id = "draggable")
	private WebElement dragMeAround;

	public void clickOnDraggable() {
		waitForVisibility(draggable);
		draggable.click();
	}

	public void dragAndDropToElement() {
		driver.switchTo().frame(iframe);
		build.dragAndDropBy(dragMeAround, 50, 50).perform();
		driver.switchTo().defaultContent();
	}

	public String getAttribute() {
		driver.switchTo().frame(iframe);
		String value=dragMeAround.getAttribute("style");
		driver.switchTo().defaultContent();
		return value;
	}

}
