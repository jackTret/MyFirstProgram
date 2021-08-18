package ru.stqa.new_project.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id = Integer.MAX_VALUE;
  private String name;
  private String midname;
  private String lastname;
  private String nick;
  private String companyname;
  private String mobphone;
  private String e_mail;
  private String group;
  private String groupname;

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

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withMidname(String midname) {
    this.midname = midname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public ContactData withCompanyname(String companyname) {
    this.companyname = companyname;
    return this;
  }

  public ContactData withMobphone(String mobphone) {
    this.mobphone = mobphone;
    return this;
  }

  public ContactData withE_mail(String e_mail) {
    this.e_mail = e_mail;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }
}
