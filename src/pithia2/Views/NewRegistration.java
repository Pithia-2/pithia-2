package pithia2.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Student;

public class NewRegistration extends JFrame {

  private JPanel RootPanel;
  private JPanel Navbar;
  private JButton BackButton;
  private JButton SignoutButton;
  private JButton HomeButton;
  private JPanel RegistrationTablePanel;
  private JScrollPane Lessons;
  private JTable LessonTable;
  private JPanel MiscPanel;
  private JLabel CreditLabel;
  private JButton ConfirmButton;
  private JScrollPane ChosenLessons;
  private JTable ChosenLessonTable;

  NewRegistration() {
    add(RootPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BackButton.addActionListener(e -> {
      LessonRegistration lessonRegistration = new LessonRegistration();
      lessonRegistration.setVisible(true);
      dispose();
    });

    HomeButton.addActionListener(e -> {
      Home home = new Home();
      home.setVisible(true);
      dispose();
    });

    SignoutButton.addActionListener(e -> {
      Login login = new Login();
      login.setVisible(true);
      dispose();
      Student.getStudentInstance().logout();
    });
  }
}
