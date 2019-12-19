package pithia2.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DepartmentTest {
  @Test
  public void testSearchDepartment(){
    University university = new University();
    Department department1 = new Department();
    department1.setName("Department1");
    Department department2 = new Department();
    department2.setName("Department2");
    Department department3 = new Department();
    department3.setName("Department3");

    university.getDepartments().add(department1);
    university.getDepartments().add(department2);
    university.getDepartments().add(department3);
    University.setUniversityInstance(university);

    String departmentName = "Department1";
    Department department = Department.search(departmentName);

    assertEquals(departmentName, department.getName());
  }
}