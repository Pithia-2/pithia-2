package pithia2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import pithia2.Models.University;

public class GlobalConstants {

  public static final int FRAME_WIDTH = 1280;
  public static final int FRAME_HEIGHT = 720;

  public static final String APP_ROOT = Paths.get(".").toAbsolutePath().normalize().toString();
  public static final String UNIVERSITIES_PATH = APP_ROOT + "\\Universities\\";

  public static void save() {
    String path = UNIVERSITIES_PATH + "test.uni";
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
      os.writeObject(University.getUniversityInstance());
      os.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
