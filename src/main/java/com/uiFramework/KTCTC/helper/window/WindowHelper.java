package com.uiFramework.KTCTC.helper.window;

import java.util.Set;

import org.openqa.selenium.WebDriver;
public class WindowHelper {

	private WebDriver driver;

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will switch to parent window
	 */
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will switch to child window based on index
	 * @param index
	 */
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				driver.switchTo().window(window);
			} else {
				i++;
			}
		}
	}

	/**
	 * This method will close all tabbed window and 
	 * switched to main window
	 */
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();

		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
	}
	
	/**
	 * This method will do browser back navigation
	 */
	public void navigateBack(){
		driver.navigate().back();
	}
	
	/**
	 * This method will do browser forward navigation
	 */
	public void navigateForward(){
		driver.navigate().forward();
	}
}
