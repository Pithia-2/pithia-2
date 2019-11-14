package pithia2.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
import pithia2.Models.Student;
import pithia2.Models.University;

public class LessonsList extends JFrame {

  private JPanel LessonsListPanel;
  private JPanel Navbar;
  private JButton BackButton;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable LessonsTable;
  private JScrollPane LessonsScrollPane;
  private JPanel ErrorPanel;
  private JLabel ErrorLabel;
  private JComboBox DepartmentsDropdown;

  public LessonsList() {
    add(LessonsListPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BackButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Home home = new Home();
        home.setVisible(true);
        dispose();
      }
    });

    ListLesons();

    DepartmentsDropdown.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<Department> departments = University.getUniversityInstance().getDepartments();
        int DepIndex = DepartmentsDropdown.getSelectedIndex();
        Department DepSelected = departments.get(DepIndex);
        List<Lesson> lessons = DepSelected.getLessons();
        DefaultTableModel model = (DefaultTableModel) LessonsTable.getModel();
        model.setRowCount(0);

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

        LessonsTable.setModel(model);
      }
    });
  }

  private void ListLesons() {
    if (University.getUniversityInstance() != null) {
      List<Department> departments = University.getUniversityInstance().getDepartments();

      for (int i = 0; i < departments.size(); i++) {
        DepartmentsDropdown.addItem(departments.get(i).getName());
      }

      int DepIndex = DepartmentsDropdown.getSelectedIndex();
      Department DepSelected = departments.get(DepIndex);
      List<Lesson> lessons = DepSelected.getLessons();
      DefaultTableModel model = (DefaultTableModel) LessonsTable.getModel();
      model.addColumn("ID");
      model.addColumn("Name");
      model.addColumn("Semester");
      model.addColumn("Lab Hours");
      model.addColumn("Theory Hours");
      model.addColumn("Credits");
      model.addColumn("Type");

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

      LessonsTable.setModel(model);
    } else {
      ErrorLabel.setText("No data found.");
    }
  }
}
