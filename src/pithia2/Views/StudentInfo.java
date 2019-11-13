package pithia2.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Student;
import pithia2.Models.Department;

public class StudentInfo extends JFrame {

  private JPanel InfoPanel;
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
  private JButton HomeButton;
  private JButton PassChangeButton;
  private JButton SignoutButton;
  private JButton RegistrationButton;
  private JButton GradesButton;
  private JPanel UsernameLabelPanel;
  private JPanel NameLabelPanel;
  private JPanel EmailLabelPanel;
  private JPanel DepartmentLabelPanel;
  private JPanel SemesterLabelPanel;
  private JPanel CodeLabelPanel;
  private JPanel UsernamePanel;
  private JPanel NamePanel;
  private JPanel EmailPanel;
  private JPanel SpacerPanel;
  private JPanel DepartmentPanel;
  private JPanel SemesterPanel;
  private JPanel CodePanel;
  private JButton LessonsListButton;
  private JButton lessonListButton;

  StudentInfo() {
    add(InfoPanel);
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
      StudentGrades studentGrades = new StudentGrades();
      studentGrades.setVisible(true);
      dispose();
    });

    RegistrationButton.addActionListener(e -> {
      LessonRegistration lessonRegistration = new LessonRegistration();
      lessonRegistration.setVisible(true);
      dispose();
    });

    PassChangeButton.addActionListener(e -> {
      PasswordChange passwordChange = new PasswordChange();
      passwordChange.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Student.getStudentInstance().logout();
    });
    ShowInfo();
  }

  private void ShowInfo() {
    Student student = Student.getStudentInstance();
    UsernameInfo.setText(student.getUsername());
    NameInfo.setText(student.getFullname());
    EmailInfo.setText(student.getEmail());
    Department department = student.getDepartment();
    DepartmentInfo.setText(department.getName());
    SemesterInfo.setText(String.valueOf(student.getSemester()));
    StudentCodeInfo.setText(String.valueOf(student.getStudentCode()));
  }
}
