package pithia2.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class University implements Serializable {

  private String name;
  private String acronym;
  private String address;
  private String email;
  private String website;
  private String phoneNumber;
  private String details;
  private List<Department> departments = new ArrayList<Department>();
  private List<User> users = new ArrayList<User>();

  private static University universityInstance = null;

  public University(String name, String acronym, String address, String email,
      String website, String phoneNumber,
      String details) {
    this.name = name;
    this.acronym = acronym;
    this.address = address;
    this.email = email;
    this.website = website;
    this.phoneNumber = phoneNumber;
    this.details = details;
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

  public static University getUniversityInstance() {
    return universityInstance;
  }

  public static void setUniversityInstance(University universityInstance) {
    University.universityInstance = universityInstance;
  }

  public List<Department> getDepartments() {
    return departments;
  }

  public void setDepartments(List<Department> departments) {
    this.departments = departments;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getAcronym() {
    return acronym;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }
}
