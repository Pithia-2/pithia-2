package pithia2.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
  private JButton HomeButton;

  public Login()
  {
    add(LoginPane);
    setSize(1000,800);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //Εμφανιζει το Home page
    HomeButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        JFrame login_frame = new Home();
        login_frame.setVisible(true);
      }
    });
  }
}
