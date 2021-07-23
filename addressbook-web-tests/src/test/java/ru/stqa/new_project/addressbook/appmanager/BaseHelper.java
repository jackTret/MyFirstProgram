package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import ru.stqa.new_project.addressbook.model.GroupData;

public class BaseHelper {
  protected WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void typeOtherFields(By locator, String text) {
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  protected void type(By locator, String text) {
    click(locator);
    typeOtherFields(locator, text);
  }

  protected void submit(By locator) {
    wd.findElement(locator).submit();
  }
  public boolean isAtertPresent () {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
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
}
