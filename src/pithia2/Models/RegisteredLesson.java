package pithia2.Models;

public class RegisteredLesson extends Lesson {

  private double grade;

  public RegisteredLesson(int id, String name, int semester, int labHours, int theoryHours,
      int credit, String type, double grade) {
    super(id, name, semester, labHours, theoryHours, credit, type);
    this.grade = grade;
  }

  public double getGrade() {
    return grade;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }
}
