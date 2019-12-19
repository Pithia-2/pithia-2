package pithia2.Views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
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
  private JPanel LessonPanel;
  private JScrollPane Lessons;
  private JTable LessonTable;
  private JPanel MiscPanel;
  private JButton SaveButton;
  private JButton NewButton;
  private JButton DeleteButton;
  private JComboBox<Object> DepartmentsDropdown;
  private JTable PrerequisiteTable;
  private JScrollPane Prerequisites;
  private JPanel PrerequisitePanel;
  private JScrollPane AvailablePrerequisites;
  private JTable AvailablePrerequisiteTable;

  private List<Lesson> lessons;

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

    DepartmentsDropdown.addActionListener(e -> loadLessons());

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Administrator.getAdminInstance().logout();
    });

    LessonTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        loadPrerequisites();
      }
    });

    PrerequisiteTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        DefaultTableModel prerequisiteTableModel = (DefaultTableModel) PrerequisiteTable.getModel();
        Vector<Object> selectedRow = (Vector<Object>) prerequisiteTableModel.getDataVector()
            .elementAt(PrerequisiteTable.getSelectedRow());
        ((DefaultTableModel) AvailablePrerequisiteTable.getModel()).addRow(selectedRow);
        prerequisiteTableModel.removeRow(PrerequisiteTable.getSelectedRow());
//        ErrorLabel.setVisible(false);
      }
    });

    AvailablePrerequisiteTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        DefaultTableModel availablePrerequisiteTableModel = (DefaultTableModel) AvailablePrerequisiteTable.getModel();
        Vector<Object> selectedRow = (Vector<Object>) availablePrerequisiteTableModel.getDataVector()
            .elementAt(AvailablePrerequisiteTable.getSelectedRow());
        ((DefaultTableModel) PrerequisiteTable.getModel()).addRow(selectedRow);
        availablePrerequisiteTableModel.removeRow(AvailablePrerequisiteTable.getSelectedRow());
//        ErrorLabel.setVisible(false);
      }
    });
  }

  private void createUIComponents() {
    String[] lessonColumns = {"ID", "Lesson", "Semester", "Lab Hours", "Theory Hours", "Credits", "Type"};
    DefaultTableModel lessonTableModel = new DefaultTableModel(lessonColumns, 0);
    LessonTable = new JTable(lessonTableModel);

    String[] prerequisiteColumns = {"ID", "Lesson", "Credits"};
    DefaultTableModel prerequisiteTableModel = new DefaultTableModel(prerequisiteColumns, 0);
    DefaultTableModel availablePrerequisiteTableModel = new DefaultTableModel(prerequisiteColumns, 0);
    PrerequisiteTable = new JTable(prerequisiteTableModel);
    AvailablePrerequisiteTable = new JTable(availablePrerequisiteTableModel);
    PrerequisiteTable.setDefaultEditor(Object.class, null);
    AvailablePrerequisiteTable.setDefaultEditor(Object.class, null);

    List<Department> departments = University.getUniversityInstance().getDepartments();
    DepartmentsDropdown = new JComboBox<>();
    for (Department department : departments) {
      DepartmentsDropdown.addItem(department.getName());
    }

    loadLessons();
  }

  private void loadLessons() {
    ((DefaultTableModel) LessonTable.getModel()).setRowCount(0);
    List<Department> departments = University.getUniversityInstance().getDepartments();
    Department selectedDepartment = departments.get(DepartmentsDropdown.getSelectedIndex());
    lessons = selectedDepartment.getLessons();

    Object[] rowData = new Object[7];
    for (Lesson lesson : lessons) {
      rowData[0] = lesson.getId();
      rowData[1] = lesson.getName();
      rowData[2] = lesson.getSemester();
      rowData[3] = lesson.getLabHours();
      rowData[4] = lesson.getTheoryHours();
      rowData[5] = lesson.getCredit();
      rowData[6] = lesson.getType();
      ((DefaultTableModel) LessonTable.getModel()).addRow(rowData);
    }
  }

  private void loadPrerequisites() {
    // Reset the tables
    ((DefaultTableModel) PrerequisiteTable.getModel()).setRowCount(0);
    ((DefaultTableModel) AvailablePrerequisiteTable.getModel()).setRowCount(0);

    int selectedLessonIndex = LessonTable.getSelectedRow();
    List<Lesson> requiredLessons = lessons.get(selectedLessonIndex).getRequiredLessons();
    for (Lesson requiredLesson : requiredLessons) {
      Object[] row = new Object[3];
      row[0] = requiredLesson.getId();
      row[1] = requiredLesson.getName();
      row[2] = requiredLesson.getCredit();

      ((DefaultTableModel) PrerequisiteTable.getModel()).addRow(row);
    }
  }
}
