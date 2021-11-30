package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Contacts;
import ru.stqa.new_project.addressbook.model.GroupData;
import ru.stqa.new_project.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test 1"));
    }
    if (app.db().contacts().size() == 0) {
      app.contact().ContactHomePage();
      File photo = new File("src/test/resources/kitten_child.png");
      Groups groups = app.db().groups();
      ContactData newContact = new ContactData()
              .withName("Vladimir 1")
              .withMidName("Ivanovich 1")
              .withLastname("Zgardanov 1")
              .withNick("Zgardan 1")
              .withPhoto(photo)
              .withCompanyName("NightClub")
              .withAddress("115666 Moscow, Black st., h.666")
              .withMobPhone("+79057312337")
              .withE_mail("Zgardanych777@gmail.com")
              .withE_mailNew("Zgardanych787@gmail.com")
              .withE_mailWork("Zgardanych797@gmail.com")
              .withHomePhone("+74955467743")
              .withWorkPhone("+74995467743")
              .inGroup(groups.iterator().next());
      app.contact().create(newContact, true);
      app.contact().returnToHomePage();
    }
  }

  @Test (enabled = true)
  public void testAddContactToGroupTest() {
    Groups allGroups = app.db().groups();
    Contacts allContacts = app.db().contacts();
    Contacts contactsForAdding = new Contacts();
    GroupData selectedGroup;
    for (ContactData contactData : allContacts) {
      Groups groups = contactData.getGroups();
      if (groups.size() < allGroups.size()) {
        contactsForAdding.add(contactData);
      }
    }
    if (contactsForAdding.size() == 0) {
      GroupData newGroup = new GroupData().withName("test 1");
      app.goTo().groupPage();
      app.group().create(newGroup);
      allGroups = app.db().groups();
      contactsForAdding = allContacts;
      //app.goTo().groupPage();
    }
    ContactData addedContactToGroup = contactsForAdding.iterator().next();
    selectedGroup = app.contact().checkGroupForAdding(addedContactToGroup, allGroups).iterator().next();
    app.contact().addContactToGroup(addedContactToGroup, selectedGroup);
    app.contact().returnToHomePage();
    app.contact().selectGroupInUiForAdd(selectedGroup);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), allContacts.size());
    for (ContactData contact : after) {
      if (contact.getId() == addedContactToGroup.getId()) {
        assertThat(addedContactToGroup.getGroups()
                .withAdded(selectedGroup), equalTo(contact.getGroups()));

        verifyContactListInUi();
      }
    }
  }
}