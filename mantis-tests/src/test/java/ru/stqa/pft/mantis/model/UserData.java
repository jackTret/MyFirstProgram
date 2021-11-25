package ru.stqa.pft.mantis.model;


import javax.persistence.*;

@Entity
@Table(name = "mantis_user_table")
public class UserData {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "email")
  private String email;

  @Column(name = "username")
  private String userName;

  @Column(name = "password")
  private String password;

  public int getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getUserName() { return userName; }

  public String getPassword() {
    return password;
  }


  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withName(String email) {
    this.email = email;
    return this;
  }

  public UserData withPassword(String password) {
    this.password = password;
    return this;
  }

  public UserData withUserName(String userName) {
    this.userName = userName;
    return this;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", userName='" + userName + '\'' +
            '}';
  }
}