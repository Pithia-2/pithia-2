package pithia2.Models;

public class User {

  private int studentCode;
  private String username;
  private String firstname;
  private String lastname;
  private String department;
  private int semester;

  private static User userInstance = null;

  public User(int studentCode, String username, String firstname, String lastname,
      String department, int semester) {
    this.studentCode = studentCode;
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
    this.department = department;
    this.semester = semester;
  }

  public void login() {
    userInstance = this;
  }

  public static User getUserInstance() {
    return userInstance;
  }

  public static void setUserInstance(User userInstance) {
    User.userInstance = userInstance;
  }

  public int getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(int studentCode) {
    this.studentCode = studentCode;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
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
}
