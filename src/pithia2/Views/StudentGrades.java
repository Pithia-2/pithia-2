package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Student;

public class StudentGrades extends JFrame {

  private JPanel StudentGradesPanel;
  private JPanel Navbar;
  private JButton BackButton;
  private JButton SignoutButton;
  private JTable table1;

  StudentGrades() {
    add(StudentGradesPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BackButton.addActionListener(e -> {
      StudentInfo studentInfo = new StudentInfo();
      studentInfo.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Student.getStudentInstance().logout();
    });
  }
}
