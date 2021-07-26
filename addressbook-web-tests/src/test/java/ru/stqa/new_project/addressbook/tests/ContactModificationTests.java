package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.contactHelper.clickEditContact();
    //app.contactHelper.watchChoiceInContactForm();
    //app.contactHelper.checkContact();
    app.contactHelper.fillContactForms(new ContactData("Vladimir", "Ivanovich", "Zgardanov", "Zgardan", "NightClub", "+79057312337", "Zgardanych777@gmail.com"));
    app.contactHelper.clickUpdateContact();
    app.contactHelper.returnToHomePage();
  }
}
