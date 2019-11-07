package pithia2.Models;

import java.io.Serializable;

public class Department implements Serializable {

  private String name;
  private String phoneNumber;
  private Lesson[] lessons = new Lesson[100];

  public Department(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public Department() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Lesson[] getLessons() {
    return lessons;
  }

  public void setLessons(Lesson[] lessons) {
    this.lessons = lessons;
  }
}
