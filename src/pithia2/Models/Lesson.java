package pithia2.Models;

import java.io.Serializable;

public class Lesson implements Serializable {

  private int id;
  private String name;
  private int semester;
  private int labHours;
  private int theoryHours;
  private int credit;
  private String type;

  Lesson(int id, String name, int semester, int labHours, int theoryHours, int credit,
      String type) {
    this.id = id;
    this.name = name;
    this.semester = semester;
    this.labHours = labHours;
    this.theoryHours = theoryHours;
    this.credit = credit;
    this.type = type;
  }

  Lesson() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public int getLabHours() {
    return labHours;
  }

  public void setLabHours(int labHours) {
    this.labHours = labHours;
  }

  public int getTheoryHours() {
    return theoryHours;
  }

  public void setTheoryHours(int theoryHours) {
    this.theoryHours = theoryHours;
  }

  public int getCredit() {
    return credit;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
