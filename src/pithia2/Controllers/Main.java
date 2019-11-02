package pithia2.Controllers;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pithia2.Views.Home;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new Home();
        frame.setVisible(true);
      }
    });
  }

}
