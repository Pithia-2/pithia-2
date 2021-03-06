package pithia2.Views;

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
import pithia2.Models.RegisteredLesson;
import pithia2.Models.Student;

public class LessonRegistration extends JFrame {

  private JPanel Navbar;
  private JButton BackButton;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable RegistrationTable;
  private JPanel LessonRegistrationPanel;
  private JPanel RegistrationTablePanel;
  private JScrollPane Registration;
  private JPanel MiscPanel;
  private JLabel CreditLabel;
  private JButton NewRegistrationButton;

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

    NewRegistrationButton.addActionListener(e -> {
      NewRegistration newRegistration = new NewRegistration();
      newRegistration.setVisible(true);
      dispose();
    });

    if (RegistrationTable.getRowCount() > 0) {
      CreditLabel.setText("Credits: " + calculateCredit() + "/42");
    } else {
      CreditLabel.setText("Credits: 0/42");
    }
  }

  private void createUIComponents() {
    String[] columns = {"ID", "Lesson", "Semester", "Lab Hours", "Theory Hours", "Credits", "Type"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    RegistrationTable = new JTable(tableModel);
    RegistrationTable.setDefaultEditor(Object.class, null);

    boolean studentHasNoRegistrationForCurrentSemester =
        Student.getStudentInstance().getSemester() > Student.getStudentInstance().getRegistrations().size();

    if (studentHasNoRegistrationForCurrentSemester) {
      NewRegistrationButton = new JButton("New Registration");
    } else {
      int lastRegistrationIndex = Student.getStudentInstance().getRegistrations().size() - 1;
      List<RegisteredLesson> registeredLessons = Student.getStudentInstance().getRegistrations()
          .get(lastRegistrationIndex).getRegisteredLessons();
      for (RegisteredLesson registeredLesson : registeredLessons) {
        Object[] row = new Object[7];
        row[0] = registeredLesson.getId();
        row[1] = registeredLesson.getName();
        row[2] = registeredLesson.getSemester();
        row[3] = registeredLesson.getLabHours();
        row[4] = registeredLesson.getTheoryHours();
        row[5] = registeredLesson.getCredit();
        row[6] = registeredLesson.getType();
        ((DefaultTableModel) RegistrationTable.getModel()).addRow(row);
      }
      NewRegistrationButton = new JButton("New Registration");
      NewRegistrationButton.setEnabled(false);
    }
  }

  private int calculateCredit() {
    int credit = 0;
    for (int i = 0; i < RegistrationTable.getRowCount(); i++) {
      credit += Integer.parseInt(RegistrationTable.getValueAt(i, 5).toString());
    }
    return credit;
  }
}
