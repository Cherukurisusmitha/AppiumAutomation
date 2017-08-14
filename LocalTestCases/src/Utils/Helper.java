package Utils;

//import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import android.view.KeyEvent;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import test.StartApplication;


public class Helper  {
//	public static UiDevice uidevice ;
	public static AndroidDriver driver = StartApplication.driver;

	public Helper(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
 public static  void allowPermissions() throws InterruptedException {
/* 
	 Alert alert = driver.switchTo().alert();
	 
     System.out.println(alert.getText());

     alert.accept();*/
	WebElement allow = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
	while(allow.isDisplayed()){
		allow.click();
	}
	WebElement terms = driver.findElement(By.id("android:id/button1"));
	while(terms.isDisplayed())
	{
		terms.click();
	}
}	


 public static void takeScreenShot(String scname) throws IOException, InterruptedException  {
	  
	  TakesScreenshot screenShot = ((TakesScreenshot)driver);
	  File screenshotAs =screenShot.getScreenshotAs(OutputType.FILE);
	  Thread.sleep(5000);
	  FileUtils.copyFile(screenshotAs, new File("E:\\AppiumTools\\AutomationScreenshots\\"+scname+".png"));
 }
  public static void longpress(AndroidDriver driver, WebElement we){
	  TouchAction action = new TouchAction(driver);
	  action.longPress(we).perform();;
  }
  public static void swipeRtoL(){
	  
	  Dimension size = driver.manage().window().getSize();
	  int startX = (int)(size.width*0.70);
	  int endX = (int)(size.width*0.10);
	  int startY = (int)(size.width*0*50);
	  driver.swipe(startX, startY, endX, startY, 1000);
	  
  }
  @Test
  public static void swipeLtoR(){
	 
	  Dimension size = driver.manage().window().getSize();
	  int startX = (int) (size.width*0.10);
	  int endX = (int)(size.width*0.80);
	  int startY = (int)(size.height*0*50);
	  driver.swipe(startX, startY, endX, startY, 1000);
	  
  }
  public static void back(){
	  driver.pressKeyCode(KeyEvent.KEYCODE_BACK);
  }
  public static void menu(){
	  driver.pressKeyCode(KeyEvent.KEYCODE_MENU);
  }
  public static void home(){
	  driver.pressKeyCode(KeyEvent.KEYCODE_HOME);
  }
  public void landscapeOrientation(){
	driver.rotate(ScreenOrientation.LANDSCAPE);  
  }
  public void porttraitOrientation(){
	  driver.rotate(ScreenOrientation.PORTRAIT);
  }

/*  public void scrollTo(String element){
	   driver.scrollTo(element);
  }*/
}
