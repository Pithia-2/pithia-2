package pithia2.Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  public void testStudentFillPassedLessons() {
    Student student = new Student();
    Registration registration1 = new Registration(0);
    Registration registration2 = new Registration(1);
    Registration registration3 = new Registration(2);
    RegisteredLesson registeredLesson1 = new RegisteredLesson();
    registeredLesson1.setId(0);
    registeredLesson1.setGrade(5);
    RegisteredLesson registeredLesson2 = new RegisteredLesson();
    registeredLesson2.setId(1);
    registeredLesson2.setGrade(4);
    RegisteredLesson registeredLesson3 = new RegisteredLesson();
    registeredLesson3.setId(2);
    registeredLesson3.setGrade(8.9);
    RegisteredLesson registeredLesson4 = new RegisteredLesson();
    registeredLesson4.setId(3);
    registeredLesson4.setGrade(10);
    RegisteredLesson registeredLesson5 = new RegisteredLesson();
    registeredLesson5.setId(4);
    registeredLesson5.setGrade(3);
    RegisteredLesson registeredLesson6 = new RegisteredLesson();
    registeredLesson6.setId(5);
    registeredLesson6.setGrade(4.9);

    registration1.getRegisteredLessons().add(registeredLesson1);
    registration1.getRegisteredLessons().add(registeredLesson2);
    registration2.getRegisteredLessons().add(registeredLesson3);
    registration3.getRegisteredLessons().add(registeredLesson4);
    registration3.getRegisteredLessons().add(registeredLesson5);
    registration3.getRegisteredLessons().add(registeredLesson6);

    student.getRegistrations().add(registration1);
    student.getRegistrations().add(registration2);
    student.getRegistrations().add(registration3);

    student.fillPassedLessons();

    int numOfPassedLessons = student.getPassedLessons().size();
    int[] expectedIds = {0, 2, 3};
    int[] actualIds = new int[numOfPassedLessons];

    for (int i = 0; i < numOfPassedLessons; i++){
      actualIds[i] = student.getPassedLessons().get(i).getId();
    }

    assertArrayEquals(expectedIds, actualIds);
  }

  @Test
  public void testGetLastRegistration() {
    Student student = new Student();
    student.getRegistrations().add(new Registration(0));
    student.getRegistrations().add(new Registration(1));
    student.getRegistrations().add(new Registration(2));
    student.getRegistrations().add(new Registration(3));

    Registration registration = student.getLastRegistration();
    assertEquals(3, registration.getId());
  }
}