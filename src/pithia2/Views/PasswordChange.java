package pithia2.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;

public class PasswordChange extends JFrame {

  private JPanel ChangePassPanel;
  private JButton HomeButton;
  private JLabel OldPassLabel;
  private JTextField OldPassField;
  private JLabel NewPassLabel;
  private JTextField NewPassField;
  private JLabel ConfirmNewPassLabel;
  private JTextField ConfirmNewPassField;
  private JButton SignoutButton;
  private JButton ConfirmButton;
  private JLabel PassChangeSuccessLabel;

  public PasswordChange() {
    add(ChangePassPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    HomeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Home home = new Home();
        home.setVisible(true);
        dispose();
      }
    });
  }
}
