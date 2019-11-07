package pithia2.Models;

import java.io.Serializable;

public class University implements Serializable {

  private String name;
  private String address;
  private String email;
  private String website;
  private String phoneNumber;
  private Department[] departments = new Department[30];
  private User[] users = new User[100];

  private static University userInstance = null;

  public University(String name, String address, String email, String website, String phoneNumber) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.website = website;
    this.phoneNumber = phoneNumber;
  }

  public University() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public static University getUserInstance() {
    return userInstance;
  }

  public static void setUserInstance(University userInstance) {
    University.userInstance = userInstance;
  }

  public Department[] getDepartments() {
    return departments;
  }

  public void setDepartments(Department[] departments) {
    this.departments = departments;
  }

  public User[] getUsers() {
    return users;
  }

  public void setUsers(User[] users) {
    this.users = users;
  }
}
