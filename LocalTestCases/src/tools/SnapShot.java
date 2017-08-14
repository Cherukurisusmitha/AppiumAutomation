package tools;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SnapShot {
	
	public SnapShot(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
  @Test
  public static void takeScreenShot(AndroidDriver driver,String scname) throws IOException, InterruptedException  {
  
	  TakesScreenshot screenShot = ((TakesScreenshot)driver);
	  File screenshotAs =screenShot.getScreenshotAs(OutputType.FILE);
	  System.out.println(screenshotAs);
	  Thread.sleep(5000);
	  FileUtils.copyFile(screenshotAs, new File("E:\\AppiumTools\\"+scname+".png"));
  }
}
