package ru.stqa.new_project.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id;
  private final String name;
  private final String midname;
  private final String lastname;
  private final String nick;
  private final String companyname;
  private final String mobphone;
  private final String e_mail;
  private String group;
  private String groupname;


  public ContactData(String name, String midname, String lastname, String nick, String companyname, String mobphone, String e_mail, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.midname = midname;
    this.lastname = lastname;
    this.nick = nick;
    this.companyname = companyname;
    this.mobphone = mobphone;
    this.e_mail = e_mail;
    this.group = group;
  }

  public ContactData(int id, String name, String midname, String lastname, String nick, String companyname, String mobphone, String e_mail, String group) {
    this.id = id;
    this.name = name;
    this.midname = midname;
    this.lastname = lastname;
    this.nick = nick;
    this.companyname = companyname;
    this.mobphone = mobphone;
    this.e_mail = e_mail;
    this.group = group;
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

  public int getId() {
    return id;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastname);
  }
  /*@Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
    return lastname != null ? lastname.hashCode() : 0;
  }*/
}
