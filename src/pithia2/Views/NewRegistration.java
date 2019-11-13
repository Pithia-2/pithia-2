package pithia2.Views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import pithia2.GlobalConstants;
import pithia2.Models.Lesson;
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
  private int credit;

  NewRegistration() {
    add(RootPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    credit = 0;
    CreditLabel.setText("ΔΜ: " + credit + "/42");

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

    LessonTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        DefaultTableModel tableModel = (DefaultTableModel) LessonTable.getModel();
        Vector<Object> selectedRow = (Vector<Object>) tableModel.getDataVector()
            .elementAt(LessonTable.getSelectedRow());
        if (Integer.parseInt(selectedRow.get(2).toString()) + calculateCredit() <= 42) {
          ((DefaultTableModel) ChosenLessonTable.getModel()).addRow(selectedRow);
          tableModel.removeRow(LessonTable.getSelectedRow());
          CreditLabel.setText("ΔΜ: " + calculateCredit() + "/42");
        } else {
          System.out.println("out of credit");
        }
      }
    });

    ChosenLessonTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        DefaultTableModel tableModel2 = (DefaultTableModel) ChosenLessonTable.getModel();
        Vector<Object> selectedRow = (Vector<Object>) tableModel2.getDataVector()
            .elementAt(ChosenLessonTable.getSelectedRow());
        ((DefaultTableModel) LessonTable.getModel()).addRow(selectedRow);
        tableModel2.removeRow(ChosenLessonTable.getSelectedRow());
        CreditLabel.setText("ΔΜ: " + calculateCredit() + "/42");
      }
    });
  }

  private void createUIComponents() {
    String[] columns = {"ID", "Lesson", "Credits"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    DefaultTableModel tableModel2 = new DefaultTableModel(columns, 0);
    LessonTable = new JTable(tableModel);
    ChosenLessonTable = new JTable(tableModel2);
    LessonTable.setDefaultEditor(Object.class, null);
    ChosenLessonTable.setDefaultEditor(Object.class, null);

    List<Lesson> lessonList = availableLessons();
    for (Lesson lesson : lessonList) {
      Object[] row = new Object[3];
      row[0] = lesson.getId();
      row[1] = lesson.getName();
      row[2] = lesson.getCredit();

      ((DefaultTableModel) LessonTable.getModel()).addRow(row);
    }
  }

  private int calculateCredit() {
    int credit = 0;
    for (int i = 0; i < ChosenLessonTable.getRowCount(); i++) {
      credit += Integer.parseInt(ChosenLessonTable.getValueAt(i, 2).toString());
    }
    return credit;
  }

  private List<Lesson> availableLessons() {
    List<Lesson> lessonList = Student.getStudentInstance().getDepartment().getLessons();
    List<Lesson> lessons = new ArrayList<Lesson>();
    for (Lesson lesson : lessonList) {
      if (Student.getStudentInstance().getSemester() % 2 == 0) {
        if (lesson.getSemester() % 2 == 0) {
          lessons.add(lesson);
        }
      } else {
        if (lesson.getSemester() % 2 != 0) {
          lessons.add(lesson);
        }
      }
    }
    return lessons;
  }
}
