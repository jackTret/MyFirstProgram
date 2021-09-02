package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.new_project.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

 @BeforeMethod
  public void ensurePreconditions(){
    app.contact().ContactHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withName("Vladimir")
              .withMidName("Ivanovich")
              .withLastname("Zgardanov")
              .withNick("Zgardan")
              .withCompanyName("NightClub")
              .withAddress("115666 Moscow, Black st., h.666")
              .withMobPhone("+79057312337")
              .withE_mail("Zgardanych777@gmail.com")
              .withE_mailNew("Zgardanych787@gmail.com")
              .withE_mailWork("Zgardanych797@gmail.com")
              .withHomePhone("+74955467743")
              .withWorkPhone("+74995467743")
              .withGroup("test1"));
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
  /*public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }*/
}
