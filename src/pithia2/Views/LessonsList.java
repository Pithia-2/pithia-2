package pithia2.Views;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Department;
import pithia2.Models.Lesson;
import pithia2.Models.University;

public class LessonsList extends JFrame {

  private JPanel LessonsListPanel;
  private JButton BackButton;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable LessonsTable;
  private JScrollPane Lessons;
  private JPanel ErrorPanel;
  private JLabel ErrorLabel;
  private JComboBox<String> DepartmentsDropdown;
  private JPanel LessonsPanel;
  private JPanel Navbar;

  LessonsList() {
    add(LessonsListPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BackButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    DepartmentsDropdown.addActionListener(e -> addRows());
  }

  private void createUIComponents() {
    String[] columns = {"ID", "Lesson", "Semester", "Lab Hours", "Theory Hours", "Credits", "Type"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    LessonsTable = new JTable(tableModel);
    LessonsTable.setDefaultEditor(Object.class, null);

    List<Department> departments = University.getUniversityInstance().getDepartments();
    DepartmentsDropdown = new JComboBox<>();
    for (Department department : departments) {
      DepartmentsDropdown.addItem(department.getName());
    }
    addRows();
  }

  private void addRows() {
    ((DefaultTableModel) LessonsTable.getModel()).setRowCount(0);
    List<Department> departments = University.getUniversityInstance().getDepartments();
    Department DepSelected = departments.get(DepartmentsDropdown.getSelectedIndex());
    List<Lesson> lessons = DepSelected.getLessons();

    Object[] rowData = new Object[7];
    for (Lesson lesson : lessons) {
      rowData[0] = lesson.getId();
      rowData[1] = lesson.getName();
      rowData[2] = lesson.getSemester();
      rowData[3] = lesson.getLabHours();
      rowData[4] = lesson.getTheoryHours();
      rowData[5] = lesson.getCredit();
      rowData[6] = lesson.getType();
      ((DefaultTableModel) LessonsTable.getModel()).addRow(rowData);
    }
  }
}
