package pithia2.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Department;
import pithia2.Models.University;
import pithia2.Models.User;

public class DepartmentPage extends JFrame {

  private JPanel DepartmentPanel;
  private JButton HomeButton;
  private JPanel NavBar;
  private JButton SignoutButton;
  private JTable DepartmentTable;

  public DepartmentPage() {
    add(DepartmentPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        StudentInfo info = new StudentInfo();
        info.setVisible(true);
        dispose();
      }
    });

    SignoutButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Login login = new Login();
        login.setVisible(true);
        dispose();
      }
    });
    ListDepartment();
  }

  private void ListDepartment() {
    List<Department> depa = University.getUserInstance().getDepartments();
    DefaultTableModel model = (DefaultTableModel) DepartmentTable.getModel();
    model.addColumn("Name");
    model.addColumn("Phone Number");
    Object rowData[] = new Object[2];
    for (int i = 0; i < depa.size(); i++) {
      rowData[0] = depa.get(i).getName();
      rowData[1] = depa.get(i).getPhoneNumber();
      model.addRow(rowData);
    }
    DepartmentTable.setModel(model);
  }
}
