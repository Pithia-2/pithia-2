package pithia2.Controllers;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pithia2.Views.Home;

public class Main {

  public static void main(String[] args)
      throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    SwingUtilities.invokeLater(() -> {
      Home home = new Home();
      home.setVisible(true);
    });
  }
}
