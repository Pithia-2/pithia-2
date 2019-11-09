package pithia2.Controllers;

import pithia2.GlobalConstants;
import pithia2.Models.University;
import pithia2.Views.Home;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {

  public static void main(String[] args)
    throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    String path = GlobalConstants.UNIVERSITIES_PATH + "test.univer";
    try {
      ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));

      University.setUniversityInstance((University) is.readObject());
      is.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    SwingUtilities.invokeLater(() -> {
      Home home = new Home();
      home.setVisible(true);
    });
  }
}
