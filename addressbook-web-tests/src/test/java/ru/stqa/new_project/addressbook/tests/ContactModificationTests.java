package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Contacts;
import ru.stqa.new_project.addressbook.model.GroupData;
import ru.stqa.new_project.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() ==0) {
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
    }
  }

  @Test (enabled = true)
  public void testContactModification() {
    app.contact().ContactHomePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("src/test/resources/kitten_child.png");
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withName("Vladimir")
            .withMidName("Ivanovich")
            .withLastname("Zgardanov")
            .withNick("Zgardan")
            .withPhoto(photo)
            .withCompanyName("NightClub")
            .withAddress("115666 Moscow, Black st., h.676")
            .withMobPhone("+79057312337")
            .withHomePhone("+74955467843")
            .withWorkPhone("+74995467943")
            .withE_mail("Zgardanych877@gmail.com")
            .withE_mailNew("Zgardanych887@gmail.com")
            .withE_mailWork("Zgardanych897@gmail.com");
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    //assertEquals(after.size(), before.size());
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();
  }
}
