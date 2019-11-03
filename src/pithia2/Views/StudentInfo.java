package pithia2.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;

public class StudentInfo extends JFrame {

  private JPanel InfoPanel;
  private JButton HomeButton;
  private JLabel StudentInfoLabel;
  private JLabel UsernameLabel;
  private JLabel UsernameInfo;
  private JLabel NameLabel;
  private JLabel NameInfo;
  private JLabel SurnameLabel;
  private JLabel SurenameInfo;
  private JLabel EmailLabel;
  private JLabel DepartmentLabel;
  private JLabel EmailInfo;
  private JLabel DepartmentInfo;
  private JLabel SemesterLabel;
  private JLabel SemesterInfo;
  private JButton SignoutButton;
  private JButton PassChangeButton;
  private JLabel StudentCodeLabel;
  private JLabel StudentCodeInfo;

  public StudentInfo() {
    add(InfoPanel);
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
