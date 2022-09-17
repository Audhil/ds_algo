package _interview_prep._0sys_designs._3designPatterns._0creational._0singleton;

public class _2ThreadSafe_over_method {

  private static class SomeClass {

    private static SomeClass instance;

    private SomeClass() {
    }

    public static synchronized SomeClass getInstance() {
      if (instance == null) {
        instance = new SomeClass();
      }
      return instance;
    }
  }
}
