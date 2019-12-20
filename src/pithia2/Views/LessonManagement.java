package pithia2.Views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import pithia2.Models.Student;
import pithia2.Models.University;
import pithia2.Models.User;

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

    // Moves lesson to AvailablePrerequisiteTable
    PrerequisiteTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        DefaultTableModel prerequisiteTableModel = (DefaultTableModel) PrerequisiteTable.getModel();
        Vector<Object> selectedRow = (Vector<Object>) prerequisiteTableModel.getDataVector()
            .elementAt(PrerequisiteTable.getSelectedRow());
        ((DefaultTableModel) AvailablePrerequisiteTable.getModel()).addRow(selectedRow);
        prerequisiteTableModel.removeRow(PrerequisiteTable.getSelectedRow());
      }
    });

    // Moves lesson to PrerequisiteTable
    AvailablePrerequisiteTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        DefaultTableModel availablePrerequisiteTableModel = (DefaultTableModel) AvailablePrerequisiteTable
            .getModel();
        Vector<Object> selectedRow = (Vector<Object>) availablePrerequisiteTableModel
            .getDataVector()
            .elementAt(AvailablePrerequisiteTable.getSelectedRow());
        ((DefaultTableModel) PrerequisiteTable.getModel()).addRow(selectedRow);
        availablePrerequisiteTableModel.removeRow(AvailablePrerequisiteTable.getSelectedRow());
      }
    });

    NewButton.addActionListener(e -> newLesson());

    DeleteButton.addActionListener(e -> deleteLesson());

//    SaveButton.addActionListener(e -> save());
  }

  private void createUIComponents() {
    String[] lessonColumns = {"ID", "Lesson", "Semester", "Lab Hours", "Theory Hours", "Credits",
        "Type"};
    DefaultTableModel lessonTableModel = new DefaultTableModel(lessonColumns, 0);
    LessonTable = new JTable(lessonTableModel);
    LessonTable.setDefaultEditor(Object.class, null);

    String[] prerequisiteColumns = {"ID", "Lesson", "Semester"};
    DefaultTableModel prerequisiteTableModel = new DefaultTableModel(prerequisiteColumns, 0);
    DefaultTableModel availablePrerequisiteTableModel = new DefaultTableModel(prerequisiteColumns,
        0);
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
    // Reset the table
    ((DefaultTableModel) LessonTable.getModel()).setRowCount(0);

    List<Lesson> lessons = getSelectedDepartmentsLessons();
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

    List<Lesson> requiredLessons = getSelectedLessonsPrerequisites();
    for (Lesson requiredLesson : requiredLessons) {
      Object[] row = new Object[3];
      row[0] = requiredLesson.getId();
      row[1] = requiredLesson.getName();
      row[2] = requiredLesson.getSemester();

      ((DefaultTableModel) PrerequisiteTable.getModel()).addRow(row);
    }

    List<Lesson> availablePrerequisites = getAvailablePrerequisites();
    for (Lesson availablePrerequisite : availablePrerequisites) {
      Object[] row = new Object[3];
      row[0] = availablePrerequisite.getId();
      row[1] = availablePrerequisite.getName();
      row[2] = availablePrerequisite.getSemester();

      ((DefaultTableModel) AvailablePrerequisiteTable.getModel()).addRow(row);
    }
  }

  private List<Lesson> getAvailablePrerequisites() {
    List<Lesson> lessons = getSelectedDepartmentsLessons();
    List<Lesson> availablePrerequisites = new ArrayList<>(lessons.size());
    availablePrerequisites.addAll(lessons);
    int selectedLessonIndex = LessonTable.getSelectedRow();
    Lesson selectedLesson = availablePrerequisites.get(selectedLessonIndex);

    // Remove lessons that exist in the PrerequisiteTable already
    List<Lesson> requiredLessons = getSelectedLessonsPrerequisites();
    for (Lesson requiredLesson : requiredLessons) {
      int availablePrerequisiteIndex = availablePrerequisites.indexOf(requiredLesson);
      if (availablePrerequisiteIndex != -1) {
        availablePrerequisites.remove(availablePrerequisiteIndex);
      }
    }

    // Remove lessons that belong to same or higher semester
    availablePrerequisites.removeIf(l -> l.getSemester() >= selectedLesson.getSemester());

    return availablePrerequisites;
  }

  private List<Lesson> getSelectedDepartmentsLessons() {
    List<Department> departments = University.getUniversityInstance().getDepartments();
    Department selectedDepartment = departments.get(DepartmentsDropdown.getSelectedIndex());
    return selectedDepartment.getLessons();
  }

  private List<Lesson> getSelectedLessonsPrerequisites() {
    int selectedLessonIndex = LessonTable.getSelectedRow();
    return getSelectedDepartmentsLessons().get(selectedLessonIndex).getRequiredLessons();
  }

  private void newLesson() {
    int increment = getSelectedDepartmentsLessons().size() + 1;
    Lesson lesson = new Lesson(1100 + increment, "Lesson11" + increment, 1, 0, 0, 6, "ΥΠ");
    List<Lesson> lessons = getSelectedDepartmentsLessons();
    lessons.add(lesson);

    GlobalConstants.save();
    loadLessons();
  }

  private void deleteLesson() {
    int id = Integer.parseInt(LessonTable.getValueAt(LessonTable.getSelectedRow(), 0).toString());
    List<Department> departments = University.getUniversityInstance().getDepartments();
    Department selectedDepartment = departments.get(DepartmentsDropdown.getSelectedIndex());
    selectedDepartment.deleteLesson(id);

    GlobalConstants.save();
    loadLessons();
  }

//  private void save() {
//    List<User> users = new ArrayList<User>();
//
//    for (int i = 0; i < StudentTable.getRowCount(); i++) {
//      String username = StudentTable.getValueAt(i, 0).toString();
//      String password = StudentTable.getValueAt(i, 1).toString();
//      String fullname = StudentTable.getValueAt(i, 2).toString();
//      String email = StudentTable.getValueAt(i, 3).toString();
//      int studentCode = Integer.parseInt(StudentTable.getValueAt(i, 4).toString());
//      Department department = Department.search(StudentTable.getValueAt(i, 5).toString());
//      int semester = Integer.parseInt(StudentTable.getValueAt(i, 6).toString());
//
//      users
//          .add(new Student(username, password, fullname, email, studentCode, department, semester));
//    }
//
//    for (int i = 0; i < AdministratorTable.getRowCount(); i++) {
//      String username = AdministratorTable.getValueAt(i, 0).toString();
//      String password = AdministratorTable.getValueAt(i, 1).toString();
//      String fullname = AdministratorTable.getValueAt(i, 2).toString();
//      String email = AdministratorTable.getValueAt(i, 3).toString();
//      int adminCode = Integer.parseInt(AdministratorTable.getValueAt(i, 4).toString());
//
//      users.add(new Administrator(username, password, fullname, email, adminCode));
//    }
//
//    University.getUniversityInstance().setUsers(users);
//
//    GlobalConstants.save();
//    loadLessons();
//  }
}
