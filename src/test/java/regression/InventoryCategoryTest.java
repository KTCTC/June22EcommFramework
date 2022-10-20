package regression;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiFramework.KTCTC.Pages.InventoryCategoryPage;
import com.uiFramework.KTCTC.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.KTCTC.testbase.TestBase;

public class InventoryCategoryTest extends TestBase{
	InventoryCategoryPage inventoryCategoryPage;
	String categoryName= null;
	String newCategoryName= null;
	int initialCount = 999;
	
	@BeforeClass
	public void beforeClassOfA() {
		driver = ChromeBrowser.getBrowserInstance();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		test = extent.createTest(getClass().getSimpleName());
		driver.get(proObj.getPropertyValueFromFile("baseURL"));
		cmObj.acceptPrivateConnectionWarningIfPresent(driver);		
		cmObj.loginToApplication(driver, proObj.getPropertyValueFromFile("adminNumber"),proObj.getPropertyValueFromFile("adminPass"));
	}
	
	
	@Test (priority = 1)
	public void verifyNewCategoryCanBeAddedOnCategoryPage()
	{
		inventoryCategoryPage = new InventoryCategoryPage(driver);
		SoftAssert sAssert = new SoftAssert();
		categoryName = cmObj.getcharacterString(7);
		cmObj.expandInventoryOption(driver);
		inventoryCategoryPage.expandCategoryOptionFromInventory();
		initialCount = inventoryCategoryPage.getCountOfCategoriesPresentOnCategoryPage();
		inventoryCategoryPage.addNewCategoryOnInventoryCategoryPage(categoryName);
		boolean flag = inventoryCategoryPage.isCategoryAddedSuccessfullyBannerDisplayed();
		sAssert.assertTrue(flag, "Category added successfully banner is not displayed");		
		sAssert.assertAll();		
	}
	
	@Test(priority = 2)
	public void verifyCountGetsIncreasedAfterAddingNewCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		int finalCount = inventoryCategoryPage.getCountOfCategoriesPresentOnCategoryPage();		
		sAssert.assertEquals(finalCount, initialCount+1, "Count is not increased by one after adding new category");
		sAssert.assertAll();		
	}
	@Test (priority = 3)
	public void verifyNewlyAddedCategoryIsDisplayedOnCategoryPage()
	{
		SoftAssert sAssert = new SoftAssert();
		boolean flag = inventoryCategoryPage.isCategoryDisplaedOnCategoryPage( categoryName);
		sAssert.assertTrue(flag, "Newly added category is not displayed on category page");
		sAssert.assertAll();
	}
	
	
	@Test (priority = 4)
	public void verifyUserCanUpdateExistingCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		newCategoryName = cmObj.getcharacterString(7);
		initialCount = inventoryCategoryPage.getCountOfCategoriesPresentOnCategoryPage();
		inventoryCategoryPage.editExistingCategoryOnCategoryPage(categoryName, newCategoryName);
		boolean flag = inventoryCategoryPage.isCategoryUpdatedSuccessfullyBannerDisplayed();
		sAssert.assertTrue(flag, "Category updated successfully banner is not displayed");	
		sAssert.assertAll();
	}
	@Test(priority = 5)
	public void verifyCountWillNotChangeAfterEditingNewCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		int finalCount = inventoryCategoryPage.getCountOfCategoriesPresentOnCategoryPage();		
		sAssert.assertEquals(initialCount,finalCount,  "Count is updated while updating existing category");
		sAssert.assertAll();		
	}
	@Test (priority = 6)
	public void verifyUpdatedCategoryIsDisplayedOnCategoryPage()
	{
		SoftAssert sAssert = new SoftAssert();
		boolean flag = inventoryCategoryPage.isCategoryDisplaedOnCategoryPage(newCategoryName);
		sAssert.assertTrue(flag, "Updated category is not displayed on category page");
		boolean flag2 = inventoryCategoryPage.isCategoryDisplaedOnCategoryPage(categoryName);
		sAssert.assertFalse(flag2, "old category name is still displayed on category page");
		sAssert.assertAll();
		
	}
	
	@Test (priority = 7)
	public void verifyUserCanDeleteExistingCategoryFromCategoryPage()
	{
		SoftAssert sAssert = new SoftAssert();
		initialCount = inventoryCategoryPage.getCountOfCategoriesPresentOnCategoryPage();
		inventoryCategoryPage.deleteExistingCategoryOnCategoryPage(newCategoryName);
		boolean flag = inventoryCategoryPage.isCategoryDeletedSuccessfullyBannerDisplayed();
		sAssert.assertTrue(flag, "Category deleted successfully banner is not displayed");	
		sAssert.assertAll();
	}
	@Test (priority = 8)
	public void verifyCountOfRecordsWillGetReducedAfterDeletingCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		int finalCount = inventoryCategoryPage.getCountOfCategoriesPresentOnCategoryPage();		
		sAssert.assertEquals(initialCount-1,finalCount,"Count is not decreased by one after deleting category");
		sAssert.assertAll();
	}
	@Test (priority = 9)
	public void verifyDeletedCategoryIsNotDisplayedOnCategoryPage()
	{
		SoftAssert sAssert = new SoftAssert();		
		boolean flag2 = inventoryCategoryPage.isCategoryDisplaedOnCategoryPage(newCategoryName);
		sAssert.assertFalse(flag2, "Deleted category name is still displayed on category page");
		sAssert.assertAll();
	}

}
