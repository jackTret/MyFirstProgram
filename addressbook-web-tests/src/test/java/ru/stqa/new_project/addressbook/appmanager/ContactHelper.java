package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.new_project.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void watchChoiceInContactForm() {
    click(By.name("new_group"));
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void checkCreatedGroup(String groupname) {
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupname);
  }

  public void fillContactForms(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    typeOtherFields(By.name("middlename"), contactData.getMidname());
    typeOtherFields(By.name("lastname"), contactData.getLastname());
    typeOtherFields(By.name("nickname"), contactData.getNick());
    type(By.name("company"), contactData.getCompanyname());
    type(By.name("mobile"), contactData.getMobphone());
    type(By.name("email"), contactData.getE_mail());
    click(By.name("new_group"));
  }

  public void clickPageAddNew() {
    click(By.linkText("add new"));
  }
}
