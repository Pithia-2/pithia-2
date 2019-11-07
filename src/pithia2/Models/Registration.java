package pithia2.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Registration implements Serializable {

  private int id;
  private List<RegisteredLesson> registeredLessons = new ArrayList<RegisteredLesson>();

  public Registration(int id) {
    this.id = id;
  }

  public Registration() {
  }

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public List<RegisteredLesson> getRegisteredLessons() {
    return registeredLessons;
  }

  public void setRegisteredLessons(List<RegisteredLesson> registeredLessons) {
    this.registeredLessons = registeredLessons;
  }
}
