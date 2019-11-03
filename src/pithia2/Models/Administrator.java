package pithia2.Models;

import java.io.Serializable;

public class Administrator extends User implements Serializable {

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
