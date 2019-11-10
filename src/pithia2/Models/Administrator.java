package pithia2.Models;

import java.io.Serializable;

public class Administrator extends User implements Serializable {

  private int adminCode;

  private static Administrator adminInstance = null;

  public Administrator(String username, String password, String fullname, String email,
      int adminCode) {
    super(username, password, fullname, email);
    this.adminCode = adminCode;
  }

  public Administrator() {
  }

  public void login() {
    adminInstance = this;
  }

  public void logout() {
    adminInstance = null;
  }

  public int getAdminCode() {
    return adminCode;
  }

  public void setAdminCode(int adminCode) {
    this.adminCode = adminCode;
  }

  public static Administrator getAdminInstance() {
    return adminInstance;
  }

  public static void setAdminInstance(Administrator adminInstance) {
    Administrator.adminInstance = adminInstance;
  }
}
