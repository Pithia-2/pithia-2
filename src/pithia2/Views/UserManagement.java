package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;

public class UserManagement extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton HomeButton;
  private JButton SignoutButton;
  private JTable UserTable;
  private JPanel ConfirmPanel;
  private JButton ConfirmButton;
  private JScrollPane Users;
  private JPanel TablePanel;

  UserManagement() {
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
