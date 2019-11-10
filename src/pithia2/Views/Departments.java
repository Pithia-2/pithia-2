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
import pithia2.Models.Department;
import pithia2.Models.University;

public class Departments extends JFrame {

  private JPanel DepartmentPanel;
  private JButton BackButton;
  private JTable DepartmentTable;
  private JPanel Navbar;
  private JLabel ErrorLabel;
  private JPanel TablePanel;
  private JScrollPane Departments;
  private JPanel ErrorPanel;

  Departments() {
    add(DepartmentPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BackButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    ListDepartments();
  }

   private void ListDepartments() {
    if (University.getUniversityInstance() != null) {
      List<Department> departments = University.getUniversityInstance().getDepartments();
      DefaultTableModel model = (DefaultTableModel) DepartmentTable.getModel();
      model.addColumn("Name");
      model.addColumn("Phone Number");

      Object[] rowData = new Object[2];
      for (Department department : departments) {
        rowData[0] = department.getName();
        rowData[1] = department.getPhoneNumber();
        model.addRow(rowData);
      }

      DepartmentTable.setModel(model);
    } else {
      ErrorLabel.setText("No data found.");
    }
  }
}
