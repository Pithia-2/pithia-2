package pithia2.Models;

public class Administrator extends User {

  private int adminCode;

  public Administrator(String username, String password, String fullname, String email,
      int adminCode) {
    super(username, password, fullname, email);
    this.adminCode = adminCode;
  }

  public int getAdminCode() {
    return adminCode;
  }

  public void setAdminCode(int adminCode) {
    this.adminCode = adminCode;
  }
}
