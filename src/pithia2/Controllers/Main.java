package pithia2.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pithia2.GlobalConstants;
import pithia2.Models.University;
import pithia2.Views.Home;

public class Main {

  public static void main(String[] args)
      throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    if (!new File(GlobalConstants.UNIVERSITIES_PATH).exists()){
      File file = new File(GlobalConstants.UNIVERSITIES_PATH);
      boolean bool = file.mkdir();
    }

    String path = GlobalConstants.UNIVERSITIES_PATH + "IHU.uni";
    try {
      ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));

      University.setUniversityInstance((University) is.readObject());
      is.close();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    SwingUtilities.invokeLater(() -> {
      Home home = new Home();
      home.setVisible(true);
    });
  }
}
