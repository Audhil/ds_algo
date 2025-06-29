package _interview_prep._0sys_designs._3designPatterns._0creational._0singleton;

//  https://youtu.be/VGLjQuEQgkI?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _3ThreadSafe_over_block {

  private static class SomeClass {

    private static SomeClass instance;

    private SomeClass() {
    }

    public static SomeClass getInstance() {
      if (instance == null) {
        synchronized (SomeClass.class) {
          if (instance == null) {
            instance = new SomeClass();
          }
        }
      }
      return instance;
    }
  }
}
