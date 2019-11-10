package pithia2.Views;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.Student;
import pithia2.Models.University;
import pithia2.Models.User;

public class PasswordChange extends JFrame {

  private JPanel ChangePassPanel;
  private JButton BackButton;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JLabel OldPassLabel;
  private javax.swing.JPasswordField OldPassField;
  private JLabel NewPassLabel;
  private javax.swing.JPasswordField NewPassField;
  private JLabel ConfirmNewPassLabel;
  private javax.swing.JPasswordField ConfirmNewPassField;
  private JLabel MessageLabel;
  private JPanel Navbar;
  private JButton ConfirmButton;
  private JLabel TitleLabel;

  PasswordChange() {
    add(ChangePassPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BackButton.addActionListener(e -> {
      StudentInfo studentInfo = new StudentInfo();
      studentInfo.setVisible(true);
      dispose();
    });

    HomeButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Student.getStudentInstance().logout();
      Administrator.getAdminInstance().logout();
    });
    ConfirmButton.addActionListener(e-> {
      changePassword();
    });
  }

  private void changePassword() {
    String oldPassword, newPassword, confirmPassword;
    oldPassword = OldPassField.getText();
    newPassword = NewPassField.getText();
    confirmPassword = ConfirmNewPassField.getText();
    List<User> users = University.getUniversityInstance().getUsers();

    if (oldPassword.equals(Student.getStudentInstance().getPassword())) {
      if (newPassword.equals(confirmPassword)) {
        for (User user : users) {
          if (user.getUsername().equals(Student.getStudentInstance().getUsername()) &&
              user.getPassword().equals(Student.getStudentInstance().getPassword())) {
            user.setPassword(newPassword);
            Student.setStudentInstance((Student) user);
            University.getUniversityInstance().setUsers(users);
            try {
              String path = GlobalConstants.UNIVERSITIES_PATH + "test.univer";
              ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
              os.writeObject(University.getUniversityInstance());
              os.close();
            } catch (IOException e) {
              System.out.println(e.getMessage());
            }
            MessageLabel.setText("Password Changed!");
            MessageLabel.setForeground(new Color(0, 100, 0));
          }
        }
      } else {
        MessageLabel.setText("Passwords don't match!");
        MessageLabel.setForeground(new Color(200, 0, 0));
      }
    } else {
      MessageLabel.setText("Wrong Password!");
      MessageLabel.setForeground(new Color(200, 0, 0));
    }
  }
}
