package pithia2.Views;

import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.Student;
import pithia2.Models.University;
import pithia2.Models.User;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame {

  private JPanel LoginPane;
  private JPasswordField PasswordField;
  private JTextField UsernameField;
  private JLabel Login;
  private JLabel UsernameText;
  private JLabel PasswordText;
  private JButton HomeButton;
  private JLabel ErrorLabel;
  private JButton LoginButton;

  public Login() {
    add(LoginPane);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.setOpaque(false);
    HomeButton.setContentAreaFilled(false);

    ErrorLabel.setVisible(false);
    ErrorLabel.setText("Wrong credentials.");

    this.addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        UsernameField.requestFocus();
      }
    });

    HomeButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    LoginButton.addActionListener(e -> login());
  }

  private void login() {
    String username, password;
    username = UsernameField.getText();
    password = PasswordField.getText();

    for (User user : University.getUniversityInstance().getUsers()) {
      if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
        if (user instanceof Student) {
          Student.setStudentInstance((Student) user);
          StudentInfo si = new StudentInfo();
          si.setVisible(true);
          dispose();
        } else if (user instanceof Administrator) {
          Administrator.setAdminInstance((Administrator) user);
          AdminHome adminHome = new AdminHome();
          adminHome.setVisible(true);
          dispose();
        }
      } else {
        ErrorLabel.setVisible(true);
      }
    }
  }

  public String GetUsername()
  {
    return UsernameField.getText();
  }
}
