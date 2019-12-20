package pithia2.Views;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import pithia2.Models.Department;
import pithia2.Models.Lesson;
import pithia2.Models.Student;

class NewRegistrationTest {
  @Test
  public void testNewRegistration(){
    Department department = new Department();
    Student student = new Student();
    student.setSemester(2);
    student.setDepartment(department);
    Lesson lesson1 = new Lesson();
    lesson1.setId("0");
    lesson1.setSemester(2);
    Lesson lesson2 = new Lesson();
    lesson2.setId("1");
    lesson2.setSemester(4);
    lesson2.getRequiredLessons().add(lesson1);
    Lesson lesson3 = new Lesson();
    lesson3.setId("2");
    lesson3.setSemester(5);
    Lesson lesson4 = new Lesson();
    lesson4.setId("3");
    lesson4.setSemester(7);

    student.getPassedLessons().add(lesson1);
    Student.setStudentInstance(student);

    department.getLessons().add(lesson1);
    department.getLessons().add(lesson2);
    department.getLessons().add(lesson3);
    department.getLessons().add(lesson4);

    List<Lesson> availableLessons = NewRegistration.availableLessons();
    String[] expectedIds = {"1"};
    String[] actualIds = new String[availableLessons.size()];

    for(int i = 0; i < availableLessons.size(); i++) {
      actualIds[i] = availableLessons.get(i).getId();
    }

    assertArrayEquals(expectedIds, actualIds);
  }
}