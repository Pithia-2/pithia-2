package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;

public class AdminHome extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton SignoutButton;
  private JButton RegistrationButton;
  private JButton GradesButton;
  private JLabel TitleLabel;
  private JLabel UsernameLabel;
  private JLabel UsernameInfo;
  private JLabel DontRemoveMeLabel;
  private JLabel NameLabel;
  private JLabel NameInfo;
  private JLabel EmailLabel;
  private JLabel EmailInfo;
  private JLabel AdminCodeLabel;
  private JLabel AdminCodeInfo;

  AdminHome() {
    add(RootPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
    });
  }
}
