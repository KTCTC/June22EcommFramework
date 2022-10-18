package com.uiFramework.KTCTC.helper.alert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class AlertHelper {

	private WebDriver driver;
	
	public AlertHelper(WebDriver driver){
		this.driver = driver;
		
	}
	
	
	public Alert getAlert(){
		
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		getAlert().accept();

	}
	
	public void dismissAlert(){
		getAlert().dismiss();
		
	}
	
	public String getAlertText(){
		String text = getAlert().getText();
		
		return text;
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			
			return true;
		}
		catch(NoAlertPresentException e){
			
			return false;
		}
	}
	
	public void acceptAlertIfPresent(){
		if(isAlertPresent()){
			acceptAlert();
		}
		
	}
	
	public void dismissAlertIfPresent(){
		if(isAlertPresent()){
			dismissAlert();
		}
		
	}
	
	public void acceptPrompt(String text){
		if(isAlertPresent()){
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();

		}
	}
}
