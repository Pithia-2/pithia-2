package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;

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
  }
}
