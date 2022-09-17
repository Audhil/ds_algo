package _interview_prep._0sys_designs._3designPatterns._0creational._0singleton;

public class _1LazyInit {

  public static class SomeClass {

    private SomeClass() {
    }

    private static SomeClass instance;

    public static SomeClass getInstance() {
      if (instance == null) {
        instance = new SomeClass();
      }
      return instance;
    }
  }
}
