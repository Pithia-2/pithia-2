package pithia2.Views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.RegisteredLesson;
import pithia2.Models.Registration;
import pithia2.Models.Student;
import pithia2.Models.University;
import pithia2.Models.User;

public class AdminGrades extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton BackButton;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable StudentTable;
  private JButton ConfirmButton;
  private JTable LessonTable;
  private JPanel TablePanel;
  private JPanel ConfirmPanel;
  private JScrollPane Lessons;
  private JScrollPane Students;

  AdminGrades() {
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

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Administrator.getAdminInstance().logout();
    });

    StudentTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        loadLessons();
      }
    });
  }

  private void createUIComponents() {
    String[] studentTableColumns = {"Student Code", "Name"};
    DefaultTableModel studentTableModel = new DefaultTableModel(studentTableColumns, 0);
    StudentTable = new JTable(studentTableModel);
    StudentTable.setDefaultEditor(Object.class, null);

    String[] lessonTableColumns = {"ID", "Name", "Grade"};
    DefaultTableModel lessonTableModel = new DefaultTableModel(lessonTableColumns, 0);
    LessonTable = new JTable(lessonTableModel);

    loadStudents();
  }

  private void loadStudents() {
    List<User> users = University.getUniversityInstance().getUsers();
    for (User user : users) {
      if (user instanceof Student) {
        Student student = (Student) user;
        Object[] row = new Object[2];
        row[0] = student.getStudentCode();
        row[1] = student.getFullname();

        ((DefaultTableModel) StudentTable.getModel()).addRow(row);
      }
    }
  }

  private void loadLessons() {
    DefaultTableModel lessonTableModel = (DefaultTableModel) LessonTable.getModel();
    lessonTableModel.setRowCount(0);

    int studentTableSelectedRow = StudentTable.getSelectedRow();
    int studentCode = Integer.parseInt(StudentTable.getValueAt(studentTableSelectedRow, 0).toString());
    List<User> users = University.getUniversityInstance().getUsers();
    Student selectedStudent;

    for (User user : users) {
      if (user instanceof Student && ((Student) user).getStudentCode() == studentCode) {
        selectedStudent = (Student) user;

        int registrationCount = selectedStudent.getRegistrations().size();
        if (registrationCount > 0) {
          int lastRegistrationIndex = registrationCount - 1;
          Registration lastRegistration = selectedStudent.getRegistrations().get(lastRegistrationIndex);
          List<RegisteredLesson> registeredLessons = lastRegistration.getRegisteredLessons();

          for (RegisteredLesson registeredLesson : registeredLessons) {
            Object[] row = new Object[3];
            row[0] = registeredLesson.getId();
            row[1] = registeredLesson.getName();
            row[2] = registeredLesson.getGrade();

            ((DefaultTableModel) LessonTable.getModel()).addRow(row);
          }
        }
      }
    }
  }
}
