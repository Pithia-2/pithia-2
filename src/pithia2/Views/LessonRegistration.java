package pithia2.Views;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Department;
import pithia2.Models.Lesson;
import pithia2.Models.Student;

public class LessonRegistration extends JFrame {

  private JPanel Navbar;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable table1;
  private JPanel LessonRegistrationPanel;
  private JButton ConfirmButton;

  LessonRegistration() {
    add(LessonRegistrationPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.addActionListener(e -> {
      StudentInfo info = new StudentInfo();
      info.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
    });
    showLesons();
  }

  private void showLesons() {
    Department dest = Student.getStudentInstance().getDepartment();
    List<Lesson> data = dest.getLessons();
    DefaultTableModel model = (DefaultTableModel) table1.getModel();
    model.addColumn("ID");
    model.addColumn("Name");
    model.addColumn("Semester");
    model.addColumn("LabHours");
    model.addColumn("TheoryHours");
    model.addColumn("Credits");
    model.addColumn("Type");
    Object rowData[] = new Object[7];
    for (int i = 0; i < data.size(); i++) {
      rowData[0] = data.get(i).getId();
      rowData[1] = data.get(i).getName();
      rowData[2] = data.get(i).getSemester();
      rowData[3] = data.get(i).getLabHours();
      rowData[4] = data.get(i).getTheoryHours();
      rowData[5] = data.get(i).getCredit();
      rowData[6] = data.get(i).getType();
      model.addRow(rowData);
    }
    table1.setModel(model);
  }
}
