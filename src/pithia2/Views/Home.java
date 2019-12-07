package pithia2.Views;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pithia2.GlobalConstants;
import pithia2.Models.Administrator;
import pithia2.Models.Department;
import pithia2.Models.Lesson;
import pithia2.Models.RegisteredLesson;
import pithia2.Models.Registration;
import pithia2.Models.Student;
import pithia2.Models.University;
import pithia2.Models.User;

public class Home extends JFrame {

  private JPanel MainPanel;
  private JLabel Logo;
  private JLabel Title;
  private JButton LoginButton;
  private JPanel Navbar;
  private JLabel Details;
  private JButton CreateButton;
  private JButton DepartmentsButton;
  private JButton LessonsButton;
  private JLabel AppNameLabel;
  private JPanel DetailsPanel;
  private JPanel AppNamePanel;
  private JPanel LogoPanel;
  private JComboBox<String> UniversitiesDropDown;

  public Home() {
    add(MainPanel);
    setSize(GlobalConstants.FRAME_WIDTH, GlobalConstants.FRAME_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    updatePage();

    this.addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        LoginButton.requestFocus();
      }
    });

    LoginButton.addActionListener(e -> {
      if (Student.getStudentInstance() != null) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setVisible(true);
        dispose();
      } else if (Administrator.getAdminInstance() != null) {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setVisible(true);
        dispose();
      } else {
        Login login = new Login();
        login.setVisible(true);
        dispose();
      }
    });

    DepartmentsButton.addActionListener(e -> {
      Departments departments = new Departments();
      departments.setVisible(true);
      dispose();
    });

    LessonsButton.addActionListener(e -> {
      LessonsList list = new LessonsList();
      list.setVisible(true);
      dispose();
    });

    CreateButton.addActionListener(e -> {
      String selectedUniversity = UniversitiesDropDown
          .getItemAt(UniversitiesDropDown.getSelectedIndex());
      create(selectedUniversity);
    });

    UniversitiesDropDown.addItemListener(e -> {
      if (e.getStateChange() == ItemEvent.SELECTED) {
        List<University> universities = readUniversities();
        University selectedUniversity = universities.get(UniversitiesDropDown.getSelectedIndex());
        University.setUniversityInstance(selectedUniversity);
        updatePage();
        Student.setStudentInstance(null);
        Administrator.setAdminInstance(null);
      }
    });
  }

  private void create(String selectedUniversity) {
    if (selectedUniversity.equals("IHU")) {
      University university = new University("International Hellenic University", "IHU", "Sindos",
          "mail@ihu.gr", "https://ihu.gr",
          "2310123456",
          "The International Hellenic University waw founded in 2005 in Thessaloniki. It consists of 7 schools in multiple cities.");

      Department department1 = new Department("Department1", "2310747474");
      Department department2 = new Department("Department2", "210-1-347-455");

      List<User> users = university.getUsers();
      List<Lesson> lessons1 = department1.getLessons();
      List<Lesson> lessons2 = department2.getLessons();
      List<Department> departments = university.getDepartments();
      List<RegisteredLesson> registeredLessons25 = new ArrayList<RegisteredLesson>();

      lessons1.add(new Lesson(1101, "Lesson11", 1, 2, 4, 6, "Y"));
      lessons1.add(new Lesson(1102, "Lesson12", 1, 0, 6, 6, "Y"));
      lessons1.add(new Lesson(1103, "Lesson13", 1, 2, 4, 6, "Y"));
      lessons1.add(new Lesson(1104, "Lesson14", 1, 0, 6, 6, "Y"));
      lessons1.add(new Lesson(1501, "Lesson15", 5, 2, 4, 6, "Y"));
      lessons1.add(new Lesson(1601, "Lesson16", 6, 0, 6, 6, "E"));
      lessons1.add(new Lesson(1701, "Lesson17", 7, 2, 4, 6, "YE"));
      lessons1.add(new Lesson(1901, "Lesson18", 9, 0, 6, 6, "E"));
      lessons1.add(new Lesson(1902, "Lesson19", 9, 2, 4, 6, "YE"));

      Lesson temp1 = new Lesson(1111, "temp1", 1, 4,4,2, "E");
      Lesson temp2 = new Lesson(1112, "temp2", 1, 4,4,2, "E");
      Lesson temp3 = new Lesson(1113, "temp3", 1, 4,4,2, "E");
      temp3.getRequiredLessons().add(temp1);
      temp3.getRequiredLessons().add(temp2);
      lessons1.add(temp1);
      lessons1.add(temp2);
      lessons1.add(temp3);

      lessons2.add(new Lesson(1101, "Lesson21", 1, 0, 6, 6, "E"));
      lessons2.add(new Lesson(1102, "Lesson22", 1, 2, 4, 6, "Y"));
      lessons2.add(new Lesson(1201, "Lesson23", 2, 0, 6, 6, "E"));
      lessons2.add(new Lesson(1202, "Lesson24", 2, 2, 4, 6, "Y"));
      lessons2.add(new Lesson(1301, "Lesson25", 3, 0, 6, 6, "E"));
      lessons2.add(new Lesson(1302, "Lesson26", 3, 2, 4, 6, "Y"));
      lessons2.add(new Lesson(1401, "Lesson27", 4, 0, 6, 6, "E"));
      lessons2.add(new Lesson(1501, "Lesson28", 5, 2, 4, 6, "Y"));
      lessons2.add(new Lesson(1601, "Lesson29", 6, 0, 6, 6, "YE"));

      Student student1 = new Student("test1", "1", "lname fname", "email1@ihu.gr",
          1, department1, 1);
      Student student2 = new Student("test2", "2", "lname2 fname2", "email2@ihu.gr",
          2, department1, 6);
      Student student3 = new Student("test3", "3", "lname3 fname3", "email3@ihu.gr",
          3, department2, 1);
      Student student4 = new Student("test4", "4", "lname4 fname4", "email4@ihu.gr",
          4, department2, 2);

      Administrator administrator = new Administrator("admin", "11",
          "Admin Admin", "admin@ihu.gr", 1);

      student1.getPassedLessons().add(temp1);

      Registration registration21 = new Registration(0);
      Registration registration22 = new Registration(1);
      Registration registration23 = new Registration(2);
      Registration registration24 = new Registration(3);
      Registration registration25 = new Registration(4);
      Registration registration31 = new Registration(0);
      Registration registration41 = new Registration(0);

      registeredLessons25.add(new RegisteredLesson(lessons1.get(2)));
      registration25.setRegisteredLessons(registeredLessons25);


      student2.getRegistrations().clear();
      student3.getRegistrations().clear();
      
      student2.setRegistrations(null);
      student3.setRegistrations(null);
      student4.setRegistrations(null);

      student2.getRegistrations().add(registration21);
      student2.getRegistrations().add(registration22);
      student2.getRegistrations().add(registration23);
      student2.getRegistrations().add(registration24);
      student2.getRegistrations().add(registration25);
      student3.getRegistrations().add(registration31);
      student4.getRegistrations().add(registration41);

      users.add(student1);
      users.add(student2);
      users.add(student3);
      users.add(student4);
      users.add(administrator);

      departments.add(department1);
      departments.add(department2);

      university.setDepartments(departments);
      university.setUsers(users);

      String path = GlobalConstants.UNIVERSITIES_PATH + "IHU.uni";
      try {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
        os.writeObject(university);
        os.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

      try {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));

        University.setUniversityInstance((University) is.readObject());
        is.close();
      } catch (IOException | ClassNotFoundException e) {
        System.out.println(e.getMessage());
      }
    } else if (selectedUniversity.equals("AUTH")) {
      University university = new University("Aristotle University of Thessaloniki", "AUTH",
          "AUTh campus", "mail@auth.gr", "https://auth.gr",
          "2310654321",
          "Aristotle University of Thessaloniki is the largest greek university. It consist of 10 schools and 40 departments");

      Department department1 = new Department("Department1", "2310747474");
      List<User> users = university.getUsers();
      List<Lesson> lessons1 = department1.getLessons();
      List<Department> departments = university.getDepartments();

      lessons1.add(new Lesson(1101, "Lesson11", 1, 2, 4, 6, "Y"));
      lessons1.add(new Lesson(1102, "Lesson12", 1, 0, 6, 6, "Y"));
      lessons1.add(new Lesson(1103, "Lesson13", 1, 2, 4, 6, "Y"));
      lessons1.add(new Lesson(1601, "Lesson16", 6, 0, 6, 6, "E"));
      lessons1.add(new Lesson(1701, "Lesson17", 7, 2, 4, 6, "YE"));
      lessons1.add(new Lesson(1801, "Lesson18", 8, 0, 6, 6, "E"));
      lessons1.add(new Lesson(1901, "Lesson19", 9, 2, 4, 6, "YE"));

      Student student1 = new Student("test1", "1", "lname fname", "email1@auth.gr",
          1, department1, 1);
      Administrator administrator = new Administrator("admin", "11",
          "Admin Admin", "admin@ihu.gr", 1);
      users.add(student1);
      users.add(administrator);
      departments.add(department1);

      university.setDepartments(departments);
      university.setUsers(users);

      String path = GlobalConstants.UNIVERSITIES_PATH + "AUTH.uni";

      try {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
        os.writeObject(university);
        os.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

      try {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));

        University.setUniversityInstance((University) is.readObject());
        is.close();
      } catch (IOException | ClassNotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
    else {
      create();
    }
  }

  private void createUIComponents() {
    UniversitiesDropDown = new JComboBox<>();
    if (readUniversities().isEmpty()){
      create();
    }
    
    List<University> universities = readUniversities();

    for (University university : universities) {
      UniversitiesDropDown.addItem(university.getAcronym());
      if (University.getUniversityInstance().getAcronym().equals(university.getAcronym())) {
        UniversitiesDropDown.setSelectedIndex(universities.indexOf(university));
      }
    }
  }

  private List<University> readUniversities() {
    Path path = Paths.get(GlobalConstants.UNIVERSITIES_PATH);
    List<University> universities = new ArrayList<>();

    try (Stream<Path> subPaths = Files.walk(path, 1)) {
      List<String> subPathList = subPaths.filter(Files::isRegularFile)
          .map(Objects::toString)
          .collect(Collectors.toList());

      for (String p : subPathList) {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(p));
        University uni = (University) is.readObject();
        universities.add(uni);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return universities;
  }

  private void updatePage() {
    Details.setText(University.getUniversityInstance().getDetails());
    Title.setText(University.getUniversityInstance().getName());
    Icon icon = new ImageIcon(
        GlobalConstants.APP_ROOT + "\\src\\resources\\" + University.getUniversityInstance()
            .getAcronym().toLowerCase() + ".png");
    Logo.setIcon(icon);
  }

  private void create() {
    create("AUTH");
    create("IHU");
  }
}
