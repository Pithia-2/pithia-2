package pithia2.Models;

import java.io.Serializable;

public class RegisteredLesson extends Lesson implements Serializable {

  private double grade;

  public RegisteredLesson(Lesson lesson){
    super(lesson.getId(), lesson.getName(), lesson.getSemester(), lesson.getLabHours(),
        lesson.getTheoryHours(), lesson.getCredit(), lesson.getType());
    this.grade = 0;
  }

  public RegisteredLesson() {
  }

  public double getGrade() {
    return grade;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }
}
