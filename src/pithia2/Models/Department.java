package pithia2.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {

  private String name;
  private String phoneNumber;
  private List<Lesson> lessons = new ArrayList<Lesson>();

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

  public List<Lesson> getLessons() {
    return lessons;
  }

  public void setLessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  public void deleteLesson(String id) {
    lessons.removeIf(lesson -> lesson.getId().equals(id));
  }

  public static Department search(String departmentName) {
    List<Department> departments = University.getUniversityInstance().getDepartments();

    for (Department department : departments) {
      if (department.getName().equals(departmentName)) {
        return department;
      }
    }

    return departments.get(0);
  }
}
