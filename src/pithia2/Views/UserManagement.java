package pithia2.Views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.Department;
import pithia2.Models.Student;
import pithia2.Models.University;
import pithia2.Models.User;

public class UserManagement extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton BackButton;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable StudentTable;
  private JPanel MiscPanel;
  private JButton SaveButton;
  private JScrollPane Students;
  private JPanel TablePanel;
  private JScrollPane Administrators;
  private JTable AdministratorTable;
  private JButton NewStudentButton;
  private JButton NewAdminButton;
  private JButton DeleteStudentButton;
  private JButton DeleteAdminButton;
  private JPanel ErrorPanel;
  private JLabel ErrorLabel;

  UserManagement() {
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

    NewStudentButton.addActionListener(e -> createStudent());

    NewAdminButton.addActionListener(e -> createAdministrator());

    DeleteStudentButton.addActionListener(e -> deleteStudent());

    DeleteAdminButton.addActionListener(e -> deleteAdmin());

    SaveButton.addActionListener(e -> save());
  }

  private void createUIComponents() {
    String[] studentTableColumns = {"username", "password", "fullname", "email", "studentCode", "department", "semester"};
    DefaultTableModel studentTableModel = new DefaultTableModel(studentTableColumns, 0);
    StudentTable = new JTable(studentTableModel);

    String[] adminTableColumns = {"username", "password", "fullname", "email", "adminCode"};
    DefaultTableModel adminTableModel = new DefaultTableModel(adminTableColumns, 0);
    AdministratorTable = new JTable(adminTableModel);

    loadTable();
  }

  private void loadTable() {
    DefaultTableModel studentTableModel = (DefaultTableModel) StudentTable.getModel();
    DefaultTableModel adminTableModel = (DefaultTableModel) AdministratorTable.getModel();
    studentTableModel.setRowCount(0);
    adminTableModel.setRowCount(0);

    List<User> users = University.getUniversityInstance().getUsers();
    for (User user : users) {
      if (user instanceof Student) {
        Student student = (Student) user;
        Object[] row = new Object[7];
        row[0] = student.getUsername();
        row[1] = student.getPassword();
        row[2] = student.getFullname();
        row[3] = student.getEmail();
        row[4] = student.getStudentCode();
        row[5] = student.getDepartment().getName();
        row[6] = student.getSemester();

        ((DefaultTableModel) StudentTable.getModel()).addRow(row);
      } else if (user instanceof Administrator) {
        Administrator admin = (Administrator) user;
        Object[] row = new Object[5];
        row[0] = admin.getUsername();
        row[1] = admin.getPassword();
        row[2] = admin.getFullname();
        row[3] = admin.getEmail();
        row[4] = admin.getAdminCode();

        ((DefaultTableModel) AdministratorTable.getModel()).addRow(row);
      }
    }
  }

  private void createStudent() {
    int increment = University.getUniversityInstance().getUsers().size() + 1;
    Department department = University.getUniversityInstance().getDepartments().get(0);
    Student student = new Student("newStudent" + increment, "-", "-", "-", 0, department, 0);
    List<User> users = University.getUniversityInstance().getUsers();
    users.add(student);
    University.getUniversityInstance().setUsers(users);

    GlobalConstants.save();
    loadTable();
  }

  private void createAdministrator() {
    int increment = University.getUniversityInstance().getUsers().size() + 1;
    Administrator admin = new Administrator("newAdmin" + increment, "-", "-", "-", 0);
    List<User> users = University.getUniversityInstance().getUsers();
    users.add(admin);
    University.getUniversityInstance().setUsers(users);

    GlobalConstants.save();
    loadTable();
  }

  private void deleteStudent() {
    int row = StudentTable.getSelectedRow();
    String username = StudentTable.getValueAt(row, 0).toString();
    List<User> users = User.deleteUser(University.getUniversityInstance().getUsers(), username);
    University.getUniversityInstance().setUsers(users);

    GlobalConstants.save();
    loadTable();
  }

  private void deleteAdmin() {
    int row = AdministratorTable.getSelectedRow();
    String username = AdministratorTable.getValueAt(row, 0).toString();
    List<User> users = User.deleteUser(University.getUniversityInstance().getUsers(), username);
    University.getUniversityInstance().setUsers(users);

    GlobalConstants.save();
    loadTable();
  }

  private void save() {
    List<User> users = new ArrayList<User>();

    for (int i = 0; i < StudentTable.getRowCount(); i++) {
      String username = StudentTable.getValueAt(i, 0).toString();
      String password = StudentTable.getValueAt(i, 1).toString();
      String fullname = StudentTable.getValueAt(i, 2).toString();
      String email = StudentTable.getValueAt(i, 3).toString();
      int studentCode = Integer.parseInt(StudentTable.getValueAt(i, 4).toString());
      Department department = Department.search(StudentTable.getValueAt(i, 5).toString());
      int semester = Integer.parseInt(StudentTable.getValueAt(i, 6).toString());

      users.add(new Student(username, password, fullname, email, studentCode, department, semester));
    }

    for (int i = 0; i < AdministratorTable.getRowCount(); i++) {
      String username = AdministratorTable.getValueAt(i, 0).toString();
      String password = AdministratorTable.getValueAt(i, 1).toString();
      String fullname = AdministratorTable.getValueAt(i, 2).toString();
      String email = AdministratorTable.getValueAt(i, 3).toString();
      int adminCode = Integer.parseInt(AdministratorTable.getValueAt(i, 4).toString());

      users.add(new Administrator(username, password, fullname, email, adminCode));
    }

    University.getUniversityInstance().setUsers(users);

    GlobalConstants.save();
    loadTable();
  }
}
