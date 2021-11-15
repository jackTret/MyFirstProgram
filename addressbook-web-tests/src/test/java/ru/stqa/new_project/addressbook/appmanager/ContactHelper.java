package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Contacts;
import ru.stqa.new_project.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForms(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMidname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNick());
    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("company"), contactData.getCompanyname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobPhone());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getE_mail());
    type(By.name("email2"), contactData.getE_mailWork());
    type(By.name("email3"), contactData.getE_mailNew());
    //modifyContactForms(contactData);

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
      new Select(wd.findElement(By.name("new_group")))
              .selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void clickPageAddNew() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int id) {
    //click(By.xpath("//input[@type='checkbox']"));
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void clickEditContactById(int id) {
    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();

  }
  public void checkUpdateButtonContact() {
    //click(By.xpath("//div[@id='content']//form/input[contains(@,Update)]"));
    click(By.xpath("//div[@id='content']/form/input"));
    //click(By.xpath("//form multipart/form-data'[./input[@name='Update']"));
  }

  public void pushDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    //click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact, boolean creation) {
    clickPageAddNew();
    fillContactForms(contact, creation);
    submitContactCreate();
    ContactHomePage();
  }

  public void modify(ContactData contact) {
    ContactHomePage();
    clickEditContactById(contact.getId());
    fillContactForms(contact, false);
    checkUpdateButtonContact();
    ContactHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    pushDeleteContact();
    closeAlert();
    ContactHomePage();
  }

  public int countContact() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void ContactHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreate() {
    click(By.xpath("//input[@type='submit']"));
    //click(By.xpath("//div[@id='content']/form/input[21]"));
  }





  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    //List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String name = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      //String[] emails = allEmails.split("\n");
      String address = cells.get(3).getText();
      contacts.add(new ContactData()
              .withId(id)
              .withName(name)
              .withLastname(lastname)
              .withMobPhone(phones[1])
              .withAllE_mails(allEmails)
              .withAllPhones(allPhones)
              .withAddress(address));
              //.withHomePhone(phones[0]).withMobPhone(phones[1]).withWorkPhone(phones[2]));

    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    clickEditContactById(contact.getId());
    String name = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobphone = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String e_mail = wd.findElement(By.name("email")).getAttribute("value");
    String e_mailNew = wd.findElement(By.name("email2")).getAttribute("value");
    String e_mailWork = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withName(name)
            .withLastname(lastname)
            .withHomePhone(home)
            .withMobPhone(mobphone)
            .withWorkPhone(work)
            .withAddress(address)
            .withE_mail(e_mail)
            .withE_mailNew(e_mailNew)
            .withE_mailWork(e_mailWork);
  }

  public void selectGroupForAdd(GroupData group) {
    new Select (wd.findElement(By.name("to_group"))).selectByValue(String.valueOf(group.getId()));
  }


  public void addContactToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    selectGroupForAdd(group);
    addToGroup();
  }

  public void removeContactFromGroup(ContactData contact, GroupData group) {
    selectGroupInUI(group.getName());
    selectContactById(contact.getId());
    removeFromGroup(group.getName());
  }

  public void addToGroup() {
    click(By.name("add"));
  }

  public void removeFromGroup(String name) {
    click(By.name("remove"));
  }

  public void selectGroupInUI(String name) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(name);
    //click(By.cssSelector("select[name=\"to_group\"] > option[value='" + id + "']"));
  }
}