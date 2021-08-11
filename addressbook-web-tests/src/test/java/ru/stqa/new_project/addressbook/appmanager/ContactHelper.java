package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.new_project.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void watchChoiceInContactForm() {
    click(By.name("new_group"));
    //click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void checkCreatedGroup(String groupname) {
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupname);
  }

  public void fillContactForms(ContactData contactData, boolean creation) {
    modifyContactForms(contactData);

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void clickPageAddNew() {
    click(By.linkText("add new"));
  }

  public void clickFirstContact() {
    click(By.xpath("//input[@type='checkbox']"));
    //click(By.xpath("//*[@href='edit.php?id=3']"));
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    //click(By.xpath("//*[text()='Edit']"));
  }

  public void clickEditContact() {
    //click(By.xpath("//div[@id='content']/form/input[21]"));
    click(By.xpath("//img[@alt='Edit']"));
  }
  public void checkUpdateButtonContact() {
    //click(By.name("Update"));
    //click(By.xpath("//div[@id='content']//form/input[contains(@,Update)]"));
    click(By.xpath("//div[@id='content']/form/input"));
    //click(By.xpath("//input[@name='update']"));
    //click(By.xpath("//form multipart/form-data'[./input[@name='Update']"));
  }

  /*public void checkToDeleteContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }*/

  public void pushDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    //click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact) {
    //returnToHomePage();
    clickPageAddNew();
    fillContactForms(contact, true);
    submitContactCreate();
    backToHomePage();
    //returnToHomePage();
  }

  private void backToHomePage() {
    click(By.linkText("home page"));
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
    //return isElementPresent(By.xpath("//div[4]/form/input[@value='Update']"));
  }

  public void submitContactCreate() {
    click(By.xpath("//input[@type='submit']"));
    //click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void modifyContactForms(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    typeOtherFields(By.name("middlename"), contactData.getMidname());
    typeOtherFields(By.name("lastname"), contactData.getLastname());
    typeOtherFields(By.name("nickname"), contactData.getNick());
    type(By.name("company"), contactData.getCompanyname());
    type(By.name("mobile"), contactData.getMobphone());
    type(By.name("email"), contactData.getE_mail());
  }
}