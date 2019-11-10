package pithia2.Views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.Student;

public class Home extends JFrame {

  private JPanel MainPanel;
  private JLabel Logo;
  private JLabel Title;
  private JButton LoginButton;
  private JPanel Navbar;
  private JLabel Details;
  private JButton DepartmentsButton;
  private JButton LessonsButton;
  private JLabel AppNameLabel;
  private JPanel DetailsPanel;
  private JPanel AppNamePanel;
  private JPanel LogoPanel;

  public Home() {
    add(MainPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Details.setText(
        "<html>Το Διεθνές Πανεπιστήμιο της Ελλάδος (ΔΙ.ΠΑ.Ε.) ιδρύθηκε το 2005 με έδρα την Θεσσαλονίκη. "
            + "Το πανεπιστήμιο αποτελείται απο 7 σχολές σε Θεσσαλονίκη, Δράμα, Καβάλα και Σέρρες.</html>"
    );

    this.addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        LoginButton.requestFocus();
      }
    });

    LoginButton.addActionListener(e -> {
      if (Student.getStudentInstance() != null) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setVisible(true);
        dispose();
      } else if (Administrator.getAdminInstance() != null) {
        AdminHome adminHome = new AdminHome();
        adminHome.setVisible(true);
        dispose();
      } else {
        Login login = new Login();
        login.setVisible(true);
        dispose();
      }
    });

    DepartmentsButton.addActionListener(e -> {
      Departments departments = new Departments();
      departments.setVisible(true);
      dispose();
    });
  }
}
