package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;

public class StudentInfo extends JFrame {

  private JPanel InfoPanel;
  private JButton HomeButton;
  private JLabel UsernameLabel;
  private JLabel UsernameInfo;
  private JLabel NameLabel;
  private JLabel NameInfo;
  private JLabel EmailLabel;
  private JLabel DepartmentLabel;
  private JLabel EmailInfo;
  private JLabel DepartmentInfo;
  private JLabel SemesterLabel;
  private JLabel SemesterInfo;
  private JLabel StudentCodeLabel;
  private JLabel StudentCodeInfo;
  private JLabel TitleLabel;
  private JPanel Navbar;
  private JButton PassChangeButton;
  private JButton SignoutButton;
  private JLabel DontRemoveMeLabel;
  private JButton RegistrationButton;

  public StudentInfo() {
    add(InfoPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.addActionListener(e -> {
      StudentInfo info = new StudentInfo();
      info.setVisible(true);
      dispose();
    });

    RegistrationButton.addActionListener(e -> {
      LessonRegistration lr = new LessonRegistration();
      lr.setVisible(true);
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
    });
  }
}
