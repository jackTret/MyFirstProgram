package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.new_project.addressbook.model.GroupData;

public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  //public void clickFirstGroup() {
  //  click(By.name("//input[@type='checkbox']"));
  //}

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    //returnToGroupPage();
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
    //returnToHomePage();
  }

  public void returnToHomePage() {
    //click(By.xpath("//a[contains(@href, './')]"));
    click(By.linkText("home"));
    //click(By.xpath("//div[@id='content']/div/i/a[2]"));
  }

  public boolean isThereAGroup() {
    return isAlertPresent(By.name("selected[]"));
  }
}
