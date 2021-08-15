package ru.stqa.new_project.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreationTests() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.contactHelper.returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.contactHelper.clickPageAddNew();
    ContactData contact = new ContactData("Vladimir", "Ivanovich", "Zgardanov", "Zgardan", "NightClub", "+79057312337", "Zgardanych777@gmail.com","test1");
    app.contactHelper.fillContactForms(contact, true);
    app.contactHelper.submitContactCreate();
    app.contactHelper.returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
