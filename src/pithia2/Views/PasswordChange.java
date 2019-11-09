package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.Student;

public class PasswordChange extends JFrame {

  private JPanel ChangePassPanel;
  private JButton HomeButton;
  private JLabel OldPassLabel;
  private javax.swing.JPasswordField OldPassField;
  private JLabel NewPassLabel;
  private javax.swing.JPasswordField NewPassField;
  private JLabel ConfirmNewPassLabel;
  private javax.swing.JPasswordField ConfirmNewPassField;
  private JLabel MessageLabel;
  private JPanel Navbar;
  private JButton SignoutButton;
  private JButton ConfirmButton;
  private JLabel TitleLabel;

  public PasswordChange() {
    add(ChangePassPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.addActionListener(e -> {
      StudentInfo info = new StudentInfo();
      info.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Student.getStudentInstance().logout();
      Administrator.getAdminInstance().logout();
    });
  }
}
