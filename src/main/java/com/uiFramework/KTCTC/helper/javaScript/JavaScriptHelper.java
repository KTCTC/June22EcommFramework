package com.uiFramework.KTCTC.helper.javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class JavaScriptHelper {
	
	private WebDriver driver;
	
	
	public JavaScriptHelper(WebDriver driver){
		this.driver = driver;
		
	}
	
	/**
	 * This method will execute java script
	 * @param script
	 * @return
	 */
	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	/**
	 * This method will execute Java script with multiple arguments
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	/**
	 * This method will scroll till element
	 * @param element
	 */
	public void scrollToElement(WebElement element){
		
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	/**
	 * Scroll till element and click
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element){
		scrollToElement(element);
		element.click();
		
	}
	
	/**
	 * Scroll till element view
	 * @param element
	 */
	public void scrollIntoView(WebElement element){
		executeScript("arguments[0].scrollIntoView()",element);
	}
	
	/**
	 * Scroll till element view and click
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element){
		scrollIntoView(element);
		element.click();
	}
	
	/**
	 * This method will scroll down vertically
	 */
	public void scrollDownVertically(){
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll up vertically
	 */
	public void scrollUpVertically(){
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll till given pixel (e.g=1500)
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel){
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel){
		executeScript("window.scrollBY(0,-"+pixel+")");
	}
	
	/**
	 * This method will zoom screen by 100%
	 */
	public void zoomInBy100Percentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This method will zoom screen by 60%
	 */
	public void zoomInBy60Percentage(){
		executeScript("document.body.style.zoom='40%'");
	}
	
	/**
	 * This method will click on element
	 * @param element
	 */
	public void clickElement(WebElement element){
		executeScript("arguments[0].click();", element);
	}
	

}
