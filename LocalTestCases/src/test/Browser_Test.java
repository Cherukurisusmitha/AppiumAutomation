package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Browser;
import Utils.Helper;
import tools.SnapShot;

@Listeners(Utils.Listener.class)
public class Browser_Test {
	public static  AndroidDriver driver;
	static Browser browser;
//	@BeforeMethod
	@Test(priority=0)
  public static void launchBrowser() throws IOException, InterruptedException {
  	  driver = StartApplication.preconditions(AppIdentifiers.BrowserPackage, AppIdentifiers.BrowserActivity);
	  browser = new Browser(driver);
	  Thread.sleep(1000);
	  Helper.allowPermissions();
	  Thread.sleep(1500);
	}
	@Test(dependsOnMethods={"launchBrowser"})
	public void browsePage() throws InterruptedException{
		Thread.sleep(2000);
		  browser.browse("www.python.org");
	}
    @Test(dependsOnMethods={"browsePage"})
    public void bookmarks() throws InterruptedException{
   	 browser.addBookmark();
   	 Helper.back();
   	 browser.verifyBookmark("https://www.python.org/");	
    }
     @Test(dependsOnMethods={"browsePage"})
     public void addBrowserShortcuts() throws InterruptedException{
    	 browser.addShortcutToHomeScreen();
    	 Helper.back();
    	 browser.addShortcutToStartPage();
     }
     @Test
     public void multipleTabs() throws InterruptedException{
    	 browser.browse("www.python.org");
    	 browser.addNewTab();
		 browser.browse("www.mi.com");

     }
     @Test(dependsOnMethods={"browsePage"})
     public void saveWebPage(){
   	  browser.savePageAsScreenshot();
   	  browser.savePageAsHTML();    	 
     }
     @Test
     public void viewhistory() throws InterruptedException{
    	 browser.viewHistory();
    	 Helper.back();
     }
     @Test(dependsOnMethods={"browsePage"})
     public void clearHistory() throws InterruptedException{
    	 browser.clearHistory();
     }

//	  Helper.takeScreenShot("browser");
	// browser.verifyBookmark("https://www.python.org/");
	 /*  browser.addShortcutToHomeScreen();
	  browser.addShortcutToStartPage();
	  browser.browse("www.testng.org");
	// browser.homePage();
	// browser.viewHistory();
	// browser.homePage();
//	 browser.clearHistory();
  }
/*	@AfterMethod
	public void teardown(ITestResult result) throws IOException, InterruptedException{
		if(ITestResult.FAILURE==(result.getStatus()))
		{
			System.out.println(result.getName());
			Helper.takeScreenShot(driver, result.getTestName());
		}
			
	}
	*/
@AfterMethod
public void tearDown() throws InterruptedException{
	browser.homePage();
	Thread.sleep(1000);
}
}
