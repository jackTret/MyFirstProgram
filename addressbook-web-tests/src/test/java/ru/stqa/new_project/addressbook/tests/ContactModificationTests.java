package ru.stqa.new_project.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Contacts;
import ru.stqa.new_project.addressbook.model.GroupData;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
   app.goTo().groupPage();
   if (app.group().all().size() == 0) {
    app.group().create(new GroupData().withName("test1"));
   }
   app.contact().ContactHomePage();
   if (app.contact().all().size() == 0) {
    app.contact().create(new ContactData()
            .withName("Vladimir").withMidname("Ivanovich").withLastname("Zgardanov").withNick("Zgardan").withCompanyname("NightClub").withMobphone("+79057312337").withE_mail("Zgardanych777@gmail.com").withGroup("test1"));
   }
  }

  @Test (enabled = true)
  public void testContactModification() {
    app.contact().ContactHomePage();
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
           .withId(modifiedContact.getId()).withName("Vladimir").withMidname("Ivanovich").withLastname("Zgardanov").withNick("Zgardan").withCompanyname("NightClub").withMobphone("+79057312337").withE_mail("Zgardanych777@gmail.com").withGroup("test1");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
