package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;

public class AdminGrades extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable StudentTable;
  private JButton ConfirmButton;
  private JTable LessonTable;
  private JPanel TablePanel;
  private JPanel ConfirmPanel;

  AdminGrades() {
    add(RootPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.addActionListener(e -> {
      AdminHome ah = new AdminHome();
      ah.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Administrator.getAdminInstance().logout();
    });
  }
}
