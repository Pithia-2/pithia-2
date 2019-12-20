package pithia2.Models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

  private String username;
  private String password;
  private String fullname;
  private String email;

  User(String username, String password, String fullname, String email) {
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.email = email;
  }

  User() {
  }

  public String getUsername() {
    return username;
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

  public String getEmail() {
    return email;
  }

  public static void deleteUser(List<User> users, String username) {
    users.removeIf(user -> user.getUsername().equals(username));
  }
}
