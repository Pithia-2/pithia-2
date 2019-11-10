package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;

public class AdminHome extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton SignoutButton;
  private JButton UserManagementButton;
  private JButton GradesButton;
  private JLabel TitleLabel;
  private JLabel UsernameLabel;
  private JLabel UsernameInfo;
  private JLabel DontRemoveMeLabel;
  private JLabel NameLabel;
  private JLabel NameInfo;
  private JLabel EmailLabel;
  private JLabel EmailInfo;
  private JLabel AdminCodeLabel;
  private JLabel AdminCodeInfo;
  private JButton PassChangeButton;

  AdminHome() {
    add(RootPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    GradesButton.addActionListener(e -> {
      AdminGrades ag = new AdminGrades();
      ag.setVisible(true);
      dispose();
    });

    UserManagementButton.addActionListener(e -> {
      UserManagement um = new UserManagement();
      um.setVisible(true);
      dispose();
    });

    PassChangeButton.addActionListener(e -> {
      PasswordChange pc = new PasswordChange();
      pc.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Administrator.getAdminInstance().logout();
    });
  }
}
