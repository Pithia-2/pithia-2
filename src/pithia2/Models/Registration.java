package pithia2.Models;

public class Registration {

  private int id;
  private RegisteredLesson[] registeredLessons = new RegisteredLesson[9];

  public Registration(int id) {
    this.id = id;
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
