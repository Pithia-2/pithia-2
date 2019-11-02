package pithia2.Models;

public class University {

  private String name;
  private String address;
  private String email;
  private String website;
  private int phoneNumber;
  private Department[] departments = new Department[30];

  private static University userInstance = null;

  public University(String name, String address, String email, String website, int phoneNumber) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.website = website;
    this.phoneNumber = phoneNumber;
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

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
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
}
