package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Contacts;
import ru.stqa.new_project.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test (enabled = true)
  public void testContactCreationTests() throws Exception {
    app.contact().ContactHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/kitten_child.png");
    ContactData contact = new ContactData()
            .withName("Vladimir")
            .withMidName("Ivanovich")
            .withLastname("Zgardanov")
            .withNick("Zgardan")
            .withPhoto(photo)
            .withCompanyName("NightClub")
            .withAddress("115666 Moscow, Black st., h.666")
            .withMobPhone("+79057312337")
            .withHomePhone("+74955467743")
            .withWorkPhone("+74995467743")
            .withE_mail("Zgardanych777@gmail.com")
            .withE_mailNew("Zgardanych787@gmail.com")
            .withE_mailWork("Zgardanych797@gmail.com")
            .withGroup("test1");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    /*assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));*/
  }

  /*@Test (enabled = true)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/kitten_child.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/
}

