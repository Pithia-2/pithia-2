package pithia2.Models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

  private String username;
  private String password;
  private String fullname;
  private String email;

  private static User userInstance = null;

  User(String username, String password, String fullname, String email) {
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.email = email;
  }

  User() {
  }

  public void login() {
    userInstance = this;
  }

  public void logout() {
    userInstance = null;
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

  public static List<User> deleteUser(List<User> users, String username) {
    users.removeIf(user -> user.getUsername().equals(username));

    return users;
  }
}
