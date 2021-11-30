package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;
import ru.stqa.new_project.addressbook.model.Groups;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

 @BeforeMethod
  public void ensurePreconditions(){
    app.contact().ContactHomePage();
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

  @Test
  public void testContactPhones() {
    app.contact().ContactHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllE_mails(), equalTo(mergeE_mails(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  private <T> String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobPhone(), contact.getWork())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private <T> String mergeE_mails(ContactData contact) {
    return Arrays.asList(contact.getE_mail(), contact.getE_mailNew(), contact.getE_mailWork())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String address){
    return address.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
