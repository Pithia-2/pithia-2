package pithia2.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Serializable {

  private int studentCode;
  private Department department;
  private int semester;
  private List<Registration> registrations = new ArrayList<Registration>();
  private List<Lesson> passedLessons = new ArrayList<Lesson>();

  private static Student studentInstance = null;

  public Student(String username, String password, String fullname, String email, int studentCode,
      Department department, int semester) {
    super(username, password, fullname, email);
    this.studentCode = studentCode;
    this.department = department;
    this.semester = semester;
    for (int i = 0; i < semester - 1; i++){
      this.registrations.add(new Registration(i));
    }
  }

  public Student() {
  }

  public void login() {
    studentInstance = this;
  }

  public void logout() {
    studentInstance = null;
  }

  public static Student getStudentInstance() {
    return studentInstance;
  }

  public static void setStudentInstance(Student studentInstance) {
    Student.studentInstance = studentInstance;
  }

  public int getStudentCode() {
    return studentCode;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public List<Registration> getRegistrations() {
    return registrations;
  }

  public Registration getLastRegistration() {
    if (registrations.size() == 0) {
      return null;
    }

    int lastRegistration = registrations.size() - 1;

    return registrations.get(lastRegistration);
  }

  public List<Lesson> getPassedLessons() {
    return passedLessons;
  }

  public void fillPassedLessons() {
    passedLessons.clear();

    for (Registration registration : registrations) {
      for (RegisteredLesson registeredLesson : registration.getRegisteredLessons()) {
        if (registeredLesson.getGrade() >= 5 && !passedLessons.contains(registeredLesson)) {
            passedLessons.add(registeredLesson);
        }
      }
    }
  }
}
