package pithia2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

public class Login extends JFrame
{

  private JPanel LoginPane;
  private JButton LoginButton;
  private JPasswordField PasswordField;
  private JTextField UsernameField;
  private JLabel Login;
  private JLabel UsernameText;
  private JLabel PasswordText;

  public Login()
  {
    add(LoginPane);
    setSize(800,500);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    LoginButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {

      }
    });
  }
}
