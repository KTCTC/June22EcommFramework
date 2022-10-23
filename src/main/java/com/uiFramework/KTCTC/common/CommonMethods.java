package com.uiFramework.KTCTC.common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uiFramework.KTCTC.helper.javaScript.JavaScriptHelper;

public class CommonMethods {
	
	
	/**
	 * Method returns alpha numeric string of mentioned length
	 * @param n
	 * @return
	 */
	public String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }
	public String getNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }
	public String getcharacterString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }
	
	/**
	 * This method logins to the application
	 * @param driver
	 * @param number
	 * @param pass
	 */
	public void loginToApplication(WebDriver driver, String number, String pass)
	{
		driver.findElement(By.name("email")).sendKeys(number);
		driver.findElement(By.id("myInput")).sendKeys(pass);
		driver.findElement(By.name("login")).click();
		
	}
	
	/**
	 * This method expands inventory option
	 * 
	 * @param driver
	 */
	public void expandInventoryOption(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[contains(text(),'Inventory')]")).click();
		
	}
	
	
	public void acceptPrivateConnectionWarningIfPresent(WebDriver driver)
	{
		try {
			boolean flag = driver.findElement(By.xpath("//*[@id='main-message']//*[contains(text(),'Your connection is not private')]")).isDisplayed();
			if (flag)
			{
				driver.findElement(By.id("details-button")).click();
				driver.findElement(By.partialLinkText("uat.ktctc.co.in (unsafe)")).click();
			}
		}
		catch(Exception e)
		{
			
		}
	}
	

}
