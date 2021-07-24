package ru.stqa.new_project.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.contactHelper.checkToDeleteContact();
    app.contactHelper.pushDeleteContact();

  }
}
