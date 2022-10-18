package com.uiFramework.KTCTC.helper.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import com.uiFramework.KTCTC.helper.alert.AlertHelper;

public class PropertyFileHelper {
	private Properties propObj = null;	
	public PropertyFileHelper(String propName)
	{
		FileInputStream fis = null;
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\configfile\\"+propName);
		
		try {
			 fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 propObj = new Properties();
	 
	 try {
		propObj.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	
	/**
	 * Method takes key from user and returns value from property file
	 * @param key
	 * @return
	 */
	public String getPropertyValueFromFile(String key)
	{
		String val = propObj.getProperty(key);
		return val;
	}
	
	

}
