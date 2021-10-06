package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import ru.stqa.new_project.addressbook.model.GroupData;

import java.io.File;

public class BaseHelper {
  protected WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  /*protected void typeOtherFields(By locator, String text) {
     if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
      }
    }
  }*/

  protected void attach(By locator, File file) {
    if (file != null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
        //typeOtherFields(locator, text);
      }
    }
  }

  protected void submit(By locator) {
    wd.findElement(locator).submit();
  }
  public boolean isAlertPresent(By name) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    submit(By.id("LoginForm"));
  }

  protected boolean isElementPresent(By locator) {
    try{
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

}
