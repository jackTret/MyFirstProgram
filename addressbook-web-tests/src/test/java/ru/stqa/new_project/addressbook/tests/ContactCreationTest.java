package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreationTests() throws Exception {
    app.contactHelper.clickPageAddNew();
    app.contactHelper.fillContactForms(new ContactData("Владимир", "Иванович", "Згарданов", "Zgardan", "NightClub", "+79057312337", "Zgardanych777@gmail.com"));
    app.contactHelper.checkCreatedGroup("test1");
    //app.contactHelper.watchChoiceInContactForm();
  }
}
