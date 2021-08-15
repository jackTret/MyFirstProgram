package ru.stqa.new_project.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getContactHelper().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereAContact()) {
      ContactData contact = new ContactData("Vladimir",
              "Ivanovich",
              "Zgardanov",
              "Zgardan",
              "NightClub",
              "+79057312337",
              "Zgardanych777@gmail.com", "test1");
      app.getContactHelper().createContact(contact);
    }
      app.contactHelper.clickFirstContact(before.size() - 1);
      app.contactHelper.pushDeleteContact();
      app.contactHelper.closeAlert();
      app.contactHelper.returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
}
