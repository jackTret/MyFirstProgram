package ru.stqa.new_project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver wd) {
    super(wd);
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

  public void selectContactById(int id) {
    //click(By.xpath("//input[@type='checkbox']"));
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    //wd.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
    //click(By.xpath("//*[@href='edit.php?id=3']"));
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    //click(By.xpath("//*[text()='Edit']"));
  }

  public void clickEditContactById(int id) {
    //wd.findElement(By.xpath("//div[@id='content']/form/input[21]"));
    //wd.findElement(By.xpath("//img[@alt='Edit']")).click();
    //WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    //WebElement row = checkbox.findElement(By.xpath("./../.."));
    //List<WebElement> cells = row.findElements(By.tagName("td"));
    //cells.get(7).findElement(By.tagName("a")).click();
    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

  }
  public void checkUpdateButtonContact() {
    //click(By.name("Update"));
    //click(By.xpath("//div[@id='content']//form/input[contains(@,Update)]"));
    click(By.xpath("//div[@id='content']/form/input"));
    //click(By.xpath("//input[@name='update']"));
    //click(By.xpath("//form multipart/form-data'[./input[@name='Update']"));
  }

  public void pushDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    //click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact) {
    clickPageAddNew();
    fillContactForms(contact, true);
    submitContactCreate();
    ContactHomePage();
  }

  public void modify(ContactData contact) {
    ContactHomePage();
    clickEditContactById(contact.getId());
    modifyContactForms(contact);
    checkUpdateButtonContact();
    ContactHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    pushDeleteContact();
    closeAlert();
    ContactHomePage();
  }

  public void ContactHomePage() {
    click(By.linkText("home"));
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
    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("company"), contactData.getCompanyname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobPhone());
    type(By.name("home"), contactData.getHome());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getE_mail());
    type(By.name("email2"), contactData.getE_mailWork());
    type(By.name("email3"), contactData.getE_mailNew());
  }

  /*public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    //List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      int id  = Integer.parseInt(element.findElement(By.cssSelector("td.center input")).getAttribute("value"));
      //ContactData contact = new ContactData().withId(id).withName(name).withMidname(midname).withLastname(lastname).withNick(nick).withCompanyname(companyname).withMobphone(mobphone).withE_mail(e_mail).withGroup(group);
      contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname));
    }
    return contacts;
  }*/
  /*public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
  //List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
    for (WebElement row : rows) {
    List<WebElement> cells = row.findElements(By.tagName("td"));
    int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
    String lastname = cells.get(1).getText();
    String name = cells.get(2).getText();
    String [] phones = cells.get(5).getText().split("\n");
    contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname)
            .withHomePhone(phones[0]).withMobPhone(phones[1]).withWorkPhone(phones[2]));
  }
    return contacts;
}*/
  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    //List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String name = cells.get(2).getText();
      //String[] phones = cells.get(5).getText().split("\n");
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contacts.add(new ContactData()
              .withId(id)
              .withName(name)
              .withLastname(lastname)
              .withAddress(address)
              .withAllE_mails(allEmails)
              .withAllPhones(allPhones));
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
            .withAddress(address)
            .withE_mail(e_mail)
            .withE_mailNew(e_mailNew)
            .withE_mailWork(e_mailWork)
            .withHomePhone(home)
            .withMobPhone(mobphone)
            .withWorkPhone(work);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }
    /*List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;*/

}