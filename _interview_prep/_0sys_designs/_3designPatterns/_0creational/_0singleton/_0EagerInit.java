package _interview_prep._0sys_designs._3designPatterns._0creational._0singleton;

//  https://youtu.be/VGLjQuEQgkI?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0EagerInit {

  public static class SomeClass {

    private static SomeClass instance = new SomeClass();

    private SomeClass() {
    }

    public static SomeClass getInstance() {
      return instance;
    }
  }
}
