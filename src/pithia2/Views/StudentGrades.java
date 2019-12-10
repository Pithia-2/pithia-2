package pithia2.Views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.RegisteredLesson;
import pithia2.Models.Registration;
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

    loadGrades();
  }

  private void createUIComponents() {
    String[] columns = {"ID", "Name", "Semester", "Credits", "Type", "Grade"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    GradesTable = new JTable(tableModel);
    GradesTable.setDefaultEditor(Object.class, null);
  }

  private void loadGrades() {
    int credit = 0, rowCount = 0;
    double grade = 0;
    boolean studentHasRegistrations = !Student.getStudentInstance().getRegistrations().isEmpty();

    if (studentHasRegistrations) {
      List<RegisteredLesson> registeredLessons = new ArrayList<RegisteredLesson>();
      Map<String, RegisteredLesson> register = new LinkedHashMap<String, RegisteredLesson>();

      for (int i = Student.getStudentInstance().getRegistrations().size() - 1; i > -1; i--) {
        registeredLessons.addAll(Student.getStudentInstance().getRegistrations().get(i).getRegisteredLessons());
      }

      for (RegisteredLesson registeredLesson : registeredLessons) {
        if (registeredLesson.getGrade() >= 5) {
          credit += registeredLesson.getCredit();
        }
        grade += registeredLesson.getGrade();
        rowCount++;

        Object[] row = new Object[6];
        row[0] = registeredLesson.getId();
        row[1] = registeredLesson.getName();
        row[2] = registeredLesson.getSemester();
        row[3] = registeredLesson.getCredit();
        row[4] = registeredLesson.getType();
        row[5] = registeredLesson.getGrade();

        ((DefaultTableModel) GradesTable.getModel()).addRow(row);
      }
    }

    CreditLabel.setText("ΔΜ: " + credit);
    if (rowCount > 0 && grade > 0) {
      double avg = grade / rowCount;
      GradeLabel.setText("ΜΟ: " + (Math.round(avg * 100.0) / 100.0));
    } else {
      GradeLabel.setText("ΜΟ: Not yet determined");
    }

    DefaultRowSorter sorter = ((DefaultRowSorter) GradesTable.getRowSorter());
    ArrayList list = new ArrayList();
    list.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
    sorter.setSortKeys(list);
    sorter.sort();
  }
}
