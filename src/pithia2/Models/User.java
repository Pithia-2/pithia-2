package pithia2.Models;

public class User {

  private String username;
  private String password;
  private String fullname;
  private String email;

  private static User userInstance = null;

  public User(String username, String password, String fullname, String email) {
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.email = email;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
