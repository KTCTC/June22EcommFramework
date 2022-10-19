package com.uiFramework.KTCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryCategoryPage {

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

	public void addNewCategoryOnInventoryCategoryPage(WebDriver driver, String name) {
		driver.findElement(newButtonOnCategoryPage).click();
		driver.findElement(nameTextBoxOnAddNewCategoryModal).sendKeys(name);
		driver.findElement(saveButtonOnAddNewCategoryModal).click();

	}

	public boolean isCategoryAddedSuccessfullyBannerDisplayed(WebDriver driver) {
		boolean flag = false;

		try {
			flag = driver.findElement(categoryAddedSuccessfullyBannerOnCategoryPage).isDisplayed();
		} catch (Exception e) {

		}
		return flag;

	}

	public int getCountOfCategoriesPresentOnCategoryPage(WebDriver driver) {
		String cn = driver.findElement(countOfCatogoriesDisplayedOnCategoryPage).getText();
		String[] ss = cn.split(" ");
		String cnt = ss[5];
		int cc = Integer.parseInt(cnt);
		return cc;

	}

	public void serachStringInSearchBoxCategoryPage(WebDriver driver, String searchItem) {
		driver.findElement(searchBoxOnCategotyPage).clear();
		driver.findElement(searchBoxOnCategotyPage).sendKeys(searchItem);

	}

	public void clearSearchBoxOnCategoryPage(WebDriver driver) {
		driver.findElement(searchBoxOnCategotyPage).clear();
	}

	public void editExistingCategoryOnCategoryPage(WebDriver driver, String existingCatName, String newCatName) {
		serachStringInSearchBoxCategoryPage(driver, existingCatName);
		driver.findElement(editButtonOnCategoryPage).click();
		driver.findElement(nameTextBoxOnEditCategoryModal).clear();
		driver.findElement(nameTextBoxOnEditCategoryModal).sendKeys(newCatName);
		driver.findElement(updateButtonOnEditCategoryModal).click();
		clearSearchBoxOnCategoryPage(driver);

	}

	public boolean isCategoryUpdatedSuccessfullyBannerDisplayed(WebDriver driver) {
		boolean flag = false;

		try {
			flag = driver.findElement(categoryUpdatedSuccessFullyBannerOnCategoryPage).isDisplayed();
		} catch (Exception e) {

		}
		return flag;

	}

	public void deleteExistingCategoryOnCategoryPage(WebDriver driver, String existingCatName) {
		serachStringInSearchBoxCategoryPage(driver, existingCatName);
		driver.findElement(deleteButtonOnCategoryPage).click();
		driver.findElement(deleteButtonOnDeleteCategoryModal).click();
	}
	
	public boolean isCategoryDeletedSuccessfullyBannerDisplayed(WebDriver driver) {
		boolean flag = false;

		try {
			flag = driver.findElement(categoryDeletedSuccessfullyBannerOnCategoryPage).isDisplayed();
		} catch (Exception e) {

		}
		return flag;

	}

	public boolean isCategoryDisplaedOnCategoryPage(WebDriver driver, String catName) {

		boolean flag = false;
		
		try {
			flag = driver.findElement(By.xpath("//td[contains(text(),'"+catName+"')]")).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;

	}
}
