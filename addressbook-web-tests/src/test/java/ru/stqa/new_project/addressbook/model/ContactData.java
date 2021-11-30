package ru.stqa.new_project.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import org.testng.annotations.Test;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name ="id")
  private  int id = Integer.MAX_VALUE;

  @Expose
  @Column(name ="firstname")
  private String name;

  @Expose
  @Column(name ="middlename")
  private String midname;

  @Expose
  @Column(name ="lastname")
  private String lastname;

  @Expose
  @Column(name ="nickname")
  private String nick;

  @Expose
  @Column(name ="company")
  private String companyname;

  @Expose
  @Column(name ="address")
  @Type(type="text")
  private String address;

  @Expose
  @Column(name ="mobile")
  @Type(type="text")
  private String mobphone;

  @Expose
  @Column(name ="email")
  @Type(type="text")
  private String e_mail;

  @Expose
  @Column(name ="email2")
  @Type(type="text")
  private String e_mailWork;

  @Expose
  @Column(name ="email3")
  @Type(type="text")
  private String e_mailNew;

  @Expose
  @Column(name ="home")
  @Type(type="text")
  private String home;

  @Expose
  @Column(name ="work")
  @Type(type="text")
  private String work;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Transient
  private String allE_mails;

  //@Expose
  //@Transient
  //private String group;

  @Expose
  @Column(name ="photo")
  @Type(type="text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name ="address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();


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

  /*public String getGroup() {
    return group;
  }*/

  public File getPhoto() {
    return new File (photo);
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
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(midname, that.midname) && Objects.equals(lastname, that.lastname) && Objects.equals(nick, that.nick) && Objects.equals(companyname, that.companyname) && Objects.equals(address, that.address) && Objects.equals(mobphone, that.mobphone) && Objects.equals(e_mail, that.e_mail) && Objects.equals(e_mailWork, that.e_mailWork) && Objects.equals(e_mailNew, that.e_mailNew) && Objects.equals(home, that.home) && Objects.equals(work, that.work);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, midname, lastname, nick, companyname, address, mobphone, e_mail, e_mailWork, e_mailNew, home, work);
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

  /*public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }*/

  public Groups getGroups() {
    return new Groups(groups);
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
    this.photo = photo.getPath();
    return this;
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }

}
