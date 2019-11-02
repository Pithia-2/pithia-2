package pithia2.Models;

public class Department {

  private String name;
  private int phoneNumber;
  private Lesson[] lessons = new Lesson[100];

  public Department(String name, int phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Lesson[] getLessons() {
    return lessons;
  }

  public void setLessons(Lesson[] lessons) {
    this.lessons = lessons;
  }
}
