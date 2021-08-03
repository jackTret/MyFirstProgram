package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Vladimir",
              "Ivanovich",
              "Zgardanov",
              "Zgardan",
              "NightClub",
              "+79057312337",
              "Zgardanych777@gmail.com", null));
    }
    app.contactHelper.checkToDeleteContact();
    app.contactHelper.pushDeleteContact();
    app.contactHelper.closeAlert();

  }
}
