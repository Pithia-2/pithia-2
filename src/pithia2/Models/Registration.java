package pithia2.Models;

import java.io.Serializable;

public class Registration implements Serializable {

  private int id;
  private RegisteredLesson[] registeredLessons = new RegisteredLesson[9];

  public Registration(int id) {
    this.id = id;
  }

  public Registration() {
  }

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public RegisteredLesson[] getRegisteredLessons() {
    return registeredLessons;
  }

  public void setRegisteredLessons(RegisteredLesson[] registeredLessons) {
    this.registeredLessons = registeredLessons;
  }
}
