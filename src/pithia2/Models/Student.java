package pithia2.Models;

public class Student extends User {

  private int studentCode;
  private String department;
  private int semester;
  private Lesson[] passedLessons = new Lesson[100];

  public Student(String username, String password, String fullname, String email, int studentCode,
      String department, int semester) {
    super(username, password, fullname, email);
    this.studentCode = studentCode;
    this.department = department;
    this.semester = semester;
  }

  public int getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(int studentCode) {
    this.studentCode = studentCode;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public Lesson[] getPassedLessons() {
    return passedLessons;
  }

  public void setPassedLessons(Lesson[] passedLessons) {
    this.passedLessons = passedLessons;
  }
}
