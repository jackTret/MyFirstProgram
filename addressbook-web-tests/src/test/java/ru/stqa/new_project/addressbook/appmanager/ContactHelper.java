package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.new_project.addressbook.model.ContactData;

public class ContactHelper {

  protected WebDriver wb;

  public void watchChoiceInContactForm() {
    wb.findElement(By.name("new_group")).click();
    wb.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void checkCreatedGroup(String groupname) {
    new Select(wb.findElement(By.name("new_group"))).selectByVisibleText(groupname);
  }

  public void fillContactForms(ContactData contactData) {
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys(contactData.getName());
    wb.findElement(By.name("middlename")).clear();
    wb.findElement(By.name("middlename")).sendKeys(contactData.getMidname());
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wb.findElement(By.name("nickname")).clear();
    wb.findElement(By.name("nickname")).sendKeys(contactData.getNick());
    wb.findElement(By.name("company")).click();
    wb.findElement(By.name("company")).clear();
    wb.findElement(By.name("company")).sendKeys(contactData.getCompanyname());
    wb.findElement(By.name("mobile")).click();
    wb.findElement(By.name("mobile")).clear();
    wb.findElement(By.name("mobile")).sendKeys(contactData.getMobphone());
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys(contactData.getE_mail());
    wb.findElement(By.name("new_group")).click();
  }

  public void clickPageAddNew() {
    wb.findElement(By.linkText("add new")).click();
  }
}
