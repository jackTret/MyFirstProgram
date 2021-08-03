package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Vladimir",
              "Ivanovich",
              "Zgardanov",
              "Zgardan",
              "NightClub",
              "+79057312337",
              "Zgardanych777@gmail.com", null));
    }
    //app.contactHelper.watchChoiceInContactForm();
    app.contactHelper.clickEditContact();
    app.contactHelper.fillContactForms(new ContactData("Vladimyr",
            "Ivanovich",
            "Zgardanov",
            "Zgardan",
            "NightClub",
            "+79087312337",
            "Zgardanych778@gmail.com",
            null), false);
    app.contactHelper.clickUpdateContact();
    app.contactHelper.returnToHomePage();
  }
}
