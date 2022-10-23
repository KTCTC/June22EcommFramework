package com.uiFramework.KTCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author 91992
 *
 */
public class InventoryCategoryPage {
	WebDriver driver;

	By categoryOptionInInceventoryList = By.xpath("//*[starts-with(@href,'category')]");
	By newButtonOnCategoryPage = By.xpath("//a[contains(text(),'New')]");

	By nameTextBoxOnAddNewCategoryModal = By.id("name");
	By saveButtonOnAddNewCategoryModal = By.name("add");
	By categoryAddedSuccessfullyBannerOnCategoryPage = By
			.xpath("//section//*[contains(.,'Category added successfully')]");
	By countOfCatogoriesDisplayedOnCategoryPage = By.id("example1_info");

	By searchBoxOnCategotyPage = By.xpath("//*[@id='example1_filter']//input[@type='search']");

	By editButtonOnCategoryPage = By.xpath("//button[contains(text(),'Edit')]");

	By nameTextBoxOnEditCategoryModal = By.id("edit_name");
	By updateButtonOnEditCategoryModal = By.xpath("//button[contains(text(),'Update')]");
	By categoryUpdatedSuccessFullyBannerOnCategoryPage = By
			.xpath("//section//*[contains(.,'Category updated successfully')]");
	By deleteButtonOnCategoryPage = By.xpath("//td/button[contains(text(),'Delete')]");

	By deleteButtonOnDeleteCategoryModal = By.name("delete");
	By categoryDeletedSuccessfullyBannerOnCategoryPage = By
			.xpath("//section//*[contains(.,'Category deleted successfully')]");
	// Below commented part shows we can also create elements by using @FindBy annotation on page and use them as and when required instead of using By class object
	/*
	 * @FindBy (xpath = "//*[starts-with(@href,'category')]") WebElement
	 * loginButton;
	 * 
	 * @FindBy (id = "email") WebElement emailTextBox;
	 * 
	 * @FindBy (name = "pass") WebElement passTextBox;
	 * 
	 * public InventoryCategoryPage(WebDriver driver) {
	 * PageFactory.initElements(driver, this); }
	 * 
	 * public void sample() { emailTextBox.sendKeys("KTCTC");
	 * passTextBox.sendKeys("KT12"); loginButton.click(); }
	 */
	
	public InventoryCategoryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method expands category from inventory list
	 */
	public void expandCategoryOptionFromInventory()
	{
		driver.findElement(categoryOptionInInceventoryList).click();
		
		
	}

	/**
	 * This method adds new categoty on category page
	 * @param name
	 */
	public void addNewCategoryOnInventoryCategoryPage(String name) {
		driver.findElement(newButtonOnCategoryPage).click();
		driver.findElement(nameTextBoxOnAddNewCategoryModal).sendKeys(name);
		driver.findElement(saveButtonOnAddNewCategoryModal).click();

	}

	/** 
	 * This method checks if category added successfully banner is displayed or not
	 * @return
	 */
	public boolean isCategoryAddedSuccessfullyBannerDisplayed() {
		boolean flag = false;

		try {
			flag = driver.findElement(categoryAddedSuccessfullyBannerOnCategoryPage).isDisplayed();
		} catch (Exception e) {

		}
		return flag;

	}

	/**
	 * This method returns count of records present on category page
	 * @return
	 */
	public int getCountOfCategoriesPresentOnCategoryPage() {
		String cn = driver.findElement(countOfCatogoriesDisplayedOnCategoryPage).getText();
		String[] ss = cn.split(" ");
		String cnt = ss[5];
		int cc = Integer.parseInt(cnt);
		return cc;

	}

	/**
	 * This method search provided string on category page
	 * @param searchItem
	 */
	public void serachStringInSearchBoxCategoryPage(String searchItem) {
		clearSearchBoxOnCategoryPage();
		driver.findElement(searchBoxOnCategotyPage).sendKeys(searchItem);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method clears the search box on category page
	 */
	public void clearSearchBoxOnCategoryPage() {
		String str = driver.findElement(searchBoxOnCategotyPage).getAttribute("value");
		driver.findElement(searchBoxOnCategotyPage).click();
		for (int i=0; i<str.length();i++)
		{
			driver.findElement(searchBoxOnCategotyPage).sendKeys(Keys.BACK_SPACE);			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method updates existing category name to new name
	 * @param existingCatName
	 * @param newCatName
	 */
	public void editExistingCategoryOnCategoryPage(String existingCatName, String newCatName) {
		serachStringInSearchBoxCategoryPage( existingCatName);
		driver.findElement(editButtonOnCategoryPage).click();
		driver.findElement(nameTextBoxOnEditCategoryModal).clear();
		driver.findElement(nameTextBoxOnEditCategoryModal).sendKeys(newCatName);
		driver.findElement(updateButtonOnEditCategoryModal).click();
		clearSearchBoxOnCategoryPage();

	}

	/**
	 * This method checks if category updated banner is displayed or not
	 * @return
	 */
	public boolean isCategoryUpdatedSuccessfullyBannerDisplayed() {
		boolean flag = false;

		try {
			flag = driver.findElement(categoryUpdatedSuccessFullyBannerOnCategoryPage).isDisplayed();
		} catch (Exception e) {

		}
		return flag;

	}

	/**
	 * This method deleted provided category on category page
	 * @param existingCatName
	 */
	public void deleteExistingCategoryOnCategoryPage( String existingCatName) {
		serachStringInSearchBoxCategoryPage(existingCatName);
		driver.findElement(deleteButtonOnCategoryPage).click();
		driver.findElement(deleteButtonOnDeleteCategoryModal).click();
	}
	
	/**
	 * This methed checks if category deleted banner is displayed or not
	 * @return
	 */
	public boolean isCategoryDeletedSuccessfullyBannerDisplayed() {
		boolean flag = false;

		try {
			flag = driver.findElement(categoryDeletedSuccessfullyBannerOnCategoryPage).isDisplayed();
		} catch (Exception e) {

		}
		return flag;

	}

	/**
	 * This method checks if category is present on category page
	 * @param catName
	 * @return
	 */
	public boolean isCategoryDisplaedOnCategoryPage(String catName) {

		boolean flag = false;
		serachStringInSearchBoxCategoryPage(catName);
		try {
			flag = driver.findElement(By.xpath("//td[contains(text(),'"+catName+"')]")).isDisplayed();
		} catch (Exception e) {
			
		}
		clearSearchBoxOnCategoryPage();
		return flag;

	}
}
