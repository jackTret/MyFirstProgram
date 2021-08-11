package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
   app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Vladimir",
              "Ivanovich",
              "Zgardanov",
              "Zgardan",
              "NightClub",
              "+79057312337",
              "Zgardanych777@gmail.com", "test1"));
    }
    app.contactHelper.clickFirstContact();
    app.contactHelper.clickEditContact();
    app.contactHelper.modifyContactForms(new ContactData("Vladimyr",
            "Ivanovich",
            "Zgardanov",
            "Zgardan",
            "NightClub",
            "+79087312337",
            "Zgardanych778@gmail.com",
            null));
    app.contactHelper.checkUpdateButtonContact();
    app.contactHelper.returnToHomePage();
  }
}
