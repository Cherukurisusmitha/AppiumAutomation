
package tools;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Helper;
import android.view.KeyEvent;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class Browser {
 WebDriver driver;
 //static Permissions permissions;
  @FindBy(id="com.android.packageinstaller:id/permission_allow_button")
 WebElement permissions;
 @FindBy(id="android:id/button1")
//@FindBy(xpath="(//Button[@resource-id='android:id/button1'])")
 WebElement terms;
 @FindBy(id="com.android.browser:id/search_hint")
 WebElement browse;
 @FindBy(id="com.android.browser:id/rightBtn")
 WebElement go;
 @FindBy(id="com.android.browser:id/action_more")
 WebElement menu;
 @FindBy(id="com.android.browser:id/action_menu_bookmark")
 WebElement addBookmark;
 @FindBy(id="com.android.browser:id/action_menu_useful_page")
 WebElement addShortcut;
 @FindBy(id="com.android.browser:id/sendstartpage")
 WebElement startpage;
 @FindBy(id="com.android.browser:id/senddesktop")
 WebElement hs;//shortcut to homescreen
 @FindBy(id="android:id/button1")
 WebElement ok;
 @FindBy(id="com.android.browser:id/action_menu_history")
 WebElement bookmarks;
 //@FindBy(id="com.android.browser:id/label")
 @FindBy(id="com.android.browser:id/url")
 WebElement bmList;
 @FindBy(id="com.android.browser:id/action_tabs")
 WebElement add;//pages count to add new tab
 @FindBy(id="com.android.browser:id/nav_action_new_tab")
 WebElement newTab;
 @FindBy(id="com.android.browser:id/action_menu_toolbox")
 WebElement tools;
 @FindBy(id="com.android.browser:id/action_menu_snapshot")
 WebElement savePage;
 @FindBy(xpath="(//*[@resource-id='com.android.browser:id/title'])[1]")
 WebElement asScreenshot;
 @FindBy(xpath="(//*[@resource-id='com.android.browser:id/title'])[0]")
 WebElement asHtmlPage;
 @FindBy(xpath="(//*[@Text='Save'])")
 WebElement save;
 @FindBy(id="com.android.browser:id/action_home")
 WebElement homePage;
 @FindBy(xpath="(//*[@class='android.widget.LinearLayout'])[1]")
 WebElement history;
 @FindBy(id="com.android.browser:id/clear_history_menu_id")
 WebElement clearHistory;
 public Browser(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
 
 
  public void givePermissions() throws InterruptedException {

	  permissions.click();
	//  permissions.click();
	  Thread.sleep(1000);
	  terms.click();
  }
  public void browse(String url) throws InterruptedException{
//	  System.out.println(browse.isDisplayed());
	  Thread.sleep(2000);
	  browse.click();
	  browse.sendKeys(url);
	  go.click();
	  Thread.sleep(5000);
	  
  }
  public void addBookmark() throws InterruptedException
  {
	  menu.click();
	  if(addBookmark.isDisplayed())
		  {
		  addBookmark.click();
		  }
	  else{
		  Helper.back();
		  browse("www.python.org");
	  }
  }
  public void addShortcutToStartPage() throws InterruptedException{
	  menu.click();
	  if(addShortcut.isDisplayed()){
		  addShortcut.click();
  	  }
	  else{
		  Helper.back();
		  browse("www.python.org");
	  }
	  startpage.click();
	  ok.click();
  }
  public void addShortcutToHomeScreen() throws InterruptedException{
	  menu.click();
	  if(addShortcut.isDisplayed()){
		  addShortcut.click();
  	  }
	  else{
		  Helper.back();
		  browse("www.python.org");
	  }
	  hs.click();
	  ok.click();
	  
  }
  public void verifyBookmark(String expurl) throws InterruptedException{
	  menu.click();
	  bookmarks.click();
	  Thread.sleep(3000);
	  if(bmList.isDisplayed()){
		  String acturl= bmList.getText();
			 System.out.println(acturl);
			 Assert.assertEquals(acturl, expurl,"Pass");
	  }
	 
  }
  public void addNewTab(){
	  add.click();
	  newTab.click();
	  
  }
  public void savePageAsHTML(){
	  menu.click();
	  tools.click();
	  savePage.click();
	  asHtmlPage.click();
	  save.click();
  }
  public void savePageAsScreenshot(){
	  menu.click();
	  tools.click();
	  savePage.click();
	  asScreenshot.click();
  }
  public void homePage() throws InterruptedException{
	  if(homePage.isDisplayed()){
		  homePage.click();
	  }
	  else{
		  Helper.back();
		  Thread.sleep(1000);
		  homePage.click();
	  }
  }
  public void viewHistory() throws InterruptedException{
	
		menu.click();
		bookmarks.click();
		Thread.sleep(3000);
	//	history.click();
		Helper.swipeRtoL();
		Thread.sleep(2000);
		
	}
  public void clearHistory() throws InterruptedException{
	  viewHistory();
	  if(clearHistory.isDisplayed()){
	  clearHistory.click();
	  }
	  else{
		  System.out.println("History is Empty");
	  }
	  ok.click();
	  System.out.println("History is cleared successfully");
	  
  }
  
}
