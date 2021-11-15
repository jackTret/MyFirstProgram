package ru.stqa.new_project.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Contacts;
import ru.stqa.new_project.addressbook.model.GroupData;
import ru.stqa.new_project.addressbook.model.Groups;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() ==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test 1"));
    }
    if (app.db().contacts().size() == 0) {
      //Groups groups = app.db().groups();
      app.contact().ContactHomePage();
      File photo = new File("src/test/resources/kitten_child.png");
      app.contact().create(new ContactData()
              .withName("Vladimir")
              .withMidName("Ivanovich")
              .withLastname("Zgardanov")
              .withNick("Zgardan")
              .withPhoto(photo)
              .withCompanyName("NightClub")
              .withAddress("115666 Moscow, Black st., h.666")
              .withMobPhone("+79057312337")
              .withE_mail("Zgardanych777@gmail.com")
              .withE_mailNew("Zgardanych787@gmail.com")
              .withE_mailWork("Zgardanych797@gmail.com")
              .withHomePhone("+74955467743")
              .withWorkPhone("+74995467743"),true);
    }
  }

  @Test (enabled = true)
  public void testAddContactToGroupTest(){
    app.contact().ContactHomePage();
    Contacts beforeContact = app.db().contacts();
    //Groups beforeGroups = app.db().groups();
    Groups groups = app.db().groups();
    GroupData selectedGroup = groups.iterator().next();
    Contacts contacts = app.db().contacts();
    ContactData selectedContact = contacts.iterator().next();
    app.contact().addContactToGroup(selectedContact, selectedGroup);
    Contacts afterContact = app.db().contacts();
    //assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(afterContact.iterator().next().getGroups(),
            equalTo(beforeContact.iterator().next().getGroups().withAdded(selectedGroup)));
    verifyContactListInUi();
  }
}