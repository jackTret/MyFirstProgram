package ru.stqa.new_project.addressbook.model;

public class ContactData {
  private final String name;
  private final String midname;
  private final String lastname;
  private final String nick;
  private final String companyname;
  private final String mobphone;
  private final String e_mail;
  private String groupname;

  public ContactData(String name, String midname, String lastname, String nick, String companyname, String mobphone, String e_mail) {
    this.name = name;
    this.midname = midname;
    this.lastname = lastname;
    this.nick = nick;
    this.companyname = companyname;
    this.mobphone = mobphone;
    this.e_mail = e_mail;
  }
  public void checkCreatedGroup(String groupname){
    this.groupname = groupname;
  }


  public String getName() {
    return name;
  }

  public String getMidname() {
    return midname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getCompanyname() {
    return companyname;
  }

  public String getMobphone() {
    return mobphone;
  }

  public String getE_mail() {
    return e_mail;
  }

  public String getGroupname() {return groupname;}
}
