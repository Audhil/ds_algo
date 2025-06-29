package _interview_prep._0sys_designs._3designPatterns._0creational._0singleton;

public class _SingleTon_NewerMethod {

  private _SingleTon_NewerMethod() {
  }

  //  java memory model makes class loading happens sequentially
  private static class Holder {

    private static final _SingleTon_NewerMethod INSTANCE = new _SingleTon_NewerMethod();
  }

  //  https://youtu.be/G4TjjzQT8gw?t=281
  public static _SingleTon_NewerMethod getInstance() {
    return Holder.INSTANCE;
  }
}
