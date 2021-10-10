package ru.stqa.new_project.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Objects;

public class ContactData {
  @XStreamOmitField
  private  int id = Integer.MAX_VALUE;
  @Expose
  private String name;
  @Expose
  private String midname;
  @Expose
  private String lastname;
  @Expose
  private String nick;
  @Expose
  private String companyname;
  @Expose
  private String address;
  @Expose
  private String mobphone;
  @Expose
  private String e_mail;
  @Expose
  private String e_mailWork;
  @Expose
  private String e_mailNew;
  @Expose
  private String home;
  @Expose
  private String work;
  @Expose
  private String allPhones;
  @Expose
  private String allE_mails;
  @Expose
  private String group;
  @Expose
  private File photo;


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

  public String getAddress() {
    return address;
  }
  public String getE_mail() {
    return e_mail;
  }

  public String getE_mailNew() {
    return e_mailNew;
  }
  public String getE_mailWork() {
    return e_mailWork;
  }
  public String getAllE_mails() {
    return allE_mails;
  }
  public String getMobPhone() {
    return mobphone;
  }
  public String getHome() {
    return home;
  }

  public String getWork() {
    return work;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public int getId() {
    return id;
  }

  public String getGroup() {
    return group;
  }

  public File getPhoto() {
    return photo;
  }

  @Test
  public void testName() {
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", mobphone='" + mobphone + '\'' +
            ", e_mail='" + e_mail + '\'' +
            ", e_mailWork='" + e_mailWork + '\'' +
            ", e_mailNew='" + e_mailNew + '\'' +
            ", home='" + home + '\'' +
            ", work='" + work + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(mobphone, that.mobphone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname, mobphone);
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withMidName(String midName) {
    this.midname = midName;
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

  public ContactData withCompanyName(String companyName) {
    this.companyname = companyName;
    return this;
  }

  public ContactData withMobPhone(String mobPhone) {
    this.mobphone = mobPhone;
    return this;
  }

  public ContactData withE_mail(String e_mail) {
    this.e_mail = e_mail;
    return this;
  }
  public ContactData withHomePhone(String home) {
    this.home = home;
    return this;
  }

  public ContactData withWorkPhone(String work) {
    this.work = work;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withE_mailWork(String e_mailWork) {
    this.e_mailWork = e_mailWork;
    return this;
  }

  public ContactData withE_mailNew(String e_mailNew) {
    this.e_mailNew = e_mailNew;
    return this;
  }

  public ContactData withAllE_mails(String allE_mails) {
    this.allE_mails = allE_mails;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

}
