package pithia2.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Serializable {

  private int studentCode;
  private Department department;
  private int semester;
  private List<RegisteredLesson> passedLessons = new ArrayList<RegisteredLesson>();

  private static Student studentInstance = null;

  public Student(String username, String password, String fullname, String email, int studentCode,
      Department department, int semester) {
    super(username, password, fullname, email);
    this.studentCode = studentCode;
    this.department = department;
    this.semester = semester;
  }

  public Student() {
  }

  public void login() {
    studentInstance = this;
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

  public void setStudentCode(int studentCode) {
    this.studentCode = studentCode;
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

  public List<RegisteredLesson> getPassedLessons() {
    return passedLessons;
  }

  public void setPassedLessons(List<RegisteredLesson> passedLessons) {
    this.passedLessons = passedLessons;
  }
}
