package pithia2;

import java.nio.file.Paths;

public class GlobalConstants {

  public static final int FRAME_WIDTH = 1280;
  public static final int FRAME_HEIGHT = 720;

  public static final String APP_ROOT = Paths.get(".").toAbsolutePath().normalize().toString();
  public static final String STUDENTS_PATH = APP_ROOT + "\\Objects\\Students\\";
  public static final String ADMIN_PATH = APP_ROOT + "\\Objects\\Administrators\\";
  public static final String UNIVERSITY_PATH = APP_ROOT + "\\Objects\\Universities\\";
  public static final String DEPARTMENTS_PATH = APP_ROOT + "\\Objects\\Departments\\";
  public static final String LESSONS_PATH = APP_ROOT + "\\Objects\\Lessons\\";
  public static final String REGISTEREDLESSONS_PATH = APP_ROOT + "\\Objects\\RegisteredLessons\\";
  public static final String REGISTRATIONS_PATH = APP_ROOT + "\\Objects\\Registrations\\";

}
