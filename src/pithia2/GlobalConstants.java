package pithia2;

import java.nio.file.Paths;

public class GlobalConstants {

  public static final int FRAME_WIDTH = 1280;
  public static final int FRAME_HEIGHT = 720;

  public static final String APP_ROOT = Paths.get(".").toAbsolutePath().normalize().toString();
  public static final String UNIVERSITIES_PATH = APP_ROOT + "\\Universities\\";
}
