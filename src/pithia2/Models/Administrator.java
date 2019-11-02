package pithia2.Models;

public class Administrator extends User {

  private int adminCode;

  public Administrator(String username, String firstname, String lastname, String department,
      int semester, int adminCode) {
    super(username, firstname, lastname, department, semester);
    this.adminCode = adminCode;
  }

  public int getAdminCode() {
    return adminCode;
  }

  public void setAdminCode(int adminCode) {
    this.adminCode = adminCode;
  }
}
