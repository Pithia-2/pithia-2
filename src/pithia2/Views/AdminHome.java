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
  private JButton HomeButton;
  private JButton SignoutButton;
  private JButton UserManagementButton;
  private JButton GradesButton;
  private JLabel TitleLabel;
  private JLabel UsernameLabel;
  private JLabel UsernameInfo;
  private JLabel NameLabel;
  private JLabel NameInfo;
  private JLabel EmailLabel;
  private JLabel EmailInfo;
  private JLabel AdminCodeLabel;
  private JLabel AdminCodeInfo;
  private JPanel UsernameLabelPanel;
  private JPanel NameLabelPanel;
  private JPanel EmailLabelPanel;
  private JPanel CodeLabelPanel;
  private JPanel SpacerPanel;
  private JPanel UsernamePanel;
  private JPanel NamePanel;
  private JPanel EmailPanel;
  private JPanel CodePanel;

  AdminHome() {
    add(RootPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    GradesButton.addActionListener(e -> {
      AdminGrades adminGrades = new AdminGrades();
      adminGrades.setVisible(true);
      dispose();
    });

    UserManagementButton.addActionListener(e -> {
      UserManagement userManagement = new UserManagement();
      userManagement.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Administrator.getAdminInstance().logout();
    });
    AdminInfo();
  }

  private void AdminInfo() {
    Administrator admin = Administrator.getAdminInstance();
    UsernameInfo.setText(admin.getUsername());
    NameInfo.setText(admin.getFullname());
    EmailInfo.setText(admin.getEmail());
    AdminCodeInfo.setText(String.valueOf(admin.getAdminCode()));
  }
}
