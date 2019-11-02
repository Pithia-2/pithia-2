package pithia2.Models;

public class Student extends User {

  private int studentCode;

  public Student(String username, String firstname, String lastname, String department,
      int semester, int studentCode) {
    super(username, firstname, lastname, department, semester);
    this.studentCode = studentCode;
  }

  public int getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(int studentCode) {
    this.studentCode = studentCode;
  }
}
