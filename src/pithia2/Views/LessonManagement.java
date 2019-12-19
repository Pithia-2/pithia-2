package pithia2.Views;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.Department;
import pithia2.Models.Lesson;
import pithia2.Models.University;

public class LessonManagement extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton BackButton;
  private JButton SignoutButton;
  private JButton HomeButton;
  private JPanel LessonsPanel;
  private JScrollPane Lessons;
  private JTable LessonsTable;
  private JPanel MiscPanel;
  private JButton SaveButton;
  private JButton NewButton;
  private JButton DeleteButton;
  private JComboBox<Object> DepartmentsDropdown;
  private JPanel PrerequisitesPanel;
  private JTable PrerequisitesTable;
  private JScrollPane AvailablePrerequisites;
  private JTable AvailablePrerequisitesTable;
  private JScrollPane Prerequisites;

  LessonManagement() {
    add(RootPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BackButton.addActionListener(e -> {
      AdminInfo adminInfo = new AdminInfo();
      adminInfo.setVisible(true);
      dispose();
    });

    HomeButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    DepartmentsDropdown.addActionListener(e -> addRows());

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Administrator.getAdminInstance().logout();
    });
  }

  private void createUIComponents() {
    String[] columns = {"ID", "Lesson", "Semester", "Lab Hours", "Theory Hours", "Credits", "Type"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    LessonsTable = new JTable(tableModel);

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
    Department selectedDepartment = departments.get(DepartmentsDropdown.getSelectedIndex());
    List<Lesson> lessons = selectedDepartment.getLessons();

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
