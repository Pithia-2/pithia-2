package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Student;

public class StudentGrades extends JFrame {

  private JPanel StudentGradesPanel;
  private JPanel Navbar;
  private JButton BackButton;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable GradesTable;
  private JScrollPane Grades;
  private JPanel GradesPanel;
  private JPanel MiscPanel;
  private JLabel CreditLabel;
  private JLabel GradeLabel;

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
    });
  }

  private void createUIComponents() {
    String[] columns = {"ID", "Name", "Semester", "Credits", "Type", "Grade"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    GradesTable = new JTable(tableModel);
    GradesTable.setDefaultEditor(Object.class, null);
  }
}
