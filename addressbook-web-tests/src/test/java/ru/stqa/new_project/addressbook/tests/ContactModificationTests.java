package ru.stqa.new_project.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test (enabled = true)
  public void testContactModification() {
   app.goTo().groupPage();
    if (! app.group().isThereAGroup()) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.group().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Vladimir",
              "Ivanovich",
              "Zgardanov",
              "Zgardan",
              "NightClub",
              "+79057312337",
              "Zgardanych777@gmail.com", "test1"));
    }
    app.group().returnToHomePage();
    app.contactHelper.clickEditContact(before.size() - 1);
    ContactData contact = new ContactData("Vladimir",
            "Ivanovich",
            "Zgardanov",
            "Zgardan",
            "NightClub",
            "+79057312337",
            "Zgardanych777@gmail.com", null);
    app.contactHelper.modifyContactForms(contact);
    app.contactHelper.checkUpdateButtonContact();
    app.contactHelper.returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
