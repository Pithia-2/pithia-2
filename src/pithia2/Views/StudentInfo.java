package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Department;
import pithia2.Models.Student;

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
  private JButton GradesButton;

  StudentInfo() {
    add(InfoPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    GradesButton.addActionListener(e -> {
      StudentGrades sg = new StudentGrades();
      sg.setVisible(true);
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
    ShowInfo();
  }

  private void ShowInfo() {
    Student student = Student.getStudentInstance();
    UsernameInfo.setText(student.getUsername());
    NameInfo.setText(student.getFullname());
    EmailInfo.setText(student.getEmail());
    Department dep = student.getDepartment();
    DepartmentInfo.setText("Name:  " + dep.getName() + "  Phone Number:  " + dep.getPhoneNumber());
    SemesterInfo.setText(String.valueOf(student.getSemester()));
    StudentCodeInfo.setText(String.valueOf(student.getStudentCode()));
  }
}
