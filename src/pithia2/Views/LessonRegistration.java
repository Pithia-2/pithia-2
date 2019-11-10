package pithia2.Views;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Department;
import pithia2.Models.Lesson;
import pithia2.Models.Student;

public class LessonRegistration extends JFrame {

  private JPanel Navbar;
  private JButton BackButton;
  private JButton SignoutButton;
  private JTable RegistrationTable;
  private JPanel LessonRegistrationPanel;
  private JButton ConfirmButton;
  private JPanel RegistrationTablePanel;
  private JScrollPane Registrations;
  private JPanel MiscPanel;

  LessonRegistration() {
    add(LessonRegistrationPanel);
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

    showLessons();
  }

  private void showLessons() {
    DefaultTableModel model = (DefaultTableModel) RegistrationTable.getModel();
    model.addColumn("ID");
    model.addColumn("Name");
    model.addColumn("Semester");
    model.addColumn("LabHours");
    model.addColumn("TheoryHours");
    model.addColumn("Credits");
    model.addColumn("Type");

    Department department = Student.getStudentInstance().getDepartment();
    List<Lesson> lessons = department.getLessons();
    Object[] rowData = new Object[7];
    for (Lesson lesson : lessons) {
      rowData[0] = lesson.getId();
      rowData[1] = lesson.getName();
      rowData[2] = lesson.getSemester();
      rowData[3] = lesson.getLabHours();
      rowData[4] = lesson.getTheoryHours();
      rowData[5] = lesson.getCredit();
      rowData[6] = lesson.getType();
      model.addRow(rowData);
    }

    RegistrationTable.setModel(model);
  }
}
