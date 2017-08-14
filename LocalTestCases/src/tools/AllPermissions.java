package tools;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import Utils.Helper;
import io.appium.java_client.android.AndroidDriver;
import test.StartApplication;

public class AllPermissions {
//	public static AndroidDriver driver = StartApplication.driver;
	@FindBy(xpath="(//*[@text='Installed apps'])")
	WebElement installedApps;
	@FindBy(xpath="(//*[@text='App permissions'])")
	WebElement appPermissions;
//	@FindBy(id="android:id/list")
//	WebElement permissionsList;

	public AllPermissions(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public AndroidDriver grantPermissions(AndroidDriver driver,String appName) throws MalformedURLException, InterruptedException{
	 	  driver = StartApplication.preconditions(AppIdentifiers.SettingsPackage, AppIdentifiers.SettingsActivity);
	 	  Thread.sleep(5000);
	 	  installedApps.click();
//	 	  System.out.println("*******************************");
	 	  Thread.sleep(2000);
	 	  driver.findElement(By.xpath("//*[@text='"+appName+"']")).click();
	 	  Thread.sleep(1500);
	 	  appPermissions.click();
	
	 	 List<WebElement> permissionsList = driver.findElements(By.id("android:id/list"));
	     java.util.Iterator<WebElement> program = permissionsList.iterator();
	     while (program.hasNext()) {
	         String values = program.next().getText();
	         System.out.println("Permission is "+values);
	     }
	     return driver;
}
}
