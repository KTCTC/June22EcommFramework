package regression;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiFramework.KTCTC.Pages.InventoryCategoryPage;
import com.uiFramework.KTCTC.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.KTCTC.testbase.TestBase;

public class CartPageTest extends TestBase{

	
	@BeforeClass
	public void beforeClassOfA() {
		driver = ChromeBrowser.getBrowserInstance();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		test = extent.createTest(getClass().getSimpleName());
		driver.get(proObj.getPropertyValueFromFile("baseURL"));
		cmObj.acceptPrivateConnectionWarningIfPresent(driver);		
		cmObj.loginToApplication(driver, proObj.getPropertyValueFromFile("consumerNumber"),proObj.getPropertyValueFromFile("consumerPass"));
	}
	
	
}
