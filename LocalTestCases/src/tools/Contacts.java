package tools;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Helper;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.FindBy;

public class Contacts {
	WebDriver driver;

	@FindBy(id="com.android.contacts:id/fab")
	WebElement create;
	@FindBy(xpath="(//*[@text='Mi Account'])")
	WebElement miAcc;
	@FindBy(xpath="(//*[@text='Name'])")
//	@FindBy(xpath="(//*[@resource-id='com.android.contacts:id/editors'])")
	WebElement name;
	@FindBy(xpath="(//*[@text='Phone'])")
	WebElement number;
	@FindBy(xpath="(//*[@text='Email'])")
	WebElement email;
	@FindBy(id="android:id/button2")
	WebElement ok;
	@FindBy(xpath="(//*[@text='Display preferences'])")
	WebElement displaypreferences;
	@FindBy(xpath="(//*[@text='Show SIM contacts'])")
	WebElement showSimcontacts;
	@FindBy(xpath="(//*[@text='SIM card 2'])")
	WebElement sc2;
	@FindBy(xpath="(//*[@text='Delete'])")
	WebElement seldelete;
	@FindBy(id="android:id/button1")
	WebElement delete;
	@FindBy(xpath="(//*[@text='Organise contacts'])")
	WebElement orgContacts;
	@FindBy(xpath="(//*[@text='Delete batch'])")
	WebElement delBatch;
	@FindBy(xpath="(//*[@text='Select all'])")
	WebElement selectAll;
	@FindBy(id="com.android.contacts:id/empty_text")
	WebElement nocontacts;
	@FindBy(id="android:id/input")
	WebElement cSearch;
	@FindBy(xpath="(//*[@text='Import/Export contacts'])")
	WebElement ixContacts;
	@FindBy(xpath="(//*[@text='Export to storage'])")
	WebElement exStorage;
	@FindBy(xpath="(//*[@text='Import from storage'])")
	WebElement impStorage;
	@FindBy(id="miui:id/alertTitle")
	WebElement alert;
	
	public Contacts(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
  @Test
  public void createNewConatct(String cname, String cnumber, String mailid) throws InterruptedException {
	  create.click();
	  Thread.sleep(1000);
	  miAcc.click();
	  Thread.sleep(2000);
//	  System.out.println("77777777777"+name.isDisplayed());
//	  name.sendKeys(cname);
	  number.sendKeys(cnumber);
	  Helper.back();
	  Thread.sleep(2000);
	  email.sendKeys(mailid);
	  ok.click();
  }
  public void createSimContact(String cname, String cnumber, String mailid) throws InterruptedException{
	  showSimContacts();
	  Helper.back();
	  Thread.sleep(1500);
	  Helper.back();
	  create.click();
	  Thread.sleep(1500);
	  sc2.click();
	  Thread.sleep(2000);
	  System.out.println("nameee"+name.isDisplayed());
	  name.sendKeys(cname);
	  number.sendKeys(cnumber);
	  Helper.back();
	  Thread.sleep(2000);
	  email.sendKeys(mailid);
	  ok.click();
  }
  public void showSimContacts() throws InterruptedException{
	   Helper.menu();
	  displaypreferences.click();
	  Thread.sleep(1500);
	  showSimcontacts.click();
  }
  public void verifyContacts(AndroidDriver dr,String expcval) throws InterruptedException{
	  Thread.sleep(1500);
	  String name = "//*[@text='"+expcval+"']";
	  String actval = dr.findElement(By.xpath(name)).getText();
	  System.out.println(actval+" is added successfully and verified");
	 Assert.assertEquals(actval,expcval,"Given contact is saved and verified successfully");
	 
  }
  public void delContact(AndroidDriver dr,String cname) throws InterruptedException{
	  String name = "//*[@text='"+cname+"']";
	  WebElement contact = dr.findElement(By.xpath(name));
	  Thread.sleep(1500);
	  Helper.longpress(dr, contact);
	  seldelete.click();
	  delete.click();
  }
  public void delBatch() throws InterruptedException{
	  Helper.menu();
	  orgContacts.click();
	  Thread.sleep(1000);
	  delBatch.click();
	  Thread.sleep(1000);
	  if(selectAll.isEnabled())
	  {
		  selectAll.click();
		  Thread.sleep(1000);
		  seldelete.click();
		  Thread.sleep(1000);
		  delete.click();
	  }
	  else if(nocontacts.isDisplayed()){
		  System.out.println("No Contacts present to delete");
	  }
  }
  public String contactsCount(){
	  String contactCount = cSearch.getText();
	  System.out.println(contactCount);
	  return (contactCount);
  }
  public void exportToStorage() throws InterruptedException{
	  Helper.menu();
	  ixContacts.click();
	  Thread.sleep(1000);
	  if(exStorage.isDisplayed()){
		  exStorage.click();
		  Thread.sleep(1000);
		  ok.click();
	  }
	  else{
		  System.out.println("No contacts present in device for Export");
	  }
  }
  public void impToStorage() throws InterruptedException{
	  Helper.menu();
	  ixContacts.click();
	  Thread.sleep(1000);
	  impStorage.click();
	  if(alert.isDisplayed()){
		  System.out.println("No vcf file is present. Need to export");
		  ok.click();
	  }
	  else if(ok.isDisplayed()){
		  ok.click();
		  if(ok.isDisplayed()){
			  ok.click();
		  }
		  
	  }
	  
  }
}
