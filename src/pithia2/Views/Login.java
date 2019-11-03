package pithia2.Views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;

public class Login extends JFrame {

  private JPanel LoginPane;
  private JPasswordField PasswordField;
  private JTextField UsernameField;
  private JLabel Login;
  private JLabel UsernameText;
  private JLabel PasswordText;
  private JButton HomeButton;
  private JLabel ErrorLabel;
  private JButton LoginButton;

  public Login() {
    add(LoginPane);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.setOpaque(false);
    HomeButton.setContentAreaFilled(false);

    this.addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        UsernameField.requestFocus();
      }
    });

    HomeButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    LoginButton.addActionListener(e -> {
      StudentInfo si = new StudentInfo();
      si.setVisible(true);
      dispose();
    });
  }
}
