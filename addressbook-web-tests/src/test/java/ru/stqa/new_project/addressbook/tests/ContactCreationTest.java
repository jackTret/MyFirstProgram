package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.GroupData;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreationTests() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.contactHelper.clickPageAddNew();
    app.contactHelper.fillContactForms(new ContactData("Владимир", "Иванович", "Згарданов", "Zgardan", "NightClub", "+79057312337", "Zgardanych777@gmail.com", "test1"), true);
    //app.contactHelper.checkCreatedGroup("test1");
    app.contactHelper.submitContactCreate();
  }
}
